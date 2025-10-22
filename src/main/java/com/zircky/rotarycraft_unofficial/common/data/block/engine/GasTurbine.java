package com.zircky.rotarycraft_unofficial.common.data.block.engine;

import com.zircky.rotarycraft_unofficial.api.block.engine.AbstractEngineBlock;
import com.zircky.rotarycraft_unofficial.common.blockentity.engine.GasTurbineBlockEntity;
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

public class GasTurbine extends AbstractEngineBlock implements EntityBlock {
  public GasTurbine(Properties pProperties) {
    super(pProperties);
  }

  @Override
  public @Nullable BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
    return new GasTurbineBlockEntity(pPos, pState);
  }

  @Override
  public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
    return EntityBlock.super.getTicker(pLevel, pState, pBlockEntityType);
  }

  @Override
  public @Nullable <T extends BlockEntity> GameEventListener getListener(ServerLevel pLevel, T pBlockEntity) {
    return EntityBlock.super.getListener(pLevel, pBlockEntity);
  }

}
