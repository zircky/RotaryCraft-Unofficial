package com.zircky.rotarycraft_unofficial.common.data.material.engine;

import com.tterrag.registrate.util.entry.BlockEntityEntry;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.world.level.block.entity.BlockEntity;


public class EngineDefinition<T extends BlockEntity> {
  private final String id;
  private final int torque;
  private final int omega;
  private final EngineCategory category;
  private final BlockEntry<?> blockEntry;
  private final BlockEntityEntry<T> blockEntityEntry;
  private final Class<T> blockEntityClass;


  public EngineDefinition(String id, int torque, int omega, EngineCategory category, BlockEntry<?> blockEntry, BlockEntityEntry<T> blockEntityEntry, Class<T> blockEntityClass) {
    this.id = id;
    this.torque = torque;
    this.omega = omega;
    this.category = category;
    this.blockEntry = blockEntry;
    this.blockEntityEntry = blockEntityEntry;
    this.blockEntityClass = blockEntityClass;
  }

  public String getId() {
    return id;
  }

  public int getTorque() {
    return torque;
  }

  public int getOmega() {
    return omega;
  }

  public long getPower() {
    return (long) torque * (long) omega;
  }

  public EngineCategory getCategory() {
    return category;
  }

  public BlockEntry<?> getBlockEntry() {
    return blockEntry;
  }

  public BlockEntityEntry<T> getBlockEntityEntry() {
    return blockEntityEntry;
  }

}
