package com.zircky.rotarycraft_unofficial.common.blockentity.engine;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.TickingBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class DCElectricEngineBlockEntity extends BlockEntity {


  public DCElectricEngineBlockEntity(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState) {
    super(pType, pPos, pBlockState);
  }

  @Override
  public void tick() {
    if (level == null || !level.isClientSide) return;


  }
}