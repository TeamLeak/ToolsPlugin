package com.github.leanfe.cleaner;

import config.Configuration;
import com.github.leanfe.core.instance.InstanceManager;
import com.github.leanfe.core.modules.IRegistrator;

public class CleanerRegistrator implements IRegistrator {

    public static void register() {
        registerChat();
        registerConsole();
    }

    private static void registerConsole() {
        if (Configuration.cleanerModule.isConsoleCleanerEnable())
            InstanceManager.getInstance().getCommand("freeConsole").setExecutor(new ClearConsole());
    }

    private static void registerChat() {
        if (Configuration.cleanerModule.isChatCleanerEnable())
            InstanceManager.getInstance().getCommand("freeChat").setExecutor(new ClearChat());
    }
}
