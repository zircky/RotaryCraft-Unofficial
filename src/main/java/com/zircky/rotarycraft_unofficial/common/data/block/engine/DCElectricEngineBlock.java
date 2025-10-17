package com.zircky.rotarycraft_unofficial.common.data.block.engine;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEventListener;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DCElectricEngineBlock extends Block implements EntityBlock {
  public DCElectricEngineBlock(Properties pProperties) {
    super(pProperties);
  }

  @Override
  public @Nullable BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
    return null;
  }

  @Override
  public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
    return EntityBlock.super.getTicker(pLevel, pState, pBlockEntityType);
  }

  @Override
  public @Nullable <T extends BlockEntity> GameEventListener getListener(ServerLevel pLevel, T pBlockEntity) {
    return EntityBlock.super.getListener(pLevel, pBlockEntity);
  }

  @Override
  public void appendHoverText(ItemStack pStack, @Nullable BlockGetter pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
    pTooltip.add(Component.literal("Power: " + "1.024" + " kW").withStyle(ChatFormatting.GRAY));
    pTooltip.add(Component.literal("Torque: " + "4.000" + " Nm").withStyle(ChatFormatting.GRAY));
    pTooltip.add(Component.literal("Speed: " + "256.000" + " rad/s").withStyle(ChatFormatting.GRAY));
  }
}