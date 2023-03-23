package com.github.leanfe.optimization;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import static com.github.leanfe.optimization.Optimizer.*;

public class OptimizationHandler implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (args.length < 1) {
            sender.sendMessage("USAGE: /optimize <RAM/CPU/COLLECTOR/ABANDONED/ALL>");
            return false;
        }

        switch (args[0]) {
            case "RAM" -> clearRAM();
            case "COLLECTOR" -> callCollector();
            case "CPU" -> reduceCPU();
            case "ABANDONED" -> deleteAbandoned();
            default -> optimize();
        }

        sender.sendMessage(ChatColor.GREEN + "[LOG] DONE!");

        return true;
    }

}
