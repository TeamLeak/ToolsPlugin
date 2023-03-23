package com.github.leanfe.fetch;

import com.github.leanfe.config.Configuration;
import com.github.leanfe.tools.MinecraftServerInfo;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class FetchCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player && Configuration.fetchModule.isForConsole()) {
            sender.sendMessage(ChatColor.RED + "Error!");
            return false;
        }

        sender.sendMessage(MinecraftServerInfo.collectServerInfo());

        return true;
    }
}
