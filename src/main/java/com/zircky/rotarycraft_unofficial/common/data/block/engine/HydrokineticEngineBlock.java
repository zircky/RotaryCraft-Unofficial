package com.zircky.rotarycraft_unofficial.common.data.block.engine;

import com.zircky.rotarycraft_unofficial.api.block.engine.BaseEngineBlock;
import com.zircky.rotarycraft_unofficial.common.blockentity.engine.HydrokineticEngineBlockEntity;
import com.zircky.rotarycraft_unofficial.common.data.RCUBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class HydrokineticEngineBlock extends BaseEngineBlock<HydrokineticEngineBlockEntity> {
  public HydrokineticEngineBlock(Properties pProperties) {
    super(pProperties);
  }

  @Override
  public @Nullable BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
    return new HydrokineticEngineBlockEntity(pPos, pState);
  }

  @Override
  protected BlockEntityType<HydrokineticEngineBlockEntity> getEntityType() {
    return RCUBlockEntities.HYDROKINETIC_ENGINE_ENTITY.get();
  }

}