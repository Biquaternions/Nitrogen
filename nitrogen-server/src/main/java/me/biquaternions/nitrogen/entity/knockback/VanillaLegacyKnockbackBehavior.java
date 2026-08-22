package me.biquaternions.nitrogen.entity.knockback;

import io.papermc.paper.event.entity.EntityKnockbackEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;
import org.bukkit.craftbukkit.entity.CraftEntity;
import org.bukkit.craftbukkit.entity.CraftLivingEntity;
import org.bukkit.craftbukkit.util.CraftVector;
import org.bukkit.util.Vector;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

@NullMarked
public class VanillaLegacyKnockbackBehavior implements KnockbackBehavior {

    private final double horizontal;
    private final double vertical;
    private final double verticalLimit;

    private final double horizontalExtra;
    private final double verticalExtra;

    private final double horizontalFriction;
    private final double verticalFriction;

    private final float multiplierExtra;

    public VanillaLegacyKnockbackBehavior() {
        this(0.4, 0.4, 0.4000000059604645, 0.5, 0.1, 2.0, 2.0, 1.0F);
    }

    protected VanillaLegacyKnockbackBehavior(final double horizontal, final double vertical, final double verticalLimit, final double horizontalExtra, final double verticalExtra, final double horizontalFriction, final double verticalFriction, final float multiplierExtra) {
        this.horizontal = horizontal;
        this.vertical = vertical;
        this.verticalLimit = verticalLimit;
        this.horizontalExtra = horizontalExtra;
        this.verticalExtra = verticalExtra;
        this.horizontalFriction = horizontalFriction;
        this.verticalFriction = verticalFriction;
        this.multiplierExtra = multiplierExtra;
    }

    @Override
    public float getMultiplierExtra() {
        return this.multiplierExtra;
    }

    @Override
    public KnockbackVelocitySummary handleKnockback(final org.bukkit.entity.LivingEntity self, double power, final double xd, final double zd, final org.bukkit.damage.DamageSource source0, final float damage, final boolean comesFromEffect, final org.bukkit.entity.@Nullable Entity attacker0, final EntityKnockbackEvent.Cause eventCause) {
        LivingEntity thiz = ((CraftLivingEntity) self).getHandle();

        Vec3 deltaMovement = thiz.getDeltaMovement();
        double magnitude = Math.sqrt(xd * xd + zd * zd);
        Vec3 targetMovement = deltaMovement
            .multiply(1.0 / this.horizontalFriction, 1.0 / this.verticalFriction, 1.0 / this.horizontalFriction)
            .add(
                -(xd / magnitude * this.horizontal),
                this.vertical,
                -(zd / magnitude * this.horizontal)
            );
        if (targetMovement.y() > this.verticalLimit) {
            targetMovement = new Vec3(targetMovement.x(), this.verticalLimit, targetMovement.z());
        }

        return new KnockbackVelocitySummary(CraftVector.toBukkit(deltaMovement), CraftVector.toBukkit(targetMovement));
    }

    @Override
    public void handleExtraKnockback(final org.bukkit.entity.LivingEntity self, final org.bukkit.entity.Entity entity0, final float knockbackAmount, final Vector oldMovement, final org.bukkit.damage.DamageSource damageSource0, final float damage, final boolean comesFromEffect) {
        LivingEntity thiz = ((CraftLivingEntity) self).getHandle();
        Entity entity = ((CraftEntity) entity0).getHandle();

        Vec3 motion = new Vec3(
            -(Mth.sin(thiz.getYRot() * Mth.DEG_TO_RAD) * knockbackAmount * this.horizontalExtra),
            this.verticalExtra,
            Mth.cos(thiz.getYRot() * Mth.DEG_TO_RAD) * knockbackAmount * this.horizontalExtra
        );

        entity.needsSync = true;
        entity.addDeltaMovement(motion);
        thiz.setDeltaMovement(thiz.getDeltaMovement().multiply(0.6, 1.0, 0.6));
    }

}
