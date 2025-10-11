package com.zircky.rotarycraft_unofficial.api.registry.registry.generator;

import com.tterrag.registrate.providers.RegistrateBlockstateProvider;
import com.zircky.rotarycraft_unofficial.RotaryCraftUnofficial;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

public class RCUBlockstateGenerator {

  public static void generateSimpleBlock(RegistrateBlockstateProvider prov, Block block, String name) {
    prov.simpleBlock(block, prov.models().cubeAll(name, new ResourceLocation(RotaryCraftUnofficial.MODID, "block/" + name)));
  }

}
