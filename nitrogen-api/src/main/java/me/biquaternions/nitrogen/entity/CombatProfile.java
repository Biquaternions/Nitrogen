package me.biquaternions.nitrogen.entity;

import org.jspecify.annotations.NullMarked;

@NullMarked
public abstract class CombatProfile {

    public abstract KnockbackProfile getKnockback();

    /* TODO
    CooldownProfile getCooldownBehavior();
    PearlProfile getPearlBehavior();
     */

    public abstract boolean interruptsSprintOnHit();

    public abstract boolean canAttributeSwap();

    public abstract boolean canRegenerateOnSaturation();

    public abstract float getRegenerationExhaustion();

    public abstract double getCriticalMultiplier();

}
