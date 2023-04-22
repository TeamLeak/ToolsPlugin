package com.github.leanfe.config.modules;

import com.github.leanfe.core.instance.InstanceManager;
import lombok.Getter;

@Getter
public class OpModule {
    private boolean OpEnabled;

    private String OpMessage;

    public void load() {
        OpEnabled = InstanceManager.getInstance().getConfig().getBoolean("OpModule_enabled");

        reload();
    }

    public void reload() {
        OpMessage = InstanceManager.getInstance().getConfig().getString("OpMessage");
    }
}
