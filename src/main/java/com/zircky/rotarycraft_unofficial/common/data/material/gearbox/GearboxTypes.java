package com.zircky.rotarycraft_unofficial.common.data.material.gearbox;

import com.zircky.rotarycraft_unofficial.common.data.material.shaft.ShaftMaterials;

public class GearboxTypes {
  public static final GearboxType WOOD = new GearboxType("wood", 1, ShaftMaterials.WOOD);
  public static final GearboxType STONE = new GearboxType("stone", 2, ShaftMaterials.STONE);
  public static final GearboxType STEEL = new GearboxType("steel", 2, ShaftMaterials.STEEL);
  public static final GearboxType TUNGSTEN = new GearboxType("tungsten", 2, ShaftMaterials.TUNGSETN);
  public static final GearboxType DIAMOND = new GearboxType("diamond", 2, ShaftMaterials.DIAMOND);
  public static final GearboxType BEDROCK = new GearboxType("bedrock", 2, ShaftMaterials.BEDROCK);
  public static final GearboxType LIVINGWOOD = new GearboxType("livingwood", 2, ShaftMaterials.WOOD, "botania", true);
  public static final GearboxType LIVINGROCK = new GearboxType("livingrock", 2, ShaftMaterials.STONE, "botania", true);

  public static void register() {
  }
}
