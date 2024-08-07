package net.konosia.hub.listeners.player;

import net.konosia.hub.guis.PrincipalGui;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.user.User;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerClickItem implements Listener {
    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        if (e.getAction() != Action.PHYSICAL) {
            LuckPerms luckPerms = LuckPermsProvider.get();
            User user = luckPerms.getPlayerAdapter(Player.class).getUser(player);
            ItemStack current = e.getItem();
            if (current != null) {
                if (this.getName(current).equalsIgnoreCase(this.getName(PlayerJoin.getMenu()))) {
                    new PrincipalGui(player);
                    e.setCancelled(true);
                } else if (this.getName(current).equalsIgnoreCase(this.getName(PlayerJoin.getBoutique()))) {
                    player.sendMessage("§6§lKONOSIA §f┃ §cCette option n'est pas encore disponible.");
                    e.setCancelled(true);
                } else if (this.getName(current).equalsIgnoreCase(this.getName(PlayerJoin.getCos()))) {
                    e.setCancelled(true);
                    player.sendMessage("§d§lCOSMÉTIQUES §f┃ §cLes cosmétiques ont été désactivées sur ce serveur!");
                } else if (this.getName(current).equalsIgnoreCase(this.getName(PlayerJoin.getLobbys()))) {
                    e.setCancelled(true);
                }

            }
        }
    }

    public String getName(ItemStack it) {
        return it.hasItemMeta() && it.getItemMeta().hasDisplayName() ? it.getItemMeta().getDisplayName() : it.getType().toString();
    }
}
