package com.github.leanfe.jump;

import com.github.leanfe.Constants;
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

    private final int duration = 5; // in seconds

    private final AtomicBoolean isMessaged = new AtomicBoolean(false);

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();

        int accelerationLevel = Math.round((float) accelerationPercentage / 100.0f * 2);

        // Check if the player is running without jumping
        if (player.isOnGround() && player.isSprinting() && !player.isFlying()) {
            player.removePotionEffect(PotionEffectType.SLOW);
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
