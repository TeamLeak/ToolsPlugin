package com.github.leanfe.config.modules;

import com.github.leanfe.Application;
import lombok.Getter;

@Getter
public class CleanerModule {

    private boolean ChatCleanerEnable;
    private boolean ConsoleCleanerEnable;

    public void load() {
        reload();
    }

    public void reload() {
        ChatCleanerEnable = Application.getInstance().getConfig().getBoolean("CleanChatModule_enabled");
        ConsoleCleanerEnable = Application.getInstance().getConfig().getBoolean("CleanConsoleModule_enabled");

    }
}
