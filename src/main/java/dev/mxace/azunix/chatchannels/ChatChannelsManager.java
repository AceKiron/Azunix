package dev.mxace.azunix.chatchannels;

import dev.mxace.azunix.Constants;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ChatChannelsManager {
    public final static ChatChannelsManager instance = new ChatChannelsManager();
    private ChatChannelsManager() {
        ChatChannel mainChannel = new ChatChannel(mainChannelName);
        channels.add(mainChannel);

        for (Player player : Bukkit.getOnlinePlayers()) {
            join(player, mainChannelName);
        }


        for (String defaultChannelName : defaultChannelNames.subList(1, defaultChannelNames.size())) channels.add(new ChatChannel(defaultChannelName));
    }

    public String mainChannelName = "main";
    public List<String> defaultChannelNames = Arrays.asList("main", "chan1", "chan2");

    public List<ChatChannel> channels = new ArrayList<ChatChannel>();

    public void leave(Player player) {
        leaveInternal(player);
        joinInternal(player, mainChannelName);
    }

    public void leaveInternal(Player player) {
        for (ChatChannel channel : channels.stream().filter(c -> c.hasPlayer(player)).collect(Collectors.toSet())) {
            channel.leave(player);
            if (channel.getCount() == 0 && !defaultChannelNames.contains(channel.getName())) channels.remove(channel);
        }
    }

    public void join(Player player, String channelName) {
        if (channels.stream().filter(c -> c.getName().equalsIgnoreCase(channelName)).collect(Collectors.toSet()).isEmpty()) {
            player.sendMessage(Constants.MESSAGE_NOT_OK + "Channel '" + channelName + "' doesn't exist.");
            return;
        }

        leaveInternal(player);
        joinInternal(player, channelName);
    }

    public void joinInternal(Player player, String channelName) {
        for (ChatChannel channel : channels.stream().filter(c -> c.getName().equalsIgnoreCase(channelName)).collect(Collectors.toSet())) {
            channel.join(player);
        }
    }

    public void create(String channelName) {
        if (!channels.stream().filter(c -> c.getName().equalsIgnoreCase(channelName)).collect(Collectors.toSet()).isEmpty()) return;

        channels.add(new ChatChannel(channelName));
    }

    public ChatChannel getChannel(Player player) {
        for (ChatChannel channel : channels) {
            if (channel.hasPlayer(player)) {
                return channel;
            }
        }

        return null;
    }

}
