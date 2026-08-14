package me.biquaternions.nitrogen.combat;

import org.jspecify.annotations.NullMarked;

@NullMarked
public interface CombatProfile {

    KnockbackProfile getKnockback();

    CooldownProfile getCooldown();

    boolean cancelSprintOnHit();

    boolean canAttributeSwap();

}
