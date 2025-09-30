package com.zircky.rotarycraft_unofficial.api.interfaces;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;

public interface RailGunAmmo {

  RailGunAmmoType getAmmo(ItemStack stack);

  interface RailGunAmmoType extends Comparable<RailGunAmmoType> {

    /** Требуемый крутящий момент */
    int getRequiredTorque();

    /** Какой ItemStack представляет этот боеприпас */
    ItemStack getItem();

    /** Создать снаряд (Entity) для Railgun */
    Entity getProjectileEntity(Level level,
                               double x, double y, double z,
                               double vx, double vy, double vz,
                               BlockEntity railgun);

    /** Сравнение мощности */
    @Override
    int compareTo(RailGunAmmoType type);

    /** Взрывной ли боеприпас */
    boolean isExplosive();

    /** Магический ли боеприпас */
    boolean isMagic();

    /** Масса боеприпаса */
    int getMass();
  }
}
