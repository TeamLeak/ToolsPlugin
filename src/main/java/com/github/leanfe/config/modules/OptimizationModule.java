package com.github.leanfe.config.modules;

import com.github.leanfe.Application;
import lombok.Getter;

@Getter
public class OptimizationModule {

    private boolean OptimizationEnable;

    private int AbandonedObjectTimer;
    private int MaxChunksPerTick;

    private boolean AutoStart;

    public void load() {
        OptimizationEnable = Application.getInstance().getConfig().getBoolean("OptimizationModule_enabled");

        reload();
    }

    public void reload() {
        AbandonedObjectTimer = Application.getInstance().getConfig().getInt("abandonedObjectTimer");
        MaxChunksPerTick = Application.getInstance().getConfig().getInt("maxChunksPerTick");
        AutoStart = Application.getInstance().getConfig().getBoolean("autostart");
    }
}
