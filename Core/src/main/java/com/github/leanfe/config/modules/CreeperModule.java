package com.github.leanfe.config.modules;

import com.github.leanfe.core.instance.InstanceManager;
import lombok.Getter;

import java.util.List;

@Getter
public class CreeperModule {

    private boolean CreeperEnabled;

    private boolean LeaveDamage;

    private boolean DisableExplosions;

    private List<String> CreeperBlocks;

    public void load() {
        CreeperEnabled = InstanceManager.getInstance().getConfig().getBoolean("CreeperModule_enabled");

        reload();
    }

    public void reload() {
        LeaveDamage = InstanceManager.getInstance().getConfig().getBoolean("LeaveDamage");
        DisableExplosions = InstanceManager.getInstance().getConfig().getBoolean("DisableExplosions");
        CreeperBlocks = InstanceManager.getInstance().getConfig().getStringList("Creeper_blocks");
    }
}
