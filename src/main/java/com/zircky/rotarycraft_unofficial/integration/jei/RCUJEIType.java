package com.zircky.rotarycraft_unofficial.integration.jei;

import com.zircky.rotarycraft_unofficial.RotaryCraftUnofficial;
import com.zircky.rotarycraft_unofficial.common.recipe.WorktableRecipe;
import mezz.jei.api.recipe.RecipeType;

public class RCUJEIType {
  private RCUJEIType() {}
  public static final RecipeType<WorktableRecipe> JEI_WORKTABLE_TYPE =
      RecipeType.create(RotaryCraftUnofficial.MODID, "worktable", WorktableRecipe.class);
}
