package com.github.leanfe.jump;

import com.github.leanfe.Application;
import com.github.leanfe.Constants;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.concurrent.atomic.AtomicBoolean;

public class JumpListener implements Listener {
    private final int accelerationPercentage = Constants.JumpAccelerate;
    private final int decelerationPercentage = Constants.JumpDecelerate;

    private final AtomicBoolean isMessaged = new AtomicBoolean(false);

    private final AtomicBoolean isAccelerated = new AtomicBoolean(false);


    private final AtomicBoolean afterWhile = new AtomicBoolean(false);

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        // Check if the player is jumping

        Player player = event.getPlayer();

        if (player.isFlying())
            return;

        int accelerationLevel = Math.round((float)accelerationPercentage / 100.0f * 2);
        int decelerationLevel = Math.round((float)decelerationPercentage / 100.0f * 2);

        Bukkit.getScheduler().runTaskAsynchronously(Application.getInstance(), () -> {

            while (player.isSprinting()) {
                afterWhile.set(true);

                if (!player.isJumping()) {
                    if (!isAccelerated.get()) {
                        player.sendMessage(ChatColor.GREEN + "You have been accelerated!");
                        isAccelerated.set(true);
                    }

                    player.removePotionEffect(PotionEffectType.SLOW);
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20*5, accelerationLevel));
                } else {
                    if (!isMessaged.get()) {
                        player.sendMessage(ChatColor.RED + "You have been slowed down as you move through jumps!");
                        isMessaged.set(true);
                    }

                    player.removePotionEffect(PotionEffectType.SPEED);
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 20*10, decelerationLevel));
                }
            }

            if (afterWhile.get()) {
                player.sendMessage(ChatColor.BLUE + "All effects have been removed!");
                player.removePotionEffect(PotionEffectType.SPEED);
                player.removePotionEffect(PotionEffectType.SLOW);

                afterWhile.set(false);
            }
        });
    }

}
