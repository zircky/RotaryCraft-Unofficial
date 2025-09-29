package com.zircky.rotarycraft_unofficial.api.item.tools;

import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum RCUTiers implements Tier {
  BEDROCK(0, 0, 15.0F, 4, 30, () -> Ingredient.EMPTY);

  private final int uses;
  private final float speed;
  private final float attackDamageBonus;
  private final int level;
  private final int enchantmentValue;
  private final LazyLoadedValue<Ingredient> repairIngredient;

  RCUTiers(int uses, float attackDamageBonus, float speed, float level, int enchantmentValue, Supplier<Ingredient> repairIngredient) {
    this.uses = uses;
    this.attackDamageBonus = attackDamageBonus;
    this.speed = speed;
    this.level = (int)level;
    this.enchantmentValue = enchantmentValue;
    this.repairIngredient = new LazyLoadedValue<>(repairIngredient);
  }

  @Override public int getUses() { return uses; }
  @Override public float getSpeed() { return speed; }
  @Override public float getAttackDamageBonus() { return attackDamageBonus; }
  @Override public int getLevel() { return level; }
  @Override public int getEnchantmentValue() { return enchantmentValue; }
  @Override public Ingredient getRepairIngredient() { return repairIngredient.get(); }
}
