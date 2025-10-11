package com.zircky.rotarycraft_unofficial.api.power;

public interface PowerGenerator {
  public long getMaxPower();

  public long getCurrentPower();

  public int getEmittingX();
  public int getEmittingY();
  public int getEmittingZ();
}
