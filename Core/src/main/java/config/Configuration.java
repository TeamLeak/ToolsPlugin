package config;

import config.modules.*;

public class Configuration {

    public static final JumpModule jumpModule = new JumpModule();
    public static final FetchModule fetchModule = new FetchModule();
    public static final OpModule opModule = new OpModule();
    public static final CreeperModule creeperModule = new CreeperModule();
    public static final CleanerModule cleanerModule = new CleanerModule();
    public static final OptimizationModule optimizationModule = new OptimizationModule();
}
