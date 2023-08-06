package dev.mxace.azunix;

import dev.mxace.azunix.chatchannels.ChatChannelsManager;
import dev.mxace.azunix.commandhandlers.BroadcastCommandHandler;
import dev.mxace.azunix.commandhandlers.ChannelCommandHandler;
import dev.mxace.azunix.handlers.ChatHandler;
import dev.mxace.azunix.handlers.JoinHandler;
import dev.mxace.azunix.handlers.LeaveHandler;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Azunix extends JavaPlugin {
    public static Azunix instance;

    @Override
    public void onEnable() {
        instance = this;

        Bukkit.getPluginManager().registerEvents(new ChatHandler(), this);
        Bukkit.getPluginManager().registerEvents(new JoinHandler(), this);
        Bukkit.getPluginManager().registerEvents(new LeaveHandler(), this);

        getCommand("channel").setExecutor(ChannelCommandHandler.instance);
        getCommand("broadcast").setExecutor(BroadcastCommandHandler.instance);

        Bukkit.getLogger().info("Default channels size: " + ChatChannelsManager.instance.defaultChannelNames.size());
    }

    @Override
    public void onDisable() {

    }

}
