package me.biquaternions.nitrogen.configuration.misc;

import de.bsommerfeld.jshepherd.annotation.Key;
import me.biquaternions.nitrogen.configuration.types.CombatType;
import org.jspecify.annotations.NullMarked;

@NullMarked
public class ConfigInfo {

    @Key("version")
    private String version = "1.0";

    @Key("type")
    private CombatType type = CombatType.LEGACY;

    private ConfigInfo() {
    }

    public ConfigInfo(final String version, final CombatType type) {
        this.version = version;
        this.type = type;
    }

    public String getVersion() {
        return this.version;
    }

    public CombatType getType() {
        return this.type;
    }
}
