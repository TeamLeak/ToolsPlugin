package com.github.leanfe.config.modules;

import com.github.leanfe.Application;
import com.github.leanfe.module.Module;
import com.github.leanfe.module.ModuleManager;
import lombok.Getter;

import java.util.List;

@Getter
public class CreeperModule extends Module {

    private boolean CreeperEnabled;

    private boolean LeaveDamage;

    private boolean DisableExplosions;

    private List<String> CreeperBlocks;

    public CreeperModule(ModuleManager moduleManager) {
        super(moduleManager, "Creeper");
    }

    @Override
    public void load() {
        CreeperEnabled = Application.getInstance().getConfig().getBoolean("CreeperModule_enabled");

        reload();
    }

    @Override
    public void reload() {
        LeaveDamage = Application.getInstance().getConfig().getBoolean("LeaveDamage");
        DisableExplosions = Application.getInstance().getConfig().getBoolean("DisableExplosions");
        CreeperBlocks = Application.getInstance().getConfig().getStringList("Creeper_blocks");
    }
}
