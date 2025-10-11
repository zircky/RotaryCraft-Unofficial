package com.zircky.rotarycraft_unofficial.common.data.register;


import com.tterrag.registrate.util.entry.BlockEntityEntry;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.zircky.rotarycraft_unofficial.api.registry.RCURegistrates;
import com.zircky.rotarycraft_unofficial.common.blockentity.ShaftBlockEntity;
import com.zircky.rotarycraft_unofficial.common.data.block.ShaftBlock;
import com.zircky.rotarycraft_unofficial.common.data.material.ShaftMaterial;
import net.minecraft.core.Direction;
import net.minecraft.world.item.BlockItem;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class RCUShaftRegister {
  private static final Map<ShaftMaterial, BlockEntry<ShaftBlock>> ShAFT_BLOCKS = new HashMap<>();
  private static BlockEntityEntry<ShaftBlockEntity> SHAFT_ENTITY;
  private static final String mBlock = "block/shaft/";

  public static void init() {
    for (ShaftMaterial mat : ShaftMaterial.all()) {
      String name = mat.getId() + "_shaft";
      BlockEntry<ShaftBlock> block = RCURegistrates.REGISTRATE
          .block(name, props -> new ShaftBlock(props.strength(3F).noOcclusion()))
          .blockstate((ctx, prov) -> prov.getVariantBuilder(ctx.getEntry())
              .partialState().with(ShaftBlock.AXIS, Direction.Axis.X)
              .modelForState()
              .modelFile(prov.models().getExistingFile(prov.modLoc(mBlock + mat.getId() + "/" + name + "_horizontal")))
              .rotationY(90)
              .addModel()

              .partialState().with(ShaftBlock.AXIS, Direction.Axis.Y)
              .modelForState()
              .modelFile(prov.models().getExistingFile(prov.modLoc(mBlock + mat.getId() + "/" + name + "_vertical")))
              .addModel()

              .partialState().with(ShaftBlock.AXIS, Direction.Axis.Z)
              .modelForState()
              .modelFile(prov.models().getExistingFile(prov.modLoc(mBlock + mat.getId() + "/" + name + "_horizontal")))
              .addModel()
          )
          .item(BlockItem::new)
          .model((ctx, prov) -> prov.withExistingParent(ctx.getName(), prov.modLoc(mBlock + mat.getId() + "/" + name + "_horizontal")))
          .build()
          .register();
      
      ShAFT_BLOCKS.put(mat, block);
    }
    
    SHAFT_ENTITY = RCURegistrates.REGISTRATE.blockEntity("shaft", ShaftBlockEntity::new).validBlocks(ShAFT_BLOCKS.values().toArray(BlockEntry[]::new)).register();

  }
  
  public static BlockEntry<ShaftBlock> get(ShaftMaterial mat) {
    return ShAFT_BLOCKS.get(mat);
  }
  
  public static Collection<BlockEntry<ShaftBlock>> alL() {
    return ShAFT_BLOCKS.values();
  }

  public static BlockEntityEntry<ShaftBlockEntity> getEnitity() {
    return SHAFT_ENTITY;
  }
}
