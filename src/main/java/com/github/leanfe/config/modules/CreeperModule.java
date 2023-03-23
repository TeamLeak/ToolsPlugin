package com.github.leanfe.config.modules;

import com.github.leanfe.Application;
import lombok.Getter;

import java.util.List;

@Getter
public class CreeperModule {

    private boolean CreeperEnabled;

    private boolean LeaveDamage;

    private boolean DisableExplosions;

    private List<String> CreeperBlocks;

    public void load() {
        CreeperEnabled = Application.getInstance().getConfig().getBoolean("CreeperModule_enabled");

        reload();
    }

    public void reload() {
        LeaveDamage = Application.getInstance().getConfig().getBoolean("LeaveDamage");
        DisableExplosions = Application.getInstance().getConfig().getBoolean("DisableExplosions");
        CreeperBlocks = Application.getInstance().getConfig().getStringList("Creeper_blocks");
    }
}
