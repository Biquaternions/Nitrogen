package me.biquaternions.nitrogen;

import de.bsommerfeld.jshepherd.annotation.Key;
import de.bsommerfeld.jshepherd.annotation.PostInject;
import de.bsommerfeld.jshepherd.annotation.Section;
import de.bsommerfeld.jshepherd.core.ConfigurablePojo;
import de.bsommerfeld.jshepherd.core.ConfigurationLoader;
import java.nio.file.Path;

@SuppressWarnings({"unused", "FieldMayBeFinal", "FieldCanBeLocal"})
public class NitrogenConfig extends ConfigurablePojo<NitrogenConfig> {
    private NitrogenConfig() {
    }

    @SuppressWarnings("NullAway.Init")
    private static NitrogenConfig INSTANCE;
    public static NitrogenConfig getInstance() {
        return INSTANCE;
    }

    private static boolean INITIALIZED = false;
    public static void init() {
        if (INITIALIZED) {
            return;
        }

        INSTANCE = ConfigurationLoader.from(Path.of("nitrogen.yml"))
            .withComments()
            .load(NitrogenConfig::new);
        INITIALIZED = true;
    }

    @Section("info")
    public Info info = new Info();
    public static class Info {

        @Key("version")
        public String version = "1.0";

    }

    @PostInject
    private void validate() {
    }

}
