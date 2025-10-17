package com.zircky.rotarycraft_unofficial.common.data.material.gearbox;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class GearboxItem extends BlockItem {
  public GearboxItem(Block pBlock, Properties pProperties) {
    super(pBlock, pProperties);
  }

  @Override
  public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
    super.appendHoverText(pStack, pLevel, pTooltip, pFlag);
    CompoundTag tag = pStack.getOrCreateTag();
    if (tag.contains("Ratio")) {
      pTooltip.add(Component.literal("Gear ratio: " + tag.getInt("Ratio") + ":1"));
    }
    if (tag.contains("Type")) {
      pTooltip.add(Component.literal("Material: " + tag.getString("Type")));
    }
  }
}
