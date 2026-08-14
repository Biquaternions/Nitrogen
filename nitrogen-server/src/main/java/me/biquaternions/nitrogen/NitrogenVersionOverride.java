package me.biquaternions.nitrogen;

import io.papermc.paper.ServerBuildInfo;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.JoinConfiguration;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.jspecify.annotations.NullMarked;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@NullMarked
public class NitrogenVersionOverride {

    private static final Component HEADER = MiniMessage.miniMessage().deserialize("<gradient:#950AFF:#21E9FF:#950AFF><st>  </st>[<white>Nitrogen</white>]<st>                      </st></gradient>");
    private static final TextColor COLOR_PRIMARY = TextColor.color(0xF7, 0xA8, 0xFF);

    public static Component getVersionMessage() {
        final ServerBuildInfo build = ServerBuildInfo.buildInfo();
        final String version = build.minecraftVersionName();
        final String buildNumber = build.buildNumber().stream().mapToObj(String::valueOf).findFirst().orElse("DEV");
        final Optional<String> branch = build.gitBranch();
        final Optional<String> commit = build.gitCommit();

        final List<Component> components = new ArrayList<>(3);
        components.add(HEADER);

        Component next = Component.textOfChildren(
            Component.text("Version", COLOR_PRIMARY),
            Component.space(),
            Component.text(version, NamedTextColor.WHITE, TextDecoration.UNDERLINED),
            Component.space(),
            Component.text("build", COLOR_PRIMARY),
            Component.space(),
            Component.text(buildNumber, NamedTextColor.WHITE, TextDecoration.UNDERLINED)
        );
        if (branch.isPresent() && commit.isPresent()) {
            next = Component.textOfChildren(
                next,
                Component.space(),
                Component.text("branch", COLOR_PRIMARY),
                Component.space(),
                Component.text(branch.get(), NamedTextColor.WHITE, TextDecoration.UNDERLINED),
                Component.space(),
                Component.text("commit", COLOR_PRIMARY),
                Component.space(),
                Component.text(commit.get(), NamedTextColor.WHITE, TextDecoration.UNDERLINED)
            );
        }
        components.add(next);

        final String javaVersion = System.getProperty("java.specification.version");
        final String javaVendorVersion = System.getProperty("java.vendor.version");
        final String javaVendor = System.getProperty("java.vendor");
        components.add(Component.textOfChildren(
            Component.text("Java", COLOR_PRIMARY),
            Component.space(),
            Component.text(javaVersion, NamedTextColor.WHITE),
            Component.space(),
            Component.text("(", NamedTextColor.DARK_GRAY),
            Component.text(javaVendorVersion, NamedTextColor.WHITE),
            Component.text(")", NamedTextColor.DARK_GRAY),
            Component.space(),
            Component.text("provided by", COLOR_PRIMARY),
            Component.space(),
            Component.text(javaVendor, NamedTextColor.WHITE, TextDecoration.UNDERLINED)
        ));

        return Component.join(JoinConfiguration.newlines(), components);
    }

}
