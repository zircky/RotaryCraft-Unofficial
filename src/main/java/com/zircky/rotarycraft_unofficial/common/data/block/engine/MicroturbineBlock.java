package com.zircky.rotarycraft_unofficial.common.data.block.engine;

import com.zircky.rotarycraft_unofficial.api.block.engine.BaseEngineBlock;
import com.zircky.rotarycraft_unofficial.common.blockentity.engine.MicroturbineBlockEntity;
import com.zircky.rotarycraft_unofficial.common.data.RCUBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MicroturbineBlock extends BaseEngineBlock<MicroturbineBlockEntity> {
  public MicroturbineBlock(Properties pProperties) {
    super(pProperties);
  }

  @Override
  public @Nullable BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
    return new MicroturbineBlockEntity(pPos, pState);
  }

  @Override
  protected BlockEntityType<MicroturbineBlockEntity> getEntityType() {
    return RCUBlockEntities.MICROTURBINE_ENTITY.get();
  }

}
