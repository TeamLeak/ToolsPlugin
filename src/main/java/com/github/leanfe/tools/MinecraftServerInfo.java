package com.github.leanfe.tools;

import org.bukkit.Bukkit;

public class MinecraftServerInfo {

    public static String[] collectServerInfo() {
        String[] serverInfo = new String[5];

        // Get server core information
        String serverCore = Bukkit.getServer().getName();

        // Get RAM information
        Runtime runtime = Runtime.getRuntime();
        long maxMemory = runtime.maxMemory();
        long allocatedMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();

        // Get processor information
        String processorInfo = System.getenv("PROCESSOR_IDENTIFIER");

        // Get TPS and timeout information
        double tps = Bukkit.getTPS()[0];
        int timeout = Bukkit.getTicksPerAnimalSpawns();

        // Create server info array
        serverInfo[0] = "\\u001B[36m" + Bukkit.getServer().getName() + " / " + serverCore + "\\u001B[0m";
        serverInfo[1] = "RAM: %d MB (%d MB allocated, %d MB free)".formatted(maxMemory / (1024 * 1024), allocatedMemory / (1024 * 1024), freeMemory / (1024 * 1024));
        serverInfo[2] = "Processor: " + processorInfo;
        serverInfo[3] = "TPS: " + tps;
        serverInfo[4] = "Timeout: " + timeout;

        return serverInfo;
    }

}
