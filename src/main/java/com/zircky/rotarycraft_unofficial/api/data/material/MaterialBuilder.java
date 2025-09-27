package com.zircky.rotarycraft_unofficial.api.data.material;

import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.entry.ItemEntry;
import com.zircky.rotarycraft_unofficial.RotaryCraftUnofficial;
import com.zircky.rotarycraft_unofficial.api.registry.RCURegistrates;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;

import java.util.function.Function;

public class MaterialBuilder {
  // остановился на 786
/*
  private final String name;

  private int color = 0xFFFFFF; // по умолчанию белый
  private Function<BlockBehaviour.Properties, Block> blockFactory =
      props -> new Block(props.mapColor(MapColor.METAL));
  private Item.Properties itemProps = new Item.Properties();

  public MaterialBuilder(String name) {
    this.name = name;
  }

  public MaterialBuilder color(int rgb) {
    this.color = rgb;
    return this;
  }

  public MaterialBuilder block(Function<BlockBehaviour.Properties, Block> factory) {
    this.blockFactory = factory;
    return this;
  }

  public MaterialBuilder itemProps(Item.Properties props) {
    this.itemProps = props;
    return this;
  }

  public ItemEntry<Item> registerItem() {
    return RCURegistrates.REGISTRATE.item(name, Item::new)
        .properties(p -> itemProps)
        .model((ctx, prov) -> prov.generated(ctx, new ResourceLocation(RotaryCraftUnofficial.MODID, "item/iron_ingot")))
        .color(() -> (stack, layer) -> layer == 0 ? color : 0xFFFFFF)
        .register();
  }*/
}
