package com.github.leanfe.config.modules;

import com.github.leanfe.Application;
import lombok.Getter;

@Getter
public class FetchModule {
    private boolean FetchEnabled;
    private boolean ForConsole;

    public void load() {
        FetchEnabled = Application.getInstance().getConfig().getBoolean("FetchModule_enabled");

        reload();
    }

    public void reload() {
        ForConsole = Application.getInstance().getConfig().getBoolean("ForConsole");
    }

}
