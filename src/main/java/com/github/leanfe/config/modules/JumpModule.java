package com.github.leanfe.config.modules;

import com.github.leanfe.Application;
import lombok.Getter;

@Getter
public class JumpModule {

    private boolean JumpEnabled;

    private float JumpSpeed;

    private float NormalSpeed;

    private String JumpAccelerate;

    private String JumpDecelerate;

    public void load() {
        JumpEnabled = Application.getInstance().getConfig().getBoolean("JumpModule_enabled");

        reload();
    }

    public void reload() {
        JumpSpeed = Application.getInstance().getConfig().getInt("JumpSpeed");
        NormalSpeed = Application.getInstance().getConfig().getInt("NormalSpeed");

        JumpAccelerate = Application.getInstance().getConfig().getString("JumpAccelerate");
        JumpDecelerate = Application.getInstance().getConfig().getString("JumpDecelerate");

    }
}
