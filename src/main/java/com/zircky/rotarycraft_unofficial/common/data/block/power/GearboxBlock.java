package com.zircky.rotarycraft_unofficial.common.data.block.power;

import com.zircky.rotarycraft_unofficial.common.blockentity.power.GearboxBlockEntity;
import com.zircky.rotarycraft_unofficial.common.data.material.gearbox.GearboxType;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.gameevent.GameEventListener;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class GearboxBlock extends Block implements EntityBlock {
  public static final DirectionProperty FACING = DirectionProperty.create("facing", Direction.Plane.HORIZONTAL);
  public static final BooleanProperty POWERED = BooleanProperty.create("powered");

  private final GearboxType type;

  public GearboxBlock(GearboxType type, Properties pProperties) {
    super(pProperties);
    this.type = type;
    this.registerDefaultState(this.getStateDefinition().any().setValue(FACING, Direction.NORTH).setValue(POWERED, false));
  }

  public GearboxType getType() {
    return type;
  }

  @Override
  public @Nullable BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
    return new GearboxBlockEntity(pPos, pState, this.type);
  }

  @Override
  protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
    pBuilder.add(FACING, POWERED);
  }



  @Override
  public @Nullable BlockState getStateForPlacement(BlockPlaceContext pContext) {
    return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite());
  }

  @Override
  public @NotNull RenderShape getRenderShape(BlockState pState) {
    return RenderShape.MODEL;
  }

  @Override
  public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
    if (!pLevel.isClientSide) {
      BlockEntity be = pLevel.getBlockEntity(pPos);
      if (be instanceof GearboxBlockEntity gearbox) {
        pPlayer.displayClientMessage(
            gearbox.getInfoText(), true
        );
      }
    }
    return InteractionResult.SUCCESS;
  }

  @Override
  public boolean hasAnalogOutputSignal(BlockState pState) {
    return true;
  }

  @Override
  public int getAnalogOutputSignal(BlockState pState, Level pLevel, BlockPos pPos) {
    BlockEntity be = pLevel.getBlockEntity(pPos);
    if (be instanceof GearboxBlockEntity gearbox) {
      return gearbox.getSignalOutput();
    }
    return 0;
  }

  @Override
  public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pMovedByPiston) {
    if (pState.getBlock() != pNewState.getBlock()) {
      BlockEntity be = pLevel.getBlockEntity(pPos);
      if (be instanceof GearboxBlockEntity gearbox) {
        gearbox.dropAllContents();
      }
      super.onRemove(pState, pLevel, pPos, pNewState, pMovedByPiston);
    }
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
    switch (type.getId()) {
      case "wood", "livingwood" -> {
        pTooltip.add(Component.literal("Damage: " + 0 + "%").withStyle(ChatFormatting.GRAY));
        pTooltip.add(Component.literal("Max Speed: " + "4" + " krad/s").withStyle(ChatFormatting.GRAY));
        pTooltip.add(Component.literal("Max Torque: " + "278" + " Nm").withStyle(ChatFormatting.GRAY));
      }
      case "stone", "livingrock" -> {
        pTooltip.add(Component.literal("Damage: " + 0 + "%").withStyle(ChatFormatting.GRAY));
        pTooltip.add(Component.literal("Lubricant: " + 0 + "mB").withStyle(ChatFormatting.GRAY));
        pTooltip.add(Component.literal("Max Speed: " + "12" + " krad/s").withStyle(ChatFormatting.GRAY));
        pTooltip.add(Component.literal("Max Torque: " + "959" + " Nm").withStyle(ChatFormatting.GRAY));
      }
      case "steel" -> {
        pTooltip.add(Component.literal("Damage: " + 0 + "%").withStyle(ChatFormatting.GRAY));
        pTooltip.add(Component.literal("Lubricant: " + 0 + "mB").withStyle(ChatFormatting.GRAY));
        pTooltip.add(Component.literal("Max Speed: " + "57" + " krad/s").withStyle(ChatFormatting.GRAY));
        pTooltip.add(Component.literal("Max Torque: " + "7" + " kNm").withStyle(ChatFormatting.GRAY));
      }
      case "tugsten" -> {
        pTooltip.add(Component.literal("Damage: " + 0 + "%").withStyle(ChatFormatting.GRAY));
        pTooltip.add(Component.literal("Lubricant: " + 0 + "mB").withStyle(ChatFormatting.GRAY));
        pTooltip.add(Component.literal("Max Speed: " + "314" + " krad/s").withStyle(ChatFormatting.GRAY));
        pTooltip.add(Component.literal("Max Torque: " + "10" + " kNm").withStyle(ChatFormatting.GRAY));
      }
      case "diamond" -> {
        pTooltip.add(Component.literal("Damage: " + 0 + "%").withStyle(ChatFormatting.GRAY));
        pTooltip.add(Component.literal("Lubricant: " + 0 + "mB").withStyle(ChatFormatting.GRAY));
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
