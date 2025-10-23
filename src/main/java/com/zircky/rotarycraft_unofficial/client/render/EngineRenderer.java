package com.zircky.rotarycraft_unofficial.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import com.zircky.rotarycraft_unofficial.RotaryCraftUnofficial;
import com.zircky.rotarycraft_unofficial.api.block.entity_block.BaseEngineBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class EngineRenderer<T extends BaseEngineBlockEntity> implements BlockEntityRenderer<T> {
  private final ResourceLocation model;
  private final ResourceLocation texture;

  public EngineRenderer(BlockEntityRendererProvider.Context ctx, String engineId) {
    this.model = ResourceLocation.parse(RotaryCraftUnofficial.MODID + ":block/engine/" + engineId);
    this.texture = ResourceLocation.parse(RotaryCraftUnofficial.MODID + ":textures/block/engine" + engineId + ".png");
  }

  @Override
  public void render(T pEngine, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, int pPackedOverlay) {
    pPoseStack.pushPose();
    pPoseStack.translate(0, 0, 0);

    if (pEngine.isActive()) {
      float angle = pEngine.getInterpolatedRotation(pPartialTick);
      pPoseStack.mulPose(Axis.ZP.rotationDegrees(angle));
    }

    BakedModel bakedModel = Minecraft.getInstance().getModelManager().getModel(model);
    VertexConsumer vertexConsumer = pBuffer.getBuffer(RenderType.cutout());

    Minecraft.getInstance().getBlockRenderer().getModelRenderer().renderModel(pPoseStack.last(), vertexConsumer, pEngine.getBlockState(), bakedModel, 1, 1, 1, pPackedLight, pPackedOverlay);

    pPoseStack.popPose();
  }
}
