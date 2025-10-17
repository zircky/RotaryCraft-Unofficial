package com.zircky.rotarycraft_unofficial.common.data.register;


import com.tterrag.registrate.util.entry.BlockEntityEntry;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.zircky.rotarycraft_unofficial.api.registry.RCURegistrates;
import com.zircky.rotarycraft_unofficial.common.blockentity.power.ShaftBlockEntity;
import com.zircky.rotarycraft_unofficial.common.data.block.power.ShaftBlock;
import com.zircky.rotarycraft_unofficial.common.data.material.shaft.ShaftMaterial;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class RCUShaftRegister {
  private static final Map<ShaftMaterial, BlockEntry<ShaftBlock>> SHAFT_BLOCKS = new HashMap<>();
  private static BlockEntityEntry<ShaftBlockEntity> SHAFT_ENTITY;
  private static final String mBlock = "block/shaft/";

  public static void init() {
    for (ShaftMaterial mat : ShaftMaterial.all()) {
      String name = mat.getId() + "_shaft";
      BlockEntry<ShaftBlock> block = RCURegistrates.REGISTRATE
          .block(name, props -> new ShaftBlock(props.strength(3F).noOcclusion(), mat))
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
      
      SHAFT_BLOCKS.put(mat, block);
    }
    
    SHAFT_ENTITY = RCURegistrates.REGISTRATE.blockEntity("shaft", (BlockEntityType<ShaftBlockEntity> type, BlockPos pos, BlockState blockState) -> new ShaftBlockEntity(type, pos, blockState)).validBlocks(SHAFT_BLOCKS.values().toArray(BlockEntry[]::new)).register();

  }
  
  public static BlockEntry<ShaftBlock> get(ShaftMaterial mat) {
    return SHAFT_BLOCKS.get(mat);
  }
  
  public static Collection<BlockEntry<ShaftBlock>> all() {
    return SHAFT_BLOCKS.values();
  }

  public static BlockEntityEntry<ShaftBlockEntity> getEnitity() {
    return SHAFT_ENTITY;
  }
}
