package com.zircky.rotarycraft_unofficial;

import com.zircky.rotarycraft_unofficial.api.registry.RCURegistrates;
import com.zircky.rotarycraft_unofficial.common.RCUItems;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(RotaryCraftUnofficial.MODID)
public class RotaryCraftUnofficial {

  public static final String MODID = "rotarycraft_unofficial";
  public static final String NAME = "RotaryCraft Unofficial";
  private static final Logger LOGGER = LogManager.getLogger();

  public RotaryCraftUnofficial() {
    RotaryCraftUnofficial.init();
    var bus = FMLJavaModLoadingContext.get().getModEventBus();
    bus.register(this);
  }

  public static void init() {
    LOGGER.info("{} is initializing...", NAME);
    RCUItems.init();
    RCURegistrates.REGISTRATE.registerRegistrate();
  }
}
