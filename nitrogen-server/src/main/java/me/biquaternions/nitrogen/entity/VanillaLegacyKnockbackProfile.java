package me.biquaternions.nitrogen.entity;

import me.biquaternions.nitrogen.entity.knockback.KnockbackBehavior;
import me.biquaternions.nitrogen.entity.knockback.VanillaLegacyKnockbackBehavior;
import org.jspecify.annotations.NullMarked;

@NullMarked
public class VanillaLegacyKnockbackProfile implements KnockbackProfile {

    private final KnockbackBehavior melee;
    private final KnockbackBehavior fishingHook;
    private final KnockbackBehavior snowball;
    private final KnockbackBehavior egg;
    private final KnockbackBehavior enderpearl;
    private final KnockbackBehavior arrow;
    private final KnockbackBehavior spectralArrow;
    private final KnockbackBehavior trident;

    public VanillaLegacyKnockbackProfile() {
        this(new VanillaLegacyKnockbackBehavior());
    }

    protected VanillaLegacyKnockbackProfile(final KnockbackBehavior global) {
        this(global, global, global, global, global, global, global, global);
    }

    protected VanillaLegacyKnockbackProfile(final KnockbackBehavior melee, final KnockbackBehavior fishingHook, final KnockbackBehavior snowball, final KnockbackBehavior egg, final KnockbackBehavior enderpearl, final KnockbackBehavior arrow, final KnockbackBehavior spectralArrow, final KnockbackBehavior trident) {
        this.melee = melee;
        this.fishingHook = fishingHook;
        this.snowball = snowball;
        this.egg = egg;
        this.enderpearl = enderpearl;
        this.arrow = arrow;
        this.spectralArrow = spectralArrow;
        this.trident = trident;
    }

    @Override
    public KnockbackBehavior getMelee() {
        return this.melee;
    }

    @Override
    public KnockbackBehavior getFishingHook() {
        return this.fishingHook;
    }

    @Override
    public KnockbackBehavior getSnowball() {
        return this.snowball;
    }

    @Override
    public KnockbackBehavior getEgg() {
        return this.egg;
    }

    @Override
    public KnockbackBehavior getEnderpearl() {
        return this.enderpearl;
    }

    @Override
    public KnockbackBehavior getArrow() {
        return this.arrow;
    }

    @Override
    public KnockbackBehavior getSpectralArrow() {
        return this.spectralArrow;
    }

    @Override
    public KnockbackBehavior getTrident() {
        return this.trident;
    }

}
