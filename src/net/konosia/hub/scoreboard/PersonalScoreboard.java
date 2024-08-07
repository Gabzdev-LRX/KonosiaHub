package net.konosia.hub.scoreboard;

import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.user.User;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class PersonalScoreboard {
    private Player player;
    private final ObjectiveSign objectiveSign;

    PersonalScoreboard(Player player) {
        this.player = player;
        this.objectiveSign = new ObjectiveSign("sidebar", "§6§lKONOSIA");
        this.reloadData();
        this.objectiveSign.addReceiver(player);
    }

    public void reloadData() {
    }

    public void setLines(String ip) {
        LuckPerms luck = LuckPermsProvider.get();

        User user = luck.getPlayerAdapter(Player.class).getUser(this.player);

        String prefix = user.getCachedData().getMetaData().getPrefix();
        this.objectiveSign.setDisplayName("§6§lKONOSIA");
        this.objectiveSign.setLine(0, "§e");
        this.objectiveSign.setLine(1, "§8┃ §7Compte: §6" + player.getName());
        this.objectiveSign.setLine(2, "§8┃ §7Grade: " + prefix);
        this.objectiveSign.setLine(3, "§8┃ §7Coins: §e0 ⛃");
        this.objectiveSign.setLine(4, "§5");
        this.objectiveSign.setLine(5, "§8┃ §7Hub: §d#1");
        this.objectiveSign.setLine(6, "§8┃ §7Connecté(s): §a" + Bukkit.getOnlinePlayers().size());
        this.objectiveSign.setLine(7, "§6");
        this.objectiveSign.setLine(8, "§8» " + ip);
        this.objectiveSign.updateLines();
    }

    public void onLogout() {
        this.objectiveSign.removeReceiver(Bukkit.getServer().getOfflinePlayer(this.player.getUniqueId()));
    }
}
