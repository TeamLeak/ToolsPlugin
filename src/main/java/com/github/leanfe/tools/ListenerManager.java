package com.github.leanfe.tools;

import com.github.leanfe.Application;
import com.github.leanfe.cryper.CryperListener;
import com.github.leanfe.jump.JumpListener;

import static com.github.leanfe.config.Constants.CreeperEnabled;
import static com.github.leanfe.config.Constants.JumpEnabled;

public class ListenerManager {

    private final Application instance = Application.getInstance();

    public void init() {
        if (CreeperEnabled) {
            instance.getServer().getPluginManager().registerEvents(new CryperListener(), instance);
        }

        if (JumpEnabled) {
            instance.getServer().getPluginManager().registerEvents(new JumpListener(), instance);
        }
    }
}
