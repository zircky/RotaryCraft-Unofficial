package com.zircky.rotarycraft_unofficial;

import com.zircky.rotarycraft_unofficial.api.registry.RCURegistrates;
import com.zircky.rotarycraft_unofficial.common.data.RCUBlocks;
import com.zircky.rotarycraft_unofficial.common.data.RCUCreativeModeTabs;
import com.zircky.rotarycraft_unofficial.common.data.RCUItems;
import com.zircky.rotarycraft_unofficial.common.data.RCUMaterials;
import com.zircky.rotarycraft_unofficial.utils.FormattingUtil;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(RotaryCraftUnofficial.MODID)
public class RotaryCraftUnofficial {

  public static final String MODID = "rotarycraft_unofficial";
  private static final ResourceLocation TEMPLATE_LOCATION = new ResourceLocation(MODID, "");
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
    RCUMaterials.init();
    RCUBlocks.init();
    RCUCreativeModeTabs.init();
    RCURegistrates.REGISTRATE.registerRegistrate();
  }

  public static ResourceLocation id(String path) {
    if (path.isBlank()) {
      return TEMPLATE_LOCATION;
    }

    int i = path.indexOf(':');
    if (i > 0) {
      return new ResourceLocation(path);
    } else if (i == 0) {
      path = path.substring(i + 1);
    }
    // only convert it to camel_case if it has any uppercase to begin with
    if (FormattingUtil.hasUpperCase(path)) {
      path = FormattingUtil.toLowerCaseUnderscore(path);
    }
    return TEMPLATE_LOCATION.withPath(path);
  }
}
