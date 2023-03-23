package com.github.leanfe.cryper;

import com.github.leanfe.config.Configuration;
import com.github.leanfe.config.modules.CreeperModule;
import com.github.leanfe.module.ModuleManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityExplodeEvent;

import java.util.HashSet;
import java.util.Set;

public class CryperListener implements Listener {

    private final Set<Material> allowedBlocks = new HashSet<>();

    {

        Configuration.creeperModule.getCreeperBlocks().forEach(blockName -> {
            Material blockMaterial = Material.getMaterial(blockName);
            if (blockMaterial != null) {
                allowedBlocks.add(blockMaterial);
            } else {
                Bukkit.getLogger().warning("Invalid block name: " + blockName);
            }
        });
    }

    private final boolean isDamageEnabled = Configuration.creeperModule.isLeaveDamage();

    @EventHandler
    public void onEntityExplode(EntityExplodeEvent event) {
        event.blockList().removeIf(block -> allowedBlocks.contains(block.getType()));
    }

    @EventHandler
    public void onEntityDamage(EntityDamageEvent event) {
        if (event.getEntity() instanceof Player && !isDamageEnabled) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Creeper && event.getEntity() instanceof Player) {
            if (!isDamageEnabled) {
                event.setCancelled(true);
            }
        }
    }

}
