package com.github.leanfe.creeper;

import com.github.leanfe.config.Configuration;
import com.github.leanfe.core.instance.InstanceManager;
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
                InstanceManager.getInstance().getConfig().set("CreeperModule_enabled", false);
                InstanceManager.getInstance().saveConfig();

                Configuration.creeperModule.reload();

                sender.sendMessage("Disabled creeper module!");

                InstanceManager.getInstance().getCommand("creeperadd").setExecutor(null);
                InstanceManager.getInstance().getCommand("toolscreeper").setExecutor(null);
            }

            return true;
        }

        return false;
    }

    public void addAllowedBlock(Material block) {
        Configuration.creeperModule.getCreeperBlocks().add(block.toString().toLowerCase());
    }

}
