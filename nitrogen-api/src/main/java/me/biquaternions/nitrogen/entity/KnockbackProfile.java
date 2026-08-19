package me.biquaternions.nitrogen.entity;

import me.biquaternions.nitrogen.entity.knockback.KnockbackBehavior;
import org.bukkit.damage.DamageSource;
import org.jspecify.annotations.NullMarked;

@NullMarked
public interface KnockbackProfile {

    // Melee
    KnockbackBehavior getMelee();

    // Projectiles according to ThrowableItemProjectile (except potions)
    KnockbackBehavior getFishingHook();
    KnockbackBehavior getSnowball();
    KnockbackBehavior getEgg();
    KnockbackBehavior getEnderpearl();

    // Projectiles according to AbstractArrow
    KnockbackBehavior getArrow();
    KnockbackBehavior getSpectralArrow();
    KnockbackBehavior getTrident();

    // Fallback
    KnockbackBehavior getFallback();

    KnockbackBehavior getBehaviorFromDamageSource(DamageSource source);

}
