package com.github.leanfe.cleaner;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ClearConsole implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player)
            return false;

        clearConsole();
        return true;
    }

    public void clearConsole() {
        ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
        for (int i = 0; i < 100; i++) {
            console.sendMessage("");
        }
        console.sendMessage(ChatColor.GREEN + "Console cleared.");
    }
}
