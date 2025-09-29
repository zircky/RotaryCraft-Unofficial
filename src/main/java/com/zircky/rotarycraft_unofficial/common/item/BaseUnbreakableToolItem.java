package com.zircky.rotarycraft_unofficial.common.item;

import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;

public class BaseUnbreakableToolItem extends TieredItem {

  private final float attackDamage;
  private final float attackSpeed;
  private Map<Enchantment, Integer> requiredEnchantments;

  public BaseUnbreakableToolItem(Tier tier,
                                 float attackDamage,
                                 float attackSpeed,
                                 Properties properties,
                                 int durability,
                                 Rarity rarity,
                                 Map<Enchantment, Integer> requiredEnchantments) {
    super(tier, properties
        .stacksTo(1)
        .durability(durability) // бесконечный
        .rarity(rarity)
        .fireResistant());
    this.attackDamage = attackDamage;
    this.attackSpeed = attackSpeed;
    this.requiredEnchantments = requiredEnchantments;
  }

  public BaseUnbreakableToolItem(Tier tier,
                                 float attackDamage,
                                 float attackSpeed,
                                 Properties properties) {
    super(tier, properties);
    this.attackDamage = attackDamage;
    this.attackSpeed = attackSpeed;
  }

  // Стартовый экземпляр с чарами
  @Override
  public ItemStack getDefaultInstance() {
    ItemStack stack = super.getDefaultInstance();
    for (Map.Entry<Enchantment, Integer> e : requiredEnchantments.entrySet()) {
      stack.enchant(e.getKey(), e.getValue());
    }
    return stack;
  }

  // Проверка чар при апдейте
  public void inventoryTick(ItemStack stack, Level level, LivingEntity entity, int slot, boolean selected) {
    super.inventoryTick(stack, level, entity, slot, selected);

    if (!(entity instanceof Player player)) return;

    for (Map.Entry<Enchantment, Integer> e : requiredEnchantments.entrySet()) {
      int actualLevel = EnchantmentHelper.getItemEnchantmentLevel(e.getKey(), stack);
      if (actualLevel < e.getValue()) {
        // «ломаем» предмет
        level.playSound(null, player.blockPosition(), SoundEvents.ITEM_BREAK, SoundSource.PLAYERS, 1F, 1F);
        player.hurt(player.damageSources().generic(), 10);
        player.getInventory().removeItem(stack);
        return;
      }
    }
  }

  // Всегда можно добывать
  @Override
  public boolean isCorrectToolForDrops(ItemStack stack, net.minecraft.world.level.block.state.BlockState state) {
    return true;
  }

  // Кастомное имя
  @Override
  public Component getName(ItemStack stack) {
    return Component.translatable(this.getDescriptionId(stack));
  }

  // Тултип
  @Override
  public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flag) {
    tooltip.add(Component.literal("§6Unbreakable Tool"));

    super.appendHoverText(stack, world, tooltip, flag);
  }

  public float getAttackDamage() {
    return attackDamage;
  }

  public float getAttackSpeed() {
    return attackSpeed;
  }
}
