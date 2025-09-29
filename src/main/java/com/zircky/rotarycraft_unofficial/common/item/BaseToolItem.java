package com.zircky.rotarycraft_unofficial.common.item;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class BaseToolItem extends TieredItem {

  private final float attackDamage;
  private final float attackSpeed;
  private final ToolType type; // наш тип инструмента

  public enum ToolType {
    PICKAXE, AXE, SHOVEL, HOE, SWORD
  }

  public BaseToolItem(Tier tier, Properties properties,
                      float attackDamage, float attackSpeed, ToolType type) {
    super(tier, properties);
    this.attackDamage = attackDamage;
    this.attackSpeed = attackSpeed;
    this.type = type;
  }

  @Override
  public boolean mineBlock(ItemStack stack, Level level,
                           BlockState state, BlockPos pos, LivingEntity entity) {
    if (state.getDestroySpeed(level, pos) != 0.0F) {
      stack.hurtAndBreak(1, entity, e -> e.broadcastBreakEvent(entity.getUsedItemHand()));
    }
    return true;
  }

  public float getAttackDamage() {
    return attackDamage;
  }

  public float getAttackSpeed() {
    return attackSpeed;
  }

  public ToolType getToolType() {
    return type;
  }
}
