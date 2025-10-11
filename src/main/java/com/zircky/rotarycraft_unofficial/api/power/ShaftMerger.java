package com.zircky.rotarycraft_unofficial.api.power;

public interface ShaftMerger {
  public void onPowerLooped(PowerTracker pwr);

  public void fail();
}
