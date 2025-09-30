package com.zircky.rotarycraft_unofficial.common.item.tools.hsla_steel;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.state.BlockState;

public class HSLASteelPickaxeItem extends PickaxeItem {
  private final String name;

  public HSLASteelPickaxeItem(String name) {
    super(Tiers.IRON,
        2,
        1.0F,
        new Properties()
            .stacksTo(1)
            .fireResistant()
            .durability(600)
    );
    this.name = name;
  }

  @Override
  public boolean isCorrectToolForDrops(ItemStack stack, BlockState state) {
    return true;
  }

  @Override
  public Component getName(ItemStack stack) {
    return Component.translatable(name);
  }

  @Override
  public boolean isDamageable(ItemStack stack) {
    return false;
  }

  @Override
  public boolean canBeDepleted() {
    return false;
  }
}
