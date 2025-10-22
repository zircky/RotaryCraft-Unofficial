package com.zircky.rotarycraft_unofficial.common.data.material.engine;

public enum EngineCategory {
  KINETIC,
  THERMAL,
  ELECTRIC,
  PISTON,
  TURBINE;

  public boolean isECUControllable() {
    return this == PISTON || this == TURBINE;
  }
}
