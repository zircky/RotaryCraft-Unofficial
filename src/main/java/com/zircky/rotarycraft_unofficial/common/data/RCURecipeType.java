package com.zircky.rotarycraft_unofficial.common.data;

import com.tterrag.registrate.util.entry.RegistryEntry;
import com.zircky.rotarycraft_unofficial.api.registry.RCURegistrates;
import com.zircky.rotarycraft_unofficial.common.recipe.WorktableRecipeType;
import net.minecraft.core.registries.Registries;

public class RCURecipeType {
  public static final RegistryEntry<WorktableRecipeType> WORKTABLE_TYPE = RCURegistrates.REGISTRATE.simple(WorktableRecipeType.ID, Registries.RECIPE_TYPE, () -> WorktableRecipeType.INSTANCE);

  public static void init() {}
}
