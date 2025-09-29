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
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BedrockSwordItem extends SwordItem {
  public BedrockSwordItem() {
    super(RCUTiers.BEDROCK,
        1,
        -3.0F,
        new Properties()
            .stacksTo(1)
            .fireResistant()
            .rarity(Rarity.EPIC)
            .durability(0)
    );
  }

  @Override
  public ItemStack getDefaultInstance() {
    ItemStack stack = super.getDefaultInstance();
    stack.enchant(Enchantments.SHARPNESS, 5);
    stack.enchant(Enchantments.MOB_LOOTING, 5);
    return stack;
  }

  // Проверка чар при апдейте
  public void inventoryTick(ItemStack stack, Level level, LivingEntity entity, int slot, boolean selected) {
    super.inventoryTick(stack, level, entity, slot, selected);

    if (!(entity instanceof Player player)) return;

    int sharptness = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.SHARPNESS, stack);
    int looting = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.MOB_LOOTING, stack);

    if (sharptness < 5 || looting < 5) {
      level.playSound(null, player.blockPosition(), SoundEvents.ITEM_BREAK, SoundSource.PLAYERS, 1F, 1F);
      player.hurt(player.damageSources().generic(), 10);
      player.getInventory().removeItem(stack);
    }
  }

  // Всегда можно добывать
  @Override
  public boolean isCorrectToolForDrops(ItemStack stack, BlockState state) {
    return true;
  }

  // Кастомное название
  @Override
  public Component getName(ItemStack stack) {
    return Component.translatable("Bedrock Sword");
  }

  // Тултип
  @Override
  public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flag) {
    tooltip.add(Component.literal("§6The unbreakable Sword"));
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
