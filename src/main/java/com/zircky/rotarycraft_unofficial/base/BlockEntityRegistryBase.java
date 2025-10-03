package com.zircky.rotarycraft_unofficial.base;

import com.zircky.rotarycraft_unofficial.api.interfaces.registry.TileEnum;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public abstract class BlockEntityRegistryBase<E extends TileEnum> extends BlockEntity {

  public BlockEntityRegistryBase(BlockEntityType<?> type, BlockPos pos, BlockState state) {
    super(type, pos, state);
  }

  public final Block getTileEntityBlockID() {
    return this.getTile().getBlock();
  }

  public abstract E getTile();

  public final int getIndex() {
    return this.getTile().ordinal();
  }

  public String getTEName() {
    return this.getTile().getName();
  }

  public abstract void tick(Level world, BlockPos pos, BlockState state);

  protected abstract void animateWithTick(Level world, BlockPos pos);

  public final boolean isThisTE(Block id, int meta) {
    return id == this.getTileEntityBlockID() && meta == this.getIndex();
  }
}
