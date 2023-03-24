package com.github.leanfe.jump;

import com.destroystokyo.paper.event.player.PlayerJumpEvent;
import config.Configuration;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

public class JumpListener implements Listener {

    private final float accelerationPercentage = Configuration.jumpModule.getNormalSpeed();

    private final int duration = 5; // in seconds

    private final AtomicBoolean isMessaged = new AtomicBoolean(false);

    private final HashMap<UUID, Boolean> playerList = new HashMap<>();


    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerJump(PlayerJumpEvent event) {
        Player player = event.getPlayer();

        boolean fromPlayerMove = playerList.getOrDefault(player.getUniqueId(), false);

        if (fromPlayerMove && !player.isOp()) {
            player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "You can't move by jumping.");
            event.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();

        int accelerationLevel = Math.round(accelerationPercentage / 100.0f * 2);

        // Check if the player is running without jumping
        if (player.isOnGround() && player.isSprinting() && !player.isFlying()) {
            playerList.put(player.getUniqueId(), true);

            player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20 * duration, accelerationLevel));

            if (!isMessaged.get()) {
                player.sendMessage(ChatColor.GREEN + "You have been accelerated!");
                isMessaged.set(true);
            }
        } else {
            if (isMessaged.get()) {

                player.removePotionEffect(PotionEffectType.SPEED);
                player.sendMessage(ChatColor.GREEN + "All effects have been removed!");
                isMessaged.set(false);

            }
        }
    }
}
