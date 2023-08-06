package dev.mxace.azunix.handlers;

import dev.mxace.azunix.chatchannels.ChatChannelsManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinHandler implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        ChatChannelsManager.instance.join(event.getPlayer(), ChatChannelsManager.instance.mainChannelName);
    }

}
