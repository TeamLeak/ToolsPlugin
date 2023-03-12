package com.github.leanfe.cryper;

import com.github.leanfe.Application;
import com.github.leanfe.Constants;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class CreeperCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("creeperadd")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("This command can only be executed by a player.");
                return false;
            }

            Player player = (Player) sender;
            ItemStack heldItem = player.getInventory().getItemInMainHand();
            Material heldMaterial = heldItem.getType();
            addAllowedBlock(heldMaterial);

            player.sendMessage("Added " + heldMaterial.toString() + " to allowed blocks.");
            return true;
        }

        if (cmd.getName().equalsIgnoreCase("toolscreeper")) {

            if (args[0].equalsIgnoreCase("disable")) {
                Application.getInstance().getConfig().set("CreeperModule_enabled", false);
                Application.getInstance().saveConfig();
                Constants.reload();

                sender.sendMessage("Disabled creeper module!");

                Application.getInstance().getCommand("creeperadd").setExecutor(null);
                Application.getInstance().getCommand("toolscreeper").setExecutor(null);
            }

            return true;
        }

        return false;
    }

    public void addAllowedBlock(Material block) {
        Constants.CreeperBlocks.add(block.toString().toLowerCase());
    }

}
