package com.zircky.rotarycraft_unofficial.integration.jei.recipe;

import com.zircky.rotarycraft_unofficial.RotaryCraftUnofficial;
import com.zircky.rotarycraft_unofficial.common.recipe.WorktableRecipe;
import com.zircky.rotarycraft_unofficial.integration.jei.RCUJEIPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableStatic;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

import static com.zircky.rotarycraft_unofficial.integration.jei.RCUJEIType.JEI_WORKTABLE_TYPE;

public class WorktebleRecipeCategory implements IRecipeCategory<WorktableRecipe> {
  public static final ResourceLocation ID = ResourceLocation.fromNamespaceAndPath(RotaryCraftUnofficial.MODID, "worktable");
  public static final ResourceLocation TEXTURY = ResourceLocation.fromNamespaceAndPath(RotaryCraftUnofficial.MODID, "textures/gui/worktable_gui.png");

  private final IDrawableStatic background;
  private final IDrawable icon;

  public WorktebleRecipeCategory(IGuiHelper guiHelper) {
    this.background = guiHelper.createDrawable(TEXTURY, 5, 11, 166, 70);
    this.icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(BuiltInRegistries.BLOCK.get(ID)));
  }

  @Override
  public RecipeType<WorktableRecipe> getRecipeType() {
    return JEI_WORKTABLE_TYPE;
  }

  @Override
  public Component getTitle() {
    return Component.translatable("gui." + RotaryCraftUnofficial.MODID + ".worktable");
  }

  @Override
  public @Nullable IDrawable getBackground() {
    return background;
  }

  @Override
  public @Nullable IDrawable getIcon() {
    return icon;
  }

  @Override
  public void setRecipe(IRecipeLayoutBuilder builder, WorktableRecipe recipe, IFocusGroup focuses) {
    int startX = 21;
    int startY = 7;
    for (int y = 0; y < 3; y++) {
      for (int x = 0; x < 3; x++) {
        int index = y * 3 + x;
        if (index < recipe.getIngredients().size()) {
          builder.addSlot(RecipeIngredientRole.INPUT, startX + x * 18, startY + y * 18).addIngredients(recipe.getIngredients().get(index));
        }
      }
    }
    builder.addSlot(RecipeIngredientRole.OUTPUT, 111, 24).addItemStack(recipe.getResultItem(null));
  }

  @Override
  public void draw(WorktableRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {

  }
}
