package config.modules;

import com.github.leanfe.core.instance.InstanceManager;
import lombok.Getter;

@Getter
public class OptimizationModule {

    private boolean OptimizationEnable;

    private int AbandonedObjectTimer;
    private int MaxChunksPerTick;

    private boolean AutoStart;

    public void load() {
        OptimizationEnable = InstanceManager.getInstance().getConfig().getBoolean("OptimizationModule_enabled");

        reload();
    }

    public void reload() {
        AbandonedObjectTimer = InstanceManager.getInstance().getConfig().getInt("abandonedObjectTimer");
        MaxChunksPerTick = InstanceManager.getInstance().getConfig().getInt("maxChunksPerTick");
        AutoStart = InstanceManager.getInstance().getConfig().getBoolean("autostart");
    }
}
