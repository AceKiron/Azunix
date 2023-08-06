package dev.mxace.azunix.chatchannels;

import dev.mxace.azunix.Constants;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class ChatChannel {

    private List<Player> players;
    private String name;

    public ChatChannel(String name) {
        players = new ArrayList<Player>();
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public int getCount() {
        return players.size();
    }

    public boolean hasPlayer(Player player) {
        return players.contains(player);
    }

    public void leave(Player player) {
        for (Player player1 : players) {
            player1.sendMessage(Constants.MESSAGE_NOT_OK + player.getDisplayName() + " left the channel '" + name + "'.");
        }

        players.remove(player);
        String playersLeft = "";
        for (Player p : players) {
            playersLeft += "," + p.getDisplayName();
        }
        Bukkit.getLogger().info("Player " + player.getDisplayName() + " left channel " + name + ", now there is " + playersLeft + " left.");
    }

    public void join(Player player) {
        players.add(player);

        for (Player player1 : players) {
            player1.sendMessage(Constants.MESSAGE_OK + player.getDisplayName() + " joined the channel '" + name + "'.");
        }

        String playersLeft = "";
        for (Player p : players) {
            playersLeft += "," + p.getDisplayName();
        }
        Bukkit.getLogger().info("Player " + player.getDisplayName() + " joined channel " + name + ", now there is " + playersLeft + " in this channel.");
    }

}
