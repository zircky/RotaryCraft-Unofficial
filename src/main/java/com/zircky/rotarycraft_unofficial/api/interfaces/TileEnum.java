package com.zircky.rotarycraft_unofficial.api.interfaces;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;

public interface TileEnum {

  /**
   * @return Blockkentity class associated with this type.
   */
  Class<? extends BlockEntity> getBlockEntityClass();

  /**
   * @return Unique name of the mechanism (used in logs, renders, identifiers).
   */
  String getName();

  /**
   * @return The block itself, registered in Registrate or Registry.
   */
  Block getBlock();

  /**
   * @return Additional metadata (if not needed, you can return 0).
   */
  int getBlockMetadata();

  /**
   * @return The finished item (itemstack) of this mechanism by default.
   */
  ItemStack getCraftedProduct();

  /**
   * @param be — BlockEntity instance to receive data (e.g. damage, fullness, etc.)
   * @return ItemStack with NBT, reflecting the current state of the block.
   */
  ItemStack getCraftedProduct(BlockEntity be);

  /**
   * @return Order index (analogue enum.ordinal ()).
   */
  int ordinal();
}
