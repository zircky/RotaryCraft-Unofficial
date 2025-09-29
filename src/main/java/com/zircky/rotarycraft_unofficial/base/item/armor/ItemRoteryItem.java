package com.zircky.rotarycraft_unofficial.base.item.armor;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;

public abstract class ItemRoteryItem extends ArmorItem {
  public ItemRoteryItem(ArmorMaterial pMaterial, Type pType, Properties pProperties) {
    super(pMaterial, pType, pProperties.stacksTo(1));

  }

  

}
