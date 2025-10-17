package com.zircky.rotarycraft_unofficial.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.zircky.rotarycraft_unofficial.common.blockentity.power.ShaftBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

public class ShaftRenderer implements BlockEntityRenderer<ShaftBlockEntity> {
  public ShaftRenderer(BlockEntityRendererProvider.Context context) {}

  @Override
  public void render(ShaftBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, int pPackedOverlay) {
    BlockState state = pBlockEntity.getBlockState();
    Direction.Axis axis = state.getValue(BlockStateProperties.AXIS);

    ResourceLocation modelLoc = ResourceLocation.parse("rotarycraft_unofficial:block/shaft/wood/wood_shaft_horizontal");
    if (axis == Direction.Axis.Y) {
      modelLoc = ResourceLocation.parse("rotarycraft_unofficial:block/shaft/wood/wood_shaft_vertical");
    }

    BakedModel model = Minecraft.getInstance().getModelManager().getModel(modelLoc);

    pPoseStack.pushPose();

    pPoseStack.translate(0.5, 0.5, 0.5);

    switch (axis) {
      case X -> pPoseStack.mulPose(Axis.ZP.rotationDegrees(90));
      case Y -> {}
      case Z -> pPoseStack.mulPose(Axis.XP.rotationDegrees(90));
    }

    pPoseStack.mulPose(Axis.YP.rotationDegrees(pBlockEntity.rotation));

    Minecraft.getInstance().getBlockRenderer().getModelRenderer().renderModel(
        pPoseStack.last(),
        pBuffer.getBuffer(RenderType.cutout()),
        state,
        model,
        1.0F, 1.0F, 1.0F,
        pPackedLight,
        pPackedOverlay
    );

    pPoseStack.popPose();
  }

  @Override
  public boolean shouldRenderOffScreen(ShaftBlockEntity pBlockEntity) {
    return true;
  }
}
