package com.zircky.rotarycraft_unofficial.common.data.register;

import com.tterrag.registrate.util.entry.BlockEntityEntry;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.zircky.rotarycraft_unofficial.api.registry.RCURegistrates;
import com.zircky.rotarycraft_unofficial.api.registry.registry.generator.RCUBlockstateGenerator;
import com.zircky.rotarycraft_unofficial.common.blockentity.power.FlywheelBlockEntity;
import com.zircky.rotarycraft_unofficial.common.data.block.power.FlywheelBlock;
import com.zircky.rotarycraft_unofficial.common.data.material.flywheel.FlywheelMaterial;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class RCUFlywheelRegister {
  private static final Map<FlywheelMaterial, BlockEntry<FlywheelBlock>> FLYWHEEL_BLOCKS = new HashMap<>();
  private static BlockEntityEntry<FlywheelBlockEntity> FLYWHEEL_ENTITY;

  public static void init() {
    for (FlywheelMaterial mat : FlywheelMaterial.getAll()) {
      String name = mat.getId() + "_flywheel";
      BlockEntry<FlywheelBlock> block = RCURegistrates.REGISTRATE
          .block(name, props -> new FlywheelBlock(props.strength(5F).noOcclusion(), mat))
          .blockstate((ctx, prov) -> RCUBlockstateGenerator.generateSimpleBlockModel(prov, ctx.getEntry(), "flywheel/"+name))
          .item(BlockItem::new)
          .model((ctx, prov) -> prov.withExistingParent(ctx.getName(), prov.modLoc("block/flywheel/" + name)))
          .build()
          .register();


      FLYWHEEL_BLOCKS.put(mat, block);
    }

    FLYWHEEL_ENTITY = RCURegistrates.REGISTRATE.blockEntity("flywheel", (BlockEntityType<FlywheelBlockEntity> type, BlockPos pos, BlockState blockState) -> new FlywheelBlockEntity(type, pos, blockState)).validBlocks(FLYWHEEL_BLOCKS.values().toArray(BlockEntry[]::new)).register();
  }

  public static Collection<BlockEntry<FlywheelBlock>> all() {
    return FLYWHEEL_BLOCKS.values();
  }

  public BlockEntityEntry<FlywheelBlockEntity> getEntity() {
    return FLYWHEEL_ENTITY;
  }
}
