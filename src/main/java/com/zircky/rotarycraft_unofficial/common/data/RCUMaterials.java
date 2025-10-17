package com.zircky.rotarycraft_unofficial.common.data;

import com.zircky.rotarycraft_unofficial.common.data.material.flywheel.FlywheelMaterials;
import com.zircky.rotarycraft_unofficial.common.data.material.gearbox.GearboxTypes;
import com.zircky.rotarycraft_unofficial.common.data.material.shaft.ShaftMaterials;
import com.zircky.rotarycraft_unofficial.common.data.ores.RCUOres;

public class RCUMaterials {
  public static void init() {
    RCUOres.init();
    ShaftMaterials.register();
    FlywheelMaterials.register();
    GearboxTypes.register();

  }
}
