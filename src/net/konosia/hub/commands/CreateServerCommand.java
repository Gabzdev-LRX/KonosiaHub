package net.konosia.hub.commands;

import net.konosia.hub.KonosiaHub;
import net.konosia.hub.utils.server.ServerUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;

public class CreateServerCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player && args.length == 0) {
            Player player = (Player) sender;

            createHost(player);

        }

        return false;
    }

    public static void createHost(Player player) {
        player.sendMessage("§aDemande de création d'host vers ??? en cours");
        final List<String> bar_cache = new ArrayList<>();
        bar_cache.add("§6▁▂▃▄▅▆▇▉▉▇▆▅▄▃▂▁");
        bar_cache.add("§6▁▁▂▃▄▅▆▇▉▉▇▆▅▄▃▂");
        bar_cache.add("§6▂▁▁▂▃▄▅▆▇▉▉▇▆▅▄▃");
        bar_cache.add("§6▃▂▁▁▂▃▄▅▆▇▉▉▇▆▅▄");
        bar_cache.add("§6▄▃▂▁▁▂▃▄▅▆▇▉▉▇▆▅");
        bar_cache.add("§6▅▄▃▂▁▁▂▃▄▅▆▇▉▉▇▆");
        bar_cache.add("§6▆▅▄▃▂▁▁▂▃▄▅▆▇▉▉▇");
        bar_cache.add("§6▇▆▅▄▃▂▁▁▂▃▄▅▆▇▉▉");
        bar_cache.add("§6▉▇▆▅▄▃▂▁▁▂▃▄▅▆▇▉");
        bar_cache.add("§6▉▉▇▆▅▄▃▂▁▁▂▃▄▅▆▇");
        bar_cache.add("§6▇▉▉▇▆▅▄▃▂▁▁▂▃▄▅▆");
        bar_cache.add("§6▅▆▇▉▉▇▆▅▄▃▂▁▁▂▃▄");
        bar_cache.add("§6▄▅▆▇▉▉▇▆▅▄▃▂▁▁▂▃");
        bar_cache.add("§6▂▃▄▅▆▇▉▉▇▆▅▄▃▂▁▁");
        (new BukkitRunnable() {
            List<String> bar = new ArrayList(bar_cache);

            public void run() {
                ServerUtils.sendTitle(player, 20, 40, 20, bar.toString(), "");
                this.cancel();


            }
        }).runTaskTimer(KonosiaHub.getInstance(), 10L, 10L);
    }
}


