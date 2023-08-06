package dev.mxace.azunix.handlers;

import dev.mxace.azunix.Constants;
import dev.mxace.azunix.chatchannels.ChatChannel;
import dev.mxace.azunix.chatchannels.ChatChannelsManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatHandler implements Listener {

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        event.setCancelled(true);

        ChatChannel channel = ChatChannelsManager.instance.getChannel(event.getPlayer());

        String message = "<" + event.getPlayer().getDisplayName() + "> " + event.getMessage();
        String readallMessage = Constants.PRIMARY_COLOR + "[" + channel.getName() + "] " + ChatColor.RESET + message;

        Bukkit.getLogger().info(readallMessage);

        for (Player player : Bukkit.getOnlinePlayers()) {
            if (channel.hasPlayer(player)) {
                player.sendMessage(message);
            } else if (player.hasPermission("azunix.channel.readall")) {
                player.sendMessage(readallMessage);
            }
        }
    }

}
