package dev.mxace.azunix.handlers;

import dev.mxace.azunix.chatchannels.ChatChannel;
import dev.mxace.azunix.chatchannels.ChatChannelsManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class LeaveHandler implements Listener {

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        ChatChannelsManager.instance.leaveInternal(event.getPlayer());
    }

}
