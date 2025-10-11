package com.zircky.rotarycraft_unofficial.api.power;

import net.minecraft.nbt.CompoundTag;

public final class BasicPowerHandler {
  private int torque;
  private int omega;
  private long power;
  private int iotick;

  public int getTorque() {
    return torque;
  }

  public void setTorque(int torque) {
    this.torque = torque;
  }

  public int getOmega() {
    return omega;
  }

  public void setOmega(int omega) {
    this.omega = omega;
  }

  public long getPower() {
    return power;
  }

  public void setPower(long power) {
    this.power = power;
  }

  public int getIORenderAlpha() {
    return iotick;
  }

  public void setIORenderAlpha(int io) {
    iotick = io;
  }

  public void decreaseIOTick(int amt) {
    iotick = Math.max(0, iotick - amt);
  }

  public void readFromNBT(CompoundTag compound) {
    omega = compound.getInt("omg");
    torque = compound.getInt("tq");
    power = compound.getLong("pwr");
  }

  public void writeToNBT(CompoundTag compound) {
    compound.putInt("omg", omega);
    compound.putInt("tq", torque);
    compound.putLong("pwr", power);
  }
}
