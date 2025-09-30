package com.zircky.rotarycraft_unofficial.common.data.tools;

import com.tterrag.registrate.util.entry.ItemEntry;
import com.zircky.rotarycraft_unofficial.api.item.tools.RCUArmorMaterials;
import com.zircky.rotarycraft_unofficial.api.registry.RCURegistrates;
import com.zircky.rotarycraft_unofficial.common.data.RCUCreativeModeTabs;
import com.zircky.rotarycraft_unofficial.common.item.CustemItem;
import com.zircky.rotarycraft_unofficial.common.item.EnergyItem;
import com.zircky.rotarycraft_unofficial.common.item.SpringItem;
import com.zircky.rotarycraft_unofficial.common.item.rail_gun.ItemRailGunAmmo;
import com.zircky.rotarycraft_unofficial.common.item.tools.bedrock.*;
import com.zircky.rotarycraft_unofficial.common.item.tools.hsla_steel.HSLASteelArmor;
import com.zircky.rotarycraft_unofficial.common.item.tools.hsla_steel.HSLASteelAxeItem;
import net.minecraft.world.item.ArmorItem;
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

  public static final ItemEntry<BedrockPickaxeItem> BedrockPickaxe = RCURegistrates.REGISTRATE.item("bedrock_pickaxe", props -> new BedrockPickaxeItem()).register();
  public static final ItemEntry<BedrockAxeItem> BedrockAxe = RCURegistrates.REGISTRATE.item("bedrock_axe", props -> new BedrockAxeItem()).register();
  public static final ItemEntry<BedrockShovelItem> BedrockShovel = RCURegistrates.REGISTRATE.item("bedrock_shovel", props -> new BedrockShovelItem()).register();
  public static final ItemEntry<BedrockHoeItem> BedrockHoe = RCURegistrates.REGISTRATE.item("bedrock_hoe", props -> new BedrockHoeItem()).register();
  public static final ItemEntry<BedrockSwordItem> BedrockSword = RCURegistrates.REGISTRATE.item("bedrock_sword", props -> new BedrockSwordItem()).register();
  public static final ItemEntry<ItemRailGunAmmo> RailGunAmmo = RCURegistrates.REGISTRATE.item("rail_gun_ammo", ItemRailGunAmmo::new).register();
  public static final ItemEntry<BedrockArmor> BedrockHelmet = RCURegistrates.REGISTRATE.item("bedrock_helmet", props -> new BedrockArmor("Bedrock Helmet", RCUArmorMaterials.BEDROCK, ArmorItem.Type.HELMET, props)).register();
  public static final ItemEntry<BedrockArmor> BedrockChestplate = RCURegistrates.REGISTRATE.item("bedrock_chestplate", props -> new BedrockArmor("Bedrock Chestplate", RCUArmorMaterials.BEDROCK, ArmorItem.Type.CHESTPLATE, props)).register();
  public static final ItemEntry<BedrockArmor> BedrockLeggings = RCURegistrates.REGISTRATE.item("bedrock_leggings", props -> new BedrockArmor("Bedrock Leggings", RCUArmorMaterials.BEDROCK, ArmorItem.Type.LEGGINGS, props)).register();
  public static final ItemEntry<BedrockArmor> BedrockBoots = RCURegistrates.REGISTRATE.item("bedrock_boots", props -> new BedrockArmor("Bedrock Boots", RCUArmorMaterials.BEDROCK, ArmorItem.Type.BOOTS, props)).register();
  public static final ItemEntry<BedrockArmor> NVGoggles = RCURegistrates.REGISTRATE.item("nv_goggles", props -> new BedrockArmor("Night Vision Goggles", RCUArmorMaterials.NVGM, ArmorItem.Type.HELMET, props)).register();
  public static final ItemEntry<BedrockArmor> IOGoggles = RCURegistrates.REGISTRATE.item("io_goggles", props -> new BedrockArmor("I/O Goggles", RCUArmorMaterials.IOGM, ArmorItem.Type.HELMET, props)).register();
  public static final ItemEntry<CustemItem> PerojectorSlide = RCURegistrates.REGISTRATE.item("perojector_slide", props -> new CustemItem("Perojector Slide", props.stacksTo(1))).register();
  public static final ItemEntry<HSLASteelAxeItem> HslaSteelAxe = RCURegistrates.REGISTRATE.item("hsla_steel_axe", props -> new HSLASteelAxeItem("Hsla Steel Axe")).register();
  public static final ItemEntry<HSLASteelAxeItem> HslaSteelHoe = RCURegistrates.REGISTRATE.item("hsla_steel_hoe", props -> new HSLASteelAxeItem("Hsla Steel Hoe")).register();
  public static final ItemEntry<HSLASteelAxeItem> HslaSteelPickaxe = RCURegistrates.REGISTRATE.item("hsla_steel_pickaxe", props -> new HSLASteelAxeItem("Hsla Steel Pickaxe")).register();
  public static final ItemEntry<HSLASteelAxeItem> HslaSteelShovel = RCURegistrates.REGISTRATE.item("hsla_steel_shovel", props -> new HSLASteelAxeItem("Hsla Steel Shovel")).register();
  public static final ItemEntry<HSLASteelAxeItem> HslaSteelSword = RCURegistrates.REGISTRATE.item("hsla_steel_sword", props -> new HSLASteelAxeItem("Hsla Steel Sword")).register();
  public static final ItemEntry<HSLASteelArmor> HslaSteelHelmet = RCURegistrates.REGISTRATE.item("hsla_steel_helmet", props -> new HSLASteelArmor("Hsla Steel Helmet", RCUArmorMaterials.HSLA, ArmorItem.Type.HELMET, props)).register();
  public static final ItemEntry<HSLASteelArmor> HslaSteelChestplate = RCURegistrates.REGISTRATE.item("hsla_steel_chestplate", props -> new HSLASteelArmor("Hsla Steel Chestplate", RCUArmorMaterials.HSLA, ArmorItem.Type.CHESTPLATE, props)).register();
  public static final ItemEntry<HSLASteelArmor> HslaSteelLeggings = RCURegistrates.REGISTRATE.item("hsla_steel_leggings", props -> new HSLASteelArmor("Hsla Steel Leggings", RCUArmorMaterials.HSLA, ArmorItem.Type.LEGGINGS, props)).register();
  public static final ItemEntry<HSLASteelArmor> HslaSteelBoots = RCURegistrates.REGISTRATE.item("hsla_steel_boots", props -> new HSLASteelArmor("Hsla Steel Boots", RCUArmorMaterials.HSLA, ArmorItem.Type.BOOTS, props)).register();


  public static void init() {}
}
