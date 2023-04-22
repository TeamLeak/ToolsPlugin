package com.github.leanfe.config.modules;

import com.github.leanfe.core.instance.InstanceManager;
import lombok.Getter;

@Getter
public class FetchModule {
    private boolean FetchEnabled;
    private boolean ForConsole;

    public void load() {
        FetchEnabled = InstanceManager.getInstance().getConfig().getBoolean("FetchModule_enabled");

        reload();
    }

    public void reload() {
        ForConsole = InstanceManager.getInstance().getConfig().getBoolean("ForConsole");
    }

}
