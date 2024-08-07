package net.konosia.hub.listeners.player;


import net.konosia.hub.guis.PrincipalGui;
import net.konosia.hub.guis.serverGames.FallenKingdomServerGui;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerInventory implements Listener {

    @EventHandler
    public boolean onClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        ItemStack current = event.getCurrentItem();

        if (event.getCurrentItem() == null) return false;

        if (event.getInventory().getHolder() != null) {
            if (event.getInventory().getHolder() instanceof PrincipalGui) {
                event.setCancelled(true);


                if (current.getType().equals(Material.TNT) && current.hasItemMeta() && current.getItemMeta().hasDisplayName()) {
                    if (current.getItemMeta().getDisplayName().equalsIgnoreCase("§f» §c§lFallenKingdom §f┃ §61.8")) {
                        if (event.getClick().isRightClick()) {
                            player.closeInventory();
                            player.playSound(player.getLocation(), Sound.VILLAGER_NO, 1f, 1f);
                            player.sendMessage("§6§lKONOSIA §f┃ §cCe serveur est hors-ligne.");
                        } else {
                            new FallenKingdomServerGui(player);
                        }
                    }
                    return false;
                } else if (current.getType().equals(Material.BARRIER) && current.hasItemMeta() && current.getItemMeta().hasDisplayName()) {
                    if (current.getItemMeta().getDisplayName().equalsIgnoreCase("§8» §cFermer l'inventaire")) {
                        player.closeInventory();
                    }
                    return false;


                }
            }
        }
        return false;
    }


    @EventHandler
    public boolean onClickFKGUI(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        ItemStack current = event.getCurrentItem();

        if (event.getCurrentItem() == null) return false;

        if (event.getInventory().getHolder() != null) {
            if (event.getInventory().getHolder() instanceof FallenKingdomServerGui) {
                event.setCancelled(true);


                if (current.getType().equals(Material.SKULL_ITEM) && current.hasItemMeta() && current.getItemMeta().hasDisplayName()) {
                    if (current.getItemMeta().getDisplayName().equalsIgnoreCase("§8» §c§lFallenKingdom-1")) {
                        player.closeInventory();
                        player.playSound(player.getLocation(), Sound.VILLAGER_NO, 1f, 1f);
                        player.sendMessage("§c§lERREUR §f┃ §cImpossible de rejoindre l'Instance demandé :(");
                    }
                    return false;
                } else if (current.getType().equals(Material.BARRIER) && current.hasItemMeta() && current.getItemMeta().hasDisplayName()) {
                    if (current.getItemMeta().getDisplayName().equalsIgnoreCase("§8» §cFermer l'inventaire")) {
                        player.closeInventory();
                    }
                    return false;

                } else if (current.getType().equals(Material.ARROW) && current.hasItemMeta() && current.getItemMeta().hasDisplayName()) {
                    if (current.getItemMeta().getDisplayName().equalsIgnoreCase("§8» §aRetourner en arrière")) {
                        new PrincipalGui(player);
                    }
                    return false;
                }
            }
        }
        return false;
    }

}

