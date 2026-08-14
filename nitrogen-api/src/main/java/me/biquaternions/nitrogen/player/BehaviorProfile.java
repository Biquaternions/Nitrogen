package me.biquaternions.nitrogen.player;

import me.biquaternions.nitrogen.player.combat.CooldownProfile;
import me.biquaternions.nitrogen.player.combat.KnockbackProfile;
import me.biquaternions.nitrogen.player.projectile.PearlProfile;
import org.jspecify.annotations.NullMarked;

@NullMarked
public interface BehaviorProfile {

    KnockbackProfile getKnockbackBehavior();

    CooldownProfile getCooldownBehavior();

    PearlProfile getPearlBehavior();

    boolean cancelSprintOnHit();

    boolean canAttributeSwap();

    boolean isLegacyFoodRegeneration();

    float getRegenerationExhaustion();

}
