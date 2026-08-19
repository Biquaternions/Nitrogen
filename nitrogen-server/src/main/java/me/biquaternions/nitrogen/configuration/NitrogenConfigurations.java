package me.biquaternions.nitrogen.configuration;

import io.papermc.paper.configuration.ConfigurationPart;
import org.jspecify.annotations.NullMarked;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;

import static io.leangen.geantyref.GenericTypeReflector.erase;

@NullMarked
public class NitrogenConfigurations extends Configurations<GlobalConfiguration, WorldConfiguration, KnockbackConfiguration> {

    static final String PLACEHOLDER_KEY = "<name>";

    static final String GLOBAL_CONFIG_FILE_NAME = "nitrogen-global.yml";
    static final String WORLD_DEFAULTS_CONFIG_FILE_NAME = "nitrogen-world-defaults.yml";
    static final String WORLD_CONFIG_FILE_NAME = "nitrogen-world.yml";
    static final String KNOCKBACK_CONFIG_PLACEHOLDER_NAME = String.format("%s.yml", PLACEHOLDER_KEY);

    public static final String CONFIG_DIR = "config";
    public static final String KNOCKBACK_DIR = "config/knockback";

    public NitrogenConfigurations(final Path globalFolder) {
        super(globalFolder, GlobalConfiguration.class, WorldConfiguration.class, KnockbackConfiguration.class, GLOBAL_CONFIG_FILE_NAME, WORLD_DEFAULTS_CONFIG_FILE_NAME, WORLD_CONFIG_FILE_NAME, KNOCKBACK_CONFIG_PLACEHOLDER_NAME);
    }

    @Override
    protected boolean isConfigType(final Type type) {
        return ConfigurationPart.class.isAssignableFrom(erase(type));
    }

    @Override
    protected int globalConfigVersion() {
        return 0;
    }

    @Override
    protected int worldConfigVersion() {
        return 0;
    }

    // Symlinks are not correctly checked in createDirectories
    static void createDirectoriesSymlinkAware(Path path) throws IOException {
        if (!Files.isDirectory(path)) {
            Files.createDirectories(path);
        }
    }

}
