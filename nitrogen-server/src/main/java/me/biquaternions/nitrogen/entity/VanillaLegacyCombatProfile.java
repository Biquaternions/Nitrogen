package me.biquaternions.nitrogen.entity;

import org.jspecify.annotations.NullMarked;

@NullMarked
public class VanillaLegacyCombatProfile extends CombatProfile {

    private final KnockbackProfile knockback;

    private final boolean interruptsSprintOnHit;
    private final boolean canAttributeSwap;
    private final boolean canRegenerateOnSaturation;

    private final float regenerationExhaustion;
    private final double criticalMultiplier;

    public VanillaLegacyCombatProfile() {
        this(new VanillaLegacyKnockbackProfile(), true, true, false, 0.3F, 1.5);
    }

    protected VanillaLegacyCombatProfile(final KnockbackProfile knockback, final boolean interruptsSprintOnHit, final boolean canAttributeSwap, final boolean canRegenerateOnSaturation, final float regenerationExhaustion, final double criticalMultiplier) {
        this.knockback = knockback;
        this.interruptsSprintOnHit = interruptsSprintOnHit;
        this.canAttributeSwap = canAttributeSwap;
        this.canRegenerateOnSaturation = canRegenerateOnSaturation;
        this.regenerationExhaustion = regenerationExhaustion;
        this.criticalMultiplier = criticalMultiplier;
    }


    @Override
    public KnockbackProfile getKnockback() {
        return this.knockback;
    }

    @Override
    public boolean interruptsSprintOnHit() {
        return this.interruptsSprintOnHit;
    }

    @Override
    public boolean canAttributeSwap() {
        return this.canAttributeSwap;
    }

    @Override
    public boolean canRegenerateOnSaturation() {
        return this.canRegenerateOnSaturation;
    }

    @Override
    public float getRegenerationExhaustion() {
        return this.regenerationExhaustion;
    }

    @Override
    public double getCriticalMultiplier() {
        return this.criticalMultiplier;
    }

}
