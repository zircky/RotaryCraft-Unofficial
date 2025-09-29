package com.zircky.rotarycraft_unofficial.common.item.tools.bedrock;

import com.google.common.collect.Multimap;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;

public class BedrockArmor extends ArmorItem {
  private final String name;
  public BedrockArmor(String name, ArmorMaterial pMaterial, Type pType, Properties pProperties) {
    super(pMaterial, pType, pProperties.stacksTo(1));
    this.name = name;
  }

  @Override
  public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot pEquipmentSlot) {
    return super.getDefaultAttributeModifiers(pEquipmentSlot);
  }

  @Override
  public Type getType() {
    return super.getType();
  }

  @Override
  public EquipmentSlot getEquipmentSlot() {
    return super.getEquipmentSlot();
  }

  @Override
  public boolean isValidRepairItem(ItemStack pToRepair, ItemStack pRepair) {
    return super.isValidRepairItem(pToRepair, pRepair);
  }

  @Override
  public int getEnchantmentValue() {
    return super.getEnchantmentValue();
  }

  @Override
  public int getMaxDamage(ItemStack stack) {
    return Integer.MAX_VALUE;
  }

  @Override
  public boolean isDamaged(ItemStack stack) {
    return false;
  }

  @Override
  public Component getName(ItemStack pStack) {
    return Component.translatable(name);
  }
}
