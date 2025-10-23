package com.zircky.rotarycraft_unofficial.common.data.block.engine;

import com.zircky.rotarycraft_unofficial.api.block.engine.BaseEngineBlock;
import com.zircky.rotarycraft_unofficial.common.blockentity.engine.DCElectricEngineBlockEntity;
import com.zircky.rotarycraft_unofficial.common.data.RCUBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;


public class DCElectricEngineBlock extends BaseEngineBlock<DCElectricEngineBlockEntity> {
  public DCElectricEngineBlock(Properties pProperties) {
    super(pProperties);
  }

  @Override
  public @Nullable BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
    return new DCElectricEngineBlockEntity(pPos, pState);
  }

  @Override
  public RenderShape getRenderShape(BlockState pState) {
    return RenderShape.MODEL;
  }

  @Override
  protected BlockEntityType<DCElectricEngineBlockEntity> getEntityType() {
    return RCUBlockEntities.DC_ELECTRIC_ENGINE_ENTITY.get();
  }
}