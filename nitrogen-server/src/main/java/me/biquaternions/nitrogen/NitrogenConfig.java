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

    @Priority(2)
    public static class FEATURES {
        public static boolean ITEM_COOLDOWN = false;
        public static boolean _ITEM_COOLDOWN = false;
    }



    @Ignore
    private static boolean INITIALIZED = false;
    public static void init() {

        /*
         *  INITIALIZE RELOADABLE STUFF
         */



        /*
         *  INITIALIZE NON-RELOADABLE STUFF
         */
        if (!INITIALIZED) {
            FEATURES._ITEM_COOLDOWN = FEATURES.ITEM_COOLDOWN;
        }
        INITIALIZED = true;
    }

}
