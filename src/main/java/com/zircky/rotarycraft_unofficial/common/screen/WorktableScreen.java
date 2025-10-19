package com.zircky.rotarycraft_unofficial.common.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import com.zircky.rotarycraft_unofficial.RotaryCraftUnofficial;
import com.zircky.rotarycraft_unofficial.common.menu.WorktableMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class WorktableScreen extends AbstractContainerScreen<WorktableMenu> {

  private static final ResourceLocation BACKGROUND_TEXTURE = ResourceLocation.fromNamespaceAndPath(RotaryCraftUnofficial.MODID ,"textures/gui/worktable_gui2.png");

  public WorktableScreen(WorktableMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
    super(pMenu, pPlayerInventory, pTitle);
    this.imageHeight = 176;
    this.imageWidth = 176;
  }

  @Override
  protected void renderBg(GuiGraphics pGuiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
    RenderSystem.setShaderTexture(0, BACKGROUND_TEXTURE);
    pGuiGraphics.blit(BACKGROUND_TEXTURE, leftPos, topPos, 0, 0, imageWidth, imageHeight);
  }

  @Override
  protected void renderLabels(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY) {
    pGuiGraphics.drawString(font, title.getString(), 8, 6, 4210752, false);
  }
}
