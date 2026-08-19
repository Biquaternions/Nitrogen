package me.biquaternions.nitrogen.entity.knockback;

import io.papermc.paper.event.entity.EntityKnockbackEvent;
import org.bukkit.damage.DamageSource;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.util.Vector;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

@NullMarked
public interface KnockbackBehavior {

    float getMultiplierExtra();

    void handleKnockback(LivingEntity self, double power, double xd, double zd, DamageSource source, float damage, boolean comesFromEffect, @Nullable Entity attacker, EntityKnockbackEvent.Cause eventCause);

    void handleExtraKnockback(LivingEntity self, Entity entity, float knockbackAmount, Vector oldMovement, DamageSource damageSource, float damage, boolean comesFromEffect);

}
