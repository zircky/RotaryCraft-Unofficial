package com.zircky.rotarycraft_unofficial.api.power;

public interface ShaftMachine {
  public int getOmega();

  public int getTorque();

  public long getPower();

  public String getName();

  public int getIORenderAlpha();

  public void setIORenderAlpha(int io);
}
