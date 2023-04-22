package com.github.leanfe.jump;

import com.github.leanfe.config.Configuration;
import com.github.leanfe.core.instance.InstanceManager;
import com.github.leanfe.core.modules.IRegistrator;

public class JumpRegistrator implements IRegistrator {

    public static void register() {
        if (Configuration.jumpModule.isJumpEnabled()) {
            registerCommand();
            registerListener();
        }
    }

    private static void registerCommand() {
        InstanceManager.getInstance().getCommand("toolsjump").setExecutor(new JumpCommand());
    }

    private static void registerListener() {
            InstanceManager.getInstance().getServer().getPluginManager().registerEvents(new JumpListener(), InstanceManager.getInstance());
    }
}
