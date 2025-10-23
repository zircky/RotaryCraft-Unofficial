package com.zircky.rotarycraft_unofficial.api.block.entity_block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class BaseEngineBlockEntity extends BlockEntity {
  protected boolean active;
  protected float rotation;
  protected float prevRotation;
  protected float speedPerTick;

  public BaseEngineBlockEntity(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState, int omegs) {
    super(pType, pPos, pBlockState);
    this.speedPerTick = (float) Math.toDegrees(omegs) / 20.0F;
  }

  public static void clinetTick(Level pLevel, BlockPos pPos, BlockState pBlockState, BaseEngineBlockEntity pEngineBlockEntity) {
    pEngineBlockEntity.prevRotation = pEngineBlockEntity.rotation;
    if (pEngineBlockEntity.active) {
      pEngineBlockEntity.rotation = (pEngineBlockEntity.rotation + pEngineBlockEntity.speedPerTick) % 360F;
    }
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  public float getInterpolatedRotation(float partialTicks) {
    return prevRotation + (rotation - prevRotation) * partialTicks;
  }
}
