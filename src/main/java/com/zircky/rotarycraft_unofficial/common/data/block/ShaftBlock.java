package com.zircky.rotarycraft_unofficial.common.data.block;

import com.zircky.rotarycraft_unofficial.common.blockentity.ShaftBlockEntity;
import com.zircky.rotarycraft_unofficial.common.data.RCUContent;
import com.zircky.rotarycraft_unofficial.common.registry.MaterialRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;

public class ShaftBlock extends Block implements EntityBlock {
//  public static final DirectionProperty FACING = DirectionProperty.create("facing", Direction.Plane.HORIZONTAL);
//  public static final EnumProperty<Direction.Axis> AXIS = EnumProperty.create("axis", Direction.Axis.class);

  private final MaterialRegistry material;

  public ShaftBlock(MaterialRegistry mat, BlockBehaviour.Properties props) {
    super(props);
    this.material = mat;
    //this.registerDefaultState(this.stateDefinition.any().setValue(AXIS, Direction.Axis.Y));
  }

  public MaterialRegistry getMaterialType() {
    return material;
  }

//  @Override
//  protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
//    pBuilder.add(AXIS);
//  }
//
//  @Override
//  public BlockState getStateForPlacement(BlockPlaceContext context) {
//    Direction.Axis axis = context.getClickedFace().getAxis();
//    return this.defaultBlockState().setValue(AXIS, axis);
//  }

  @Override
  public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
    ShaftBlockEntity be = new ShaftBlockEntity(pos, state);
    be.setMaterial(material);
    return be;
  }

  @Override
  public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
    return RCUContent.SHAFT_BE.get() == type ? (lvl, pos, st, be) -> ShaftBlockEntity.tick(lvl, pos, st, (ShaftBlockEntity) be) : null;
  }
}
