package com.zircky.rotarycraft_unofficial.common.item.tools.hsla_steel;

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

public class HSLASteelSwordItem extends SwordItem {
  public HSLASteelSwordItem() {
    super(Tiers.IRON,
        2,
        6.0F,
        new Properties()
            .stacksTo(1)
            .fireResistant()
            .durability(600)
    );
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
