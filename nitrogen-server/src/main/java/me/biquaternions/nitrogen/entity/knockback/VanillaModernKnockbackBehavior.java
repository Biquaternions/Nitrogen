package me.biquaternions.nitrogen.entity.knockback;

import io.papermc.paper.event.entity.EntityKnockbackEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.phys.Vec3;
import org.bukkit.craftbukkit.damage.CraftDamageSource;
import org.bukkit.craftbukkit.entity.CraftEntity;
import org.bukkit.craftbukkit.entity.CraftLivingEntity;
import org.bukkit.craftbukkit.event.CraftEventFactory;
import org.bukkit.util.Vector;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;
import java.util.Objects;

@NullMarked
public class VanillaModernKnockbackBehavior extends KnockbackBehavior {

    @Override
    public void handleKnockback(final org.bukkit.entity.LivingEntity self, double power, double xd, double zd, final org.bukkit.damage.DamageSource source, final float damage, final boolean comesFromEffect, final org.bukkit.entity.@Nullable Entity attacker0, final EntityKnockbackEvent.Cause eventCause) {
        LivingEntity thiz = ((CraftLivingEntity) self).getHandle();
        Entity attacker = Objects.requireNonNull(((CraftEntity) attacker0)).getHandle();

        power *= 1.0 - thiz.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE);
        Vec3 deltaMovement = thiz.getDeltaMovement();

        while (xd * xd + zd * zd < 1.0E-5F) {
            xd = (thiz.getRandom().nextDouble() - thiz.getRandom().nextDouble()) * 0.01;
            zd = (thiz.getRandom().nextDouble() - thiz.getRandom().nextDouble()) * 0.01;
        }

        Vec3 deltaVector = new Vec3(xd, 0.0, zd).normalize().scale(power);
        Vec3 targetMovement = new Vec3( // Paper - knockback events
            deltaMovement.x / 2.0 - deltaVector.x,
            thiz.onGround() ? Math.min(0.4, deltaMovement.y / 2.0 + power) : deltaMovement.y,
            deltaMovement.z / 2.0 - deltaVector.z
        );
        // Paper start - knockback events
        Vec3 knockback = targetMovement.subtract(deltaMovement);
        io.papermc.paper.event.entity.EntityKnockbackEvent event = CraftEventFactory.callEntityKnockbackEvent((org.bukkit.craftbukkit.entity.CraftLivingEntity) thiz.getBukkitEntity(), attacker, attacker, eventCause, power, knockback);
        if (event.isCancelled()) {
            return;
        }

        thiz.needsSync = true;
        thiz.setDeltaMovement(deltaMovement.add(event.getKnockback().getX(), event.getKnockback().getY(), event.getKnockback().getZ()));
        // Paper end - knockback events
    }

    @Override
    public void handleExtraKnockback(final org.bukkit.entity.LivingEntity self, final org.bukkit.entity.Entity entity0, final float knockbackAmount, final Vector oldMovement, final org.bukkit.damage.DamageSource damageSource0, final float damage, final boolean comesFromEffect) {
        LivingEntity thiz = ((CraftLivingEntity) self).getHandle();
        Entity entity = ((CraftEntity) entity0).getHandle();
        DamageSource damageSource = ((CraftDamageSource) damageSource0).getHandle();

        if (entity instanceof LivingEntity livingTarget) {
            livingTarget.knockback(
                knockbackAmount, Mth.sin(thiz.getYRot() * Mth.DEG_TO_RAD), -Mth.cos(thiz.getYRot() * Mth.DEG_TO_RAD), damageSource, damage, comesFromEffect, thiz, io.papermc.paper.event.entity.EntityKnockbackEvent.Cause.ENTITY_ATTACK // Paper - knockback events
            );
        } else {
            entity.push(-Mth.sin(thiz.getYRot() * Mth.DEG_TO_RAD) * knockbackAmount, 0.1, Mth.cos(thiz.getYRot() * Mth.DEG_TO_RAD) * knockbackAmount, thiz); // Paper - Add EntityKnockbackByEntityEvent and EntityPushedByEntityAttackEvent
        }

        thiz.setDeltaMovement(thiz.getDeltaMovement().multiply(0.6, 1.0, 0.6));
    }

}
