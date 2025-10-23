package com.zircky.rotarycraft_unofficial.common.data.material.engine;

import com.tterrag.registrate.util.entry.BlockEntry;
import com.zircky.rotarycraft_unofficial.common.blockentity.engine.*;
import com.zircky.rotarycraft_unofficial.common.data.RCUBlockEntities;
import com.zircky.rotarycraft_unofficial.common.data.RCUBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.*;

public class EngineDefinitions {
  public static final Map<String, EngineDefinition<?>> ENGINES = new HashMap<>();

  public static final EngineDefinition<DCElectricEngineBlockEntity> DC_ENGINE = new EngineDefinition<>(
      "dc_electric_engine",
      4,
      256,
      EngineCategory.ELECTRIC,
      () -> RCUBlocks.DC_ELECTRIC_ENGINE,
      () ->  RCUBlockEntities.DC_ELECTRIC_ENGINE_ENTITY.get(),
      DCElectricEngineBlockEntity.class
  );

  public static final EngineDefinition<ACElectricEngineBlockEntity> ACE_ENGINE = new EngineDefinition<>(
      "ac_electric_engine",
      512,
      256,
      EngineCategory.ELECTRIC,
      () -> RCUBlocks.AC_ELECTRIC_ENGINE,
      () -> RCUBlockEntities.AC_ELECTRIC_ENGINE_ENTITY.get(),
      ACElectricEngineBlockEntity.class
  );

  public static final EngineDefinition<WindTurbineBlockEntity> WIND_TURBINE = new EngineDefinition<>(
      "wind_turbine",
      8,
      1024,
      EngineCategory.KINETIC,
      () -> RCUBlocks.WIND_TURBINE,
      () -> RCUBlockEntities.WIND_TURBINE_ENTITY.get(),
      WindTurbineBlockEntity.class
  );

  public static final EngineDefinition<SteamEngineBlockEntity> STEAM_ENGINE = new EngineDefinition<>(
      "steam_engine",
      32,
      512,
      EngineCategory.THERMAL,
      () -> RCUBlocks.STEAM_ENGINE,
      () -> RCUBlockEntities.STEAM_ENGINE_ENTITY.get(),
      SteamEngineBlockEntity.class
  );
  public static final EngineDefinition<GasolineEngineBlockEntity> GASOLINE_ENGINE = new EngineDefinition<>(
      "gasoline_engine",
      128,
      512,
      EngineCategory.PISTON,
      () -> RCUBlocks.GASOLINE_ENGINE,
      () -> RCUBlockEntities.GASOLINE_ENGINE_ENTITY.get(),
      GasolineEngineBlockEntity.class
  );

  public static final EngineDefinition<PerformanceEngineBlockEntity> PERFORMANCE_ENGINE = new EngineDefinition<>(
      "performance_engine",
      256,
      1024,
      EngineCategory.PISTON,
      () -> RCUBlocks.PERFORMANCE_ENGINE,
      () -> RCUBlockEntities.PERFORMANCE_ENGINE_ENTITY.get(),
      PerformanceEngineBlockEntity.class
  );

  public static final EngineDefinition<HydrokineticEngineBlockEntity> HYDROKINETIC_ENGINE = new EngineDefinition<>(
      "hydrokinetic_engine",
      16384,
      32,
  EngineCategory.KINETIC,
      () -> RCUBlocks.HYDROKINETIC_ENGINE,
      () -> RCUBlockEntities.HYDROKINETIC_ENGINE_ENTITY.get(),
  HydrokineticEngineBlockEntity.class
    );

  public static final EngineDefinition<MicroturbineBlockEntity> MICROTURBINE = new EngineDefinition<>(
      "microturbine",
      16,
      131072,
      EngineCategory.TURBINE,
      () -> RCUBlocks.MICROTURBINE,
      () -> RCUBlockEntities.MICROTURBINE_ENTITY.get(),
      MicroturbineBlockEntity.class
  );

  public static final EngineDefinition<GasTurbineBlockEntity> GAS_TURBINE = new EngineDefinition<>(
      "gas_turbine",
      1024,
      65536,
      EngineCategory.TURBINE,
      () -> RCUBlocks.GAS_TURBINE,
      () -> RCUBlockEntities.GAS_TURBINE_ENTITY.get(),
      GasTurbineBlockEntity.class
  );

  public static void init() {
    add(DC_ENGINE);
    add(ACE_ENGINE);
    add(WIND_TURBINE);
    add(STEAM_ENGINE);
    add(GASOLINE_ENGINE);
    add(PERFORMANCE_ENGINE);
    add(HYDROKINETIC_ENGINE);
    add(MICROTURBINE);
    add(GAS_TURBINE);
  }

  public static void add(EngineDefinition<?> def) {
    if (ENGINES.containsKey(def.getId()))
      throw new IllegalStateException("Duplicate engine id: " + def.getId());
    ENGINES.put(def.getId(), def);
  }

  public static EngineDefinition<?> getById(String id) {
    return ENGINES.get(id);
  }

  public static Collection<EngineDefinition<?>> all() {
    return Collections.unmodifiableCollection(ENGINES.values());
  }

  public static Block getBlockById(String id) {
    EngineDefinition<?> def = ENGINES.get(id);
    if (def != null && def.getBlockSupplier() != null) {
      BlockEntry<?> entry = def.getBlockSupplier().get();
      if (entry != null)
        return entry.get();
    }
    return null;
  }

  /** Получает описание двигателя по Block */
  public static EngineDefinition<?> getByBlock(Block block) {
    for (EngineDefinition<?> def : ENGINES.values()) {
      BlockEntry<?> entry = def.getBlockSupplier().get();
      if (entry != null && entry.get() == block)
        return def;
    }
    return null;
  }

  /** Получает ID по Block */
  public static String getIdByBlock(Block block) {
    for (var entry : ENGINES.entrySet()) {
      EngineDefinition<?> def = entry.getValue();
      BlockEntry<?> blockEntry = def.getBlockSupplier().get();
      if (blockEntry != null && blockEntry.get() == block)
        return entry.getKey();
    }
    return null;
  }

  public static EngineDefinition<?> getByEntityType(BlockEntityType<?> type) {
    for (EngineDefinition<?> def : ENGINES.values()) {
      if (def.getBlockEntityType().get() == type)
        return def;
    }
    return null;
  }

  public static boolean exists(String id) {
    return ENGINES.containsKey(id);
  }
}
