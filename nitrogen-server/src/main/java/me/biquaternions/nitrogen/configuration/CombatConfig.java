package me.biquaternions.nitrogen.configuration;

import de.bsommerfeld.jshepherd.core.ConfigurablePojo;
import java.util.Locale;

public class CombatConfig extends ConfigurablePojo<CombatConfig> {

    private final String name;

    public CombatConfig(final String name) {
        this.name = name.toLowerCase(Locale.ROOT).trim();
    }

}
