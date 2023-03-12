package com.github.leanfe.jump;

import com.github.leanfe.Application;
import com.github.leanfe.Constants;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class JumpListener implements Listener {

    private final Map<UUID, Integer> jumpCountMap = new HashMap<>();
    private final int accelerationPercentage = Constants.JumpAccelerate;
    private final int decelerationPercentage = Constants.JumpDecelerate;

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();

        // Check if player is running
        if (player.isSprinting()) {
            UUID playerUuid = player.getUniqueId();

            AtomicInteger jumpCount = new AtomicInteger();
            jumpCount.set(jumpCountMap.getOrDefault(playerUuid, 0));

            // Check if player has just started sprinting
            if (player.getVelocity().getX() != 0 || player.getVelocity().getZ() != 0) {
                // Apply acceleration effect
                int accelerationLevel = Math.round((float)accelerationPercentage / 100.0f * 2);
                player.removePotionEffect(PotionEffectType.SLOW);
                player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20*5, accelerationLevel));
            }

            // Wait for jump event
            Bukkit.getScheduler().runTaskLater(Application.getInstance(), () -> {
                if (!player.isOnGround()) {
                    // Player has jumped
                    jumpCount.getAndIncrement();
                    jumpCountMap.put(playerUuid, jumpCount.get());

                    if (jumpCount.get() > 3) {
                        // Player has jumped more than 3 times
                        player.sendMessage("You've jumped too many times while running!");
                        int decelerationLevel = Math.round((float)decelerationPercentage / 100.0f * 2);
                        player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 20*10, decelerationLevel));
                    }
                } else {
                    // Player is on the ground
                    jumpCountMap.put(playerUuid, 0);
                }
            }, 1L);
        } else {
            // Player is not running
            player.removePotionEffect(PotionEffectType.SPEED);
            player.removePotionEffect(PotionEffectType.SLOW);
            jumpCountMap.put(player.getUniqueId(), 0);
        }
    }

}
