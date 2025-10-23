package com.zircky.rotarycraft_unofficial.common.blockentity.engine;

import com.zircky.rotarycraft_unofficial.api.block.entity_block.BaseEngineBlockEntity;
import com.zircky.rotarycraft_unofficial.common.data.RCUBlockEntities;
import com.zircky.rotarycraft_unofficial.common.data.material.engine.EngineDefinitions;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class GasolineEngineBlockEntity extends BaseEngineBlockEntity {
  public GasolineEngineBlockEntity(BlockPos pPos, BlockState pBlockState) {
    super(RCUBlockEntities.GASOLINE_ENGINE_ENTITY.get(), pPos, pBlockState, EngineDefinitions.getById("gasoline_engine").getOmega());
  }
}