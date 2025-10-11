package com.zircky.rotarycraft_unofficial.common.data.block;

import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;

public class ShaftBlock extends RotatedPillarBlock {
  public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.AXIS;

  public ShaftBlock(BlockBehaviour.Properties properties) {
    super(properties);
    this.registerDefaultState(this.stateDefinition.any().setValue(AXIS, Direction.Axis.Y));
  }

  @Override
  protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
    builder.add(AXIS);
  }

  @Override
  public BlockState getStateForPlacement(BlockPlaceContext context) {
//    Player player = context.getPlayer();
//
//    if (player == null) {
//      return this.defaultBlockState().setValue(AXIS, Direction.Axis.Y);
//    }
//
//    // Если игрок зажал Shift — ставим вертикально
//    if (player.isShiftKeyDown()) {
//      return this.defaultBlockState().setValue(AXIS, Direction.Axis.Y);
//    }
//
//    // По умолчанию — горизонтально, по направлению взгляда игрока
//    Direction lookDir = player.getDirection();
//    return this.defaultBlockState().setValue(AXIS, lookDir.getAxis());

    Direction face = context.getClickedFace();
    return this.defaultBlockState().setValue(AXIS,
        (face == Direction.UP || face == Direction.DOWN)
            ? Direction.Axis.Y
            : face.getAxis());
  }



}
