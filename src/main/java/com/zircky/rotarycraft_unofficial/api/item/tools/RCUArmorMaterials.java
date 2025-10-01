package com.zircky.rotarycraft_unofficial.api.item.tools;

import com.zircky.rotarycraft_unofficial.RotaryCraftUnofficial;
import com.zircky.rotarycraft_unofficial.common.data.RCUItems;
import net.minecraft.Util;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.EnumMap;
import java.util.function.Supplier;

public enum RCUArmorMaterials implements StringRepresentable, ArmorMaterial {
  NVHM("NVHelmet",  65536, Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
    map.put(ArmorItem.Type.HELMET, 0);
  }), 0, SoundEvents.EMPTY, 0F, 0F, () -> Ingredient.EMPTY),
  NVGM("NVGoggles", 65536, Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
    map.put(ArmorItem.Type.HELMET, 0);
  }), 0, SoundEvents.EMPTY, 0F, 0F, () -> Ingredient.EMPTY),
  IOGM("IOGoggles",  65536, Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
    map.put(ArmorItem.Type.HELMET, 0);
  }), 0, SoundEvents.EMPTY, 0F, 0F, () -> Ingredient.EMPTY),
  JETPACK("Jetpack",  65536, Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
    map.put(ArmorItem.Type.HELMET, 0);
  }), 0, SoundEvents.EMPTY, 0F, 0F, () -> Ingredient.EMPTY),
  JUMP("Jump",  65536, Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
    map.put(ArmorItem.Type.HELMET, 0);
  }), 0, SoundEvents.EMPTY, 0F, 0F, () -> Ingredient.EMPTY),

  BEDROCK("bedrock", 0, Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> {
    map.put(ArmorItem.Type.HELMET, 6);
    map.put(ArmorItem.Type.CHESTPLATE, 12);
    map.put(ArmorItem.Type.LEGGINGS, 10);
    map.put(ArmorItem.Type.BOOTS, 5);
  }), 18, SoundEvents.ARMOR_EQUIP_DIAMOND, 3.0F,  0.1F, () -> Ingredient.of(RCUItems.BADROCK_ALLOY_INGOT)),

  HSLA("hsla",  24, Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
    map.put(ArmorItem.Type.HELMET, 3);
    map.put(ArmorItem.Type.CHESTPLATE, 7);
    map.put(ArmorItem.Type.LEGGINGS, 5);
    map.put(ArmorItem.Type.BOOTS, 3);
  }), 9, SoundEvents.EMPTY, 0F, 0F, () -> Ingredient.of(RCUItems.HSLASteelIngot));


  public static final StringRepresentable.EnumCodec<ArmorMaterials> CODEC = StringRepresentable.fromEnum(ArmorMaterials::values);
  private static final EnumMap<ArmorItem.Type, Integer> HEALTH_FUNCTION_FOR_TYPE = Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> {
    map.put(ArmorItem.Type.BOOTS, 13);
    map.put(ArmorItem.Type.LEGGINGS, 15);
    map.put(ArmorItem.Type.CHESTPLATE, 16);
    map.put(ArmorItem.Type.HELMET, 11);
  });
  private final String name;
  private final int durabilityMultiplier;
  private final EnumMap<ArmorItem.Type, Integer> protectionFunctionForType;
  private final int enchantmentValue;
  private final SoundEvent sound;
  private final float toughness;
  private final float knockbackResistance;
  private final LazyLoadedValue<Ingredient> repairIngredient;

  private RCUArmorMaterials(String pName, int pDurabilityMultiplier, EnumMap<ArmorItem.Type, Integer> pProtectionFunctionForType, int pEnchantmentValue, SoundEvent pSound, float pToughness, float pKnockbackResistance, Supplier<Ingredient> pRepairIngredient) {
    this.name = pName;
    this.durabilityMultiplier = pDurabilityMultiplier;
    this.protectionFunctionForType = pProtectionFunctionForType;
    this.enchantmentValue = pEnchantmentValue;
    this.sound = pSound;
    this.toughness = pToughness;
    this.knockbackResistance = pKnockbackResistance;
    this.repairIngredient = new LazyLoadedValue<>(pRepairIngredient);
  }

  public int getDurabilityForType(ArmorItem.Type pType) {
    return HEALTH_FUNCTION_FOR_TYPE.get(pType) * this.durabilityMultiplier;
  }

  public int getDefenseForType(ArmorItem.Type pType) {
    return this.protectionFunctionForType.get(pType);
  }

  public int getEnchantmentValue() {
    return this.enchantmentValue;
  }

  public SoundEvent getEquipSound() {
    return this.sound;
  }

  public Ingredient getRepairIngredient() {
    return this.repairIngredient.get();
  }

  public String getName() {
    return RotaryCraftUnofficial.MODID + ":" + this.name;
  }

  public float getToughness() {
    return this.toughness;
  }

  /**
   * Gets the percentage of knockback resistance provided by armor of the material.
   */
  public float getKnockbackResistance() {
    return this.knockbackResistance;
  }

  public String getSerializedName() {
    return this.name;
  }
}
