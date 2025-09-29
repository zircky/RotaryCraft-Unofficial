package com.zircky.rotarycraft_unofficial.common.item.rail_gun;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import javax.swing.text.html.parser.Entity;

public interface RailGunAmmoType extends Comparable<RailGunAmmoType> {

  /**
   * Создаёт снаряд, который выстреливает рейлган.
   */
  Entity createProjectile(Level level, double x, double y, double z,
                          double vx, double vy, double vz, Object railgun);

  /**
   * Возвращает ItemStack, соответствующий этому боеприпасу.
   */
  ItemStack getItem();

  /**
   * Сколько требуется "энергии" или "крутящего момента" для выстрела.
   */
  int getRequiredTorque();

  /**
   * Является ли снаряд взрывным.
   */
  boolean isExplosive();

  /**
   * Является ли снаряд магическим.
   */
  boolean isMagic();

  /**
   * Масса снаряда (влияет на урон/скорость).
   */
  int getMass();
}
