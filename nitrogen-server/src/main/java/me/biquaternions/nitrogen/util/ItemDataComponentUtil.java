package me.biquaternions.nitrogen.util;

import me.biquaternions.nitrogen.world.item.SwordItem;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.component.PatchedDataComponentMap;
import net.minecraft.world.item.EnderpearlItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.UseCooldown;
import org.jspecify.annotations.NullMarked;

@NullMarked
public class ItemDataComponentUtil {
    private ItemDataComponentUtil() {
        throw new IllegalStateException();
    }

    private static final float FLOAT_ZERO_POSITIVE = 0.0000000001F;

    public static PatchedDataComponentMap mergeItemComponents(final Item item, final PatchedDataComponentMap components) {
        switch (item) {
            case SwordItem _ -> {
                if (!components.hasNonDefault(DataComponents.BLOCKS_ATTACKS)) {
                    components.set(DataComponents.BLOCKS_ATTACKS, SwordItem.SWORD_BLOCKING_COMPONENT);
                }
            }
            case EnderpearlItem _ -> {
                if (!components.hasNonDefault(DataComponents.USE_COOLDOWN)) {
                    components.set(DataComponents.USE_COOLDOWN, new UseCooldown(FLOAT_ZERO_POSITIVE));
                }
            }
            default -> {}
        }
        return components;
    }

}
