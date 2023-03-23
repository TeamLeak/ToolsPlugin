package com.github.leanfe.config;

import com.github.leanfe.config.modules.*;
import com.github.leanfe.module.ModuleManager;

public class Configuration {

    public static final JumpModule jumpModule = (JumpModule) ModuleManager.getModuleByName("Jump");
    public static final FetchModule fetchModule = (FetchModule) ModuleManager.getModuleByName("Fetch");
    public static final OpModule opModule = (OpModule) ModuleManager.getModuleByName("Op");
    public static final CreeperModule creeperModule = (CreeperModule) ModuleManager.getModuleByName("Creeper");
    public static final CleanerModule cleanerModule = (CleanerModule) ModuleManager.getModuleByName("Cleaner");
    public static final OptimizationModule optimizationModule = (OptimizationModule) ModuleManager.getModuleByName("Optimization");
}
