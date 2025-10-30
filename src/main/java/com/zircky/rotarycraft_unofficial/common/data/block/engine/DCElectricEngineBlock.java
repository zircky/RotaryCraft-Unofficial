package com.zircky.rotarycraft_unofficial.common.data.block.engine;

import com.zircky.rotarycraft_unofficial.api.block.engine.BaseEngineBlock;
import com.zircky.rotarycraft_unofficial.api.block.entity_block.BaseEngineBlockEntity;
import com.zircky.rotarycraft_unofficial.common.blockentity.engine.DCElectricEngineBlockEntity;
import com.zircky.rotarycraft_unofficial.common.data.RCUBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
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

//  @Override
//  public RenderShape getRenderShape(BlockState pState) {
//    return RenderShape.MODEL;
//  }

  @Override
  protected BlockEntityType<DCElectricEngineBlockEntity> getEntityType() {
    return RCUBlockEntities.DC_ELECTRIC_ENGINE_ENTITY.get();
  }

  @Override
  public void neighborChanged(BlockState state, Level level, BlockPos pos,
                              Block block, BlockPos fromPos, boolean moving) {
    if (!level.isClientSide) {
      boolean powered = level.hasNeighborSignal(pos);
      if (powered != state.getValue(POWERED)) {
        level.setBlock(pos, state.setValue(POWERED, powered), 3);

        BlockEntity be = level.getBlockEntity(pos);
        if (be instanceof DCElectricEngineBlockEntity engine) {
          engine.setActive(powered);
          System.out.println("Engine active set to " + powered);
        }
      }
    }
  }

  @Override
  public <T extends BlockEntity> BlockEntityTicker<T> getTicker(
      Level level, BlockState state, BlockEntityType<T> type) {

    return level.isClientSide
        ? createTickerHelper(type, RCUBlockEntities.DC_ELECTRIC_ENGINE_ENTITY.get(), BaseEngineBlockEntity::clientTick)
        : null;
  }


}