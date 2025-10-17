package com.zircky.rotarycraft_unofficial.common.data.register;

import com.tterrag.registrate.util.entry.BlockEntityEntry;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.zircky.rotarycraft_unofficial.api.registry.RCURegistrates;
import com.zircky.rotarycraft_unofficial.api.registry.registry.generator.RCUBlockstateGenerator;
import com.zircky.rotarycraft_unofficial.common.blockentity.power.FlywheelBlockEntity;
import com.zircky.rotarycraft_unofficial.common.blockentity.power.GearboxBlockEntity;
import com.zircky.rotarycraft_unofficial.common.data.block.power.GearboxBlock;
import com.zircky.rotarycraft_unofficial.common.data.material.gearbox.GearboxItem;
import com.zircky.rotarycraft_unofficial.common.data.material.gearbox.GearboxType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class RCUGearboxRegister {
  private static final Map<GearboxType, BlockEntry<GearboxBlock>> GEARBOX_BLOCKS = new HashMap<>();
  private static BlockEntityEntry<GearboxBlockEntity> GEARBOX_ENTITY;
  private static final int[] RATIOS = {2, 4, 8, 16};

  public static void init() {
    for (GearboxType type : GearboxType.getAll()) {
      for (int ratio : RATIOS) {
        String name = type.getId() + "_gearbox_" + ratio;
        BlockEntry<GearboxBlock> block = RCURegistrates.REGISTRATE
            .block(name, props -> new GearboxBlock(type, props.strength(5F).noOcclusion()))
            .blockstate((ctx, prov) -> RCUBlockstateGenerator.generateSimpleBlockModel(prov, ctx.getEntry(), "gearbox/"+name))
            .lang(type.getId().substring(0,1).toUpperCase()+ type.getId().substring(1) + " " + ratio + ":1 Gearbox")
            .item(GearboxItem::new)
            .model((ctx, prov) -> prov.withExistingParent(ctx.getName(), prov.modLoc("block/gearbox/"+name)))
            .build()
            .register();

        GEARBOX_BLOCKS.put(type, block);
      }
    }

    GEARBOX_ENTITY = RCURegistrates.REGISTRATE.blockEntity("gearbox", (BlockEntityType<FlywheelBlockEntity> type, BlockPos pos, BlockState blockState) -> new FlywheelBlockEntity(type, pos, blockState)).validBlocks(GEARBOX_BLOCKS.values().toArray(BlockEntry[]::new)).register();
  }

  public static Collection<BlockEntry<GearboxBlock>> all() {
    return GEARBOX_BLOCKS.values();
  }

  public BlockEntityEntry<GearboxBlockEntity> getEntity() {
    return GEARBOX_ENTITY;
  }
}
