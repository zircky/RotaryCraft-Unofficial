package com.zircky.rotarycraft_unofficial.common.data.block.power;

import com.zircky.rotarycraft_unofficial.common.blockentity.power.ShaftBlockEntity;
import com.zircky.rotarycraft_unofficial.common.data.material.shaft.ShaftMaterial;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.gameevent.GameEventListener;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ShaftBlock extends RotatedPillarBlock implements EntityBlock {
  public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.AXIS;
  private final ShaftMaterial material;

  public ShaftBlock(BlockBehaviour.Properties properties, ShaftMaterial material) {
    super(properties);
    this.material = material;
    this.registerDefaultState(this.stateDefinition.any().setValue(AXIS, Direction.Axis.Y));
  }

  @Override
  protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
    builder.add(AXIS);
  }

  @Override
  public BlockState getStateForPlacement(BlockPlaceContext context) {
//    Player player = context.getPlayer();
//
//    if (player == null) {
//      return this.defaultBlockState().setValue(AXIS, Direction.Axis.Y);
//    }
//
//    // Если игрок зажал Shift — ставим вертикально
//    if (player.isShiftKeyDown()) {
//      return this.defaultBlockState().setValue(AXIS, Direction.Axis.Y);
//    }
//
//    // По умолчанию — горизонтально, по направлению взгляда игрока
//    Direction lookDir = player.getDirection();
//    return this.defaultBlockState().setValue(AXIS, lookDir.getAxis());

    Direction face = context.getClickedFace();
    return this.defaultBlockState().setValue(AXIS,
        (face == Direction.UP || face == Direction.DOWN)
            ? Direction.Axis.Y
            : face.getAxis());
  }


  @Override
  public @Nullable BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
    return new ShaftBlockEntity(pPos, pState);
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
        pTooltip.add(Component.literal("Max Speed: " + "4" + " krad/s").withStyle(ChatFormatting.GRAY));
        pTooltip.add(Component.literal("Max Torque: " + "278" + " Nm").withStyle(ChatFormatting.GRAY));
      }
      case "stone" -> {
        pTooltip.add(Component.literal("Max Speed: " + "12" + " krad/s").withStyle(ChatFormatting.GRAY));
        pTooltip.add(Component.literal("Max Torque: " + "959" + " Nm").withStyle(ChatFormatting.GRAY));
      }
      case "steel" -> {
        pTooltip.add(Component.literal("Max Speed: " + "57" + " krad/s").withStyle(ChatFormatting.GRAY));
        pTooltip.add(Component.literal("Max Torque: " + "7" + " kNm").withStyle(ChatFormatting.GRAY));
      }
      case "tungsten" -> {
        pTooltip.add(Component.literal("Max Speed: " + "314" + " krad/s").withStyle(ChatFormatting.GRAY));
        pTooltip.add(Component.literal("Max Torque: " + "10" + " kNm").withStyle(ChatFormatting.GRAY));
      }
      case "diamond" -> {
        pTooltip.add(Component.literal("Max Speed: " + "4" + " Mrad/s").withStyle(ChatFormatting.GRAY));
        pTooltip.add(Component.literal("Max Torque: " + "70" + " kNm").withStyle(ChatFormatting.GRAY));
      }
      case "bedrock" -> {
        pTooltip.add(Component.literal("Max Speed: " + "Infinity" + " rad/s").withStyle(ChatFormatting.GRAY));
        pTooltip.add(Component.literal("Max Torque: " + "Infinity" + " Nm").withStyle(ChatFormatting.GRAY));
      }
    }
  }
}
