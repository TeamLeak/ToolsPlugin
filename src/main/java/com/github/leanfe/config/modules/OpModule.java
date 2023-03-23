package com.github.leanfe.config.modules;

import com.github.leanfe.Application;
import com.github.leanfe.module.Module;
import com.github.leanfe.module.ModuleManager;
import lombok.Getter;

@Getter
public class OpModule extends Module {
    private boolean OpEnabled;

    private String OpMessage;

    public OpModule(ModuleManager moduleManager) {
        super(moduleManager, "Op");
    }

    @Override
    public void load() {
        OpEnabled = Application.getInstance().getConfig().getBoolean("OpModule_enabled");

        reload();
    }

    @Override
    public void reload() {
        OpMessage = Application.getInstance().getConfig().getString("OpMessage");
    }
}
