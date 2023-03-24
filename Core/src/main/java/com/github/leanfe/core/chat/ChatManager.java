package com.github.leanfe.core.chat;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class ChatManager {

    public static void clearChat() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            for (int i = 0; i < 100; i++) {
                player.sendMessage("");
            }
        }

        Bukkit.getServer().broadcast(Component.text(ChatColor.GREEN + "[CHAT] cleared."));
    }

    public static void clearConsole() {
        ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
        for (int i = 0; i < 100; i++) {
            console.sendMessage("");
        }
        console.sendMessage(ChatColor.GREEN + "Console cleared.");
    }

}
