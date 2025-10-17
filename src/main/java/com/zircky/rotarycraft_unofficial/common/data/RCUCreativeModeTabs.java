package com.zircky.rotarycraft_unofficial.common.data;

import com.tterrag.registrate.util.entry.RegistryEntry;
import com.zircky.rotarycraft_unofficial.RotaryCraftUnofficial;
import com.zircky.rotarycraft_unofficial.api.item.IComponentItem;
import com.zircky.rotarycraft_unofficial.api.registry.registry.RCURegistrate;
import com.zircky.rotarycraft_unofficial.common.data.ores.RCUOres;
import com.zircky.rotarycraft_unofficial.common.data.tools.RCUTools;
import net.minecraft.core.NonNullList;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.*;
import org.jetbrains.annotations.NotNull;

import static com.zircky.rotarycraft_unofficial.api.registry.RCURegistrates.REGISTRATE;

public class RCUCreativeModeTabs {
  public static RegistryEntry<CreativeModeTab> RotaryCraft = REGISTRATE.defaultCreativeTab("rotarycraft",
          builder -> builder.displayItems(new RegistrateDisplayItemsGenerator("rotarycraft", REGISTRATE))
              .icon(() -> RCUBlocks.GAS_TURBINE.asStack())
              .title(REGISTRATE.addLang("itemGroup",  RotaryCraftUnofficial.id("rotarycraft"),
                  RotaryCraftUnofficial.NAME + " RotaryCraft Containers"))
              .build())
      .register();
  public static RegistryEntry<CreativeModeTab> POWER = REGISTRATE.defaultCreativeTab("power",
          builder -> builder.displayItems(new RegistrateDisplayItemsGenerator("power", REGISTRATE))
              .icon(() -> RCUItems.HSLASteelScrap.asStack())
              .title(REGISTRATE.addLang("itemGroup",  RotaryCraftUnofficial.id("power"),
                  RotaryCraftUnofficial.NAME + " Power"))
              .build())
      .register();
  public static RegistryEntry<CreativeModeTab> TOOLS = REGISTRATE.defaultCreativeTab("tools",
          builder -> builder.displayItems(new RegistrateDisplayItemsGenerator("tools", REGISTRATE))
              .icon(() -> RCUTools.Screwdriver.asStack())
              .title(REGISTRATE.addLang("itemGroup",  RotaryCraftUnofficial.id("tools"),
                  RotaryCraftUnofficial.NAME + " Tools"))
              .build())
      .register();
  public static RegistryEntry<CreativeModeTab> ITEMS = REGISTRATE.defaultCreativeTab("items",
          builder -> builder.displayItems(new RegistrateDisplayItemsGenerator("items", REGISTRATE))
              .icon(() -> RCUItems.BELT.asStack())
              .title(REGISTRATE.addLang("itemGroup",  RotaryCraftUnofficial.id("items"),
                  RotaryCraftUnofficial.NAME + " Items"))
              .build())
      .register();
  public static RegistryEntry<CreativeModeTab> ORES = REGISTRATE.defaultCreativeTab("ores",
          builder -> builder.displayItems(new RegistrateDisplayItemsGenerator("ores", REGISTRATE))
              .icon(() -> RCUOres.COPPER_POWDERED.asStack())
              .title(REGISTRATE.addLang("itemGroup",  RotaryCraftUnofficial.id("ores"),
                  RotaryCraftUnofficial.NAME + " Ores"))
              .build())
      .register();

  public static void init() {}

  public static class RegistrateDisplayItemsGenerator implements CreativeModeTab.DisplayItemsGenerator {

    public final String name;
    public final RCURegistrate registrate;

    public RegistrateDisplayItemsGenerator(String name, RCURegistrate registrate) {
      this.name = name;
      this.registrate = registrate;
    }

    @Override
    public void accept(@NotNull CreativeModeTab.ItemDisplayParameters itemDisplayParameters,
                       @NotNull CreativeModeTab.Output output) {
      var tab = registrate.get(name, Registries.CREATIVE_MODE_TAB);
      for (var entry : registrate.getAll(Registries.BLOCK)) {
        if (!registrate.isInCreativeTab(entry, tab))
          continue;

        Item item = entry.get().asItem();
        if (item == Items.AIR) continue;
        if (item instanceof IComponentItem componentItem) {
          NonNullList<ItemStack> list = NonNullList.create();
          componentItem.fillItemCategory(tab.get(), list);
          list.forEach(output::accept);
        } else {
        output.accept(item);
      }
      }

      for (var entry : registrate.getAll(Registries.ITEM)) {
        if (!registrate.isInCreativeTab(entry, tab))
          continue;
        Item item = entry.get();
        if (item instanceof BlockItem)
          continue;
        if (item instanceof IComponentItem componentItem) {
          NonNullList<ItemStack> list = NonNullList.create();
          componentItem.fillItemCategory(tab.get(), list);
          list.forEach(output::accept);
        } else {
          output.accept(item);
        }
      }
    }
  }
}
