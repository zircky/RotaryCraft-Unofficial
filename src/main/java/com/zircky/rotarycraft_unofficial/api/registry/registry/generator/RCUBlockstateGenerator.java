package com.zircky.rotarycraft_unofficial.api.registry.registry.generator;

import com.tterrag.registrate.providers.RegistrateBlockstateProvider;
import net.minecraft.world.level.block.Block;

public class RCUBlockstateGenerator {

  public static void generateSimpleBlockModel(RegistrateBlockstateProvider prov, Block block, String name) {
    prov.simpleBlock(block, prov.models().getExistingFile(prov.modLoc("block/" + name)));
  }

  public static void generateSimpleBlockBottomTop(RegistrateBlockstateProvider prov, Block block, String name, String side, String bottom, String top) {
    prov.simpleBlock(block, prov.models().cubeBottomTop(name, prov.modLoc("block/"+side), prov.modLoc("block/"+bottom), prov.modLoc("block/"+top)));
  }

}
