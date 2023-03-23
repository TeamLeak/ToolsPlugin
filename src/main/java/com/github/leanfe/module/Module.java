package com.github.leanfe.module;

public abstract class Module implements IModule {

    public Module(ModuleManager moduleManager, String name) {
        moduleManager.addModule(this, name);
    }

    @Override
    public abstract void load();
    @Override
    public abstract void reload();

}
