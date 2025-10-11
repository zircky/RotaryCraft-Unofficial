package com.zircky.rotarycraft_unofficial.common.blockentity;

import com.zircky.rotarycraft_unofficial.api.interfaces.IPowerHandler;
import com.zircky.rotarycraft_unofficial.common.data.register.RCUShaftRegister;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class GearboxBlockEntity extends BlockEntity {
  private double omega;
  private double torque;
  private double temperature;

  public GearboxBlockEntity(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState) {
    super(pType, pPos, pBlockState);
  }

  public GearboxBlockEntity(BlockPos pPos, BlockState pBlockState) {
    super(null, pPos, pBlockState);
  }

}
