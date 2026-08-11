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
        @Ignore
        public static boolean _ITEM_COOLDOWN = false;

        public static boolean ATTACK_STRENGTH = false;
    }

    @Priority(3)
    public static class KNOCKBACK { // Maybe I can make this per-world or per-player in the future
        public static double FRICTION = 2.0;
        public static double HORIZONTAL = 0.4;
        public static double VERTICAL = 0.4;
        public static double VERTICAL_LIMIT = 0.4000000059604645;
        public static double EXTRA_HORIZONTAL = 0.5;
        public static double EXTRA_VERTICAL = 0.1;
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
