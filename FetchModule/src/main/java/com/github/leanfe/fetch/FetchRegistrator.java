package com.github.leanfe.fetch;

import config.Configuration;
import com.github.leanfe.core.instance.InstanceManager;
import com.github.leanfe.core.modules.IRegistrator;

public class FetchRegistrator implements IRegistrator {

    public static void register() {
        if (Configuration.fetchModule.isFetchEnabled())
            InstanceManager.getInstance().getCommand("neofetch").setExecutor(new FetchCommand());
    }
}
