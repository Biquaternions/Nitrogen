package me.biquaternions.nitrogen.world.item;

import net.minecraft.core.component.DataComponents;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.component.BlocksAttacks;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.equipment.Equippable;
import net.minecraft.world.level.Level;
import org.jspecify.annotations.NullMarked;
import java.util.List;
import java.util.Optional;

@NullMarked
public class SwordItem extends Item {

    /**
     * Creates an instance of Sword item.
     * This custom sword uses data components and attributes.
     * <p>
     * See {@link net.minecraft.world.item.Items#SHIELD}
     *
     * @param material Tool material
     * @param attackDamage Attack damage
     * @param attackSpeed Attack speed
     * @param properties Item properties
     */
    public SwordItem(ToolMaterial material, float attackDamage, float attackSpeed, Item.Properties properties) {
        super(properties.sword(material, attackDamage, attackSpeed)
            .delayedComponent(DataComponents.BLOCKS_ATTACKS, _ -> new BlocksAttacks(
                0.0F, 0.0F,
                List.of(new BlocksAttacks.DamageReduction(360.0F, Optional.empty(), 0.0F, 0.5F)),
                new BlocksAttacks.ItemDamageFunction(Integer.MAX_VALUE, 0.0F, 1.0F),
                Optional.empty(),
                Optional.of(SoundEvents.SPEAR_HIT),
                Optional.empty()
            ))
        );
    }

    /**
     * Uses sword blocking.
     * This prevents using the offhand when holding a sword.
     * <p>
     * See {@link net.minecraft.world.item.Item#use(Level, Player, InteractionHand)}
     *
     * @param level Level
     * @param player Player
     * @param hand Hand
     *
     * @return Result of the interaction
     */
    @Override
    public InteractionResult use(final Level level, final Player player, final InteractionHand hand) {
        // See net.minecraft.world.item.Item#use
        ItemStack stack = player.getItemInHand(hand);
        Consumable consumable = stack.get(DataComponents.CONSUMABLE);
        if (consumable != null) {
            return consumable.startConsuming(player, stack, hand);
        } else {
            Equippable equippable = stack.get(DataComponents.EQUIPPABLE);
            if (equippable != null && equippable.swappable()) {
                return equippable.swapWithEquipmentSlot(stack, player);
            } else if (stack.has(DataComponents.BLOCKS_ATTACKS)) {
                player.startUsingItem(hand);
                return InteractionResult.SUCCESS;
            }
            return InteractionResult.PASS;
        }
    }

}
