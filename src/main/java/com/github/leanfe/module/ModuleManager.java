package com.github.leanfe.module;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ModuleManager {

    private static final HashMap<String, Module> modules = new HashMap<>();

    public void init() {
        modules.forEach((k, v) -> v.load());
    }

    public void addModule(Module module, String name) {
        modules.put(name, module);
    }

    public static Module getModuleByName(String name) {
        return modules.get(name);
    }
}
