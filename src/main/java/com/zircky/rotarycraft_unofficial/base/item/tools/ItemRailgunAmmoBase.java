package com.zircky.rotarycraft_unofficial.base.item.tools;

import com.zircky.rotarycraft_unofficial.api.interfaces.RailGunAmmo;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class ItemRailgunAmmoBase extends Item implements RailGunAmmo {
  public ItemRailgunAmmoBase(Properties pProperties) {
    super(pProperties.stacksTo(16));
  }

  @Override
  public RailGunAmmoType getAmmo(ItemStack stack) {
    return null;
  }
}
