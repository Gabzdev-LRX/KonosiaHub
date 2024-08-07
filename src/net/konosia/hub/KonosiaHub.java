package net.konosia.hub;

import net.konosia.hub.commands.CreateServerCommand;
import net.konosia.hub.listeners.player.PlayerChat;
import net.konosia.hub.listeners.player.PlayerClickItem;
import net.konosia.hub.listeners.player.PlayerInventory;
import net.konosia.hub.listeners.player.PlayerJoin;
import net.konosia.hub.listeners.world.BlockEvent;
import net.konosia.hub.npc.FallenKingdomNPC;
import net.konosia.hub.scoreboard.ScoreboardManager;
import net.konosia.hub.utils.server.ServerUtils;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class KonosiaHub extends JavaPlugin {

    private ScoreboardManager scoreboardManager;
    private ScheduledExecutorService executorMonoThread;
    private ScheduledExecutorService scheduledExecutorService;
    private static KonosiaHub Instance;

    @Override
    public void onEnable() {
        this.scheduledExecutorService = Executors.newScheduledThreadPool(16);
        this.executorMonoThread = Executors.newScheduledThreadPool(1);
        this.scoreboardManager = new ScoreboardManager(this);
        Instance = this;

        ServerUtils.print("KonosiaHub >> Attention le Plugin est en phase de TEST.");
        ServerUtils.print("KonosiaHub >> New si tu vois des problèmes mp moi pls");

        registerListeners();

        getCommand("test").setExecutor(new CreateServerCommand());
    }

    private void registerListeners() {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new PlayerClickItem(), this);
        pm.registerEvents(new PlayerInventory(), this);
        pm.registerEvents(new PlayerJoin(), this);
        pm.registerEvents(new BlockEvent(), this);
        pm.registerEvents(new FallenKingdomNPC(), this);
        pm.registerEvents(new PlayerChat(), this);
    }

    @Override
    public void onDisable() {

    }

    public static KonosiaHub getInstance() {
        return Instance;
    }

    public ScheduledExecutorService getExecutorMonoThread() {
        return this.executorMonoThread;
    }

    public ScheduledExecutorService getScheduledExecutorService() {
        return this.scheduledExecutorService;
    }

    public ScoreboardManager getScoreboardManager() {
        return this.scoreboardManager;
    }
}
