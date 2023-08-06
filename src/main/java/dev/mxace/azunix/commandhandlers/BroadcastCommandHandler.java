package dev.mxace.azunix.commandhandlers;

import dev.mxace.azunix.Constants;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BroadcastCommandHandler implements CommandExecutor {
    public final static BroadcastCommandHandler instance = new BroadcastCommandHandler();
    private BroadcastCommandHandler() {

    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) return false;

        String message = "";
        for (String arg : args) {
            message += " " + arg;
        }
        message = Constants.MESSAGE_BROADCAST + message.substring(1);

        Bukkit.getLogger().info(message);
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.sendMessage(message);
        }

        return true;
    }
}
