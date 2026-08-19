package me.biquaternions.nitrogen.configuration;

import com.mojang.logging.LogUtils;
import io.papermc.paper.configuration.Configuration;
import io.papermc.paper.configuration.ConfigurationPart;
import net.minecraft.resources.Identifier;
import org.slf4j.Logger;
import org.spongepowered.configurate.objectmapping.meta.Setting;

@SuppressWarnings({"FieldCanBeLocal", "FieldMayBeFinal", "NotNullFieldNotInitialized", "InnerClassMayBeStatic"})
public class WorldConfiguration extends ConfigurationPart {

    private static final Logger LOGGER = LogUtils.getClassLogger();
    static final int CURRENT_VERSION = 1; // (when you change the version, change the comment, so it conflicts on rebases): migrate spawn loaded configs to gamerule

    private final transient Identifier worldKey;

    WorldConfiguration(final Identifier worldKey) {
        this.worldKey = worldKey;
    }

    public boolean isDefault() {
        return this.worldKey.equals(NitrogenConfigurations.WORLD_DEFAULTS_KEY);
    }

    @Setting(Configuration.VERSION_FIELD)
    public int version = CURRENT_VERSION;

}
