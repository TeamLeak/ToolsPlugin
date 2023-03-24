package com.github.leanfe.op;

import config.Configuration;
import com.github.leanfe.core.instance.InstanceManager;
import com.github.leanfe.core.modules.IRegistrator;

public class OPRegistrator implements IRegistrator {

    public static void register() {
        if (Configuration.opModule.isOpEnabled())
            InstanceManager.getInstance().getCommand("op").setExecutor(new OPHandler());
    }

}
