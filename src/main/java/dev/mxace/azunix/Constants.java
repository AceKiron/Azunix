package dev.mxace.azunix;

import org.bukkit.ChatColor;

public class Constants {

    public final static ChatColor PRIMARY_COLOR = ChatColor.AQUA;
    public final static ChatColor SECONDARY_COLOR = ChatColor.DARK_AQUA;

    public final static String MESSAGE_PREFIX = PRIMARY_COLOR + "[Azunix] " + ChatColor.RESET;

    public final static String MESSAGE_OK = MESSAGE_PREFIX + ChatColor.GREEN;
    public final static String MESSAGE_NOT_OK = MESSAGE_PREFIX + ChatColor.RED;

    public final static String MESSAGE_BROADCAST = PRIMARY_COLOR + "[Azunix/Broadcast] " + SECONDARY_COLOR;

}
