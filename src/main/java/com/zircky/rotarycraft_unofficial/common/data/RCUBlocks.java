package com.zircky.rotarycraft_unofficial.common.data;

import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.nullness.NonNullBiConsumer;
import com.zircky.rotarycraft_unofficial.api.registry.RCURegistrates;
import com.zircky.rotarycraft_unofficial.common.data.block.ShaftBlock;
import com.zircky.rotarycraft_unofficial.common.data.ores.RCUBlockOres;
import com.zircky.rotarycraft_unofficial.common.registry.MaterialRegistry;
import net.minecraft.world.item.BlockItem;


public class RCUBlocks {
  static {
    RCURegistrates.REGISTRATE.creativeModeTab(() -> RCUCreativeModeTabs.POWER);
  }

  public static final BlockEntry<ShaftBlock> WOOODEN_SHAFT = RCURegistrates.REGISTRATE
      .block("wooden_shaft", props -> new ShaftBlock(MaterialRegistry.WOOD, props))
      .properties(p -> p.isValidSpawn((state, level, pos, ent) -> false))

      .item(BlockItem::new)
      .model(NonNullBiConsumer.noop())
      .build()
      .register();

  public static void init() {
    RCUBlockOres.init();
    RCUBlockEntities.init();
  }
}

