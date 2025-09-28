package com.zircky.rotarycraft_unofficial.common.item;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;


public class SpringItem extends Item {
  private final String baseName;

  public SpringItem(String baseName, Properties properties) {
    super(properties);
    this.baseName = baseName;
  }

  private void initEnergy(ItemStack stack) {
    if (!stack.hasTag()) stack.setTag(new CompoundTag());
    if (!stack.getTag().contains("powerLevel")) {
      stack.getTag().putInt("powerLevel", 0);
    }
  }

  public int getPowerLevel(ItemStack stack) {
    initEnergy(stack);
    return stack.getTag().getInt("powerLevel");
  }

  public void setPowerLevel(ItemStack stack, int level) {
    initEnergy(stack);
    stack.getTag().putInt("powerLevel", Math.max(0, Math.min(level, getMaxPowerLevel())));
  }

  public int getEnergy(ItemStack stack) {
    int level = getPowerLevel(stack);

    if (level == 0) {
      return 0;
    }

    int value = (int) Math.pow(2, level - 1);
    return Math.min(value, getMaxEnergy());
  }

  public int getMaxEnergy() {
    return 30000;
  }

  public int getMaxPowerLevel() {
    return 14; // 2^14 = 16384, 2^15 = 32768 > 30000
  }

  public void increaseEnergy(ItemStack stack) {
    int currentLevel = getPowerLevel(stack);
    if (currentLevel < getMaxPowerLevel()) {
      setPowerLevel(stack, currentLevel + 1);
    }
  }

  @Override
  public Component getName(ItemStack stack) {
    return Component.literal(baseName + " (" + getEnergy(stack) + " kJ)");
  }

  @Override
  public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flag) {
    tooltip.add(Component.literal("Power Level: " + getPowerLevel(stack)));
    tooltip.add(Component.literal("Stored Energy: " + getEnergy(stack) + " kJ"));
  }

}
