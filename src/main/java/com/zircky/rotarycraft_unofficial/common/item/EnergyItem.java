package com.zircky.rotarycraft_unofficial.common.item;

import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class EnergyItem extends Item {
  private final int maxEnergy;
  private final String baseName;
  private String text = null;

  public EnergyItem(String baseName, Properties properties, int maxEnergy) {
    super(properties);
    this.maxEnergy = maxEnergy;
    this.baseName = baseName;
  }

  public EnergyItem(String baseName, Properties properties, int maxEnergy, String text) {
    super(properties);
    this.maxEnergy = maxEnergy;
    this.baseName = baseName;
    this.text = text;
  }

  // --- Работа с NBT ---
  private void initNBT(ItemStack stack) {
    if (!stack.hasTag()) stack.setTag(new CompoundTag());
    CompoundTag tag = stack.getTag();
    if (!tag.contains("Energy")) {
      tag.putInt("Energy", 0);
    }
  }

  public int getEnergy(ItemStack stack) {
    initNBT(stack);
    return stack.getTag().getInt("Energy");
  }

  public void setEnergy(ItemStack stack, int energy) {
    initNBT(stack);
    stack.getTag().putInt("Energy", Math.min(energy, maxEnergy));
  }

  public void addEnergy(ItemStack stack, int amount) {
    setEnergy(stack, getEnergy(stack) + amount);
  }

  public void removeEnergy(ItemStack stack, int amount) {
    setEnergy(stack, getEnergy(stack) - amount);
  }

  public int getMaxEnergy() {
    return maxEnergy;
  }

  @Override
  public Component getName(ItemStack stack) {
    return Component.literal(baseName + " (" + getEnergy(stack) + " / " + maxEnergy + " kJ)");
  }

  // --- Tooltip ---
  @Override
  public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flag) {
    if (text == null) {
      tooltip.add(Component.literal("Energy: " + getEnergy(stack) + " / " + maxEnergy + " kJ"));
    } else {
      tooltip.add(Component.literal("Energy: " + getEnergy(stack) + " / " + maxEnergy + " kJ"));
      tooltip.add(Component.literal(text).withStyle(ChatFormatting.GRAY));
    }

  }

}
