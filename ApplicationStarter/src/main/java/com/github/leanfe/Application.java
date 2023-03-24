package com.github.leanfe;

import com.github.leanfe.cleaner.CleanerRegistrator;
import com.github.leanfe.creeper.CreeperRegistrator;
import com.github.leanfe.fetch.FetchRegistrator;
import com.github.leanfe.jump.JumpRegistrator;
import com.github.leanfe.op.OPRegistrator;
import com.github.leanfe.optimization.OptimizationRegistrator;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * The type Jump plugin.
 */
public final class Application extends JavaPlugin {

    private boolean enabled;

    /**
     * Called when the plugin is enabled.
     */
    @Override
    public void onEnable() {
        // load config.
        loadConfig();

        if (!enabled)
            onDisable();

        // Load modules.
        loadModules();
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }

    /**
     * Loads the configuration from the config.yml file.
     */
    private void loadConfig() {
        saveDefaultConfig();

        FileConfiguration config = getConfig();

        enabled = config.getBoolean("Enabled");
    }

    private void loadModules() {
        CleanerRegistrator.register();
        CreeperRegistrator.register();

        FetchRegistrator.register();
        JumpRegistrator.register();

        OPRegistrator.register();
        OptimizationRegistrator.register();
    }

}
