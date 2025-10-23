package com.zircky.rotarycraft_unofficial.common.data.block.engine;

import com.zircky.rotarycraft_unofficial.api.block.engine.BaseEngineBlock;
import com.zircky.rotarycraft_unofficial.common.blockentity.engine.GasTurbineBlockEntity;
import com.zircky.rotarycraft_unofficial.common.data.RCUBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class GasTurbineBlock extends BaseEngineBlock<GasTurbineBlockEntity> {
  public GasTurbineBlock(Properties pProperties) {
    super(pProperties);
  }

  @Override
  public @Nullable BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
    return new GasTurbineBlockEntity(pPos, pState);
  }

  @Override
  protected BlockEntityType<GasTurbineBlockEntity> getEntityType() {
    return RCUBlockEntities.GAS_TURBINE_ENTITY.get();
  }

}
