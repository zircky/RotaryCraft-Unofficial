package com.zircky.rotarycraft_unofficial.common.blockentity;

import com.zircky.rotarycraft_unofficial.common.data.RCUBlockEntities;
import com.zircky.rotarycraft_unofficial.common.menu.BlastFurnaceMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class BlastFurnaceBlockEntity extends BlockEntity implements MenuProvider {
  private final SimpleContainer inventory = new SimpleContainer(15);
  private final ContainerData data = new ContainerData() {
    public int progress;
    public int temperature;

    @Override
    public int get(int pIndex) {
      return switch (pIndex) {
        case 0 -> this.progress;
        case 1 -> this.temperature;
        default -> 0;
      };
    }

    @Override
    public void set(int pIndex, int pValue) {
      switch (pIndex) {
        case 0 -> this.progress = pValue;
        case 1 -> this.temperature = pValue;
      }
    }

    @Override
    public int getCount() {
      return 2;
    }
  };

  public BlastFurnaceBlockEntity(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState) {
    super(pType, pPos, pBlockState);
  }

  public BlastFurnaceBlockEntity(BlockPos pPos, BlockState pBlockState) {
    super(RCUBlockEntities.BLAST_FURNACE_ENTITY.get(), pPos, pBlockState);
  }

  public SimpleContainer getInventory() {
    return inventory;
  }

  public ContainerData getData() {
    return data;
  }

  @Override
  public Component getDisplayName() {
    return Component.literal("Blast Furnace");
  }

  @Override
  public @Nullable AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
    return new BlastFurnaceMenu(null, pContainerId, pPlayerInventory, this);
  }

}