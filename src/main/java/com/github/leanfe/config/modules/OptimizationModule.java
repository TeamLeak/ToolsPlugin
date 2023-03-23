package com.github.leanfe.config.modules;

import com.github.leanfe.Application;
import com.github.leanfe.module.Module;
import com.github.leanfe.module.ModuleManager;
import lombok.Getter;

@Getter
public class OptimizationModule extends Module {

    private boolean OptimizationEnable;

    private int AbandonedObjectTimer;
    private int MaxChunksPerTick;

    private boolean AutoStart;

    public OptimizationModule(ModuleManager moduleManager) {
        super(moduleManager, "Optimization");
    }

    @Override
    public void load() {
        OptimizationEnable = Application.getInstance().getConfig().getBoolean("OptimizationModule_enabled");

        reload();
    }

    @Override
    public void reload() {
        AbandonedObjectTimer = Application.getInstance().getConfig().getInt("abandonedObjectTimer");
        MaxChunksPerTick = Application.getInstance().getConfig().getInt("maxChunksPerTick");
        AutoStart = Application.getInstance().getConfig().getBoolean("autostart");
    }
}
