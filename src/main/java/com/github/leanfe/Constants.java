package com.github.leanfe;

import java.util.List;

public class Constants {

    public static boolean CreeperEnabled = Application.getInstance().getConfig().getBoolean("CreeperModule_enabled");
    public static boolean JumpEnabled = Application.getInstance().getConfig().getBoolean("JumpModule_enabled");

    public static boolean LeaveDamage = Application.getInstance().getConfig().getBoolean("LeaveDamage");

    public static boolean DisableExplosions = Application.getInstance().getConfig().getBoolean("DisableExplosions");

    public static List<String> CreeperBlocks = Application.getInstance().getConfig().getStringList("Creeper_blocks");

    public static float JumpSpeed = Application.getInstance().getConfig().getInt("JumpSpeed");

    public static float NormalSpeed = Application.getInstance().getConfig().getInt("NormalSpeed");

    public static int JumpAccelerate = Application.getInstance().getConfig().getInt("JumpAccelerate");

    public static int JumpDecelerate = Application.getInstance().getConfig().getInt("JumpDecelerate");

    public static void reload() {
        CreeperEnabled = Application.getInstance().getConfig().getBoolean("CreeperModule_enabled");
        JumpEnabled = Application.getInstance().getConfig().getBoolean("JumpModule_enabled");

        LeaveDamage = Application.getInstance().getConfig().getBoolean("LeaveDamage");

        DisableExplosions = Application.getInstance().getConfig().getBoolean("DisableExplosions");

        CreeperBlocks = Application.getInstance().getConfig().getStringList("Creeper_blocks");

        JumpSpeed = Application.getInstance().getConfig().getInt("JumpSpeed");

        NormalSpeed = Application.getInstance().getConfig().getInt("NormalSpeed");

        JumpAccelerate = Application.getInstance().getConfig().getInt("JumpAccelerate");

        JumpDecelerate = Application.getInstance().getConfig().getInt("JumpDecelerate");
    }

}
