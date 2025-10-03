package com.zircky.rotarycraft_unofficial.api.interfaces.registry;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public interface TileEnum {
  Class<? extends BlockEntity> getTEClass();
  String getName();
  Block getBlock();
  BlockState getBlockState(); // Замена getBlockMetadata
  ItemStack getCraftedProduct();
  ItemStack getCraftedProduct(BlockEntity be);
  int ordinal();
}
