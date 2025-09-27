package com.zircky.rotarycraft_unofficial.common.data;

import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.item.Item;

import static com.zircky.rotarycraft_unofficial.api.registry.RCURegistrates.REGISTRATE;

public class RCUItems {

  static {
    REGISTRATE.creativeModeTab(() -> RCUCreativeModeTabs.ITEMS);
  }

  public static ItemEntry<Item> IRON_CASING = REGISTRATE.item("iron_casing", Item::new)
      .lang("Iron Casing")
      .defaultModel()
      .register();

  public static void init() {}

}
