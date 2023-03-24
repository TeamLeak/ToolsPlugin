package com.github.leanfe.creeper;

import config.Configuration;
import com.github.leanfe.core.instance.InstanceManager;
import com.github.leanfe.core.modules.IRegistrator;

public class CreeperRegistrator implements IRegistrator {

    public static void register() {
        if (Configuration.creeperModule.isCreeperEnabled()) {
            registerCommand();

            registerListeners();
        }
    }

    private static void registerCommand() {
        InstanceManager.getInstance().getCommand("creeperadd").setExecutor(new CreeperCommand());
        InstanceManager.getInstance().getCommand("toolscreeper").setExecutor(new CreeperCommand());
    }

    private static void registerListeners() {
        InstanceManager.getInstance().getServer().getPluginManager().registerEvents(new CreeperListener(), InstanceManager.getInstance());
    }
}
