package com.zircky.rotarycraft_unofficial.common.blockentity;

import com.zircky.rotarycraft_unofficial.common.RCUMenu;
import com.zircky.rotarycraft_unofficial.common.data.RCUBlockEntities;
import com.zircky.rotarycraft_unofficial.common.menu.WorktableMenu;
import com.zircky.rotarycraft_unofficial.common.recipe.WorktableRecipe;
import com.zircky.rotarycraft_unofficial.common.recipe.WorktableRecipeType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.StackedContents;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.inventory.ResultContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;

public class WorktableBlockEntity extends BlockEntity implements MenuProvider {
  private final SimpleContainer inventory = new SimpleContainer(18);
  private final CraftingContainer craftInv = new CraftingContainer() {
    private final NonNullList<ItemStack> items = NonNullList.withSize(9, ItemStack.EMPTY);

    @Override
    public void fillStackedContents(StackedContents pContents) {
      for(ItemStack stack : items) {
        pContents.accountSimpleStack(stack);
      }
    }

    @Override
    public void clearContent() {
      items.clear();
    }

    @Override
    public int getContainerSize() {
      return items.size();
    }

    @Override
    public boolean isEmpty() {
      for (ItemStack itemStack : items) {
        if(!itemStack.isEmpty()) {
          return false;
        }
      }
      return true;
    }

    @Override
    public ItemStack getItem(int pSlot) {
      return items.get(pSlot);
    }

    @Override
    public ItemStack removeItem(int pSlot, int pAmount) {
      ItemStack stack = ContainerHelper.removeItem(items, pSlot, pAmount);
      if(!stack.isEmpty()) setChanged();
      return stack;
    }

    @Override
    public ItemStack removeItemNoUpdate(int pSlot) {
      return ContainerHelper.takeItem(items, pSlot);
    }

    @Override
    public void setItem(int pSlot, ItemStack pStack) {
      items.set(pSlot, pStack);
      setChanged();
    }

    @Override
    public void setChanged() {
      WorktableBlockEntity.this.setChanged();
    }

    @Override
    public boolean stillValid(Player pPlayer) {
      return true;
    }

    @Override
    public int getWidth() {
      return 3;
    }

    @Override
    public int getHeight() {
      return 3;
    }

    @Override
    public List<ItemStack> getItems() {
      return items;
    }
  };
  private final ResultContainer resultInv = new ResultContainer();

  public WorktableBlockEntity(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState) {
    super(pType, pPos, pBlockState);
  }

  public WorktableBlockEntity(BlockPos pPos, BlockState pBlockState) {
    super(RCUBlockEntities.WORKTABLE.get(), pPos, pBlockState);
  }

  public SimpleContainer getInventory() {
    return inventory;
  }

  @Override
  public Component getDisplayName() {
    return Component.literal("Worktable");
  }

  @Override
  public @Nullable AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
    return new WorktableMenu(RCUMenu.WORKTABLE_MENU.get(), pContainerId, pPlayerInventory, this);
  }

  public CraftingContainer getCraftInv() { return craftInv; }
  public ResultContainer getResultInv() { return resultInv; }

  public void updateRecipe(Level level) {
    if (level.isClientSide) return;

    for (int i = 0; i < 9; i++) {
      craftInv.setItem(i, inventory.getItem(i));
    }

    Optional<WorktableRecipe> match = level.getRecipeManager()
        .getAllRecipesFor(WorktableRecipeType.INSTANCE)
        .stream()
        .filter(r -> r.matches(craftInv, level))
        .findFirst();

    if (match.isPresent()) {
      WorktableRecipe recipe = match.get();
      ItemStack result = recipe.assemble(craftInv, level.registryAccess());
      inventory.setItem(13, result.copy());
    } else {
      inventory.setItem(13, ItemStack.EMPTY);
    }
  }

  public void craftResult() {
    for (int i = 0; i < 9; i++) {
      ItemStack stack = craftInv.getItem(i);
      if (!stack.isEmpty()) {
        stack.shrink(1);
        if (stack.getCount() <= 0) {
          inventory.setItem(i, ItemStack.EMPTY);
        }
      }
      setChanged();
    }
  }

  @Override
  protected void saveAdditional(CompoundTag pTag) {
    super.saveAdditional(pTag);
    NonNullList<ItemStack> items = NonNullList.withSize(inventory.getContainerSize(), ItemStack.EMPTY);
    for (int i = 0; i < inventory.getContainerSize(); i++) {
      items.set(i, inventory.getItem(i));
    }
    ContainerHelper.saveAllItems(pTag, items);
  }

  @Override
  public void load(CompoundTag pTag) {
    super.load(pTag);

    NonNullList<ItemStack> items = NonNullList.withSize(inventory.getContainerSize(), ItemStack.EMPTY);
    ContainerHelper.loadAllItems(pTag, items);

    for (int i = 0; i < inventory.getContainerSize(); i++) {
      inventory.setItem(i, items.get(i));
    }
  }
}