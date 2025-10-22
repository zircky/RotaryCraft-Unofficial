package com.zircky.rotarycraft_unofficial.common.data.material.engine;

import com.zircky.rotarycraft_unofficial.common.blockentity.engine.*;
import com.zircky.rotarycraft_unofficial.common.data.RCUBlockEntities;
import com.zircky.rotarycraft_unofficial.common.data.RCUBlocks;
import net.minecraft.world.level.block.Block;

import java.util.ArrayList;
import java.util.List;

public class EngineDefinitions {
  public static final List<EngineDefinition<?>> ENGINES = new ArrayList<>();

  static {
    ENGINES.add(new EngineDefinition<>(
        "dc_electric_engine",
        4,
        256,
        EngineCategory.ELECTRIC,
        RCUBlocks.DC_ELECTRIC_ENGINE,
        RCUBlockEntities.DC_ELECTRIC_ENGINE_ENTITY,
        DCElectricEngineBlockEntity.class
    ));

    ENGINES.add(new EngineDefinition<>(
        "ac_electric_engine",
        512,
        256,
        EngineCategory.ELECTRIC,
        RCUBlocks.AC_ELECTRIC_ENGINE,
        RCUBlockEntities.AC_ELECTRIC_ENGINE_ENTITY,
        ACElectricEngineBlockEntity.class
    ));

    ENGINES.add(new EngineDefinition<>(
        "wind_turbine",
        8,
        1024,
        EngineCategory.KINETIC,
        RCUBlocks.WIND_TURBINE,
        RCUBlockEntities.WIND_TURBINE_ENTITY,
        WindTurbineBlockEntity.class
    ));

    ENGINES.add(new EngineDefinition<>(
        "steam_engine",
        32,
        512,
        EngineCategory.THERMAL,
        RCUBlocks.STEAM_ENGINE,
        RCUBlockEntities.STEAM_ENGINE_ENTITY,
        SteamEngineBlockEntity.class
    ));

    ENGINES.add(new EngineDefinition<>(
        "gasoline_engine",
        128,
        512,
        EngineCategory.PISTON,
        RCUBlocks.GASOLINE_ENGINE,
        RCUBlockEntities.GASOLINE_ENGINE_ENTITY,
        GasolineEngineBlockEntity.class
    ));

    ENGINES.add(new EngineDefinition<>(
        "performance_engine",
        256,
        1024,
        EngineCategory.PISTON,
        RCUBlocks.PERFORMANCE_ENGINE,
        RCUBlockEntities.PERFORMANCE_ENGINE_ENTITY,
        PerformanceEngineBlockEntity.class
    ));

    ENGINES.add(new EngineDefinition<>(
        "hydrokinetic_engine",
        16384,
        32,
        EngineCategory.KINETIC,
        RCUBlocks.HYDROKINETIC_ENGINE,
        RCUBlockEntities.HYDROKINETIC_ENGINE_ENTITY,
        HydrokineticEngineBlockEntity.class
    ));

    ENGINES.add(new EngineDefinition<>(
        "microturbine",
        16,
        131072,
        EngineCategory.TURBINE,
        RCUBlocks.MICROTURBINE,
        RCUBlockEntities.MICROTURBINE_ENTITY,
        MicroturbineBlockEntity.class
    ));

    ENGINES.add(new EngineDefinition<>(
        "gas_turbine",
        1024,
        65536,
        EngineCategory.TURBINE,
        RCUBlocks.GAS_TURBINE,
        RCUBlockEntities.GAS_TURBINE_ENTITY,
        GasTurbineBlockEntity.class
    ));
  }


  public static EngineDefinition<?> getByName(String name) {
    return ENGINES.stream()
        .filter(e -> e.getId().equals(name))
        .findFirst()
        .orElse(null);
  }

  public static EngineDefinition<?> getByBlock(Block block) {
    return ENGINES.stream()
        .filter(e -> e.getBlockEntry().get() == block)
        .findFirst()
        .orElse(null);
  }
}
