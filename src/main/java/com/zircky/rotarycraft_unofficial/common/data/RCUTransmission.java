package com.zircky.rotarycraft_unofficial.common.data;

import com.tterrag.registrate.util.entry.BlockEntityEntry;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.zircky.rotarycraft_unofficial.api.registry.RCURegistrates;
import com.zircky.rotarycraft_unofficial.api.registry.registry.RCURegistrate;
import com.zircky.rotarycraft_unofficial.common.blockentity.GearboxBlockEntity;
import com.zircky.rotarycraft_unofficial.common.blockentity.ShaftBlockEntity;
import com.zircky.rotarycraft_unofficial.common.data.block.GearboxBlock;
import com.zircky.rotarycraft_unofficial.common.data.block.ShaftBlock;
import com.zircky.rotarycraft_unofficial.common.registry.MaterialRegistry;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public class RCUTransmission {
  public static final Map<MaterialRegistry, BlockEntry<ShaftBlock>> SHAFTS = new EnumMap<>(MaterialRegistry.class);
  public static final Map<MaterialRegistry, BlockEntry<GearboxBlock>> GEARBOXS = new EnumMap<>(MaterialRegistry.class);


  public static BlockEntityEntry<BlockEntity> SHAFT_BE;
  public static BlockEntityEntry<BlockEntity> GEARBOX_BE;


  static {
    for (MaterialRegistry mat : MaterialRegistry.values()) {
      final MaterialRegistry m = mat;
      String name = m.idName() + "_shaft";
      String nameGear = m.idName() + "_gearbox";
      System.out.println(name);
      BlockBehaviour.Properties props = BlockBehaviour.Properties.copy(m.getBaseBlock()).noOcclusion();
      BlockEntry<ShaftBlock> entry = RCURegistrates.REGISTRATE.block(name, p -> new ShaftBlock(m, props))
          .properties(p -> p.isValidSpawn((state, level, pos, ent) -> false))
          .item(BlockItem::new)
          .model((ctx, prov) -> prov.withExistingParent(ctx.getName(), prov.modLoc("block/" + name)))
          .lang(m.name().substring(0,1).toUpperCase() + m.name().substring(1) + " Shaft")
          .build()
          .register();

      for (GearboxBlock.GearRatio ger :  GearboxBlock.GearRatio.values()) {
        final String nameGearRatio = nameGear + ger.getRatio() + "x";
        System.out.println("Test: " + nameGearRatio);
        BlockEntry<GearboxBlock> gearbox = RCURegistrates.REGISTRATE.block(nameGearRatio, p -> new GearboxBlock(m, props, ger))
            .properties(p -> p.isValidSpawn(((pState, pLevel, pPos, pValue) -> false)))
            .item(BlockItem::new)
            .model((ctx, prov) -> prov.withExistingParent(ctx.getName(), prov.modLoc("block/" + nameGear)))
            .lang(m.name().substring(0,1).toUpperCase()+ m.name().substring(1) + ger.getRatio() + ":1 Gearbox")
            .build()
            .register();

        GEARBOXS.put(m, gearbox);
      }


      SHAFTS.put(m, entry);
    }

    BlockEntry<?>[] arrShaft = SHAFTS.values().toArray(new BlockEntry[0]);
    BlockEntry<?>[] arrGearbox = GEARBOXS.values().toArray(new BlockEntry[0]);

    SHAFT_BE = RCURegistrates.REGISTRATE.blockEntity("shaft", ShaftBlockEntity::new)
        .validBlocks(Arrays.stream(arrShaft).toArray(BlockEntry[]::new))
        .register();
    GEARBOX_BE = RCURegistrates.REGISTRATE.blockEntity("gearbox", GearboxBlockEntity::new)
        .validBlocks(Arrays.stream(arrGearbox).toArray(BlockEntry[]::new))
        .register();

  }


  public static void init() {}
}
