package me.biquaternions.nitrogen;

import net.j4c0b3y.api.config.ConfigHandler;
import net.j4c0b3y.api.config.StaticConfig;
import java.nio.file.Path;

public class NitrogenConfig extends StaticConfig {

    @Ignore
    public static final ConfigHandler HANDLER = new ConfigHandler();

    @Ignore
    public static NitrogenConfig INSTANCE;

    public NitrogenConfig() {
        super(Path.of("nitrogen.yml"), HANDLER);
        INSTANCE = this;
    }

    @Priority(1)
    public static class INFO {
        public static String VERSION = "1.0";
    }

}
