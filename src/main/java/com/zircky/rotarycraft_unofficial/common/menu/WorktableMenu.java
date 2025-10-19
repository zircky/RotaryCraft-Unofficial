package com.zircky.rotarycraft_unofficial.common.menu;

import com.zircky.rotarycraft_unofficial.common.blockentity.WorktableBlockEntity;
import com.zircky.rotarycraft_unofficial.common.menu.slot.OutputSlot;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.jetbrains.annotations.Nullable;

public class WorktableMenu extends AbstractContainerMenu {
  private final WorktableBlockEntity blockEntity;
  private final Level level;

  public WorktableMenu(@Nullable MenuType<?> type, int id, Inventory inv, WorktableBlockEntity be) {
    super(type, id);
    this.blockEntity = be;
    this.level = inv.player.level();

    if (be != null) {
      int startX = 26;
      int startY = 17;
      for (int row = 0; row < 3; ++row) {
        for (int col = 0; col < 3; ++col) {
          this.addSlot(new Slot(be.getInventory(), col + row * 3, startX + col * 18, startY + row * 18) {
            @Override
            public void setChanged() {
              super.setChanged();
              be.updateRecipe(level);
            }
          });
        }
      }

      int outStartX = 98;
      int outStartY = 17;
      for (int row = 0; row < 3; ++row)
        for (int col = 0; col < 3; ++col)
          this.addSlot(new OutputSlot(be.getInventory(), 9 + col + row * 3, outStartX + col * 18, outStartY + row * 18) {
            @Override
            public void onTake(Player pPlayer, ItemStack pStack) {
              super.onTake(pPlayer, pStack);
              be.craftResult();
              be.updateRecipe(level);
            }
          });
    }

    addPlayerInventory(inv);
    addPlayerHotbar(inv);
  }

  public WorktableMenu(@Nullable MenuType<?> type, int id, Inventory inv, FriendlyByteBuf buf) {
    this(type, id, inv, getBlockEntity(inv, buf.readBlockPos()));
  }

  private static WorktableBlockEntity getBlockEntity(Inventory inv, BlockPos pos) {
    BlockEntity be = inv.player.level().getBlockEntity(pos);
    return be instanceof WorktableBlockEntity wbe ? wbe : null;
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
  public ItemStack quickMoveStack(Player player, int index) {
    ItemStack itemstack = ItemStack.EMPTY;
    Slot slot = this.slots.get(index);
    if (slot != null && slot.hasItem()) {
      ItemStack stack = slot.getItem();
      itemstack = stack.copy();

      int containerSlots = 18;
      if (index < containerSlots) {
        if (!this.moveItemStackTo(stack, containerSlots, this.slots.size(), true))
          return ItemStack.EMPTY;
      } else if (!this.moveItemStackTo(stack, 0, 9, false)) {
        return ItemStack.EMPTY;
      }

      if (stack.isEmpty()) slot.set(ItemStack.EMPTY);
      else slot.setChanged();
    }
    return itemstack;
  }


  @Override
  public boolean stillValid(Player player) {
    return true;
  }

}
