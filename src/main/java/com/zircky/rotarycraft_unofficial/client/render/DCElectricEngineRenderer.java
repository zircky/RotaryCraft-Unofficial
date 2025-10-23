package com.zircky.rotarycraft_unofficial.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import com.zircky.rotarycraft_unofficial.RotaryCraftUnofficial;
import com.zircky.rotarycraft_unofficial.common.blockentity.engine.DCElectricEngineBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.resources.ResourceLocation;

public class DCElectricEngineRenderer implements BlockEntityRenderer<DCElectricEngineBlockEntity> {
  private static final ResourceLocation ROTOR_MODEL = ResourceLocation.fromNamespaceAndPath(RotaryCraftUnofficial.MODID, "block/engine/dc_electric_engine_rotor");
  private static final ResourceLocation TEXTURE =
      ResourceLocation.fromNamespaceAndPath("rotarycraft_unofficial", "textures/block/engine/dc_electric_engine.png");

  public DCElectricEngineRenderer(BlockEntityRendererProvider.Context ctx) {}

  @Override
  public void render(DCElectricEngineBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, int pPackedOverlay) {
    if (!pBlockEntity.isActive()) return;

    pPoseStack.pushPose();
    pPoseStack.translate(0.0D, 0.0D, 0.0D);

    float angle = pBlockEntity.getInterpolatedRotation(pPartialTick);
    pPoseStack.mulPose(Axis.ZP.rotationDegrees(angle));

    BakedModel bakedModel = Minecraft.getInstance().getModelManager().getModel(ROTOR_MODEL);
    VertexConsumer vertex = pBuffer.getBuffer(RenderType.entityCutout(TEXTURE));

    Minecraft.getInstance().getBlockRenderer().getModelRenderer().renderModel(pPoseStack.last(), vertex, pBlockEntity.getBlockState(), bakedModel, 1, 1, 1, pPackedLight, pPackedOverlay);

    pPoseStack.popPose();
  }
}
