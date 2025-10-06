package com.zircky.rotarycraft_unofficial.common.blockentity;

import com.zircky.rotarycraft_unofficial.api.interfaces.IPowerHandler;
import com.zircky.rotarycraft_unofficial.common.data.RCUTransmission;
import com.zircky.rotarycraft_unofficial.common.registry.MaterialRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class GearboxBlockEntity extends BlockEntity implements IPowerHandler {
  private double omega;
  private double torque;
  private double temperature;

  private MaterialRegistry material = MaterialRegistry.WOOD;


  public GearboxBlockEntity(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState) {
    super(pType, pPos, pBlockState);
  }

  public GearboxBlockEntity(BlockPos pPos, BlockState pBlockState) {
    super(RCUTransmission.GEARBOX_BE.get(), pPos, pBlockState);
  }

  public void setMaterial(MaterialRegistry mat) {
    this.material = mat;
    setChanged();
  }

  public MaterialRegistry getMaterialType() {
    return material;
  }

  @Override
  protected void saveAdditional(CompoundTag tag) {
    tag.putDouble("Omega", omega);
    tag.putDouble("Torque", torque);
    tag.putDouble("Temp", temperature);
  }

  @Override
  public void load(CompoundTag tag) {
    super.load(tag);
    omega = tag.getDouble("Omega");
    torque = tag.getDouble("Torque");
    temperature = tag.getDouble("Temp");
  }

  public void tickServer() {
    if (temperature > 250 && material != MaterialRegistry.BEDROCK) {
      level.destroyBlock(worldPosition, true);
    }
  }

  @Override
  public long getOmega() {
    return 0;
  }

  @Override
  public long getTorque() {
    return 0;
  }

  @Override
  public void setPower(long torque, long omega) {

  }

  @Override
  public boolean canReceive() {
    return false;
  }
}
