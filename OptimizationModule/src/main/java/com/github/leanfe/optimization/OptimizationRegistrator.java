package com.github.leanfe.optimization;

import config.Configuration;
import com.github.leanfe.core.instance.InstanceManager;
import com.github.leanfe.core.modules.IRegistrator;
import com.github.leanfe.core.optimization.Optimizer;
import org.bukkit.Bukkit;

public class OptimizationRegistrator implements IRegistrator {

    public static void register() {
        if (Configuration.optimizationModule.isAutoStart())
            Bukkit.getScheduler().scheduleSyncRepeatingTask(InstanceManager.getInstance(), Optimizer::optimize, 0L, 15L);

        if (Configuration.optimizationModule.isOptimizationEnable())
            InstanceManager.getInstance().getCommand("optimize").setExecutor(new OptimizationHandler());
    }
}
