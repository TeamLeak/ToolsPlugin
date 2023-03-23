package com.github.leanfe.tools;

import com.github.leanfe.Application;
import com.github.leanfe.config.Configuration;
import com.github.leanfe.cryper.CreeperCommand;
import com.github.leanfe.fetch.FetchCommand;
import com.github.leanfe.jump.JumpCommand;
import com.github.leanfe.op.OPHandler;

public class CommandManager {

    private final Application instance = Application.getInstance();

    public void init() {
        if (Configuration.creeperModule.isCreeperEnabled()) {
            instance.getCommand("creeperadd").setExecutor(new CreeperCommand());
            instance.getCommand("toolscreeper").setExecutor(new CreeperCommand());

        }

        if (Configuration.jumpModule.isJumpEnabled()) {
            instance.getCommand("toolsjump").setExecutor(new JumpCommand());
        }

        if (Configuration.opModule.isOpEnabled()) {
            instance.getCommand("op").setExecutor(new OPHandler());
        }

        if (Configuration.fetchModule.isFetchEnabled()) {
            instance.getCommand("neofetch").setExecutor(new FetchCommand());

        }
    }

}
