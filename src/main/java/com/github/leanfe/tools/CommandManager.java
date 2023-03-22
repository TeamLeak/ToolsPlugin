package com.github.leanfe.tools;

import com.github.leanfe.Application;
import com.github.leanfe.cryper.CreeperCommand;
import com.github.leanfe.jump.JumpCommand;
import com.github.leanfe.op.OPHandler;

import static com.github.leanfe.Constants.*;

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

        if (OpEnabled) {
            instance.getCommand("op").setExecutor(new OPHandler());
        }
    }

}
