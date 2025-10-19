package com.zircky.rotarycraft_unofficial.common.recipe;

import net.minecraft.core.NonNullList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

public class WorktableRecipe extends ShapedRecipe {

  public WorktableRecipe(ResourceLocation pId, String pGroup, CraftingBookCategory pCategory, int pWidth, int pHeight, NonNullList<Ingredient> pRecipeItems, ItemStack pResult) {
    super(pId, pGroup, pCategory, pWidth, pHeight, pRecipeItems, pResult);
  }

  @Override
  public boolean matches(CraftingContainer pInv, Level pLevel) {
    return super.matches(pInv, pLevel);
  }

  @Override
  public RecipeSerializer<?> getSerializer() {
    return WorktableRecipeSerializer.INSTANCE;
  }

  @Override
  public RecipeType<?> getType() {
    return WorktableRecipeType.INSTANCE;
  }
}
