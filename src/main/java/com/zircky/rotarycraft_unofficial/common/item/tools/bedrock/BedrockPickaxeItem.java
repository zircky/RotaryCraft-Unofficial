package com.zircky.rotarycraft_unofficial.common.item.tools.bedrock;

import com.zircky.rotarycraft_unofficial.api.item.tools.RCUTiers;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BedrockPickaxeItem extends PickaxeItem {

  public BedrockPickaxeItem() {
    super(RCUTiers.BEDROCK, // базовый материал
        4,             // бонус к атаке
        -2.8F,         // скорость атаки
        new Item.Properties()
            .stacksTo(1) // один в стаке
            .fireResistant()
            .rarity(Rarity.EPIC)
            .durability(0)
    );
  }

  // Добавляем дефолтные чары
  @Override
  public ItemStack getDefaultInstance() {
    ItemStack stack = super.getDefaultInstance();
    stack.enchant(Enchantments.SILK_TOUCH, 1);
    stack.enchant(Enchantments.BLOCK_FORTUNE, 5);
    return stack;
  }

  // Проверка чар при апдейте
  public void inventoryTick(ItemStack stack, Level level, LivingEntity entity, int slot, boolean selected) {
    super.inventoryTick(stack, level, entity, slot, selected);

    if (!(entity instanceof Player player)) return;

    int silk = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.SILK_TOUCH, stack);
    int fortune = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.BLOCK_FORTUNE, stack);

    if (silk < 1 || fortune < 5) {
      // Сломать предмет, наказать игрока :)
      level.playSound(null, player.blockPosition(), SoundEvents.ITEM_BREAK, SoundSource.PLAYERS, 1F, 1F);
      player.hurt(player.damageSources().generic(), 10);
      player.getInventory().removeItem(stack);
    }
  }

  // Очень высокая скорость копания
  @Override
  public float getDestroySpeed(ItemStack stack, BlockState state) {
    Block block = state.getBlock();

    if (block.defaultDestroyTime() > 0) {
      return 48.0F; // как пример
    }

    return super.getDestroySpeed(stack, state);
  }

  // Всегда можно добывать
  @Override
  public boolean isCorrectToolForDrops(ItemStack stack, BlockState state) {
    return true;
  }

  // Кастомное название
  @Override
  public Component getName(ItemStack stack) {
    return Component.translatable("Bedrock Pickaxe");
  }

  // Тултип
  @Override
  public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flag) {
    tooltip.add(Component.literal("§6The unbreakable pickaxe"));
    super.appendHoverText(stack, world, tooltip, flag);
  }

  @Override
  public boolean isDamageable(ItemStack stack) {
    return false; // предмет не может иметь урон
  }

  @Override
  public boolean canBeDepleted() {
    return false; // предмет не расходуется
  }
}
