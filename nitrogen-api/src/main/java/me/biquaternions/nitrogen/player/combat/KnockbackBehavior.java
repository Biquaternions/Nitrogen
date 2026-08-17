package me.biquaternions.nitrogen.player.combat;

import org.bukkit.util.Vector;

public abstract class KnockbackBehavior {
    abstract double frictionHorizontal();
    abstract double frictionVertical();
    abstract double horizontal();
    abstract double vertical();
    abstract double verticalLimit();
    abstract double extraHorizontal();
    abstract double extraVertical();
}
