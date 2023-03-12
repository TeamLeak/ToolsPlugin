package com.github.leanfe.tools;

import com.github.leanfe.Application;
import com.github.leanfe.cryper.CreeperCommand;
import com.github.leanfe.jump.JumpCommand;

import static com.github.leanfe.Constants.CreeperEnabled;
import static com.github.leanfe.Constants.JumpEnabled;

public class CommandManager {

    private final Application instance = Application.getInstance();

    public void init() {
        if (CreeperEnabled) {
            instance.getCommand("creeperadd").setExecutor(new CreeperCommand());
            instance.getCommand("toolscreeper").setExecutor(new CreeperCommand());

        }

        if (JumpEnabled) {
            instance.getCommand("toolsjump").setExecutor(new JumpCommand());
        }
    }

}
