package com.zircky.rotarycraft_unofficial.common.data.material.gearbox;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;

import java.util.Locale;
import java.util.function.BiFunction;

public enum GearPart {
  SHAFT,
  GEAR,
  UNIT2,
  UNIT4,
  UNIT8,
  UNIT16,
  BEARING,
  SHAFTCORE;

  public int getMateOffset() {
    return this.ordinal();
  }

  public String getPartTranslationKey() {
    return switch (this) {
      case SHAFT -> "shaft";
      case GEAR -> "gear";
      case UNIT2 -> "gear2";
      case UNIT4 -> "gear4";
      case UNIT8 -> "gear8";
      case UNIT16 -> "gear16";
      case BEARING -> "bearing";
      case SHAFTCORE -> "shaftcore";
    };
  }

  public Component getDisplayName(GearboxType type) {
    return Component.translatable("material.gearbox." + type.getId().toLowerCase(Locale.ROOT))
        .append(" ")
        .append(Component.translatable(this.getPartTranslationKey()));
  }

  public static GearPart fromRatio(int ratio) {
    return switch (ratio) {
      case 2 -> UNIT2;
      case 4 -> UNIT4;
      case 8 -> UNIT8;
      case 16 -> UNIT16;
      default -> throw new IllegalArgumentException("Invalid gear ratio: " + ratio);
    };
  }

  public boolean isItemOfType(ItemStack stack, BiFunction<GearboxType, GearPart, ItemStack> partStackProvider) {
    for (GearboxType type : GearboxType.getAll()) {
      ItemStack candidate = partStackProvider.apply(type, this);
      if (!candidate.isEmpty() && ItemStack.isSameItemSameTags(candidate, stack)) {
        return true;
      }
    }
    return false;
  }
}

