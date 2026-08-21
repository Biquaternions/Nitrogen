package me.biquaternions.nitrogen.service;

import de.bsommerfeld.jshepherd.core.ConfigurationLoader;
import me.biquaternions.nitrogen.NitrogenConfig;
import me.biquaternions.nitrogen.configuration.ConfigLegacyCombatProfile;
import me.biquaternions.nitrogen.configuration.types.CombatType;
import org.jspecify.annotations.NullMarked;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Stream;

@NullMarked
public class ConfigHandlerService {
    private ConfigHandlerService() {
        throw new RuntimeException();
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(ConfigHandlerService.class);

    private static final String COMBAT_PROFILES_DIR = "combat-profiles";
    private static final ConcurrentMap<String, ConfigLegacyCombatProfile> CONFIGS = new ConcurrentHashMap<>();

    public static void initialize(final Path configDir) {
        NitrogenConfig.init();

        Path combatProfilesDir = configDir.resolve(COMBAT_PROFILES_DIR);
        try {

            try (Stream<Path> paths = Files.walk(combatProfilesDir)) {
                List<Path> profilesPaths = paths
                    .filter(Files::isRegularFile)
                    .filter(path -> path.toString().endsWith(".yml"))
                    .toList();

                for (Path profilePath : profilesPaths) {

                    // TODO: Find the type field to infer the type of combat to read

                    ConfigLegacyCombatProfile profile = ConfigurationLoader.from(profilePath)
                        .withComments()
                        .load(() -> new ConfigLegacyCombatProfile(combatProfilesDir, profilePath));
                    CONFIGS.put(profile.name, profile);
                }
            }

        } catch (IOException e) {
            LOGGER.error("Failed to initialize combat profile configurations", e);
        }

    }

    public static Set<String> getCombatProfileNames() {
        return CONFIGS.keySet();
    }

    public static void createCombatProfile(final String name, final CombatType type) {

    }

}
