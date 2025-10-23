package com.zircky.rotarycraft_unofficial.common.blockentity.engine;

import com.zircky.rotarycraft_unofficial.api.block.entity_block.BaseEngineBlockEntity;
import com.zircky.rotarycraft_unofficial.common.data.RCUBlockEntities;
import com.zircky.rotarycraft_unofficial.common.data.material.engine.EngineDefinitions;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class GasTurbineBlockEntity extends BaseEngineBlockEntity {
  public GasTurbineBlockEntity(BlockPos pPos, BlockState pBlockState) {
    super(RCUBlockEntities.GAS_TURBINE_ENTITY.get(), pPos, pBlockState, EngineDefinitions.getById("gas_turbine").getOmega());
  }
}
