package com.github.leanfe;

import java.util.List;

public class Constants {

    // TODO: Дописать модуль крипера, так же перезагрузку конфига для опред.модуля!

    public static void reload() {
        CreeperEnabled = Application.getInstance().getConfig().getBoolean("CreeperModule_enabled");
        JumpEnabled = Application.getInstance().getConfig().getBoolean("JumpModule_enabled");

        LeaveDamage = Application.getInstance().getConfig().getBoolean("LeaveDamage");

        DisableExplosions = Application.getInstance().getConfig().getBoolean("DisableExplosions");

        CreeperBlocks = Application.getInstance().getConfig().getStringList("Creeper_blocks");

        JumpSpeed = Application.getInstance().getConfig().getInt("JumpSpeed");

        NormalSpeed = Application.getInstance().getConfig().getInt("NormalSpeed");

        JumpAccelerate = Application.getInstance().getConfig().getString("JumpAccelerate");

        JumpDecelerate = Application.getInstance().getConfig().getString("JumpDecelerate");

        OpEnabled = Application.getInstance().getConfig().getBoolean("OpModule_enabled");

        OpMessage = Application.getInstance().getConfig().getString("OpMessage");
    }

    private static class CreeperModule {
        public static boolean CreeperEnabled = Application.getInstance().getConfig().getBoolean("CreeperModule_enabled");
        public static boolean LeaveDamage = Application.getInstance().getConfig().getBoolean("LeaveDamage");
        public static boolean DisableExplosions = Application.getInstance().getConfig().getBoolean("DisableExplosions");
        public static List<String> CreeperBlocks = Application.getInstance().getConfig().getStringList("Creeper_blocks");

    }

    private static class JumpModule {
        public static boolean JumpEnabled = Application.getInstance().getConfig().getBoolean("JumpModule_enabled");

        public static float JumpSpeed = Application.getInstance().getConfig().getInt("JumpSpeed");

        public static float NormalSpeed = Application.getInstance().getConfig().getInt("NormalSpeed");

        public static String JumpAccelerate = Application.getInstance().getConfig().getString("JumpAccelerate");

        public static String JumpDecelerate = Application.getInstance().getConfig().getString("JumpDecelerate");
    }

    private static class OpModule {
        public static boolean OpEnabled = Application.getInstance().getConfig().getBoolean("OpModule_enabled");

        public static String OpMessage = Application.getInstance().getConfig().getString("OpMessage");

    }

    private class FetchModule {

    }
}
