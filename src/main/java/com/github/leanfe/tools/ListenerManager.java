package com.github.leanfe.tools;

import com.github.leanfe.Application;
import com.github.leanfe.config.Configuration;
import com.github.leanfe.cryper.CryperListener;
import com.github.leanfe.jump.JumpListener;

public class ListenerManager {

    private final Application instance = Application.getInstance();

    public void init() {
        if (Configuration.creeperModule.isCreeperEnabled()) {
            instance.getServer().getPluginManager().registerEvents(new CryperListener(), instance);
        }

        if (Configuration.jumpModule.isJumpEnabled()) {
            instance.getServer().getPluginManager().registerEvents(new JumpListener(), instance);
        }

    }
}
