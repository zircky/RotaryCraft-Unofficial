package com.zircky.rotarycraft_unofficial.common.data.material.engine;

import com.tterrag.registrate.util.entry.BlockEntry;
import com.zircky.rotarycraft_unofficial.api.block.engine.BaseEngineBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Supplier;


public class EngineDefinition<T extends BlockEntity> {
  private final String id;
  private final int torque;
  private final int omega;
  private final EngineCategory category;
  private final Supplier<BlockEntry<? extends BaseEngineBlock>> blockSupplier;
  private final Supplier<BlockEntityType<T>> blockEntityType;
  private final Class<T> blockEntityClass;


  public EngineDefinition(String id, int torque, int omega, EngineCategory category, Supplier<BlockEntry<? extends BaseEngineBlock>> blockEntry, Supplier<BlockEntityType<T>> blockEntityType, Class<T> blockEntityClass) {
    this.id = id;
    this.torque = torque;
    this.omega = omega;
    this.category = category;
    this.blockSupplier = blockEntry;
    this.blockEntityType = blockEntityType;
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

  public Supplier<BlockEntry<? extends BaseEngineBlock>> getBlockSupplier() {
    return blockSupplier;
  }

  public Class<T> getBlockEntityClass() {
    return blockEntityClass;
  }

  public Supplier<BlockEntityType<T>> getBlockEntityType() {
    return blockEntityType;
  }
}
