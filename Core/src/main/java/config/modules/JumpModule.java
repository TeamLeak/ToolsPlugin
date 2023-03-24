package config.modules;

import com.github.leanfe.core.instance.InstanceManager;
import lombok.Getter;

@Getter
public class JumpModule {

    private boolean JumpEnabled;

    private float JumpSpeed;

    private float NormalSpeed;

    private String JumpAccelerate;

    private String JumpDecelerate;

    public void load() {

        JumpEnabled = InstanceManager.getInstance().getConfig().getBoolean("JumpModule_enabled");

        reload();
    }

    public void reload() {
        JumpSpeed = InstanceManager.getInstance().getConfig().getInt("JumpSpeed");
        NormalSpeed = InstanceManager.getInstance().getConfig().getInt("NormalSpeed");

        JumpAccelerate = InstanceManager.getInstance().getConfig().getString("JumpAccelerate");
        JumpDecelerate = InstanceManager.getInstance().getConfig().getString("JumpDecelerate");

    }
}
