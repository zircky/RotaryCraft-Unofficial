package com.zircky.rotarycraft_unofficial.common.data.block;

import com.zircky.rotarycraft_unofficial.common.blockentity.WorktableBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.Nullable;

public class WorktableBlock extends Block implements EntityBlock {
  public WorktableBlock(Properties pProperties) {
    super(pProperties);
  }

  @Override
  public @Nullable BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
    return new WorktableBlockEntity(pPos, pState);
  }

  @Override
  public InteractionResult use(BlockState state, Level level, BlockPos pos,
                               Player player, InteractionHand hand, BlockHitResult hit) {
    if (!level.isClientSide) {
      System.out.println("DEBUG: Worktable used on server by " + player.getName().getString());
      BlockEntity be = level.getBlockEntity(pos);
      if (be instanceof MenuProvider provider) {
        NetworkHooks.openScreen((ServerPlayer) player, provider, pos);
        System.out.println("DEBUG: Opening screen for Worktable");
      } else {
        System.out.println("DEBUG: BlockEntity is not MenuProvider!");
      }
    }
    return InteractionResult.sidedSuccess(level.isClientSide);
  }
}