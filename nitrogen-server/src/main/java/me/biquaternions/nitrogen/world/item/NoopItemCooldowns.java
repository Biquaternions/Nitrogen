package me.biquaternions.nitrogen.world.item;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemCooldowns;
import net.minecraft.world.item.ItemStack;
import org.jspecify.annotations.NullMarked;

@NullMarked
public class NoopItemCooldowns extends ItemCooldowns {

    @Override
    public boolean isOnCooldown(final ItemStack item) {
        return false;
    }

    @Override
    public float getCooldownPercent(final ItemStack item, final float a) {
        return 0.0F;
    }

    @Override
    public void tick() {
    }

    @Override
    public Identifier getCooldownGroup(final ItemStack item) {
        return BuiltInRegistries.ITEM.getKey(item.getItem());
    }

    @Override
    public void addCooldown(final ItemStack item, final int time) {
    }

    @Override
    public void addCooldown(final Identifier cooldownGroup, final int time) {
    }

    @Override
    public void addCooldown(final Identifier cooldownGroup, final int time, final boolean callEvent) {
    }

    @Override
    public void removeCooldown(final Identifier cooldownGroup) {
    }

    @Override
    protected void onCooldownStarted(final Identifier cooldownGroup, final int duration) {
    }

    @Override
    protected void onCooldownEnded(final Identifier cooldownGroup) {
    }

    @Override
    public int getRemainingCooldown(final Identifier cooldownGroup) {
        return 0;
    }

}
