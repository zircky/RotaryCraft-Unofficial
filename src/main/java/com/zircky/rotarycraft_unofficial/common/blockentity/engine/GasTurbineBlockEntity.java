package com.zircky.rotarycraft_unofficial.common.blockentity.engine;

import com.zircky.rotarycraft_unofficial.common.data.RCUBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class GasTurbineBlockEntity extends BlockEntity {
  public GasTurbineBlockEntity(BlockEntityType<GasTurbineBlockEntity> pType, BlockPos pPos, BlockState pBlockState) {
    super(pType, pPos, pBlockState);
  }

  public GasTurbineBlockEntity(BlockPos pPos, BlockState pBlockState) {
    super(RCUBlockEntities.GAS_TURBINE_ENTITY.get(), pPos, pBlockState);
  }
}
