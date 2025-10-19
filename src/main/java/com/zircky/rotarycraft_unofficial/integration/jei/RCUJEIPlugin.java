package com.zircky.rotarycraft_unofficial.integration.jei;

import com.zircky.rotarycraft_unofficial.RotaryCraftUnofficial;
import com.zircky.rotarycraft_unofficial.common.recipe.WorktableRecipe;
import com.zircky.rotarycraft_unofficial.common.recipe.WorktableRecipeType;
import com.zircky.rotarycraft_unofficial.integration.jei.recipe.WorktebleRecipeCategory;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

import static com.zircky.rotarycraft_unofficial.integration.jei.RCUJEIType.JEI_WORKTABLE_TYPE;

@JeiPlugin
public class RCUJEIPlugin implements IModPlugin {
  public static final ResourceLocation ID = ResourceLocation.fromNamespaceAndPath(RotaryCraftUnofficial.MODID, "jei_worktable");

  @Override
  public ResourceLocation getPluginUid() {
    return ID;
  }

  @Override
  public void registerCategories(IRecipeCategoryRegistration registration) {
    registration.addRecipeCategories(new WorktebleRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
  }

  @Override
  public void registerRecipes(IRecipeRegistration registration) {
    Minecraft mc = Minecraft.getInstance();
    assert mc.player != null;
    var recipes = mc.level.getRecipeManager().getAllRecipesFor(WorktableRecipeType.INSTANCE);
    registration.addRecipes(JEI_WORKTABLE_TYPE, recipes);
  }

  @Override
  public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
    registration.addRecipeCatalyst(new ItemStack(BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath(RotaryCraftUnofficial.MODID, "worktable"))), JEI_WORKTABLE_TYPE);
  }
}
