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

    public static PatchedDataComponentMap mergeItemComponents(final Item item, final PatchedDataComponentMap components) {
        switch (item) {
            case SwordItem _ -> {
                if (!components.has(DataComponents.BLOCKS_ATTACKS)) {
                    components.set(DataComponents.BLOCKS_ATTACKS, SwordItem.SWORD_BLOCKING_COMPONENT);
                }
            }
            case EnderpearlItem _ -> {
                if (!components.has(DataComponents.USE_COOLDOWN)) {
                    components.set(DataComponents.USE_COOLDOWN, new UseCooldown(0.0f));
                }
            }
            default -> {}
        }
        return components;
    }

}
