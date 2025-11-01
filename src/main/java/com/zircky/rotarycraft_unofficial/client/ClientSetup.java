package com.zircky.rotarycraft_unofficial.client;

import com.zircky.rotarycraft_unofficial.client.model.engine.ModelDCEngine;
import com.zircky.rotarycraft_unofficial.client.render.engine.DCEngineRenderer;
import com.zircky.rotarycraft_unofficial.common.data.RCUBlockEntities;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientSetup {
  public static void initClient() {
    IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
    modBus.addListener(ClientSetup::onRegisterLayers);
    System.out.println("[RotaryCraftUnofficial] ✅ ClientSetup initialized");
  }

  @SubscribeEvent
  public static void onRegisterLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
    event.registerLayerDefinition(ModelDCEngine.LAYER_LOCATION, ModelDCEngine::createBodyLayer);
    System.out.println("[RotaryCraftUnofficial] ✅ Registered model layer: " + ModelDCEngine.LAYER_LOCATION);
  }

  @SubscribeEvent
  public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
    event.registerBlockEntityRenderer(RCUBlockEntities.DC_ELECTRIC_ENGINE_ENTITY.get(), DCEngineRenderer::new);
    System.out.println("[RotaryCraftUnofficial] ✅ Registered renderer: DC Engine");
  }

}
