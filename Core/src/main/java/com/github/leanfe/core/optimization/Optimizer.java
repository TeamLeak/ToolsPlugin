package com.github.leanfe.core.optimization;

import com.github.leanfe.config.Configuration;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.entity.Entity;

import java.util.Arrays;
import java.util.logging.Level;

public class Optimizer {

    private static int abandonedObjectTimer = Configuration.optimizationModule.getAbandonedObjectTimer();
    private static final int maxChunksPerTick = Configuration.optimizationModule.getMaxChunksPerTick();

    private static void haveUnused(World world) {
        for (Chunk e : Arrays.stream(world.getLoadedChunks()).toList()) {
            if (Arrays.stream(e.getEntities()).findAny().isPresent()) {
                e.unload();
            }
        }
    }

    public static void callCollector() {
        System.gc();
    }

    public static void clearRAM() {
        for (World world : Bukkit.getWorlds()) {
            haveUnused(world);
        }
    }

    public static void reduceCPU() {
        for (World world : Bukkit.getWorlds()) {
            int loadedChunks = world.getLoadedChunks().length;
            int chunksToUnload = loadedChunks - maxChunksPerTick;
            if (chunksToUnload > 0) {
                for (int i = 0; i < chunksToUnload; i++) {
                    world.getLoadedChunks()[i].unload(true);
                }
            }
        }
    }

    public static void deleteAbandoned() {
        abandonedObjectTimer++;
        if (abandonedObjectTimer >= 100) {
            abandonedObjectTimer = 0;
            for (World world : Bukkit.getWorlds()) {
                for (Entity entity : world.getEntities()) {
                    if (entity.isDead()) {
                        entity.remove();
                    }
                }
            }
        }
    }

    public static void optimize() {
        Bukkit.getLogger().log(Level.INFO, "Start optimization..");

        // Call the garbage collector
        callCollector();

        // Clear RAM by unloading unused chunks
        clearRAM();

        // Reduce CPU load by limiting the number of loaded chunks per tick
        reduceCPU();

        // Remove abandoned objects every 5-10 seconds, taking a value from a variable
        deleteAbandoned();

        // Do not count chunks in which there is no one
        for (World world : Bukkit.getWorlds()) {
            world.setKeepSpawnInMemory(false);
            world.setTicksPerAnimalSpawns(1);
            world.setTicksPerMonsterSpawns(1);
        }

        Bukkit.getLogger().log(Level.INFO, "Optimization finished!");
    }
}
