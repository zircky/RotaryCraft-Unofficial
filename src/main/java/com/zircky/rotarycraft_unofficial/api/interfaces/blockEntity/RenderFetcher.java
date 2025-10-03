package com.zircky.rotarycraft_unofficial.api.interfaces.blockEntity;

import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.level.block.entity.BlockEntity;

public interface RenderFetcher {
  BlockEntityRenderer<? extends BlockEntity> getRenderer(BlockEntityRendererProvider.Context context);
}
