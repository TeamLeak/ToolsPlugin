package com.github.leanfe.config.modules;

import com.github.leanfe.Application;
import com.github.leanfe.module.Module;
import com.github.leanfe.module.ModuleManager;
import lombok.Getter;

@Getter
public class CleanerModule extends Module {

    private boolean ChatCleanerEnable;
    private boolean ConsoleCleanerEnable;

    public CleanerModule(ModuleManager moduleManager) {
        super(moduleManager, "Cleaner");
    }

    @Override
    public void load() {
        reload();
    }

    @Override
    public void reload() {
        ChatCleanerEnable = Application.getInstance().getConfig().getBoolean("CleanChatModule_enabled");
        ConsoleCleanerEnable = Application.getInstance().getConfig().getBoolean("CleanConsoleModule_enabled");

    }
}
