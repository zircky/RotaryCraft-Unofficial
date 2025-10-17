package com.zircky.rotarycraft_unofficial.common.data.material.gearbox;

import com.zircky.rotarycraft_unofficial.common.data.material.shaft.ShaftMaterial;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class GearboxType {
  private static final List<GearboxType> ALL = new ArrayList<>();

  private final String id;
  private final int metaOffset;
  private final ShaftMaterial material;
  private final String dependentMod;
  private final boolean specialType;

  public GearboxType(String id, int metaOffset, ShaftMaterial material, String dependentMod, boolean specialType) {
    this.id = id;
    this.metaOffset = metaOffset;
    this.material = material;
    this.dependentMod = dependentMod;
    this.specialType = specialType;

    ALL.add(this);
  }

  public GearboxType(String id, int metaOffset, ShaftMaterial material) {
    this(id, metaOffset, material, null, false);
  }

  public String getId() {
    return id;
  }

  public int getMetaOffset() {
    return metaOffset;
  }

  public ShaftMaterial getMaterial() {
    return material;
  }

  public String getDependentMod() {
    return dependentMod;
  }

  public boolean isSpecialType() {
    return specialType;
  }

  public boolean idLoadeble() {
    return dependentMod == null;
  }

  public boolean needsLubricant() {
    return !material.isInfiniteStrength();
  }

  public boolean consumeLubricant() {
    return this.needsLubricant() && !id.equals("diamond");
  }

  public boolean genertatesHeat(int omega, int ambientTemp) {
    return switch (id) {
      case "wood" -> true;
      case "livingwood" -> omega >= 2048 || ambientTemp >= 100;
      case "stone" -> omega >= 8192;
      default -> false;
    };
  }

  public float getLubricantConsumeRate(int omegs) {
    return switch (id) {
      case "stone" -> Math.max(1, 1 + omegs /8192F);
      case "tungsten" -> (float) Math.min(1, 0.5F + Math.max(0, 0.03125F * (Math.log(omegs)/ Math.log(2) - 2)));
      default -> 1;
    };
  }

  public int getMaxLubricant() {
    return switch (id) {
      case "bedrock" -> 0;
      case "diamond" -> 1000;
      case "steel", "tungsten" -> 24000;
      case "stone" -> 8000;
      case "livingrock" -> 3000;
      case "wood", "livingwood" -> 0;
      default -> 0;
    };
  }

  public boolean acceptsBearingUpgrade(GearboxType upgrade) {
    if (this.isSpecialType() || this.id.equals("bedrock")) return false;
    if (this.id.equals("wood")) return false;
    return upgrade != null && !upgrade.id.equals("wood") && upgrade.material.getHarvestLevel() <= this.material.getHarvestLevel() + 2;
  }

  public static List<GearboxType> getAll() {
    return Collections.unmodifiableList(ALL);
  }

  public static GearboxType getById(String id) {
    for (GearboxType type : ALL) {
      if (type.id.equalsIgnoreCase(id)) return type;
    }
    return null;
  }

  @Override
  public String toString() {
    return id.toUpperCase(Locale.ENGLISH);
  }
}
