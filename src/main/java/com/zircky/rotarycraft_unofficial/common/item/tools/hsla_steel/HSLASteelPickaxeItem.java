package com.zircky.rotarycraft_unofficial.common.item.tools.hsla_steel;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.state.BlockState;

public class HSLASteelPickaxeItem extends PickaxeItem {

  public HSLASteelPickaxeItem() {
    super(Tiers.IRON,
        2,
        6.0F,
        new Properties()
            .stacksTo(1)
            .fireResistant()
            .durability(600)
    );
  }

  @Override
  public boolean isCorrectToolForDrops(ItemStack stack, BlockState state) {
    return true;
  }

  @Override
  public Component getName(ItemStack stack) {
    return Component.translatable("HSLA Steel Pickaxe");
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
