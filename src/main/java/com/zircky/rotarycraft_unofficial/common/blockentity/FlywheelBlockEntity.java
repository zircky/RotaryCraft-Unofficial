package com.zircky.rotarycraft_unofficial.common.blockentity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class FlywheelBlockEntity extends BlockEntity {
  public static final int MIN_TORQUE_RATIO = 4;

  public long power = 0;
  public int torque = 0;
  public int omega = 0;

  private int decayTime;
  private int maxtorque;

  public boolean failed = false;
  private int soundtick = 0;

  private int oppTorque = 0;
  private int updateticks = 0;

  protected int torquein; //
  protected int omegain; //

  public FlywheelBlockEntity(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState) {
    super(pType, pPos, pBlockState);
  }

}
