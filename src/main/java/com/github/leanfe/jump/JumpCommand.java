package com.github.leanfe.jump;

import com.github.leanfe.Application;
import com.github.leanfe.Constants;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class JumpCommand implements CommandExecutor {

    private static final Application instance = Application.getInstance();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!sender.hasPermission("toolsjump.admin")) {
            sender.sendMessage("You do not have permission to use this command.");
            return false;
        }

        if (args.length < 2) {
            sender.sendMessage(ChatColor.GREEN + "Usage: /toolsjump <add/decrease> <percentage> \n" +
                    ChatColor.BLUE + "* decrease -> Set the percentage by which the speed in the jump will change." +
                    ChatColor.GOLD + "* add -> Set the percentage by which the running speed will change.");
            return false;
        }

        String operation = args[0].toLowerCase();
        int percentage;

        try {
            percentage = Integer.parseInt(args[1].replace("%", ""));
        } catch (NumberFormatException e) {
            sender.sendMessage(ChatColor.RED + "Invalid percentage value: " + args[1]);
            return false;
        }

        if ("add".equals(operation)) {
            instance.getConfig().set("NormalSpeed", percentage);
            instance.saveConfig();

            Constants.reload();

            sender.sendMessage(ChatColor.GREEN + "Acceleration percentage increased by " + percentage + "%.");
        } else if ("decrease".equals(operation)) {
            instance.getConfig().set("JumpSpeed", percentage);
            instance.saveConfig();

            Constants.reload();

            sender.sendMessage(ChatColor.GREEN + "Acceleration percentage decreased by " + percentage + "%.");
        } else {
            sender.sendMessage(ChatColor.RED + "Invalid operation: " + operation);
            return false;
        }

        return true;
    }

}
