package com.zircky.rotarycraft_unofficial.common.data.block.engine;

import com.zircky.rotarycraft_unofficial.api.block.engine.BaseEngineBlock;
import com.zircky.rotarycraft_unofficial.common.blockentity.engine.WindTurbineBlockEntity;
import com.zircky.rotarycraft_unofficial.common.data.RCUBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;


public class WindTurbineBlock extends BaseEngineBlock<WindTurbineBlockEntity> {
  public WindTurbineBlock(Properties pProperties) {
    super(pProperties);
  }

  @Override
  public @Nullable BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
    return new WindTurbineBlockEntity(pPos, pState);
  }

  @Override
  protected BlockEntityType<WindTurbineBlockEntity> getEntityType() {
    return RCUBlockEntities.WIND_TURBINE_ENTITY.get();
  }

}