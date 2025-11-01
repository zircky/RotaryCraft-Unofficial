package com.zircky.rotarycraft_unofficial;

import com.zircky.rotarycraft_unofficial.api.registry.RCURegistrates;
import com.zircky.rotarycraft_unofficial.client.ClientSetup;
import com.zircky.rotarycraft_unofficial.client.model.engine.ModelDCEngine;
import com.zircky.rotarycraft_unofficial.common.RCUMenu;
import com.zircky.rotarycraft_unofficial.common.data.*;
import com.zircky.rotarycraft_unofficial.utils.FormattingUtil;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(RotaryCraftUnofficial.MODID)
public class RotaryCraftUnofficial {

  public static final String MODID = "rotarycraft_unofficial";
  private static final ResourceLocation TEMPLATE_LOCATION = ResourceLocation.fromNamespaceAndPath(MODID, "");
  public static final String NAME = "RotaryCraft Unofficial";
  public static final Logger LOGGER = LogManager.getLogger();

  public RotaryCraftUnofficial() {
    var bus = FMLJavaModLoadingContext.get().getModEventBus();
    RotaryCraftUnofficial.init();
    bus.register(this);

    DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> ClientSetup::initClient);
  }

  public static void init() {
    LOGGER.info("{} is initializing...", NAME);
    RCURegistrates.REGISTRATE.registerRegistrate();
    RCUBlocks.init();
    RCUBlockEntities.init();
    RCUItems.init();
    RCUMaterials.init();
    RCUMenu.init();
    RCURecipes.init();
    RCURecipeType.init();
    RCUCreativeModeTabs.init();
  }

  public static ResourceLocation id(String path) {
    if (path.isBlank()) {
      return TEMPLATE_LOCATION;
    }

    int i = path.indexOf(':');
    if (i > 0) {
      return ResourceLocation.withDefaultNamespace(path);
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
