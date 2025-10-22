package com.zircky.rotarycraft_unofficial.common.menu;

import com.zircky.rotarycraft_unofficial.common.blockentity.BlastFurnaceBlockEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class BlastFurnaceMenu extends AbstractContainerMenu {
  private final BlastFurnaceBlockEntity blockEntity;
  private final ContainerData data;

  public BlastFurnaceMenu(@Nullable MenuType<?> pMenuType, int pContainerId, Inventory playerInv, @Nullable BlastFurnaceBlockEntity blockEntity) {
    super(pMenuType, pContainerId);
    this.blockEntity = blockEntity;
    this.data = blockEntity != null ? blockEntity.getData() : new SimpleContainerData(2);
    addDataSlots(this.data);

    if (blockEntity != null) {
      var inv = blockEntity.getInventory();

      int catalystX = 20;
      int catalystY = 17;
      for (int i = 0; i < 3; i++) {
        addSlot(new Slot(inv, i, catalystX, catalystY + i * 18));
      }

      int startX = 56;
      int startY = 17;
      for (int row = 0; row < 3; row++) {
        for (int col = 0; col < 9; col++) {
          this.addSlot(new Slot(inv, 3 + col + row * 3, startX + col * 18, startY + row * 18));
        }
      }

      int outputX = 140;
      int outputY = 17;
      for (int i = 0; i < 3; i++) {
        addSlot(new Slot(inv, 12 + i, outputX, outputY + i * 18) {
          @Override
          public boolean mayPlace(ItemStack pStack) {
            return false;
          }
        });
      }
    }

    addPlayerInventory(playerInv);
    addPlayerHotbar(playerInv);
  }


  private void addPlayerInventory(Inventory inv) {
    for (int i = 0; i < 3; ++i) {
      for (int j = 0; j < 9; ++j) {
        this.addSlot(new Slot(inv, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
      }
    }
  }

  private void addPlayerHotbar(Inventory inv) {
    for (int i = 0; i < 9; ++i) {
      this.addSlot(new Slot(inv, i, 8 + i * 18, 142));
    }
  }


  @Override
  public ItemStack quickMoveStack(Player pPlayer, int pIndex) {
    return ItemStack.EMPTY;
  }

  public int getProgress() {
    return data.get(0);
  }

  public int getTemperature() {
    return data.get(1);
  }

  @Override
  public boolean stillValid(Player pPlayer) {
    return true;
  }
}
