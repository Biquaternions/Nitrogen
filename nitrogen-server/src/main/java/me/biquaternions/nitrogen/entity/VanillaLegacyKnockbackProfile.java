package me.biquaternions.nitrogen.entity;

import me.biquaternions.nitrogen.entity.knockback.KnockbackBehavior;
import me.biquaternions.nitrogen.entity.knockback.VanillaLegacyKnockbackBehavior;
import org.bukkit.damage.DamageSource;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Egg;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.FishHook;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.entity.SpectralArrow;
import org.bukkit.entity.Trident;
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
    private final KnockbackBehavior fallback;

    public VanillaLegacyKnockbackProfile() {
        this(new VanillaLegacyKnockbackBehavior());
    }

    protected VanillaLegacyKnockbackProfile(final KnockbackBehavior global) {
        this(global, global, global, global, global, global, global, global, global);
    }

    protected VanillaLegacyKnockbackProfile(final KnockbackBehavior melee, final KnockbackBehavior fishingHook, final KnockbackBehavior snowball, final KnockbackBehavior egg, final KnockbackBehavior enderpearl, final KnockbackBehavior arrow, final KnockbackBehavior spectralArrow, final KnockbackBehavior trident, final KnockbackBehavior fallback) {
        this.melee = melee;
        this.fishingHook = fishingHook;
        this.snowball = snowball;
        this.egg = egg;
        this.enderpearl = enderpearl;
        this.arrow = arrow;
        this.spectralArrow = spectralArrow;
        this.trident = trident;
        this.fallback = fallback;
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

    @Override
    public KnockbackBehavior getFallback() {
        return this.fallback;
    }

    @Override
    public KnockbackBehavior getBehaviorFromDamageSource(final DamageSource source) {
        return switch (source.getDirectEntity()) {
            case Player _ -> this.getMelee();
            case FishHook _ -> this.getFishingHook();
            case Snowball _ -> this.getSnowball();
            case Egg _ -> this.getEgg();
            case EnderPearl _ -> this.getEnderpearl();
            case Arrow _ -> this.getArrow();
            case SpectralArrow _ -> this.getSpectralArrow();
            case Trident _ -> this.getTrident();
            case null, default -> this.getFallback();
        };
    }
}
