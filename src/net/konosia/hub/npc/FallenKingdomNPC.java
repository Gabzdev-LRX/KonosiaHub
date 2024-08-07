package net.konosia.hub.npc;


import java.util.Arrays;

import net.jitse.npclib.NPCLib;
import net.jitse.npclib.api.NPC;
import net.jitse.npclib.api.events.NPCInteractEvent;
import net.jitse.npclib.api.skin.Skin;
import net.konosia.hub.KonosiaHub;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class FallenKingdomNPC implements Listener {
    private NPCLib npcLib = new NPCLib(KonosiaHub.getInstance());
    private NPC fkNPC;

    public FallenKingdomNPC() {
        this.load();
        Bukkit.getPluginManager().registerEvents(this, KonosiaHub.getInstance());
    }

    private void load() {
        Skin skin = new Skin("ewogICJ0aW1lc3RhbXAiIDogMTcwNDU0MTM5Nzc4NCwKICAicHJvZmlsZUlkIiA6ICI1OWZmOTU1YzMxYjk0MWI0YWQwNDg4NDk0ODkzNzUzOCIsCiAgInByb2ZpbGVOYW1lIiA6ICJNZWdhMzQ5IiwKICAic2lnbmF0dXJlUmVxdWlyZWQiIDogdHJ1ZSwKICAidGV4dHVyZXMiIDogewogICAgIlNLSU4iIDogewogICAgICAidXJsIiA6ICJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlLzEzNzVlNzZjZDFkZDIyMzE3ZTVjNmY4ZTFlNzk1NDE0OWNlMTQ1YTg3ODg2NDZmNTQxOWEwNDUyMDJiY2I3Y2MiCiAgICB9CiAgfQp9", "TxbVFfFuD/U97oKGXpCg0mtEPaR6etA1GtC73xDw4YZXFPW4nf7iLkrF43YrjsCdDiWSgDV3QPmf5WBhm3bzUnXPilRnmkt+P9tBactxqQRN//Dxebe+nEpmtUMFN5J0nubINNJF/zh+nofyOvXzf1AM6y/EA5Sa51qj+lGW32SBAY9SIFSkVyWWeRPmXRKeWlegGGy456TBYSk3M2g2FqXdlTkOdXzKI1j6ev+JYRI/g4DPS8ARJFeFH07oTssWc08kgiznQmr4OwBxWEa5TO8nm49Ryxgd3IFmu8bGdkals/IAJvQp9Eex7jEvxwjEuVmYYLjz+ZuwEM31x6DCyttIxma/8CT3uUBPyT/s/km21F5FSr3wHB4ZE+TY6cZ5bN5tdwL3vYo0jQc1oGG+L5OhKOMi8mWZm3JdpBnJ6hkk7j2SiLX8mzGysHynTLmZz2H2p1EKkOKsoqPVLsiXgAwcAIKLBvYbsm5hqgxgZp40aKw/oz1rsQmvvfmlVN9r9yqkHKSQ8DY8GEbSToyMON8cZ1zHMdAkJqvXp7QQSmzdlSYNKDNEMFh0OlY4xCL0/xAybm9KUixEPoGyPcWlkXW3khsf4LkxH54pLw5cXVIqxujEmhjmL5TNiBj1QzHbuWFKX5LDBc2jPd+0K9zpGHeAuEt10kFrIAg9JDOfZXI=");
        FallenKingdomNPC.this.fkNPC = FallenKingdomNPC.this.npcLib.createNPC(Arrays.asList("§c§lFallenKingdom §f▪ §cAucun Serveur", "§f§l»§b§l» §f§lCLIQUE-ICI §b§l«§f§l«"));
        FallenKingdomNPC.this.fkNPC.setLocation(new Location(Bukkit.getWorld("world"), 20.451, 84, 10.485, -144.8F, 0.4F));
        FallenKingdomNPC.this.fkNPC.setSkin(skin);

        FallenKingdomNPC.this.fkNPC.create();
    }

    @EventHandler
    public void onNPCInteract(NPCInteractEvent event) {
        Player player = event.getWhoClicked();
        if (event.getNPC() == this.fkNPC) {
            player.playSound(player.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
        }

    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        this.fkNPC.show(player);
    }
}
