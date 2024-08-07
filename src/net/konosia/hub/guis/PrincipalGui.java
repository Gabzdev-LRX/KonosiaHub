package net.konosia.hub.guis;


import net.konosia.hub.utils.guis.CustomItemStack;
import net.konosia.hub.utils.guis.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class PrincipalGui implements InventoryHolder, Listener {


    private Inventory inventory;
    private Integer[] glass = {0,1,7,8,9,17,36,44,45,46,52,53};


    public PrincipalGui(Player player) {
        this.inventory = Bukkit.createInventory(this, 54, "§8» §6Menu Principal");

        this.inventory.setItem(21, new ItemBuilder(Material.TNT).setName("§f» §c§lFallenKingdom §f┃ §61.8").setLore("", "§8» §7État: §cHors-Ligne", "§8» §7Développeur(s): §cGabriel__lrx", "", "§8» §eClique-Droit pour rejoindre une partie", "§8» §eClique-Gauche pour voir les serveurs").build());

        this.inventory.setItem(49, new ItemBuilder(Material.BARRIER).setName("§8» §cFermer l'inventaire").build());

        for (int i : glass) {
            this.inventory.setItem(i, CustomItemStack.getPane(1));
        }

        player.openInventory(inventory);
    }



    @Override
    public Inventory getInventory() {
        return inventory;
    }

}


