package com.zircky.rotarycraft_unofficial.client.render.engine;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import com.zircky.rotarycraft_unofficial.RotaryCraftUnofficial;
import com.zircky.rotarycraft_unofficial.client.model.engine.ModelDCEngine;
import com.zircky.rotarycraft_unofficial.common.blockentity.engine.DCElectricEngineBlockEntity;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;

public class DCEngineRenderer implements BlockEntityRenderer<DCElectricEngineBlockEntity> {

  private static final ResourceLocation TEXTURE = RotaryCraftUnofficial.id("textures/block/engine/dc_electric_engine.png");

  private final ModelDCEngine model;

  public DCEngineRenderer(BlockEntityRendererProvider.Context ctx) {
    EntityModelSet entityModelSet = new EntityModelSet();
    this.model = new ModelDCEngine(entityModelSet.bakeLayer(ModelDCEngine.LAYER_LOCATION));
  }


  @Override
  public void render(DCElectricEngineBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, int pPackedOverlay) {

    pPoseStack.pushPose();
    pPoseStack.translate(0.5, 1.5, 0.5);
    pPoseStack.scale(1.0F, -1.0F, 1.0F);

    Direction facing = Direction.NORTH;
    if (pBlockEntity.getBlockState().hasProperty(HorizontalDirectionalBlock.FACING)) {
      facing = pBlockEntity.getBlockState().getValue(HorizontalDirectionalBlock.FACING);
    }

    switch (facing) {
      case SOUTH -> pPoseStack.mulPose(Axis.YP.rotationDegrees(180f));
      case WEST -> pPoseStack.mulPose(Axis.YP.rotationDegrees(90f));
      case EAST -> pPoseStack.mulPose(Axis.YP.rotationDegrees(-90f));
      default -> {}
    }

    float rotationDeg = pBlockEntity.getClientRotation(pPartialTick);
    model.getShaft().yRot = (float) Math.toRadians(rotationDeg);

    VertexConsumer vertexConsumer = pBuffer.getBuffer(RenderType.entityCutout(TEXTURE));
    model.renderAll(pPoseStack, vertexConsumer, pPackedLight, pPackedOverlay);

    pPoseStack.popPose();
  }

  @Override
  public boolean shouldRenderOffScreen(DCElectricEngineBlockEntity pBlockEntity) {
    return false;
  }
}
