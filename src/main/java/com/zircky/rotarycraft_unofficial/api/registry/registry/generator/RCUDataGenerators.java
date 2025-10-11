package com.zircky.rotarycraft_unofficial.api.registry.registry.generator;

import com.zircky.rotarycraft_unofficial.RotaryCraftUnofficial;
import com.zircky.rotarycraft_unofficial.api.registry.registry.provider.RCULangProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = RotaryCraftUnofficial.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class RCUDataGenerators {
  @SubscribeEvent
  public static void gatherData(GatherDataEvent event) {
    DataGenerator gen = event.getGenerator();
    var outout = gen.getPackOutput();
    if (event.includeClient()) {
      gen.addProvider(true, new RCULangProvider(outout));
    }
  }
}
