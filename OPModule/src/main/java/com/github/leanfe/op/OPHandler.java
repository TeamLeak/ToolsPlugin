package com.github.leanfe.op;

import config.Configuration;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class OPHandler implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player))
            return true;

        if (command.getName().equalsIgnoreCase("op")) {
            sender.sendMessage(ChatColor.stripColor(Configuration.opModule.getOpMessage()));
            return false;
        }
        return true;
    }

}
