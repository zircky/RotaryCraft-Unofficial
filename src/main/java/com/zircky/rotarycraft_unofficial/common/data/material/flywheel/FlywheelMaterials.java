package com.zircky.rotarycraft_unofficial.common.data.material.flywheel;

import com.zircky.rotarycraft_unofficial.api.library.EngLibrary;

public class FlywheelMaterials {
  public static final FlywheelMaterial WOOD = new FlywheelMaterial("wood", 16, 2, EngLibrary.rhowood, EngLibrary.Twood, false);
  public static final FlywheelMaterial STONE = new FlywheelMaterial("stone", 128, 5, EngLibrary.rhorock, EngLibrary.Tstone, false);
  public static final FlywheelMaterial IRON = new FlywheelMaterial("iron", 512, 15, EngLibrary.rhoiron, EngLibrary.Tiron, false);
  public static final FlywheelMaterial GOLD = new FlywheelMaterial("gold", 4096, 40, EngLibrary.rhogold, EngLibrary.Tgold, false);
  public static final FlywheelMaterial TUNGSTEN = new FlywheelMaterial("tungsten", 8192, 25, EngLibrary.rhotungsten, EngLibrary.Ttungsten, false);
  public static final FlywheelMaterial DEPLETEDU = new FlywheelMaterial("depleted_uranium", 4096, 40, EngLibrary.rhouranium, EngLibrary.Turanium, false);
  public static final FlywheelMaterial BEDROCK = new FlywheelMaterial("bedrock", Integer.MAX_VALUE, 200, 1.75 + EngLibrary.rhoiron, Double.POSITIVE_INFINITY, true);

  public static void register() {}
}
