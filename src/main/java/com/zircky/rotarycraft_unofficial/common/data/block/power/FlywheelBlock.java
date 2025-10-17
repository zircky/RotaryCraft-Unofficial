package com.zircky.rotarycraft_unofficial.common.data.block.power;

import com.zircky.rotarycraft_unofficial.common.data.material.flywheel.FlywheelMaterial;
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

public class FlywheelBlock extends Block implements EntityBlock {
  private final FlywheelMaterial material;

  public FlywheelBlock(Properties pProperties, FlywheelMaterial material) {
    super(pProperties);
    this.material = material;
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
    switch (material.getId()) {
      case "wood" -> {
        pTooltip.add(Component.literal("Max Speed: " + "2981" + " rad/s").withStyle(ChatFormatting.GRAY));
        pTooltip.add(Component.literal("Required Troque: " + "4" + " Nm").withStyle(ChatFormatting.GRAY));
        pTooltip.add(Component.literal("Max Torque: " + "16" + " Nm").withStyle(ChatFormatting.GRAY));
        pTooltip.add(Component.literal("Decay Rate: " + "1/2").withStyle(ChatFormatting.GRAY));
      }
      case "stone" -> {
        pTooltip.add(Component.literal("Max Speed: " + "3265" + " rad/s").withStyle(ChatFormatting.GRAY));
        pTooltip.add(Component.literal("Required Troque: " + "32" + " Nm").withStyle(ChatFormatting.GRAY));
        pTooltip.add(Component.literal("Max Torque: " + "128" + " Nm").withStyle(ChatFormatting.GRAY));
        pTooltip.add(Component.literal("Decay Rate: " + "1/5").withStyle(ChatFormatting.GRAY));
      }
      case "iron" -> {
        pTooltip.add(Component.literal("Max Speed: " + "6751" + " rad/s").withStyle(ChatFormatting.GRAY));
        pTooltip.add(Component.literal("Required Troque: " + "128" + " Nm").withStyle(ChatFormatting.GRAY));
        pTooltip.add(Component.literal("Max Torque: " + "512" + " Nm").withStyle(ChatFormatting.GRAY));
        pTooltip.add(Component.literal("Decay Rate: " + "1/15").withStyle(ChatFormatting.GRAY));
      }
      case "gold" -> {
        pTooltip.add(Component.literal("Max Speed: " + "1410" + " rad/s").withStyle(ChatFormatting.GRAY));
        pTooltip.add(Component.literal("Required Troque: " + "1024" + " Nm").withStyle(ChatFormatting.GRAY));
        pTooltip.add(Component.literal("Max Torque: " + "4096" + " Nm").withStyle(ChatFormatting.GRAY));
        pTooltip.add(Component.literal("Decay Rate: " + "1/40").withStyle(ChatFormatting.GRAY));
      }
      case "tungsten" -> {
        pTooltip.add(Component.literal("Max Speed: " + "16613" + " rad/s").withStyle(ChatFormatting.GRAY));
        pTooltip.add(Component.literal("Required Troque: " + "2048" + " Nm").withStyle(ChatFormatting.GRAY));
        pTooltip.add(Component.literal("Max Torque: " + "8192" + " Nm").withStyle(ChatFormatting.GRAY));
        pTooltip.add(Component.literal("Decay Rate: " + "1/25").withStyle(ChatFormatting.GRAY));
      }
      case "depleted_uranium" -> {
        pTooltip.add(Component.literal("Max Speed: " + "8366" + " rad/s").withStyle(ChatFormatting.GRAY));
        pTooltip.add(Component.literal("Required Troque: " + "1024" + " Nm").withStyle(ChatFormatting.GRAY));
        pTooltip.add(Component.literal("Max Torque: " + "4096" + " Nm").withStyle(ChatFormatting.GRAY));
        pTooltip.add(Component.literal("Decay Rate: " + "1/40").withStyle(ChatFormatting.GRAY));
      }
      case "bedrock" -> {
        pTooltip.add(Component.literal("Required Troque: " + "16384" + " Nm").withStyle(ChatFormatting.GRAY));
        pTooltip.add(Component.literal("Decay Rate: " + "1/200").withStyle(ChatFormatting.GRAY));
      }
    }
  }
}
