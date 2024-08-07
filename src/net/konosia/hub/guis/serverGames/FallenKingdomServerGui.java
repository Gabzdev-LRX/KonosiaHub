package net.konosia.hub.guis.serverGames;

import net.konosia.hub.utils.core.HeadUtils;
import net.konosia.hub.utils.guis.CustomItemStack;
import net.konosia.hub.utils.guis.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public class FallenKingdomServerGui implements InventoryHolder, Listener {


    private Inventory inventory;
    private Integer[] glass = {0,1,7,8,9,17,36,44,45,46,52,53};


    public FallenKingdomServerGui(Player player) {
        this.inventory = Bukkit.createInventory(this, 54, "§8» §cListe de Serveur(s):");

        //NON CONNECTE A LA PARTIE DEMANDE DE DESIGN PAR NEWHALL

        this.inventory.setItem(20, new ItemBuilder(HeadUtils.RED_BALL.getItemStack()).setName("§8» §c§lFallenKingdom-1").setLore("", "§8» §7État: §cFin", "§8» §7Timer: §f00:00:00" , "", "§8» §eCliquez pour observer la partie!").build());

        this.inventory.setItem(49, new ItemBuilder(Material.BARRIER).setName("§8» §cFermer l'inventaire").build());
        this.inventory.setItem(48, new ItemBuilder(Material.ARROW).setName("§8» §aRetourner en arrière").build());

        for (int i : glass) {
            this.inventory.setItem(i, CustomItemStack.getPane(14));
        }

        player.openInventory(inventory);
    }



    @Override
    public Inventory getInventory() {
        return inventory;
    }
}
