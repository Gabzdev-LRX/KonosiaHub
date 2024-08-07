package net.konosia.hub.scoreboard;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import net.konosia.hub.KonosiaHub;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class ScoreboardManager {
    private final Map<Player, PersonalScoreboard> scoreboards = new HashMap();
    private final ScheduledFuture<?> glowingTask;
    private final ScheduledFuture<?> reloadingTask;
    private int ipCharIndex = 0;
    private int cooldown = 0;

    public ScoreboardManager(KonosiaHub main) {
        this.glowingTask = main.getScheduledExecutorService().scheduleAtFixedRate(() -> {
            String ip = this.colorIpAt();
            Iterator var3 = this.scoreboards.entrySet().iterator();

            while(var3.hasNext()) {
                Entry<Player, PersonalScoreboard> scoreboardEntry = (Entry)var3.next();
                main.getExecutorMonoThread().execute(() -> {
                    ((PersonalScoreboard)scoreboardEntry.getValue()).setLines(ip);
                });
            }

        }, 80L, 80L, TimeUnit.MILLISECONDS);
        this.reloadingTask = main.getScheduledExecutorService().scheduleAtFixedRate(() -> {
            Iterator var2 = this.scoreboards.values().iterator();

            while(var2.hasNext()) {
                PersonalScoreboard scoreboard = (PersonalScoreboard)var2.next();
                main.getExecutorMonoThread().execute(scoreboard::reloadData);
            }

        }, 20L, 20L, TimeUnit.SECONDS);
    }

    public void onDisable() {
        this.scoreboards.values().forEach(PersonalScoreboard::onLogout);
    }

    public void onLogin(Player player) {
        if (!this.scoreboards.containsKey(player)) {
            this.scoreboards.put(player, new PersonalScoreboard(player));
        }
    }

    public void onLogout(Player player) {
        if (this.scoreboards.containsKey(player)) {
            ((PersonalScoreboard)this.scoreboards.get(player)).onLogout();
            this.scoreboards.remove(player);
        }

    }

    public void update(Player player) {
        if (this.scoreboards.containsKey(player)) {
            ((PersonalScoreboard)this.scoreboards.get(player)).reloadData();
        }

    }

    private String colorIpAt() {
        String ip = "mc.konosia.net";
        if (this.cooldown > 0) {
            --this.cooldown;
            return ChatColor.GOLD + ip;
        } else {
            StringBuilder formattedIp = new StringBuilder();
            if (this.ipCharIndex > 0) {
                formattedIp.append(ip.substring(0, this.ipCharIndex - 1));
                formattedIp.append(ChatColor.YELLOW).append(ip.substring(this.ipCharIndex - 1, this.ipCharIndex));
            } else {
                formattedIp.append(ip.substring(0, this.ipCharIndex));
            }

            formattedIp.append(ChatColor.WHITE).append(ip.charAt(this.ipCharIndex));
            if (this.ipCharIndex + 1 < ip.length()) {
                formattedIp.append(ChatColor.YELLOW).append(ip.charAt(this.ipCharIndex + 1));
                if (this.ipCharIndex + 2 < ip.length()) {
                    formattedIp.append(ChatColor.GOLD).append(ip.substring(this.ipCharIndex + 2));
                }

                ++this.ipCharIndex;
            } else {
                this.ipCharIndex = 0;
                this.cooldown = 50;
            }

            return ChatColor.GOLD + formattedIp.toString();
        }
    }

    public ScheduledFuture<?> getGlowingTask() {
        return this.glowingTask;
    }

    public ScheduledFuture<?> getReloadingTask() {
        return this.reloadingTask;
    }
}
