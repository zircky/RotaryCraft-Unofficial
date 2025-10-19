package com.zircky.rotarycraft_unofficial.common.recipe;

import com.google.gson.JsonObject;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.ShapedRecipe;
import org.jetbrains.annotations.Nullable;

public class WorktableRecipeSerializer implements RecipeSerializer<WorktableRecipe> {
  public static final WorktableRecipeSerializer INSTANCE = new WorktableRecipeSerializer();

  @Override
  public WorktableRecipe fromJson(ResourceLocation pRecipeId, JsonObject pSerializedRecipe) {
    ShapedRecipe shapedRecipe = ShapedRecipe.Serializer.SHAPED_RECIPE.fromJson(pRecipeId, pSerializedRecipe);
    return new WorktableRecipe(pRecipeId, shapedRecipe.getGroup(), null, shapedRecipe.getWidth(), shapedRecipe.getHeight(), shapedRecipe.getIngredients(), shapedRecipe.getResultItem(null));
  }

  @Override
  public @Nullable WorktableRecipe fromNetwork(ResourceLocation pRecipeId, FriendlyByteBuf pBuffer) {
    ShapedRecipe shapedRecipe = ShapedRecipe.Serializer.SHAPED_RECIPE.fromNetwork(pRecipeId, pBuffer);
    return new WorktableRecipe(pRecipeId, shapedRecipe.getGroup(), null, shapedRecipe.getWidth(), shapedRecipe.getHeight(), shapedRecipe.getIngredients(), shapedRecipe.getResultItem(null));
  }

  @Override
  public void toNetwork(FriendlyByteBuf pBuffer, WorktableRecipe pRecipe) {
    ShapedRecipe.Serializer.SHAPED_RECIPE.toNetwork(pBuffer, pRecipe);
  }
}
