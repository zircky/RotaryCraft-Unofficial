package com.zircky.rotarycraft_unofficial.common.blockentity.engine;

import com.zircky.rotarycraft_unofficial.api.block.entity_block.BaseEngineBlockEntity;
import com.zircky.rotarycraft_unofficial.common.data.RCUBlockEntities;
import com.zircky.rotarycraft_unofficial.common.data.material.engine.EngineDefinitions;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class ACElectricEngineBlockEntity extends BaseEngineBlockEntity {
  public ACElectricEngineBlockEntity(BlockPos pPos, BlockState pBlockState) {
    super(RCUBlockEntities.AC_ELECTRIC_ENGINE_ENTITY.get(), pPos, pBlockState, EngineDefinitions.getById("ac_electric_engine").getOmega());
  }
}