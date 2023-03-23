package com.github.leanfe.config;

import com.github.leanfe.config.modules.CreeperModule;
import com.github.leanfe.config.modules.FetchModule;
import com.github.leanfe.config.modules.JumpModule;
import com.github.leanfe.config.modules.OpModule;
import com.github.leanfe.module.ModuleManager;

public class Configuration {

    public static final JumpModule jumpModule = (JumpModule) ModuleManager.getModuleByName("Jump");
    public static final FetchModule fetchModule = (FetchModule) ModuleManager.getModuleByName("Fetch");
    public static final OpModule opModule = (OpModule) ModuleManager.getModuleByName("Op");
    public static final CreeperModule creeperModule = (CreeperModule) ModuleManager.getModuleByName("Creeper");

}
