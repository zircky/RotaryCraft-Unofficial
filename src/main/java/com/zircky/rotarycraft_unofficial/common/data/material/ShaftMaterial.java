package com.zircky.rotarycraft_unofficial.common.data.material;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class ShaftMaterial {
  private static final List<ShaftMaterial> ALL = new ArrayList<>();

  private final String id;
  private final int harvestLevel;
  private final double emod;
  private final double smod;
  private final double tensile;
  private final double shear;
  private final double density;

  private final boolean infiniteStrength;

  public ShaftMaterial(String id, int harvestLevel, double emod, double smod,
                       double tensile, double shear, double density, boolean infiniteStrength) {
    this.id = id;
    this.harvestLevel = harvestLevel;
    this.emod = emod;
    this.smod = smod;
    this.tensile = tensile;
    this.shear = shear;
    this.density = density;
    this.infiniteStrength = infiniteStrength;

    ALL.add(this);
  }

  // === Геттеры ===

  public String getId() {
    return id;
  }

  public int getHarvestLevel() {
    return harvestLevel;
  }

  public double getEmod() {
    return emod;
  }

  public double getSmod() {
    return smod;
  }

  public double getTensile() {
    return tensile;
  }

  public double getShear() {
    return shear;
  }

  public double getDensity() {
    return density;
  }

  public boolean isInfiniteStrength() {
    return infiniteStrength;
  }

  // === Физика ===

  public double getMaxTorque() {
    if (infiniteStrength)
      return Double.POSITIVE_INFINITY;
    double r = 0.0625;
    return 0.5 * Math.PI * r * r * r * shear / 16D;
  }

  public double getMaxSpeed() {
    if (infiniteStrength)
      return Double.POSITIVE_INFINITY;
    double f = 1D / getSpeedForceExponent();
    double r = 0.0625;
    double base = Math.sqrt(2 * tensile / (density * r * r));
    return Math.pow(base, f);
  }

  public double getSpeedForceExponent() {
    return switch (id) {
      case "wood" -> 1.0;
      case "stone" -> 0.9;
      case "steel" -> 0.8;
      case "tungsten" -> 0.7;
      case "diamond" -> 0.67;
      default -> 1.0;
    };
  }

  // === Утилиты ===

  public boolean isFlammable() {
    return id.equals("wood");
  }

  public static List<ShaftMaterial> all() {
    return Collections.unmodifiableList(ALL);
  }

  public static ShaftMaterial get(String id) {
    for (ShaftMaterial m : ALL)
      if (m.id.equalsIgnoreCase(id))
        return m;
    return null;
  }

  @Override
  public String toString() {
    return id.toUpperCase(Locale.ENGLISH);
  }
}

