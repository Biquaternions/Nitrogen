package me.biquaternions.nitrogen.entity;

import me.biquaternions.nitrogen.entity.knockback.KnockbackBehavior;

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

}
