package config.modules;

import com.github.leanfe.core.instance.InstanceManager;
import lombok.Getter;

@Getter
public class CleanerModule {

    private boolean ChatCleanerEnable;
    private boolean ConsoleCleanerEnable;

    public void load() {
        reload();
    }

    public void reload() {
        ChatCleanerEnable = InstanceManager.getInstance().getConfig().getBoolean("CleanChatModule_enabled");
        ConsoleCleanerEnable = InstanceManager.getInstance().getConfig().getBoolean("CleanConsoleModule_enabled");

    }
}
