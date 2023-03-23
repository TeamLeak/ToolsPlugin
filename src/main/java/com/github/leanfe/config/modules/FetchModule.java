package com.github.leanfe.config.modules;

import com.github.leanfe.Application;
import com.github.leanfe.module.Module;
import com.github.leanfe.module.ModuleManager;
import lombok.Getter;

@Getter
public class FetchModule extends Module {
    private boolean FetchEnabled;
    private boolean ForConsole;

    public FetchModule(ModuleManager moduleManager) {
        super(moduleManager, "Fetch");
    }

    @Override
    public void load() {
        FetchEnabled = Application.getInstance().getConfig().getBoolean("FetchModule_enabled");

        reload();
    }

    @Override
    public void reload() {
        ForConsole = Application.getInstance().getConfig().getBoolean("ForConsole");
    }

}
