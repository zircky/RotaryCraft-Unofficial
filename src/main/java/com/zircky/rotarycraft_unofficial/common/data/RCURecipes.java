package com.zircky.rotarycraft_unofficial.common.data;

import com.tterrag.registrate.util.entry.RegistryEntry;
import com.zircky.rotarycraft_unofficial.api.registry.RCURegistrates;
import com.zircky.rotarycraft_unofficial.common.recipe.WorktableRecipe;
import com.zircky.rotarycraft_unofficial.common.recipe.WorktableRecipeSerializer;
import com.zircky.rotarycraft_unofficial.common.recipe.WorktableRecipeType;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;

public class RCURecipes {
  public static final RegistryEntry<RecipeSerializer<WorktableRecipe>> WORKTABLE_SERIALIZER = RCURegistrates.REGISTRATE
      .simple(WorktableRecipeType.ID, Registries.RECIPE_SERIALIZER, () -> WorktableRecipeSerializer.INSTANCE);

  public static void init() {}
}
