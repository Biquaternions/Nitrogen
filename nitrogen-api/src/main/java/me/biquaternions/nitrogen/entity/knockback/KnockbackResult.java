package me.biquaternions.nitrogen.entity.knockback;

import org.bukkit.util.Vector;

public record KnockbackResult(Vector originalDelta, Vector resultingDelta) {
}
