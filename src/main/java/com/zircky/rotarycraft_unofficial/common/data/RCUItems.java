package com.zircky.rotarycraft_unofficial.common.data;

import com.tterrag.registrate.util.entry.ItemEntry;
import com.zircky.rotarycraft_unofficial.common.data.tools.RCUTools;
import com.zircky.rotarycraft_unofficial.common.item.CustemItem;

import static com.zircky.rotarycraft_unofficial.api.registry.RCURegistrates.REGISTRATE;

public class RCUItems {

  static {
    REGISTRATE.creativeModeTab(() -> RCUCreativeModeTabs.ITEMS);
  }

  public static ItemEntry<CustemItem> YEAST = REGISTRATE.item("yeast", properties -> new CustemItem("Yeast", properties)).register();
  public static ItemEntry<CustemItem> EthanolCrystals = REGISTRATE.item("ethanol_crystals", properties -> new CustemItem("Ethanol Crystals", properties)).register();
  public static ItemEntry<CustemItem> CanolaSeeds = REGISTRATE.item("canola_seeds", properties -> new CustemItem("Canola Seeds", properties)).register();
  public static ItemEntry<CustemItem> BasePanel = REGISTRATE.item("base_panel", properties -> new CustemItem("Base Panel", properties)).register();
  public static ItemEntry<CustemItem> HSLASteelIngot = REGISTRATE.item("hsla_steel_ingot", properties -> new CustemItem("HSLA Steel Ingot", properties)).register();
  public static ItemEntry<CustemItem> Mount = REGISTRATE.item("mount", properties -> new CustemItem("Mount", properties)).register();
  public static ItemEntry<CustemItem> HSLASteelScrap = REGISTRATE.item("hsla_steel_scrap", properties -> new CustemItem("HSLA Steel Scrap", properties)).register();
  public static ItemEntry<CustemItem> IronScrap = REGISTRATE.item("item_scrap", properties -> new CustemItem("Iron Scrap", properties)).register();
  public static ItemEntry<CustemItem> WormGear = REGISTRATE.item("worm_gear", properties -> new CustemItem("Worm Gear", properties)).register();
  public static ItemEntry<CustemItem> HSLASteelShaftUnit = REGISTRATE.item("hsla_steel_shaft_unit", properties -> new CustemItem("HSLA Steel Shaft Unit", properties)).register();
  public static ItemEntry<CustemItem> HSLASteelGeat = REGISTRATE.item("hsla_steel_gear", properties -> new CustemItem("HSLA Steel Gear", properties)).register();
  public static ItemEntry<CustemItem> HSLASteel2xGeatUnit = REGISTRATE.item("hsla_steel_2x_gear_unit", properties -> new CustemItem("HSLA Steel 2x Gear Unit", properties)).register();
  public static ItemEntry<CustemItem> HSLASteel4xGeatUnit = REGISTRATE.item("hsla_steel_4x_gear_unit", properties -> new CustemItem("HSLA Steel 4x Gear Unit", properties)).register();
  public static ItemEntry<CustemItem> HSLASteel8xGeatUnit = REGISTRATE.item("hsla_steel_8x_gear_unit", properties -> new CustemItem("HSLA Steel 8x Gear Unit", properties)).register();
  public static ItemEntry<CustemItem> HSLASteel16xGeatUnit = REGISTRATE.item("hsla_steel_16x_gear_unit", properties -> new CustemItem("HSLA Steel 16x Gear Unit", properties)).register();
  public static ItemEntry<CustemItem> HSLASteelShaftBearing = REGISTRATE.item("hsla_steel_shaft_bearing", properties -> new CustemItem("HSLA Steel Shaft Bearing", properties)).register();
  public static ItemEntry<CustemItem> HSLASteelShaftCore = REGISTRATE.item("hsla_steel_shaft_core", properties -> new CustemItem("HSLA Steel Shaft Core", properties)).register();
  public static ItemEntry<CustemItem> WoodenGeat = REGISTRATE.item("wooden_gear", properties -> new CustemItem("Wooden Gear", properties)).register();
  public static ItemEntry<CustemItem> Wooden2xGeatUnit = REGISTRATE.item("wooden_2x_gear_unit", properties -> new CustemItem("Wooden 2x Gear Unit", properties)).register();
  public static ItemEntry<CustemItem> Wooden4xGeatUnit = REGISTRATE.item("wooden_4x_gear_unit", properties -> new CustemItem("Wooden 4x Gear Unit", properties)).register();
  public static ItemEntry<CustemItem> Wooden8xGeatUnit = REGISTRATE.item("wooden_8x_gear_unit", properties -> new CustemItem("Wooden 8x Gear Unit", properties)).register();
  public static ItemEntry<CustemItem> Wooden16xGeatUnit = REGISTRATE.item("wooden_16x_gear_unit", properties -> new CustemItem("Wooden 16x Gear Unit", properties)).register();
  public static ItemEntry<CustemItem> WoodenShaftBearing = REGISTRATE.item("wooden_shaft_bearing", properties -> new CustemItem("Wooden Shaft Bearing", properties)).register();
  public static ItemEntry<CustemItem> WoodenShaftCore = REGISTRATE.item("wooden_shaft_core", properties -> new CustemItem("Wooden Shaft Core", properties)).register();
  public static ItemEntry<CustemItem> StoneShaftUnit = REGISTRATE.item("stone_shaft_unit", properties -> new CustemItem("Stone Shaft Unit", properties)).register();
  public static ItemEntry<CustemItem> StoneGeat = REGISTRATE.item("stone_gear", properties -> new CustemItem("Stone Gear", properties)).register();
  public static ItemEntry<CustemItem> Stone2xGeatUnit = REGISTRATE.item("stone_2x_gear_unit", properties -> new CustemItem("Stone 2x Gear Unit", properties)).register();
  public static ItemEntry<CustemItem> Stone4xGeatUnit = REGISTRATE.item("stone_4x_gear_unit", properties -> new CustemItem("Stone 4x Gear Unit", properties)).register();
  public static ItemEntry<CustemItem> Stone8xGeatUnit = REGISTRATE.item("stone_8x_gear_unit", properties -> new CustemItem("Stone 8x Gear Unit", properties)).register();
  public static ItemEntry<CustemItem> Stone16xGeatUnit = REGISTRATE.item("stone_16x_gear_unit", properties -> new CustemItem("Stone 16x Gear Unit", properties)).register();
  public static ItemEntry<CustemItem> StoneShaftBearing = REGISTRATE.item("stone_shaft_bearing", properties -> new CustemItem("Stone Shaft Bearing", properties)).register();
  public static ItemEntry<CustemItem> StoneShaftCore = REGISTRATE.item("stone_shaft_core", properties -> new CustemItem("Stone Shaft Core", properties)).register();
  public static ItemEntry<CustemItem> DiamondShaftUnit = REGISTRATE.item("diamond_shaft_unit", properties -> new CustemItem("Diamond Shaft Unit", properties)).register();
  public static ItemEntry<CustemItem> DiamondGeat = REGISTRATE.item("diamond_gear", properties -> new CustemItem("Diamond Gear", properties)).register();
  public static ItemEntry<CustemItem> Diamond2xGeatUnit = REGISTRATE.item("diamond_2x_gear_unit", properties -> new CustemItem("Diamond 2x Gear Unit", properties)).register();
  public static ItemEntry<CustemItem> Diamond4xGeatUnit = REGISTRATE.item("diamond_4x_gear_unit", properties -> new CustemItem("Diamond 4x Gear Unit", properties)).register();
  public static ItemEntry<CustemItem> Diamond8xGeatUnit = REGISTRATE.item("diamond_8x_gear_unit", properties -> new CustemItem("Diamond 8x Gear Unit", properties)).register();
  public static ItemEntry<CustemItem> Diamond16xGeatUnit = REGISTRATE.item("diamond_16x_gear_unit", properties -> new CustemItem("Diamond 16x Gear Unit", properties)).register();
  public static ItemEntry<CustemItem> DiamondShaftBearing = REGISTRATE.item("diamond_shaft_bearing", properties -> new CustemItem("Diamond Shaft Bearing", properties)).register();
  public static ItemEntry<CustemItem> DiamondShaftCore = REGISTRATE.item("diamond_shaft_core", properties -> new CustemItem("Diamond Shaft Core", properties)).register();
  public static ItemEntry<CustemItem> BedrockShaftUnit = REGISTRATE.item("bedrock_shaft_unit", properties -> new CustemItem("Bedrock Shaft Unit", properties)).register();
  public static ItemEntry<CustemItem> BedrockGeat = REGISTRATE.item("bedrock_gear", properties -> new CustemItem("Bedrock Gear", properties)).register();
  public static ItemEntry<CustemItem> Bedrock2xGeatUnit = REGISTRATE.item("bedrock_2x_gear_unit", properties -> new CustemItem("Bedrock 2x Gear Unit", properties)).register();
  public static ItemEntry<CustemItem> Bedrock4xGeatUnit = REGISTRATE.item("bedrock_4x_gear_unit", properties -> new CustemItem("Bedrock 4x Gear Unit", properties)).register();
  public static ItemEntry<CustemItem> Bedrock8xGeatUnit = REGISTRATE.item("bedrock_8x_gear_unit", properties -> new CustemItem("Bedrock 8x Gear Unit", properties)).register();
  public static ItemEntry<CustemItem> Bedrock16xGeatUnit = REGISTRATE.item("bedrock_16x_gear_unit", properties -> new CustemItem("Bedrock 16x Gear Unit", properties)).register();
  public static ItemEntry<CustemItem> BedrockShaftBearing = REGISTRATE.item("bedrock_shaft_bearing", properties -> new CustemItem("Bedrock Shaft Bearing", properties)).register();
  public static ItemEntry<CustemItem> BedrockShaftCore = REGISTRATE.item("bedrock_shaft_core", properties -> new CustemItem("Bedrock Shaft Core", properties)).register();
  public static ItemEntry<CustemItem> TungstenAlloyShaftUnit = REGISTRATE.item("tungsten_alloy_shaft_unit", properties -> new CustemItem("Tungsten Alloy Shaft Unit", properties)).register();
  public static ItemEntry<CustemItem> TungstenAlloyGeat = REGISTRATE.item("tungsten_alloy_gear", properties -> new CustemItem("Tungsten Alloy Gear", properties)).register();
  public static ItemEntry<CustemItem> TungstenAlloy2xGeatUnit = REGISTRATE.item("tungsten_alloy_2x_gear_unit", properties -> new CustemItem("Tungsten Alloy 2x Gear Unit", properties)).register();
  public static ItemEntry<CustemItem> TungstenAlloy4xGeatUnit = REGISTRATE.item("tungsten_alloy_4x_gear_unit", properties -> new CustemItem("Tungsten Alloy 4x Gear Unit", properties)).register();
  public static ItemEntry<CustemItem> TungstenAlloy8xGeatUnit = REGISTRATE.item("tungsten_alloy_8x_gear_unit", properties -> new CustemItem("Tungsten Alloy 8x Gear Unit", properties)).register();
  public static ItemEntry<CustemItem> TungstenAlloy16xGeatUnit = REGISTRATE.item("tungsten_alloy_16x_gear_unit", properties -> new CustemItem("Tungsten Alloy 16x Gear Unit", properties)).register();
  public static ItemEntry<CustemItem> TungstenAlloyShaftBearing = REGISTRATE.item("tungsten_alloy_shaft_bearing", properties -> new CustemItem("Tungsten Alloy Shaft Bearing", properties)).register();
  public static ItemEntry<CustemItem> TungstenAlloyShaftCore = REGISTRATE.item("tungsten_alloy_shaft_core", properties -> new CustemItem("Tungsten Alloy Shaft Core", properties)).register();


  public static void init() {
    RCUTools.init();
  }

}
