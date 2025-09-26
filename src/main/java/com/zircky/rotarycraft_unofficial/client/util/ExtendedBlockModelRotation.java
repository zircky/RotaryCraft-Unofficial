package com.zircky.rotarycraft_unofficial.client.util;

import net.minecraft.core.Direction;

public enum ExtendedBlockModelRotation {

  DOWN_SOUTH(90, 0, 180),
  DOWN_WEST(90, 0, 270),
  DOWN_NORTH(90, 0, 0),
  DOWN_EAST(90, 0, 90),

  UP_SOUTH(270, 0, 0),
  UP_WEST(270, 0, 270),
  UP_NORTH(270, 0, 180),
  UP_EAST(270, 0, 90),

  NORTH_SOUTH(0, 0, 180),
  NORTH_WEST(0, 0, 90),
  NORTH_NORTH(0, 0, 0), // Default
  NORTH_EAST(0, 0, 270),

  SOUTH_SOUTH(0, 180, 180),
  SOUTH_WEST(0, 180, 90),
  SOUTH_NORTH(0, 180, 0),
  SOUTH_EAST(0, 180, 270),

  WEST_SOUTH(0, 270, 180),
  WEST_WEST(0, 270, 90),
  WEST_NORTH(0, 270, 0),
  WEST_EAST(0, 270, 270),

  EAST_SOUTH(0, 90, 180),
  EAST_WEST(0, 90, 90),
  EAST_NORTH(0, 90, 0),
  EAST_EAST(0, 90, 270);

  public static final ExtendedBlockModelRotation[] VALUES = values();

  private final int angleX;
  private final int angleY;
  private final int angleZ;

  ExtendedBlockModelRotation(int angleX, int angleY, int angleZ) {
    this.angleX = angleX;
    this.angleY = angleY;
    this.angleZ = angleZ;
  }

  public int getAngleX() {
    return angleX;
  }

  public int getAngleY() {
    return angleY;
  }

  public int getAngleZ() {
    return angleZ;
  }

  public static ExtendedBlockModelRotation get(Direction frontFacing, Direction upwardsFacing) {
    return VALUES[frontFacing.get3DDataValue() * 4 + upwardsFacing.get2DDataValue()];
  }
}
