package me.biquaternions.nitrogen.configuration;

import de.bsommerfeld.jshepherd.core.ConfigurablePojo;
import me.biquaternions.nitrogen.configuration.misc.ConfigInfo;
import me.biquaternions.nitrogen.configuration.types.CombatType;
import java.nio.file.Path;

public class ConfigLegacyCombatProfile extends ConfigurablePojo<ConfigLegacyCombatProfile> {

    public transient final Path path;
    public transient final String name;

    public ConfigLegacyCombatProfile(final Path directory, final Path path) {
        String relativePathString = directory.relativize(path).toString();
        this.path = path;
        this.name = relativePathString.substring(0, relativePathString.lastIndexOf("."));
    }


    public ConfigInfo info = new ConfigInfo("1.0", CombatType.LEGACY);

}
