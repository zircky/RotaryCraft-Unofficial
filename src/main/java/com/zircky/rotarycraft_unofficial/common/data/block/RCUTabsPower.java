package com.zircky.rotarycraft_unofficial.common.data.block;

import com.zircky.rotarycraft_unofficial.api.registry.RCURegistrates;
import com.zircky.rotarycraft_unofficial.api.registry.registry.generator.RCUBlockstateGenerator;
import com.zircky.rotarycraft_unofficial.common.data.RCUCreativeModeTabs;
import com.zircky.rotarycraft_unofficial.common.data.block.engine.DCElectricEngineBlock;
import com.zircky.rotarycraft_unofficial.common.data.block.engine.ACElectricEngineBlock;
import com.zircky.rotarycraft_unofficial.common.data.block.engine.WindTurbineBlock;
import com.zircky.rotarycraft_unofficial.common.data.block.engine.SteamEngineBlock;
import com.zircky.rotarycraft_unofficial.common.data.block.engine.GasolineEngineBlock;
import com.zircky.rotarycraft_unofficial.common.data.block.engine.PerformanceEngineBlock;
import com.zircky.rotarycraft_unofficial.common.data.block.engine.HydrokineticEngineBlock;
import com.zircky.rotarycraft_unofficial.common.data.block.engine.MicroturbineBlock;
import com.zircky.rotarycraft_unofficial.common.data.block.engine.GasTurbineBlock;
import com.zircky.rotarycraft_unofficial.common.data.material.engine.EngineDefinition;
import net.minecraft.world.item.BlockItem;

import java.util.ArrayList;
import java.util.List;

import static com.zircky.rotarycraft_unofficial.common.data.RCUBlocks.*;

public class RCUTabsPower {
  public static final List<EngineDefinition<?>> ENGINE = new ArrayList<>();
  static {
    RCURegistrates.REGISTRATE.creativeModeTab(() -> RCUCreativeModeTabs.POWER);
  }

  private static void register() {

    DC_ELECTRIC_ENGINE = RCURegistrates.REGISTRATE.block("dc_electric_engine", DCElectricEngineBlock::new).lang("DC Electric Engine")
        .properties(p -> p.noOcclusion())
        .blockstate((ctx, prov) -> {})
        .item(BlockItem::new)
        .model((ctx, prov) -> prov.withExistingParent(ctx.getName(), prov.modLoc("block/engine/dc_electric_engine")))
        .build()
        .register();

    AC_ELECTRIC_ENGINE = RCURegistrates.REGISTRATE.block("ac_electric_engine", ACElectricEngineBlock::new).lang("AC Electric Engine")
        .blockstate((ctx, prov) -> RCUBlockstateGenerator.generateSimpleBlockModel(prov, ctx.getEntry(), "engine/ac_electric_engine"))
        .item(BlockItem::new)
        .model((ctx, prov) -> prov.withExistingParent(ctx.getName(), prov.modLoc("block/engine/ac_electric_engine")))
        .build()
        .register();

    WIND_TURBINE = RCURegistrates.REGISTRATE.block("wind_turbine", WindTurbineBlock::new).lang("Wind Turbine")
        .blockstate((ctx, prov) -> RCUBlockstateGenerator.generateSimpleBlockModel(prov, ctx.getEntry(), "engine/wind_turbine"))
        .item(BlockItem::new)
        .model((ctx, prov) -> prov.withExistingParent(ctx.getName(), prov.modLoc("block/engine/wind_turbine")))
        .build()
        .register();

    STEAM_ENGINE = RCURegistrates.REGISTRATE.block("steam_engine", SteamEngineBlock::new).lang("Steam Engine")
        .blockstate((ctx, prov) -> RCUBlockstateGenerator.generateSimpleBlockModel(prov, ctx.getEntry(), "engine/steam_engine"))
        .item(BlockItem::new)
        .model((ctx, prov) -> prov.withExistingParent(ctx.getName(), prov.modLoc("block/engine/steam_engine")))
        .build()
        .register();

    GASOLINE_ENGINE = RCURegistrates.REGISTRATE.block("gasoline_engine", GasolineEngineBlock::new).lang("Gasoline Engine")
        .blockstate((ctx, prov) -> RCUBlockstateGenerator.generateSimpleBlockModel(prov, ctx.getEntry(), "engine/gasoline_engine"))
        .item(BlockItem::new)
        .model((ctx, prov) -> prov.withExistingParent(ctx.getName(), prov.modLoc("block/engine/gasoline_engine")))
        .build()
        .register();

    PERFORMANCE_ENGINE = RCURegistrates.REGISTRATE.block("performance_engine", PerformanceEngineBlock::new).lang("Performance Engine")
        .blockstate((ctx, prov) -> RCUBlockstateGenerator.generateSimpleBlockModel(prov, ctx.getEntry(), "engine/performance_engine"))
        .item(BlockItem::new)
        .model((ctx, prov) -> prov.withExistingParent(ctx.getName(), prov.modLoc("block/engine/performance_engine")))
        .build()
        .register();

    HYDROKINETIC_ENGINE = RCURegistrates.REGISTRATE.block("hydrokinetic_engine", HydrokineticEngineBlock::new).lang("Hydrokinetic Engine")
        .blockstate((ctx, prov) -> RCUBlockstateGenerator.generateSimpleBlockModel(prov, ctx.getEntry(), "engine/hydrokinetic_engine"))
        .item(BlockItem::new)
        .model((ctx, prov) -> prov.withExistingParent(ctx.getName(), prov.modLoc("block/engine/hydrokinetic_engine")))
        .build()
        .register();

    MICROTURBINE = RCURegistrates.REGISTRATE.block("microturbine", MicroturbineBlock::new).lang("Microturbine")
        .blockstate((ctx, prov) -> RCUBlockstateGenerator.generateSimpleBlockModel(prov, ctx.getEntry(), "engine/microturbine"))
        .item(BlockItem::new)
        .model((ctx, prov) -> prov.withExistingParent(ctx.getName(), prov.modLoc("block/engine/microturbine")))
        .build()
        .register();

    GAS_TURBINE = RCURegistrates.REGISTRATE.block("gas_turbine", GasTurbineBlock::new).lang("Gas Turbine")
        .blockstate((ctx, prov) -> RCUBlockstateGenerator.generateSimpleBlockModel(prov, ctx.getEntry(), "engine/gas_turbine"))
        .item(BlockItem::new)
        .model((ctx, prov) -> prov.withExistingParent(ctx.getName(), prov.modLoc("block/engine/gas_turbine")))
        .build()
        .register();
  }

  public static void init() {
    register();
  }
}
