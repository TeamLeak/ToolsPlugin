package com.github.leanfe;

import com.github.leanfe.tools.CommandManager;
import com.github.leanfe.tools.ListenerManager;
import lombok.Getter;
import lombok.var;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * The type Jump plugin.
 */
public final class Application extends JavaPlugin {

    private boolean enabled;

    @Getter
    private static Application instance;

    /**
     * Called when the plugin is enabled.
     */
    @Override
    public void onEnable() {
        instance = this;

        // load config.
        loadConfig();

        if (!enabled)
            onDisable();

        // Plugin commands & listeners logic.
        loadCommands();
        loadListeners();
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

    private void loadCommands() {
        var commandManager = new CommandManager();
        commandManager.init();
    }

    private void loadListeners() {
        var listenerManager = new ListenerManager();
        listenerManager.init();
    }

}
