package com.zircky.rotarycraft_unofficial.common.data;

import com.tterrag.registrate.util.entry.ItemEntry;
import com.zircky.rotarycraft_unofficial.common.data.tools.RCUTools;
import com.zircky.rotarycraft_unofficial.common.item.CustemItem;

import static com.zircky.rotarycraft_unofficial.api.registry.RCURegistrates.REGISTRATE;

public class RCUItems {

  static {
    REGISTRATE.creativeModeTab(() -> RCUCreativeModeTabs.ITEMS);
  }

  public static ItemEntry<CustemItem> YEAST = regItem("yeast","Yeast");
  public static ItemEntry<CustemItem> EthanolCrystals = regItem("ethanol_crystals","Ethanol Crystals");
  public static ItemEntry<CustemItem> CanolaSeeds = regItem("canola_seeds","Canola Seeds");
  public static ItemEntry<CustemItem> BasePanel = regItem("base_panel", "Base Panel");
  public static ItemEntry<CustemItem> HSLASteelIngot = regItem("hsla_steel_ingot", "hsla", "HSLA Steel Ingot");
  public static ItemEntry<CustemItem> Mount = regItem("mount", "Mount");
  public static ItemEntry<CustemItem> HSLASteelScrap = regItem("hsla_steel_scrap", "hsla", "HSLA Steel Scrap");
  public static ItemEntry<CustemItem> IronScrap = regItem("item_scrap", "Iron Scrap");
  public static ItemEntry<CustemItem> WormGear = regItem("worm_gear", "Worm Gear");
  public static ItemEntry<CustemItem> HSLASteelShaftUnit = regItem("hsla_steel_shaft_unit", "hsla", "HSLA Steel Shaft Unit");
  public static ItemEntry<CustemItem> HSLASteelGeat = regItem("hsla_steel_gear", "hsla", "HSLA Steel Gear");
  public static ItemEntry<CustemItem> HSLASteel2xGeatUnit = regItem("hsla_steel_2x_gear_unit", "hsla", "HSLA Steel 2x Gear Unit");
  public static ItemEntry<CustemItem> HSLASteel4xGeatUnit = regItem("hsla_steel_4x_gear_unit", "hsla", "HSLA Steel 4x Gear Unit");
  public static ItemEntry<CustemItem> HSLASteel8xGeatUnit = regItem("hsla_steel_8x_gear_unit", "hsla", "HSLA Steel 8x Gear Unit");
  public static ItemEntry<CustemItem> HSLASteel16xGeatUnit = regItem("hsla_steel_16x_gear_unit", "hsla", "HSLA Steel 16x Gear Unit");
  public static ItemEntry<CustemItem> HSLASteelShaftBearing = regItem("hsla_steel_shaft_bearing", "hsla", "HSLA Steel Shaft Bearing");
  public static ItemEntry<CustemItem> HSLASteelShaftCore = regItem("hsla_steel_shaft_core", "hsla", "HSLA Steel Shaft Core");
  public static ItemEntry<CustemItem> WoodenGeat = regItem("wooden_gear", "wooden", "Wooden Gear");
  public static ItemEntry<CustemItem> Wooden2xGeatUnit = regItem("wooden_2x_gear_unit", "wooden", "Wooden 2x Gear Unit");
  public static ItemEntry<CustemItem> Wooden4xGeatUnit = regItem("wooden_4x_gear_unit", "wooden", "Wooden 4x Gear Unit");
  public static ItemEntry<CustemItem> Wooden8xGeatUnit = regItem("wooden_8x_gear_unit", "wooden", "Wooden 8x Gear Unit");
  public static ItemEntry<CustemItem> Wooden16xGeatUnit = regItem("wooden_16x_gear_unit", "wooden", "Wooden 16x Gear Unit");
  public static ItemEntry<CustemItem> WoodenShaftBearing = regItem("wooden_shaft_bearing", "wooden", "Wooden Shaft Bearing");
  public static ItemEntry<CustemItem> WoodenShaftCore = regItem("wooden_shaft_core", "wooden", "Wooden Shaft Core");
  public static ItemEntry<CustemItem> StoneShaftUnit = regItem("stone_shaft_unit", "stone", "Stone Shaft Unit");
  public static ItemEntry<CustemItem> StoneGeat = regItem("stone_gear", "stone", "Stone Gear");
  public static ItemEntry<CustemItem> Stone2xGeatUnit = regItem("stone_2x_gear_unit", "stone", "Stone 2x Gear Unit");
  public static ItemEntry<CustemItem> Stone4xGeatUnit = regItem("stone_4x_gear_unit", "stone", "Stone 4x Gear Unit");
  public static ItemEntry<CustemItem> Stone8xGeatUnit = regItem("stone_8x_gear_unit", "stone", "Stone 8x Gear Unit");
  public static ItemEntry<CustemItem> Stone16xGeatUnit = regItem("stone_16x_gear_unit", "stone", "Stone 16x Gear Unit");
  public static ItemEntry<CustemItem> StoneShaftBearing = regItem("stone_shaft_bearing", "stone", "Stone Shaft Bearing");
  public static ItemEntry<CustemItem> StoneShaftCore = regItem("stone_shaft_core", "stone", "Stone Shaft Core");
  public static ItemEntry<CustemItem> DiamondShaftUnit = regItem("diamond_shaft_unit", "diamond", "Diamond Shaft Unit");
  public static ItemEntry<CustemItem> DiamondGeat = regItem("diamond_gear", "diamond", "Diamond Gear");
  public static ItemEntry<CustemItem> Diamond2xGeatUnit = regItem("diamond_2x_gear_unit", "diamond", "Diamond 2x Gear Unit");
  public static ItemEntry<CustemItem> Diamond4xGeatUnit = regItem("diamond_4x_gear_unit", "diamond", "Diamond 4x Gear Unit");
  public static ItemEntry<CustemItem> Diamond8xGeatUnit = regItem("diamond_8x_gear_unit", "diamond", "Diamond 8x Gear Unit");
  public static ItemEntry<CustemItem> Diamond16xGeatUnit = regItem("diamond_16x_gear_unit",  "diamond", "Diamond 16x Gear Unit");
  public static ItemEntry<CustemItem> DiamondShaftBearing = regItem("diamond_shaft_bearing", "diamond", "Diamond Shaft Bearing");
  public static ItemEntry<CustemItem> DiamondShaftCore = regItem("diamond_shaft_core", "diamond", "Diamond Shaft Core");
  public static ItemEntry<CustemItem> BedrockShaftUnit = regItem("bedrock_shaft_unit", "bedrock", "Bedrock Shaft Unit");
  public static ItemEntry<CustemItem> BedrockGeat = regItem("bedrock_gear", "bedrock", "Bedrock Gear");
  public static ItemEntry<CustemItem> Bedrock2xGeatUnit = regItem("bedrock_2x_gear_unit", "bedrock", "Bedrock 2x Gear Unit");
  public static ItemEntry<CustemItem> Bedrock4xGeatUnit = regItem("bedrock_4x_gear_unit", "bedrock", "Bedrock 4x Gear Unit");
  public static ItemEntry<CustemItem> Bedrock8xGeatUnit = regItem("bedrock_8x_gear_unit", "bedrock", "Bedrock 8x Gear Unit");
  public static ItemEntry<CustemItem> Bedrock16xGeatUnit = regItem("bedrock_16x_gear_unit", "bedrock", "Bedrock 16x Gear Unit");
  public static ItemEntry<CustemItem> BedrockShaftBearing = regItem("bedrock_shaft_bearing", "bedrock", "Bedrock Shaft Bearing");
  public static ItemEntry<CustemItem> BedrockShaftCore = regItem("bedrock_shaft_core", "bedrock", "Bedrock Shaft Core");
  public static ItemEntry<CustemItem> TungstenAlloyShaftUnit = regItem("tungsten_alloy_shaft_unit", "tungsten_alloy", "Tungsten Alloy Shaft Unit");
  public static ItemEntry<CustemItem> TungstenAlloyGeat = regItem("tungsten_alloy_gear", "tungsten_alloy", "Tungsten Alloy Gear");
  public static ItemEntry<CustemItem> TungstenAlloy2xGeatUnit = regItem("tungsten_alloy_2x_gear_unit", "tungsten_alloy", "Tungsten Alloy 2x Gear Unit");
  public static ItemEntry<CustemItem> TungstenAlloy4xGeatUnit = regItem("tungsten_alloy_4x_gear_unit", "tungsten_alloy", "Tungsten Alloy 4x Gear Unit");
  public static ItemEntry<CustemItem> TungstenAlloy8xGeatUnit = regItem("tungsten_alloy_8x_gear_unit", "tungsten_alloy", "Tungsten Alloy 8x Gear Unit");
  public static ItemEntry<CustemItem> TungstenAlloy16xGeatUnit = regItem("tungsten_alloy_16x_gear_unit", "tungsten_alloy", "Tungsten Alloy 16x Gear Unit");
  public static ItemEntry<CustemItem> TungstenAlloyShaftBearing = regItem("tungsten_alloy_shaft_bearing", "tungsten_alloy", "Tungsten Alloy Shaft Bearing");
  public static ItemEntry<CustemItem> TungstenAlloyShaftCore = regItem("tungsten_alloy_shaft_core", "tungsten_alloy", "Tungsten Alloy Shaft Core");
  public static ItemEntry<CustemItem> WoodenFlywheelCore = regItem("wooden_flywheel_core", "wooden", "Wooden Flywheel Core");
  public static ItemEntry<CustemItem> StoneFlywheelCore = regItem("stone_flywheel_core", "stone", "Stone Flywheel Core");
  public static ItemEntry<CustemItem> IronFlywheelCore = regItem("iron_flywheel_core", "Iron Flywheel Core");
  public static ItemEntry<CustemItem> GoldFlywheelCore = regItem("gold_flywheel_core", "Gold Flywheel Core");
  public static ItemEntry<CustemItem> TungstenAlloyFlywheelCore = regItem("tungsten_alloy_flywheel_core", "tungsten_alloy", "Tungsten Alloy Flywheel Core");
  public static ItemEntry<CustemItem> DepletedUraniumFlywheelCore = regItem("depleted_uranium_flywheel_core", "Depleted Uranium Flywheel Core");
  public static ItemEntry<CustemItem> BedrockFlywheelCore = regItem("bedrock_flywheel_core", "bedrock", "Bedrock Flywheel Core");
  public static ItemEntry<CustemItem> Impeller = regItem("impeller", "Impeller");
  public static ItemEntry<CustemItem> Compressor = regItem("compressor", "Compressor");
  public static ItemEntry<CustemItem> Turbine = regItem("turbine", "Turbine");
  public static ItemEntry<CustemItem> Diffuser = regItem("diffuser", "Diffuser");
  public static ItemEntry<CustemItem> Combustor = regItem("combustor", "Combustor");
  public static ItemEntry<CustemItem> Cylinder = regItem("cylinder", "Cylinder");
  public static ItemEntry<CustemItem> Radiator = regItem("radiator", "Radiator");
  public static ItemEntry<CustemItem> Condenser = regItem("condenser", "Condenser");
  public static ItemEntry<CustemItem> GoldCoil = regItem("gold_coil", "Gold Coil");
  public static ItemEntry<CustemItem> PaddlePanel = regItem("paddle_panel", "Paddle Panel");
  public static ItemEntry<CustemItem> IgnitionUnit = regItem("ignition_unit", "Ignition Unit");
  public static ItemEntry<CustemItem> CompoundCompressor = regItem("compound_compressor", "Compound Compressor");
  public static ItemEntry<CustemItem> ALUMINUM_ALLOY_CYLINDER = regItem("aluminum_alloy_cylinder", "Aluminum Alloy Cylinder");
  public static ItemEntry<CustemItem> HIGH_TEMPERATURE_COMBUSTOR = regItem("high_temperature_combustor", "High-Temperature Combustor");
  public static ItemEntry<CustemItem> HEAT_RAY_BARREL = regItem("heat_ray_barrel", "Heat Ray Barrel");
  public static ItemEntry<CustemItem> LENS = regItem("lens", "Lens");
  public static ItemEntry<CustemItem> POWER_MODULE = regItem("power_module", "Power Module");
  public static ItemEntry<CustemItem> HEAT_RAY_CORE = regItem("heat_ray_core", "Heat Ray Core");
  public static ItemEntry<CustemItem> LINEAR_INDUCTION_MOTOR = regItem("linear_induction_motor", "Linear Induction Motor");
  public static ItemEntry<CustemItem> PROPELLER_BLADE = regItem("propeller_blade", "Propeller Blade");
  public static ItemEntry<CustemItem> HUB = regItem("hub", "Hub");
  public static ItemEntry<CustemItem> MIRROR = regItem("mirror", "Mirror");
  public static ItemEntry<CustemItem> GENERATOR = regItem("generator", "Generator");
  public static ItemEntry<CustemItem> RAILGUN_ACCELERATOR = regItem("railgun_accelerator", "Railgun Accelerator");
  public static ItemEntry<CustemItem> TURRET_BASE = regItem("turret_base", "Turret Base");
  public static ItemEntry<CustemItem> TURRET_AIMING_UNIT = regItem("turret_aiming_unit", "Turret Aiming Unit");
  public static ItemEntry<CustemItem> COMPOUND_TURBINE = regItem("compound_turbine", "Compound Turbine");
  public static ItemEntry<CustemItem> BEDROCK_TENSION_COIL = regItem("bedrock_tension_coil", "bedrock", "Bedrock Tension Coil");
  public static ItemEntry<CustemItem> CHAIN_LINK = regItem("chain_link", "Chain Link");
  public static ItemEntry<CustemItem> BEDROCK_DRILL = regItem("bedrock_drill", "bedrock", "Bedrock Drill");
  public static ItemEntry<CustemItem> DRILL = regItem("drill", "Drill");
  public static ItemEntry<CustemItem> PRESSURE_HEAD = regItem("pressure_head", "Pressure Head");
  public static ItemEntry<CustemItem> RADAR_UNIT = regItem("radar_unit", "Radar Unit");
  public static ItemEntry<CustemItem> SONAR_UNIT = regItem("sonar_unit", "Sonar Unit");
  public static ItemEntry<CustemItem> CIRCUIT_BOARD = regItem("circuit_board", "Circuit Board");
  public static ItemEntry<CustemItem> SCREEN = regItem("screen", "Screen");
  public static ItemEntry<CustemItem> MIXER = regItem("mixer", "Mixer");
  public static ItemEntry<CustemItem> SAW = regItem("saw", "Saw");
  public static ItemEntry<CustemItem> BELT = regItem("belt", "Belt");
  public static ItemEntry<CustemItem> BALL_BEARING = regItem("ball_bearing", "Ball Bearing");
  public static ItemEntry<CustemItem> BRAKE_DISC = regItem("brake_disc", "Brake Disc");
  public static ItemEntry<CustemItem> TENSION_COIL = regItem("tension_coil", "Tension Coil");
  public static ItemEntry<CustemItem> POWDERED_COAL_ORE = regItem("powdered_coal_ore", "Powdered Coal Ore");
  public static ItemEntry<CustemItem> POWDERED_IRON_ORE = regItem("powdered_iron_ore", "Powdered Iron Ore");
  public static ItemEntry<CustemItem> POWDERED_GOLD_ORE = regItem("powdered_gold_ore", "Powdered Gold Ore");
  public static ItemEntry<CustemItem> POWDERED_REDSTONE_ORE = regItem("powdered_redstone_ore", "Powdered Redstone Ore");
  public static ItemEntry<CustemItem> POWDERED_LAPIS_ORE = regItem("powdered_lapis_ore", "Powdered Lapis Ore");
  public static ItemEntry<CustemItem> POWDERED_DIAMOND_ORE = regItem("powdered_diamond_ore", "Powdered Diamond Ore");
  public static ItemEntry<CustemItem> POWDERED_EMERALD_ORE = regItem("powdered_emerald_ore", "Powdered Emerald Ore");
  public static ItemEntry<CustemItem> POWDERED_NETHER_QUARTZ = regItem("powdered_nether_quartz", "Powdered Nether Quartz");
  public static ItemEntry<CustemItem> COAL_ORE_SLURRY = regItem("coal_ore_slurry", "Coal Ore Slurry");
  public static ItemEntry<CustemItem> IRON_ORE_SLURRY = regItem("iron_ore_slurry", "Iron Ore Slurry");
  public static ItemEntry<CustemItem> GOLD_ORE_SLURRY = regItem("gold_ore_slurry", "Gold Ore Slurry");
  public static ItemEntry<CustemItem> REDSTONE_ORE_SLURRY = regItem("redstone_ore_slurry", "Redstone Ore Slurry");
  public static ItemEntry<CustemItem> LAPIS_ORE_SLURRY = regItem("lapis_ore_slurry", "Lapis Ore Slurry");
  public static ItemEntry<CustemItem> DIAMOND_ORE_SLURRY = regItem("diamond_ore_slurry", "Diamond Ore Slurry");
  public static ItemEntry<CustemItem> EMERALD_ORE_SLURRY = regItem("emerald_ore_slurry", "Emerald Ore Slurry");
  public static ItemEntry<CustemItem> NETHER_QUARTZ_SLURRY = regItem("nether_quartz_slurry", "Nether Quartz Slurry");
  public static ItemEntry<CustemItem> COAL_ORE_SOLUTION = regItem("coal_ore_solution", "Coal Ore Solution");
  public static ItemEntry<CustemItem> IRON_ORE_SOLUTION = regItem("iron_ore_solution", "Iron Ore Solution");
  public static ItemEntry<CustemItem> GOLD_ORE_SOLUTION = regItem("gold_ore_solution", "Gold Ore Solution");
  public static ItemEntry<CustemItem> REDSTONE_ORE_SOLUTION = regItem("redstone_ore_solution", "Redstone Ore Solution");
  public static ItemEntry<CustemItem> LAPIS_ORE_SOLUTION = regItem("lapis_ore_solution", "Lapis Ore Solution");
  public static ItemEntry<CustemItem> DIAMOND_ORE_SOLUTION = regItem("diamond_ore_solution", "Diamond Ore Solution");
  public static ItemEntry<CustemItem> EMERALD_ORE_SOLUTION = regItem("emerald_ore_solution", "Emerald Ore Solution");
  public static ItemEntry<CustemItem> NETHER_QUARTZ_SOLUTION = regItem("nether_quartz_solution", "Nether Quartz Solution");
  public static ItemEntry<CustemItem> COAL_ORE_FLAKES = regItem("coal_ore_flakes", "Coal Ore Flakes");
  public static ItemEntry<CustemItem> IRON_ORE_FLAKES = regItem("iron_ore_flakes", "Iron Ore Flakes");
  public static ItemEntry<CustemItem> GOLD_ORE_FLAKES = regItem("gold_ore_flakes", "Gold Ore Flakes");
  public static ItemEntry<CustemItem> REDSTONE_ORE_FLAKES = regItem("redstone_ore_flakes", "Redstone Ore Flakes");
  public static ItemEntry<CustemItem> LAPIS_ORE_FLAKES = regItem("lapis_ore_flakes", "Lapis Ore Flakes");
  public static ItemEntry<CustemItem> DIAMOND_ORE_FLAKES = regItem("diamond_ore_flakes", "Diamond Ore Flakes");
  public static ItemEntry<CustemItem> EMERALD_ORE_FLAKES = regItem("emerald_ore_flakes", "Emerald Ore Flakes");
  public static ItemEntry<CustemItem> NETHER_QUARTZ_FLAKES = regItem("nether_quartz_flakes", "Nether Quartz Flakes");
  public static ItemEntry<CustemItem> ANTHRACITE = regItem("anthracite", "Anthracite");
  public static ItemEntry<CustemItem> PRISMANE = regItem("prismane", "Prismane");
  public static ItemEntry<CustemItem> LONSDALEITE = regItem("lonsdaleite", "Lonsdaleite");
  public static ItemEntry<CustemItem> BADROCK_ALLOY_INGOT = regItem("badrock_alloy_ingot", "bedrock", "Badrock Alloy Ingot");
  public static ItemEntry<CustemItem> SINTERED_TUNGSTEN_INGOT = regItem("sintered_tungsten_ingot", "Sintered Tungsten Ingot");
  public static ItemEntry<CustemItem> INDUCTIVE_INGOT = regItem("inductive_ingot", "Inductive Ingot");
  public static ItemEntry<CustemItem> COAL_COKE = regItem("coal_coke", "Coal Coke");
  public static ItemEntry<CustemItem> SPRING_STEEL_INGOT = regItem("spring_steel_ingot", "Spring Steel Ingot");
  public static ItemEntry<CustemItem> ALUMINUM_ALLOY_INGOT = regItem("aluminum_alloy_ingot", "Aluminum Alloy Ingot");
  public static ItemEntry<CustemItem> TUNGSTEN_ALLOY_INGOT = regItem("tungsten_alloy_ingot", "tungsten_alloy","Tungsten Alloy Ingot");
  public static ItemEntry<CustemItem> NETHERRACK_DUST = regItem("netherrack_dust", "Netherrack Dust");
  public static ItemEntry<CustemItem> TAR_SAND = regItem("tar_sand", "Tar Sand");
  public static ItemEntry<CustemItem> SLUDGE = regItem("sludge", "Sludge");
  public static ItemEntry<CustemItem> SAWDUST = regItem("sawdust", "Sawdust");
  public static ItemEntry<CustemItem> BEDROCK_DUST = regItem("bedrock_dust", "bedrock", "Bedrock Dust");
  public static ItemEntry<CustemItem> SALT = regItem("salt", "Salt");
  public static ItemEntry<CustemItem> AMMONIUM_NITRATE = regItem("ammonium_nitrate", "Ammonium Nitrate");
  public static ItemEntry<CustemItem> SILVER_IODIDE = regItem("silver_iodide", "Silver Iodide");
  public static ItemEntry<CustemItem> ALUMINUM_POWDER = regItem("aluminum_powder", "Aluminum Powder");
  public static ItemEntry<CustemItem> FLOUR = regItem("flour", "Flour");
  public static ItemEntry<CustemItem> COAL_DUST = regItem("coal_dust", "Coal Dust");
  public static ItemEntry<CustemItem> DRY_ICE = regItem("dry_ice", "Dry Ice");
  public static ItemEntry<CustemItem> INDUCTIVE_METAL_BLEND = regItem("inductive_metal_blend", "Inductive Metal Blend");
  public static ItemEntry<CustemItem> COMPOST = regItem("compost", "Compost");
  public static ItemEntry<CustemItem> SILICON_POWDER = regItem("silicon_powder", "Silicon Powder");
  public static ItemEntry<CustemItem> MULCH = regItem("mulch", "Mulch");
  public static ItemEntry<CustemItem> ETHANOL_EXTRACT = regItem("ethanol_extract", "Ethanol Extract");
  public static ItemEntry<CustemItem> GEAR_CAST = regItem("gear_cast", "Gear Cast");
  public static ItemEntry<CustemItem> BASE_PANEL_CAST = regItem("base_panel_cast", "Base Panel Cast");
  public static ItemEntry<CustemItem> SHAFT_UNIT_CAST = regItem("shaft_unit_cast", "Shaft Unit Cast");
  public static ItemEntry<CustemItem> PROPELLER_BLADE_CAST = regItem("propeller_blade_cast", "Propeller Blade Cast");
  public static ItemEntry<CustemItem> DRILL_CAST = regItem("drill_cast", "Drill Cast");


  private static ItemEntry<CustemItem> regItem(String id, String langName) {
    return REGISTRATE.item(id, properties -> new CustemItem(langName, properties))
        .model((ctx, prov) -> prov.generated(ctx, prov.modLoc("item/" + id)))
        .register();
  }

  private static ItemEntry<CustemItem> regItem(String id, String model, String langName) {
    return REGISTRATE.item(id, properties -> new CustemItem(langName, properties))
        .model((ctx, prov) -> prov.generated(ctx, prov.modLoc("item/" + model + "/" + id)))
        .register();
  }

  public static void init() {
    RCUTools.init();
  }

}
