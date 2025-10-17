package com.zircky.rotarycraft_unofficial.common.blockentity.power;

import com.zircky.rotarycraft_unofficial.common.data.block.power.ShaftBlock;
import com.zircky.rotarycraft_unofficial.common.data.register.RCUShaftRegister;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class ShaftBlockEntity extends BlockEntity {

  public float rotation = 0F;
  public float speed = 10F;

  public ShaftBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
    super(type, pos, state);
  }

  public ShaftBlockEntity(BlockPos pos, BlockState state) {
    super(RCUShaftRegister.getEnitity().get(), pos, state);
  }

  public static void tick(Level level, BlockPos pos, BlockState state, ShaftBlockEntity shaftBlockEntity) {
    if (!level.isClientSide) return;

    Direction.Axis axis = state.getValue(ShaftBlock.AXIS);
    Direction dir1 = Direction.get(Direction.AxisDirection.POSITIVE, axis);
    Direction dir2 = Direction.get(Direction.AxisDirection.NEGATIVE, axis);

    BlockEntity blockEntity1 = level.getBlockEntity(pos.relative(dir1));
    BlockEntity blockEntity2 = level.getBlockEntity(pos.relative(dir2));

    float sourceSpeed = shaftBlockEntity.speed;

    if (blockEntity1 instanceof ShaftBlockEntity shaft1) {
      sourceSpeed = Math.max(sourceSpeed, shaft1.speed);
    }
    if (blockEntity2 instanceof ShaftBlockEntity shaft2) {
      sourceSpeed = Math.max(sourceSpeed, shaft2.speed);
    }

    shaftBlockEntity.speed = sourceSpeed;
    shaftBlockEntity.rotation = (shaftBlockEntity.rotation + shaftBlockEntity.speed) % 360;
  }
}