package com.zircky.rotarycraft_unofficial.common.data;

import com.tterrag.registrate.util.entry.BlockEntry;
import com.zircky.rotarycraft_unofficial.RotaryCraftUnofficial;
import com.zircky.rotarycraft_unofficial.api.registry.RCURegistrates;
import com.zircky.rotarycraft_unofficial.api.registry.registry.generator.RCUBlockstateGenerator;
import com.zircky.rotarycraft_unofficial.common.data.material.ShaftMaterials;
import com.zircky.rotarycraft_unofficial.common.data.ores.RCUBlockOres;
import com.zircky.rotarycraft_unofficial.common.data.register.RCUShaftRegister;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;

public class RCUBlocks {
  static {
    RCURegistrates.REGISTRATE.creativeModeTab(() -> RCUCreativeModeTabs.POWER);
  }

  public static BlockEntry<Block> DC_ELECTRIC_ENGINE = RCURegistrates.REGISTRATE.block("dc_electric_engine", Block::new).lang("DC Electric Engine")
      .blockstate((ctx, prov) -> RCUBlockstateGenerator.generateSimpleBlock(prov, ctx.getEntry(), "engine/dc_electric_engine"))
      .item(BlockItem::new)
      .model((ctx, prov) -> prov.withExistingParent(ctx.getName(), prov.modLoc("block/engine/dc_electric_engine")))
      .build()
      .register();

  public static BlockEntry<Block> AC_ELECTRIC_ENGINE = RCURegistrates.REGISTRATE.block("ac_electric_engine", Block::new).lang("AC Electric Engine")
      .blockstate((ctx, prov) -> RCUBlockstateGenerator.generateSimpleBlock(prov, ctx.getEntry(), "engine/ac_electric_engine"))
      .item(BlockItem::new)
      .model((ctx, prov) -> prov.withExistingParent(ctx.getName(), prov.modLoc("block/engine/ac_electric_engine")))
      .build()
      .register();

  public static BlockEntry<Block> WIND_TURBINE = RCURegistrates.REGISTRATE.block("wind_turbine", Block::new).lang("Wind Turbine")
      .blockstate((ctx, prov) -> RCUBlockstateGenerator.generateSimpleBlock(prov, ctx.getEntry(), "engine/wind_turbine"))
      .item(BlockItem::new)
      .model((ctx, prov) -> prov.withExistingParent(ctx.getName(), prov.modLoc("block/engine/wind_turbine")))
      .build()
      .register();

  public static BlockEntry<Block> STEAM_ENGINE = RCURegistrates.REGISTRATE.block("steam_engine", Block::new).lang("Steam Engine")
      .blockstate((ctx, prov) -> RCUBlockstateGenerator.generateSimpleBlock(prov, ctx.getEntry(), "engine/steam_engine"))
      .item(BlockItem::new)
      .model((ctx, prov) -> prov.withExistingParent(ctx.getName(), prov.modLoc("block/engine/steam_engine")))
      .build()
      .register();

  public static BlockEntry<Block> GASOLINE_ENGINE = RCURegistrates.REGISTRATE.block("gasoline_engine", Block::new).lang("Gasoline Engine")
      .blockstate((ctx, prov) -> RCUBlockstateGenerator.generateSimpleBlock(prov, ctx.getEntry(), "engine/gasoline_engine"))
      .item(BlockItem::new)
      .model((ctx, prov) -> prov.withExistingParent(ctx.getName(), prov.modLoc("block/engine/gasoline_engine")))
      .build()
      .register();

  public static BlockEntry<Block> PERFORMANCE_ENGINE = RCURegistrates.REGISTRATE.block("performance_engine", Block::new).lang("Performance Engine")
      .blockstate((ctx, prov) -> RCUBlockstateGenerator.generateSimpleBlock(prov, ctx.getEntry(), "engine/performance_engine"))
      .item(BlockItem::new)
      .model((ctx, prov) -> prov.withExistingParent(ctx.getName(), prov.modLoc("block/engine/performance_engine")))
      .build()
      .register();



  public static void init() {
    ShaftMaterials.register();
    RCUBlockOres.init();
    RCUShaftRegister.init();
  }
}

