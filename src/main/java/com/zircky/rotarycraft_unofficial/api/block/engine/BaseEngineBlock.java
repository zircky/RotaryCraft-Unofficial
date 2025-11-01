package com.zircky.rotarycraft_unofficial.api.block.engine;

import com.zircky.rotarycraft_unofficial.RotaryCraftUnofficial;
import com.zircky.rotarycraft_unofficial.api.block.entity_block.BaseEngineBlockEntity;
import com.zircky.rotarycraft_unofficial.common.blockentity.engine.DCElectricEngineBlockEntity;
import com.zircky.rotarycraft_unofficial.common.data.RCUBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import org.jetbrains.annotations.Nullable;

public abstract class BaseEngineBlock<T extends BaseEngineBlockEntity> extends AbstractEngineBlock {
  protected static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
  protected static final BooleanProperty POWERED = BlockStateProperties.POWERED;

  protected BaseEngineBlock(Properties pProperties) {
    super(pProperties);
    this.registerDefaultState(this.stateDefinition.any()
        .setValue(FACING, Direction.NORTH)
        .setValue(POWERED, Boolean.FALSE));
  }

  @Override
  protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
    pBuilder.add(POWERED, FACING);
  }

  @Override
  public RenderShape getRenderShape(BlockState pState) {
    return RenderShape.MODEL;
  }

  @Nullable
  @Override
  public abstract BlockEntity newBlockEntity(BlockPos pPos, BlockState pState);

  @Override
  public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
    return pLevel.isClientSide
        ? createTickerHelper(pBlockEntityType, RCUBlockEntities.DC_ELECTRIC_ENGINE_ENTITY.get(), BaseEngineBlockEntity::clientTick)
        : null;
  }

  protected abstract BlockEntityType<T> getEntityType();

  @Override
  public void neighborChanged(BlockState pState, Level pLevel, BlockPos pPos, Block pNeighborBlock, BlockPos pNeighborPos, boolean pMovedByPiston) {
    if (!pLevel.isClientSide) {
      boolean powered = pLevel.hasNeighborSignal(pPos);
      RotaryCraftUnofficial.LOGGER.info("Redstone check at {}: {}", pPos, powered);

      if (powered != pState.getValue(POWERED)) {
        pLevel.setBlock(pPos, pState.setValue(POWERED, powered), 3);

        BlockEntity be = pLevel.getBlockEntity(pPos);
        if (be instanceof BaseEngineBlockEntity engine) {
          engine.setActive(powered);
          RotaryCraftUnofficial.LOGGER.info("Engine active set to {}", powered);
        }
      }
    }
  }

  @Override
  public void onPlace(BlockState pState, Level pLevel, BlockPos pPos, BlockState pOldState, boolean pMovedByPiston) {
    if (!pLevel.isClientSide) {
      boolean powered = pLevel.hasNeighborSignal(pPos);
      BlockEntity blockEntity = pLevel.getBlockEntity(pPos);
      if (blockEntity instanceof BaseEngineBlockEntity engineBlock) {
        engineBlock.setActive(powered);
      }
    }
  }
}
