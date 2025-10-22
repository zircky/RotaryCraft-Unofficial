package com.zircky.rotarycraft_unofficial.common.data.block;

import com.zircky.rotarycraft_unofficial.api.registry.RCURegistrates;
import com.zircky.rotarycraft_unofficial.api.registry.registry.generator.RCUBlockstateGenerator;
import com.zircky.rotarycraft_unofficial.common.data.RCUCreativeModeTabs;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.*;

import static com.zircky.rotarycraft_unofficial.common.data.RCUBlocks.*;

public class RCUBlock {
  static {
    RCURegistrates.REGISTRATE.creativeModeTab(() -> RCUCreativeModeTabs.RotaryCraft);
  }

  private static void register() {
    STEEL_BLOCK = RCURegistrates.REGISTRATE.block("steel_block", Block::new)
        .lang("Steel Block")
        .blockstate((ctx, prov) -> prov.simpleBlock(ctx.getEntry()))
        .item(BlockItem::new)
        .model((ctx, prov) -> prov.withExistingParent(ctx.getName(), prov.modLoc("block/steel_block")))
        .build()
        .register();

    ANTHRACITE_BLOCK = RCURegistrates.REGISTRATE.block("anthracite_block", Block::new)
        .lang("Anthracite Block")
        .blockstate((ctx, prov) -> prov.simpleBlock(ctx.getEntry()))
        .item(BlockItem::new)
        .model((ctx, prov) -> prov.withExistingParent(ctx.getName(), prov.modLoc("block/anthracite_block")))
        .build()
        .register();

    LONSDALEITE_BLOCK = RCURegistrates.REGISTRATE.block("lonsdaleite_block", Block::new)
        .lang("Lonsdaleite Block")
        .blockstate((ctx, prov) -> prov.simpleBlock(ctx.getEntry()))
        .item(BlockItem::new)
        .model((ctx, porv)-> porv.withExistingParent(ctx.getName(), porv.modLoc("block/lonsdaleite_block")))
        .build()
        .register();

    BORER_SHIELD_BLOCK = RCURegistrates.REGISTRATE.block("borer_shield_block", Block::new)
        .lang("Borer Shield Block")
        .blockstate((ctx, prov) -> prov.simpleBlock(ctx.getEntry()))
        .item(BlockItem::new)
        .model((ctx, prov) -> prov.withExistingParent(ctx.getName(), prov.modLoc("block/borer_shield_block")))
        .build()
        .register();
    
    BEDROCK_INGOT_BLOCK = RCURegistrates.REGISTRATE.block("bedrock_ingot_block", Block::new)
        .lang("Bedrock ingot Block")
        .blockstate((ctx, prov) -> prov.simpleBlock(ctx.getEntry()))
        .item(BlockItem::new)
        .model((ctx, prov) -> prov.withExistingParent(ctx.getName(), prov.modLoc("block/bedrock_ingot_block")))
        .build()
        .register();
    
    COAL_COKE_BLOCK = RCURegistrates.REGISTRATE.block("coal_coke_block", Block::new)
        .lang("Coal Coke Block")
        .blockstate((ctx, prov) -> prov.simpleBlock(ctx.getEntry()))
        .item(BlockItem::new)
        .model((ctx, prov) -> prov.withExistingParent(ctx.getName(), prov.modLoc("block/coal_coke_block")))
        .build()
        .register();

    BLAST_GLASS = RCURegistrates.REGISTRATE.block("blast_glass", GlassBlock::new)
        .lang("Blast Glass")
        .initialProperties(() -> Blocks.GLASS)
        .properties(p -> p.noOcclusion().strength(10F))
        .addLayer(() -> RenderType::translucent)
        .blockstate((ctx, prov) -> prov.simpleBlock(ctx.getEntry()))
        .item(BlockItem::new)
        .model((ctx, prov) -> prov.withExistingParent(ctx.getName(),  prov.modLoc("block/blast_glass")))
        .build()
        .register();

    BLAST_GLASS_PANE = RCURegistrates.REGISTRATE.block("blast_glass_pane", IronBarsBlock::new)
        .lang("Blast Glass Pane")
        .initialProperties(() -> Blocks.GLASS_PANE)
        .properties(p -> p.strength(12.5F).sound(SoundType.GLASS).noOcclusion())
        .addLayer(() -> RenderType::translucent)
        .blockstate((ctx, prov) -> prov.paneBlock(ctx.getEntry(), "blast_glass", prov.modLoc("block/blast_glass"), prov.modLoc("block/blast_glass_sibe")))
        .item()
        .model((ctx, prov) -> prov.withExistingParent(ctx.getName(), prov.modLoc("item/blast_glass_pane")))
        .build()
        .register();

    BLAST_FURNACE = RCURegistrates.REGISTRATE.block("blast_furnace", BlastFurnaceBlock::new)
        .lang("Blast Furnace")
        .blockstate((ctx, prov) -> prov.simpleBlock(ctx.getEntry(), prov.models().orientableVertical(ctx.getName(), prov.modLoc("block/blast_furnace/blast_furnace_side"), prov.modLoc("block/blast_furnace/blast_furnace_front"))))
        .item()
        .model((ctx, prov) -> prov.withExistingParent(ctx.getName(), prov.modLoc("block/blast_furnace")))
        .build()
        .register();

    WORKTABLE = RCURegistrates.REGISTRATE.block("worktable", WorktableBlock::new)
        .lang("Worktable")
        .blockstate((ctx, prov) -> RCUBlockstateGenerator.generateSimpleBlockBottomTop(prov, ctx.getEntry(), ctx.getName(), "worktable/worktable", "worktable/worktable_bottom", "worktable/worktable_top"))
        .item(BlockItem::new)
        .model((ctx, prov) -> prov.withExistingParent(ctx.getName(), prov.modLoc("block/worktable")))
        .build()
        .register();
  }

  public static void init() {
    register();
  }
}
