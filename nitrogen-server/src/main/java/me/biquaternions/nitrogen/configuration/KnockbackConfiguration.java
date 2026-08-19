package me.biquaternions.nitrogen.configuration;

import com.mojang.logging.LogUtils;
import io.papermc.paper.configuration.Configuration;
import io.papermc.paper.configuration.ConfigurationPart;
import org.slf4j.Logger;
import org.spongepowered.configurate.objectmapping.meta.Setting;

@SuppressWarnings({"FieldCanBeLocal", "FieldMayBeFinal", "NotNullFieldNotInitialized", "InnerClassMayBeStatic"})
public class KnockbackConfiguration extends ConfigurationPart {

    private static final Logger LOGGER = LogUtils.getClassLogger();
    static final int CURRENT_VERSION = 1;

    private final transient String name;

    KnockbackConfiguration(final String name) {
        this.name = name;
    }

    @Setting(Configuration.VERSION_FIELD)
    public int version = CURRENT_VERSION;

}
