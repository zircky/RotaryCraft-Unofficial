package com.zircky.rotarycraft_unofficial.common.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class CustemItem extends Item {
  private final String name;
  public CustemItem(String name, Properties pProperties) {
    super(pProperties);
    this.name = name;
  }

  @Override
  public Component getName(ItemStack pStack) {
    return Component.literal(name);
  }
}
