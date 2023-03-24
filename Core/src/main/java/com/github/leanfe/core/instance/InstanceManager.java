package com.github.leanfe.core.instance;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class InstanceManager {

    public static JavaPlugin getInstance() {
        return (JavaPlugin) Bukkit.getPluginManager().getPlugin("ToolsPlugin");
    }
}
