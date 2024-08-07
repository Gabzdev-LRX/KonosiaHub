package net.konosia.hub.listeners.player;

import net.konosia.hub.KonosiaHub;
import net.konosia.hub.utils.guis.CustomItemStack;
import net.konosia.hub.utils.server.ServerUtils;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.user.User;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.material.EnderChest;

public class PlayerJoin implements Listener {

    private static CustomItemStack boutique = (new CustomItemStack(CustomItemStack.getSkull("http://textures.minecraft.net/texture/f2784307b892f52b92f74fa9db4984c4f0f02eb81c6752e5eba69ad67858427e"))).setName("§e§lBoutique §8▪ §7(Clique-Droit)");
    private static CustomItemStack menu = (new CustomItemStack(Material.COMPASS).setName("§6§lMenu principal §8▪ §7(Clic-Droit)"));
    private static CustomItemStack cos = (new CustomItemStack(CustomItemStack.getSkull("http://textures.minecraft.net/texture/3ef80aaaeef6f9b2878859822d81ac70bd8c796b1d17cc41b797cb2bc6551feb"))).setName("§d§lCosmetiques §8▪ §7(Clic-Droit)");
    private static CustomItemStack lobbys = (new CustomItemStack(Material.NETHER_STAR)).setName("§b§lSélécteur de Lobbys §8▪ §7(Clique-Droit)");


    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        event.setJoinMessage(null);
        ServerUtils.sendTitle(player, 20, 40, 20, "§8» §6§lKONOSIA §8«", "§fExcellente session de jeu sur nos Plateformes !");
        player.sendMessage("");
        player.sendMessage("§6§lKONOSIA §f┃ §7Heureux de te voir §6" + player.getName() + " §7!");
        player.sendMessage("");
        player.sendMessage("§8» §7Cliquez sur la boussole pour découvrir nos Jeux!");
        player.sendMessage("§8» §7Ainsi vous aller retrouvé nos modes jeux comme le §b§kéééééé§7 !");
        player.sendMessage("");
        player.sendMessage("§8» §6l'Équipe de Konosia vous souhaite une agréable session de jeu!");
        player.sendMessage("");
        LuckPerms luckPerms = LuckPermsProvider.get();
        User user = luckPerms.getPlayerAdapter(Player.class).getUser(player);
        KonosiaHub.getInstance().getScoreboardManager().onLogin(player);
        player.setMaxHealth(20.0D);
        player.setHealth(20.0D);
        player.setFoodLevel(20);
        player.setWalkSpeed(0.2F);
        player.setFireTicks(0);
        player.setFallDistance(0.0F);
        player.setGameMode(GameMode.ADVENTURE);
        player.getInventory().clear();
        player.getInventory().setItem(8, lobbys);
        player.getInventory().setItem(4, cos);
        player.getInventory().setItem(1, boutique);
        player.getInventory().setItem(0, menu);
        player.playSound(player.getLocation(), Sound.NOTE_PLING, 1.0F, 1.0F);

        if (player.isOp()) {
                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "§" + user.getCachedData().getMetaData().getPrefix()) + "" + player.getName() + " §6§oà rejoint votre Hub!");
            }

    }

    public static CustomItemStack getCos() {
        return cos;
    }

    public static CustomItemStack getBoutique() {
        return boutique;
    }

    public static CustomItemStack getLobbys() {
        return lobbys;
    }

    public static CustomItemStack getMenu() {
        return menu;
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            if (event.getClickedBlock().getState() instanceof EnderChest) {
                player.sendMessage("niktamèr");
            }
        }
    }
}
