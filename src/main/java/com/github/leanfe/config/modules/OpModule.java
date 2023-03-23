package com.github.leanfe.config.modules;

import com.github.leanfe.Application;
import lombok.Getter;

@Getter
public class OpModule {
    private boolean OpEnabled;

    private String OpMessage;

    public void load() {
        OpEnabled = Application.getInstance().getConfig().getBoolean("OpModule_enabled");

        reload();
    }

    public void reload() {
        OpMessage = Application.getInstance().getConfig().getString("OpMessage");
    }
}
