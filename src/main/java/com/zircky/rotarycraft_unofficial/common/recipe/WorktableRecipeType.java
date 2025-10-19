package com.zircky.rotarycraft_unofficial.common.recipe;

import net.minecraft.world.item.crafting.RecipeType;

public class WorktableRecipeType implements RecipeType<WorktableRecipe> {
  public static final WorktableRecipeType INSTANCE = new WorktableRecipeType();
  public static final String ID = "worktable";

  public WorktableRecipeType() {}

  @Override
  public String toString() {
    return ID;
  }
}
