package dev.mxace.azunix.commandhandlers;

import dev.mxace.azunix.Constants;
import dev.mxace.azunix.chatchannels.ChatChannel;
import dev.mxace.azunix.chatchannels.ChatChannelsManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ChannelCommandHandler implements CommandExecutor {
    public final static ChannelCommandHandler instance = new ChannelCommandHandler();
    private ChannelCommandHandler() {

    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) return false;

        Player player = sender instanceof Player ? (Player) sender : null;

        switch (args[0]) {
            case "join":
                if (args.length == 1) return false;
                if (player == null) {
                    sender.sendMessage(Constants.MESSAGE_NOT_OK + "Only players can use this command.");
                    return true;
                }
                ChatChannelsManager.instance.join(player, args[1]);
                return true;

            case "leave":
                ChatChannelsManager.instance.leave(player);
                if (player == null) {
                    sender.sendMessage(Constants.MESSAGE_NOT_OK + "Only players can use this command.");
                    return true;
                }
                return true;

            case "create":
                if (args.length == 1) return false;
                if (player == null) {
                    sender.sendMessage(Constants.MESSAGE_NOT_OK + "Only players can use this command.");
                    return true;
                }
                ChatChannelsManager.instance.create(args[1]);
                ChatChannelsManager.instance.join(player, args[1]);
                return true;

            case "list":
                String message = "";
                for (ChatChannel channel : ChatChannelsManager.instance.channels) {
                    message += ", " + Constants.SECONDARY_COLOR + channel.getName() + "(" + channel.getCount() + ")" + ChatColor.RESET;
                }
                sender.sendMessage(Constants.MESSAGE_PREFIX + message.substring(2));
                return true;
        }

        return false;
    }

}
