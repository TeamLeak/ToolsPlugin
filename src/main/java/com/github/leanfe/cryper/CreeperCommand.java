package com.github.leanfe.cryper;

import com.github.leanfe.Application;
import com.github.leanfe.config.Configuration;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class CreeperCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, Command cmd, @NotNull String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("creeperadd")) {
            if (!(sender instanceof Player player)) {
                sender.sendMessage("This command can only be executed by a player.");
                return false;
            }

            ItemStack heldItem = player.getInventory().getItemInMainHand();
            Material heldMaterial = heldItem.getType();
            addAllowedBlock(heldMaterial);

            player.sendMessage("Added " + heldMaterial + " to allowed blocks.");
            return true;
        }

        if (cmd.getName().equalsIgnoreCase("toolscreeper")) {

            if (args[0].equalsIgnoreCase("disable")) {
                Application.getInstance().getConfig().set("CreeperModule_enabled", false);
                Application.getInstance().saveConfig();

                Configuration.creeperModule.reload();

                sender.sendMessage("Disabled creeper module!");

                Application.getInstance().getCommand("creeperadd").setExecutor(null);
                Application.getInstance().getCommand("toolscreeper").setExecutor(null);
            }

            return true;
        }

        return false;
    }

    public void addAllowedBlock(Material block) {
        Configuration.creeperModule.getCreeperBlocks().add(block.toString().toLowerCase());
    }

}
