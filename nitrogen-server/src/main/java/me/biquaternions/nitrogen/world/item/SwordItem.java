package me.biquaternions.nitrogen.world.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.level.Level;
import org.jspecify.annotations.NullMarked;

@NullMarked
public class SwordItem extends Item {

    public SwordItem(ToolMaterial material, float attackDamage, float attackSpeed, Item.Properties properties) {
        super(properties.sword(material, attackDamage, attackSpeed));
    }

    @Override
    public InteractionResult use(final Level level, final Player player, final InteractionHand hand) {
        return super.use(level, player, hand);
    }

    @Override
    public boolean releaseUsing(final ItemStack itemStack, final Level level, final LivingEntity entity, final int remainingTime) {
        return super.releaseUsing(itemStack, level, entity, remainingTime);
    }

}
