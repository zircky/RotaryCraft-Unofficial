package com.zircky.rotarycraft_unofficial.common.data.material.flywheel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class FlywheelMaterial {
  private static final List<FlywheelMaterial> ALL = new ArrayList<>();

  private final String id;
  private final int maxTorque;
  private final int decayTime;
  private final double density;
  private final double tensileStrength;
  private final boolean infiniteStrength;

  private final int maxSpeed;

  public FlywheelMaterial(String id, int maxTorque, int decayTime, double density, double tensileStrength, boolean infiniteStrength) {
    this.id = id;
    this.maxTorque = maxTorque;
    this.decayTime = decayTime;
    this.density = density;
    this.tensileStrength = tensileStrength;
    this.infiniteStrength = infiniteStrength;
    this.maxSpeed = calculateLimitSpeed();

    ALL.add(this);
  }

  public String getId() {
    return id;
  }

  public int getMaxTorque() {
    return maxTorque;
  }

  public int getDecayTime() {
    return decayTime;
  }

  public double getDensity() {
    return density;
  }

  public double getTensileStrength() {
    return tensileStrength;
  }

  public boolean isInfiniteStrength() {
    return infiniteStrength;
  }

  public int getMaxSpeed() {
    return maxSpeed;
  }

  private int calculateLimitSpeed() {
    if (infiniteStrength) return Integer.MAX_VALUE;

    double r = 0.75;
    double s = 100 * tensileStrength;
    double frac = 2 * s / (density * r * r);
    return (int) Math.sqrt(frac);
  }

  public static List<FlywheelMaterial> getAll() {
    return Collections.unmodifiableList(ALL);
  }

  public static FlywheelMaterial get(String id) {
    for (FlywheelMaterial f : ALL) {
      if (f.id.equalsIgnoreCase(id)) return f;
    }
    return null;
  }

  @Override
  public String toString() {
    return id.toUpperCase(Locale.ENGLISH);
  }
}
