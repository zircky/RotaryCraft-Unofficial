package com.zircky.rotarycraft_unofficial.client;

import com.zircky.rotarycraft_unofficial.client.render.ShaftRenderer;
import com.zircky.rotarycraft_unofficial.common.data.register.RCUShaftRegister;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class RCUClientSetup {
  @SubscribeEvent
  public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
    event.registerBlockEntityRenderer(RCUShaftRegister.getEnitity().get(), ShaftRenderer::new);
  }

  @SubscribeEvent
  public static void onClientSetup(FMLClientSetupEvent event) {

  }
}
