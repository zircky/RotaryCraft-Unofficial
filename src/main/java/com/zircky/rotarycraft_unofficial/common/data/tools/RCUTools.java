package com.zircky.rotarycraft_unofficial.common.data.tools;

import com.tterrag.registrate.util.entry.ItemEntry;
import com.zircky.rotarycraft_unofficial.api.registry.RCURegistrates;
import com.zircky.rotarycraft_unofficial.common.data.RCUCreativeModeTabs;
import com.zircky.rotarycraft_unofficial.common.item.EnergyItem;
import com.zircky.rotarycraft_unofficial.common.item.SpringItem;
import net.minecraft.world.item.Item;

public class RCUTools {
  static {
    RCURegistrates.REGISTRATE.creativeModeTab(() -> RCUCreativeModeTabs.TOOLS);
  }

  public static ItemEntry<Item> Screwdriver = RCURegistrates.REGISTRATE.item("screwdriver", Item::new).lang("Screwdriver").defaultModel().register();
  public static ItemEntry<Item> AngularTransducer = RCURegistrates.REGISTRATE.item("angular_transducer", Item::new).lang("Angular Transducer").defaultModel().register();
  public static final ItemEntry<SpringItem> WIND_SPRING = RCURegistrates.REGISTRATE.item("wind_spring", props -> new SpringItem("Wind Spring", props.stacksTo(1))).register();

  public static final ItemEntry<SpringItem> HIGH_STRENGTH_SPRING = RCURegistrates.REGISTRATE.item("high_strength_spring", props -> new SpringItem("High-Strength Spring", props.stacksTo(1))).register();

  public static final ItemEntry<EnergyItem> Ultrasound = RCURegistrates.REGISTRATE.item("ultrasound", props -> new EnergyItem("Ultrasound", props.stacksTo(1), 320000)).register();
  public static final ItemEntry<EnergyItem> MotionTracker = RCURegistrates.REGISTRATE.item("motion_tracker", props -> new EnergyItem("Motion Tracker", props.stacksTo(1), 320000)).register();
  public static final ItemEntry<EnergyItem> Vacuum = RCURegistrates.REGISTRATE.item("vacuum", props -> new EnergyItem("Vacuum", props.stacksTo(1), 320000)).register();
  public static final ItemEntry<EnergyItem> KnockbackGun = RCURegistrates.REGISTRATE.item("knockback_gun", props -> new EnergyItem("Knockback Gun", props.stacksTo(1), 320000)).register();
  public static final ItemEntry<EnergyItem> GravelGun = RCURegistrates.REGISTRATE.item("gravel_gun", props -> new EnergyItem("Gravel Gun", props.stacksTo(1), 320000, "Dealing 1142.6 hearts of damage per shot")).register();

  public static void init() {}
}
