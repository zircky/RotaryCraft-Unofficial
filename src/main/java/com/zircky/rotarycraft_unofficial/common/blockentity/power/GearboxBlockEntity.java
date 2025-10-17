package com.zircky.rotarycraft_unofficial.common.blockentity.power;

import com.zircky.rotarycraft_unofficial.common.data.material.gearbox.GearboxType;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class GearboxBlockEntity extends BlockEntity {
  private final GearboxType type;
  private boolean powered;
  private double omega;
  private int ratio = 2;
  private double torque;

  public GearboxBlockEntity(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState, GearboxType type) {
    super(pType, pPos, pBlockState);
    this.type = type;
  }

  public GearboxBlockEntity(BlockPos pPos, BlockState pBlockState, GearboxType type) {
    super(null, pPos, pBlockState);
    this.type = type;
  }

  public void setPowered(boolean powered) {
    this.powered = powered;
  }

  @Override
  protected void saveAdditional(CompoundTag pTag) {
    super.saveAdditional(pTag);
    pTag.putInt("Ratio", ratio);
    pTag.putBoolean("Powered", powered);
    pTag.putString("Type", type.getId());
  }

  @Override
  public void load(CompoundTag pTag) {
    super.load(pTag);
    if (pTag.contains("Ratio")) {
      ratio = pTag.getInt("Ratio");
    }
    if (pTag.contains("Powered")) {
      powered = pTag.getBoolean("Powered");
    }
  }

  public void tick() {
    if (level == null || level.isClientSide) return;

    if (powered) {
      torque = 0;
      omega = 0;
      return;
    }

    torque = 100 * ratio;
    omega = 200 / ratio;
  }

  public Component getInfoText() {
    return Component.literal("Type: " + type.getId() + " | Ratio: " + ratio + ":1" + " | Torque: " + torque + " | Omega: " + omega);
  }

  public int getSignalOutput() {
    return (int) Math.min(15, omega / 20.0);
  }

  public void dropAllContents() {}
}
