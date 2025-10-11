package com.zircky.rotarycraft_unofficial.common.data.ores;

import com.tterrag.registrate.util.entry.ItemEntry;
import com.zircky.rotarycraft_unofficial.api.registry.RCURegistrates;
import com.zircky.rotarycraft_unofficial.common.data.RCUCreativeModeTabs;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;
import java.util.function.Consumer;

public class RCUOres {
  /*
  ore procces
  1 powdered
  2 slurry
  3 solution
  4 flakes
   */

  static {
    RCURegistrates.REGISTRATE.creativeModeTab(() -> RCUCreativeModeTabs.ORES);
  }

  public static ItemEntry<Item> TIN_POWDERED;
  public static ItemEntry<Item> TIN_SLURRY;
  public static ItemEntry<Item> TIN_SOLUTION;
  public static ItemEntry<Item> TIN_FLAKES;
  public static ItemEntry<Item> TIN_ITEM;
  public static ItemEntry<Item> TIN_DUST;
  public static ItemEntry<Item> TIN_GEM;
  public static ItemEntry<Item> TIN_INGOT;

  public static ItemEntry<Item> COPPER_POWDERED;
  public static ItemEntry<Item> COPPER_SLURRY;
  public static ItemEntry<Item> COPPER_SOLUTION;
  public static ItemEntry<Item> COPPER_FLAKES;
  public static ItemEntry<Item> COPPER_ITEM;
  public static ItemEntry<Item> COPPER_DUST;
  public static ItemEntry<Item> COPPER_GEM;
  public static ItemEntry<Item> COPPER_INGOT;

  public static ItemEntry<Item> LEAD_POWDERED;
  public static ItemEntry<Item> LEAD_SLURRY;
  public static ItemEntry<Item> LEAD_SOLUTION;
  public static ItemEntry<Item> LEAD_FLAKES;
  public static ItemEntry<Item> LEAD_ITEM;
  public static ItemEntry<Item> LEAD_DUST;
  public static ItemEntry<Item> LEAD_GEM;
  public static ItemEntry<Item> LEAD_INGOT;

  public static ItemEntry<Item> NICKEL_POWDERED;
  public static ItemEntry<Item> NICKEL_SLURRY;
  public static ItemEntry<Item> NICKEL_SOLUTION;
  public static ItemEntry<Item> NICKEL_FLAKES;
  public static ItemEntry<Item> NICKEL_ITEM;
  public static ItemEntry<Item> NICKEL_DUST;
  public static ItemEntry<Item> NICKEL_GEM;
  public static ItemEntry<Item> NICKEL_INGOT;

  public static ItemEntry<Item> SILVER_POWDERED;
  public static ItemEntry<Item> SILVER_SLURRY;
  public static ItemEntry<Item> SILVER_SOLUTION;
  public static ItemEntry<Item> SILVER_FLAKES;
  public static ItemEntry<Item> SILVER_ITEM;
  public static ItemEntry<Item> SILVER_DUST;
  public static ItemEntry<Item> SILVER_GEM;
  public static ItemEntry<Item> SILVER_INGOT;

  public static ItemEntry<Item> GALENA_POWDERED;
  public static ItemEntry<Item> GALENA_SLURRY;
  public static ItemEntry<Item> GALENA_SOLUTION;
  public static ItemEntry<Item> GALENA_FLAKES;
  public static ItemEntry<Item> GALENA_ITEM;
  public static ItemEntry<Item> GALENA_DUST;
  public static ItemEntry<Item> GALENA_GEM;
  public static ItemEntry<Item> GALENA_INGOT;

  public static ItemEntry<Item> ALUMINUM_POWDERED;
  public static ItemEntry<Item> ALUMINUM_SLURRY;
  public static ItemEntry<Item> ALUMINUM_SOLUTION;
  public static ItemEntry<Item> ALUMINUM_FLAKES;
  public static ItemEntry<Item> ALUMINUM_ITEM;
  public static ItemEntry<Item> ALUMINUM_DUST;
  public static ItemEntry<Item> ALUMINUM_GEM;
  public static ItemEntry<Item> ALUMINUM_INGOT;

  public static ItemEntry<Item> IRIDIUM_POWDERED;
  public static ItemEntry<Item> IRIDIUM_SLURRY;
  public static ItemEntry<Item> IRIDIUM_SOLUTION;
  public static ItemEntry<Item> IRIDIUM_FLAKES;
  public static ItemEntry<Item> IRIDIUM_ITEM;
  public static ItemEntry<Item> IRIDIUM_DUST;
  public static ItemEntry<Item> IRIDIUM_GEM;
  public static ItemEntry<Item> IRIDIUM_INGOT;

  public static ItemEntry<Item> FIRESTONE_POWDERED;
  public static ItemEntry<Item> FIRESTONE_SLURRY;
  public static ItemEntry<Item> FIRESTONE_SOLUTION;
  public static ItemEntry<Item> FIRESTONE_FLAKES;
  public static ItemEntry<Item> FIRESTONE_ITEM;
  public static ItemEntry<Item> FIRESTONE_DUST;
  public static ItemEntry<Item> FIRESTONE_GEM;
  public static ItemEntry<Item> FIRESTONE_INGOT;

  public static ItemEntry<Item> CERTUSQUARTZ_POWDERED;
  public static ItemEntry<Item> CERTUSQUARTZ_SLURRY;
  public static ItemEntry<Item> CERTUSQUARTZ_SOLUTION;
  public static ItemEntry<Item> CERTUSQUARTZ_FLAKES;
  public static ItemEntry<Item> CERTUSQUARTZ_ITEM;
  public static ItemEntry<Item> CERTUSQUARTZ_DUST;
  public static ItemEntry<Item> CERTUSQUARTZ_GEM;
  public static ItemEntry<Item> CERTUSQUARTZ_INGOT;

  public static ItemEntry<Item> URANIUM_POWDERED;
  public static ItemEntry<Item> URANIUM_SLURRY;
  public static ItemEntry<Item> URANIUM_SOLUTION;
  public static ItemEntry<Item> URANIUM_FLAKES;
  public static ItemEntry<Item> URANIUM_ITEM;
  public static ItemEntry<Item> URANIUM_DUST;
  public static ItemEntry<Item> URANIUM_GEM;
  public static ItemEntry<Item> URANIUM_INGOT;

  public static ItemEntry<Item> CINNABAR_POWDERED;
  public static ItemEntry<Item> CINNABAR_SLURRY;
  public static ItemEntry<Item> CINNABAR_SOLUTION;
  public static ItemEntry<Item> CINNABAR_FLAKES;
  public static ItemEntry<Item> CINNABAR_ITEM;
  public static ItemEntry<Item> CINNABAR_DUST;
  public static ItemEntry<Item> CINNABAR_GEM;
  public static ItemEntry<Item> CINNABAR_INGOT;

  public static ItemEntry<Item> AMBER_POWDERED;
  public static ItemEntry<Item> AMBER_SLURRY;
  public static ItemEntry<Item> AMBER_SOLUTION;
  public static ItemEntry<Item> AMBER_FLAKES;
  public static ItemEntry<Item> AMBER_ITEM;
  public static ItemEntry<Item> AMBER_DUST;
  public static ItemEntry<Item> AMBER_GEM;
  public static ItemEntry<Item> AMBER_INGOT;

  public static ItemEntry<Item> APATITE_POWDERED;
  public static ItemEntry<Item> APATITE_SLURRY;
  public static ItemEntry<Item> APATITE_SOLUTION;
  public static ItemEntry<Item> APATITE_FLAKES;
  public static ItemEntry<Item> APATITE_ITEM;
  public static ItemEntry<Item> APATITE_DUST;
  public static ItemEntry<Item> APATITE_GEM;
  public static ItemEntry<Item> APATITE_INGOT;

  public static ItemEntry<Item> SALTPETER_POWDERED;
  public static ItemEntry<Item> SALTPETER_SLURRY;
  public static ItemEntry<Item> SALTPETER_SOLUTION;
  public static ItemEntry<Item> SALTPETER_FLAKES;
  public static ItemEntry<Item> SALTPETER_ITEM;
  public static ItemEntry<Item> SALTPETER_DUST;
  public static ItemEntry<Item> SALTPETER_GEM;
  public static ItemEntry<Item> SALTPETER_INGOT;

  public static ItemEntry<Item> TUNGSTEN_POWDERED;
  public static ItemEntry<Item> TUNGSTEN_SLURRY;
  public static ItemEntry<Item> TUNGSTEN_SOLUTION;
  public static ItemEntry<Item> TUNGSTEN_FLAKES;
  public static ItemEntry<Item> TUNGSTEN_ITEM;
  public static ItemEntry<Item> TUNGSTEN_DUST;
  public static ItemEntry<Item> TUNGSTEN_GEM;
  public static ItemEntry<Item> TUNGSTEN_INGOT;

  public static ItemEntry<Item> NIKOLITE_POWDERED;
  public static ItemEntry<Item> NIKOLITE_SLURRY;
  public static ItemEntry<Item> NIKOLITE_SOLUTION;
  public static ItemEntry<Item> NIKOLITE_FLAKES;
  public static ItemEntry<Item> NIKOLITE_ITEM;
  public static ItemEntry<Item> NIKOLITE_DUST;
  public static ItemEntry<Item> NIKOLITE_GEM;
  public static ItemEntry<Item> NIKOLITE_INGOT;

  public static ItemEntry<Item> PERIDOT_POWDERED;
  public static ItemEntry<Item> PERIDOT_SLURRY;
  public static ItemEntry<Item> PERIDOT_SOLUTION;
  public static ItemEntry<Item> PERIDOT_FLAKES;
  public static ItemEntry<Item> PERIDOT_ITEM;
  public static ItemEntry<Item> PERIDOT_DUST;
  public static ItemEntry<Item> PERIDOT_GEM;
  public static ItemEntry<Item> PERIDOT_INGOT;

  public static ItemEntry<Item> RUBY_POWDERED;
  public static ItemEntry<Item> RUBY_SLURRY;
  public static ItemEntry<Item> RUBY_SOLUTION;
  public static ItemEntry<Item> RUBY_FLAKES;
  public static ItemEntry<Item> RUBY_ITEM;
  public static ItemEntry<Item> RUBY_DUST;
  public static ItemEntry<Item> RUBY_GEM;
  public static ItemEntry<Item> RUBY_INGOT;

  public static ItemEntry<Item> SAPPHIRE_POWDERED;
  public static ItemEntry<Item> SAPPHIRE_SLURRY;
  public static ItemEntry<Item> SAPPHIRE_SOLUTION;
  public static ItemEntry<Item> SAPPHIRE_FLAKES;
  public static ItemEntry<Item> SAPPHIRE_ITEM;
  public static ItemEntry<Item> SAPPHIRE_DUST;
  public static ItemEntry<Item> SAPPHIRE_GEM;
  public static ItemEntry<Item> SAPPHIRE_INGOT;

  public static ItemEntry<Item> MONAZIT_POWDERED;
  public static ItemEntry<Item> MONAZIT_SLURRY;
  public static ItemEntry<Item> MONAZIT_SOLUTION;
  public static ItemEntry<Item> MONAZIT_FLAKES;
  public static ItemEntry<Item> MONAZIT_ITEM;
  public static ItemEntry<Item> MONAZIT_DUST;
  public static ItemEntry<Item> MONAZIT_GEM;
  public static ItemEntry<Item> MONAZIT_INGOT;

  public static ItemEntry<Item> FORCE_POWDERED;
  public static ItemEntry<Item> FORCE_SLURRY;
  public static ItemEntry<Item> FORCE_SOLUTION;
  public static ItemEntry<Item> FORCE_FLAKES;
  public static ItemEntry<Item> FORCE_ITEM;
  public static ItemEntry<Item> FORCE_DUST;
  public static ItemEntry<Item> FORCE_GEM;
  public static ItemEntry<Item> FORCE_INGOT;

  public static ItemEntry<Item> COBALT_POWDERED;
  public static ItemEntry<Item> COBALT_SLURRY;
  public static ItemEntry<Item> COBALT_SOLUTION;
  public static ItemEntry<Item> COBALT_FLAKES;
  public static ItemEntry<Item> COBALT_ITEM;
  public static ItemEntry<Item> COBALT_DUST;
  public static ItemEntry<Item> COBALT_GEM;
  public static ItemEntry<Item> COBALT_INGOT;

  // Netherit

  public static ItemEntry<Item> PLATINUM_POWDERED;
  public static ItemEntry<Item> PLATINUM_SLURRY;
  public static ItemEntry<Item> PLATINUM_SOLUTION;
  public static ItemEntry<Item> PLATINUM_FLAKES;
  public static ItemEntry<Item> PLATINUM_ITEM;
  public static ItemEntry<Item> PLATINUM_DUST;
  public static ItemEntry<Item> PLATINUM_GEM;
  public static ItemEntry<Item> PLATINUM_INGOT;

  public static ItemEntry<Item> ZINC_POWDERED;
  public static ItemEntry<Item> ZINC_SLURRY;
  public static ItemEntry<Item> ZINC_SOLUTION;
  public static ItemEntry<Item> ZINC_FLAKES;
  public static ItemEntry<Item> ZINC_ITEM;
  public static ItemEntry<Item> ZINC_DUST;
  public static ItemEntry<Item> ZINC_GEM;
  public static ItemEntry<Item> ZINC_INGOT;

  public static ItemEntry<Item> OSMIUM_POWDERED;
  public static ItemEntry<Item> OSMIUM_SLURRY;
  public static ItemEntry<Item> OSMIUM_SOLUTION;
  public static ItemEntry<Item> OSMIUM_FLAKES;
  public static ItemEntry<Item> OSMIUM_ITEM;
  public static ItemEntry<Item> OSMIUM_DUST;
  public static ItemEntry<Item> OSMIUM_GEM;
  public static ItemEntry<Item> OSMIUM_INGOT;

  public static ItemEntry<Item> PIGIRON_POWDERED;
  public static ItemEntry<Item> PIGIRON_SLURRY;
  public static ItemEntry<Item> PIGIRON_SOLUTION;
  public static ItemEntry<Item> PIGIRON_FLAKES;
  public static ItemEntry<Item> PIGIRON_ITEM;
  public static ItemEntry<Item> PIGIRON_DUST;
  public static ItemEntry<Item> PIGIRON_GEM;
  public static ItemEntry<Item> PIGIRON_INGOT;

  public static ItemEntry<Item> SULFUR_POWDERED;
  public static ItemEntry<Item> SULFUR_SLURRY;
  public static ItemEntry<Item> SULFUR_SOLUTION;
  public static ItemEntry<Item> SULFUR_FLAKES;
  public static ItemEntry<Item> SULFUR_ITEM;
  public static ItemEntry<Item> SULFUR_DUST;
  public static ItemEntry<Item> SULFUR_GEM;
  public static ItemEntry<Item> SULFUR_INGOT;

  public static ItemEntry<Item> PITCHBLENDE_POWDERED;
  public static ItemEntry<Item> PITCHBLENDE_SLURRY;
  public static ItemEntry<Item> PITCHBLENDE_SOLUTION;
  public static ItemEntry<Item> PITCHBLENDE_FLAKES;
  public static ItemEntry<Item> PITCHBLENDE_ITEM;
  public static ItemEntry<Item> PITCHBLENDE_DUST;
  public static ItemEntry<Item> PITCHBLENDE_GEM;
  public static ItemEntry<Item> PITCHBLENDE_INGOT;

  public static ItemEntry<Item> CADMIUM_POWDERED;
  public static ItemEntry<Item> CADMIUM_SLURRY;
  public static ItemEntry<Item> CADMIUM_SOLUTION;
  public static ItemEntry<Item> CADMIUM_FLAKES;
  public static ItemEntry<Item> CADMIUM_ITEM;
  public static ItemEntry<Item> CADMIUM_DUST;
  public static ItemEntry<Item> CADMIUM_GEM;
  public static ItemEntry<Item> CADMIUM_INGOT;

  public static ItemEntry<Item> INDIUM_POWDERED;
  public static ItemEntry<Item> INDIUM_SLURRY;
  public static ItemEntry<Item> INDIUM_SOLUTION;
  public static ItemEntry<Item> INDIUM_FLAKES;
  public static ItemEntry<Item> INDIUM_ITEM;
  public static ItemEntry<Item> INDIUM_DUST;
  public static ItemEntry<Item> INDIUM_GEM;
  public static ItemEntry<Item> INDIUM_INGOT;

  public static ItemEntry<Item> FLUORITE_POWDERED;
  public static ItemEntry<Item> FLUORITE_SLURRY;
  public static ItemEntry<Item> FLUORITE_SOLUTION;
  public static ItemEntry<Item> FLUORITE_FLAKES;
  public static ItemEntry<Item> FLUORITE_ITEM;
  public static ItemEntry<Item> FLUORITE_DUST;
  public static ItemEntry<Item> FLUORITE_GEM;
  public static ItemEntry<Item> FLUORITE_INGOT;

  public static ItemEntry<Item> BAUXITE_POWDERED;
  public static ItemEntry<Item> BAUXITE_SLURRY;
  public static ItemEntry<Item> BAUXITE_SOLUTION;
  public static ItemEntry<Item> BAUXITE_FLAKES;
  public static ItemEntry<Item> BAUXITE_ITEM;
  public static ItemEntry<Item> BAUXITE_DUST;
  public static ItemEntry<Item> BAUXITE_GEM;
  public static ItemEntry<Item> BAUXITE_INGOT;

  public static ItemEntry<Item> SODALITE_POWDERED;
  public static ItemEntry<Item> SODALITE_SLURRY;
  public static ItemEntry<Item> SODALITE_SOLUTION;
  public static ItemEntry<Item> SODALITE_FLAKES;
  public static ItemEntry<Item> SODALITE_ITEM;
  public static ItemEntry<Item> SODALITE_DUST;
  public static ItemEntry<Item> SODALITE_GEM;
  public static ItemEntry<Item> SODALITE_INGOT;

  public static ItemEntry<Item> PYRITE_POWDERED;
  public static ItemEntry<Item> PYRITE_SLURRY;
  public static ItemEntry<Item> PYRITE_SOLUTION;
  public static ItemEntry<Item> PYRITE_FLAKES;
  public static ItemEntry<Item> PYRITE_ITEM;
  public static ItemEntry<Item> PYRITE_DUST;
  public static ItemEntry<Item> PYRITE_GEM;
  public static ItemEntry<Item> PYRITE_INGOT;

  public static ItemEntry<Item> AMMONIUM_POWDERED;
  public static ItemEntry<Item> AMMONIUM_SLURRY;
  public static ItemEntry<Item> AMMONIUM_SOLUTION;
  public static ItemEntry<Item> AMMONIUM_FLAKES;
  public static ItemEntry<Item> AMMONIUM_ITEM;
  public static ItemEntry<Item> AMMONIUM_DUST;
  public static ItemEntry<Item> AMMONIUM_GEM;
  public static ItemEntry<Item> AMMONIUM_INGOT;

  public static ItemEntry<Item> CALCITE_POWDERED;
  public static ItemEntry<Item> CALCITE_SLURRY;
  public static ItemEntry<Item> CALCITE_SOLUTION;
  public static ItemEntry<Item> CALCITE_FLAKES;
  public static ItemEntry<Item> CALCITE_ITEM;
  public static ItemEntry<Item> CALCITE_DUST;
  public static ItemEntry<Item> CALCITE_GEM;
  public static ItemEntry<Item> CALCITE_INGOT;

  public static ItemEntry<Item> CHIMERITE_POWDERED;
  public static ItemEntry<Item> CHIMERITE_SLURRY;
  public static ItemEntry<Item> CHIMERITE_SOLUTION;
  public static ItemEntry<Item> CHIMERITE_FLAKES;
  public static ItemEntry<Item> CHIMERITE_ITEM;
  public static ItemEntry<Item> CHIMERITE_DUST;
  public static ItemEntry<Item> CHIMERITE_GEM;
  public static ItemEntry<Item> CHIMERITE_INGOT;

  public static ItemEntry<Item> VINTEUM_POWDERED;
  public static ItemEntry<Item> VINTEUM_SLURRY;
  public static ItemEntry<Item> VINTEUM_SOLUTION;
  public static ItemEntry<Item> VINTEUM_FLAKES;
  public static ItemEntry<Item> VINTEUM_ITEM;
  public static ItemEntry<Item> VINTEUM_DUST;
  public static ItemEntry<Item> VINTEUM_GEM;
  public static ItemEntry<Item> VINTEUM_INGOT;

  public static ItemEntry<Item> BLUETOPAZ_POWDERED;
  public static ItemEntry<Item> BLUETOPAZ_SLURRY;
  public static ItemEntry<Item> BLUETOPAZ_SOLUTION;
  public static ItemEntry<Item> BLUETOPAZ_FLAKES;
  public static ItemEntry<Item> BLUETOPAZ_ITEM;
  public static ItemEntry<Item> BLUETOPAZ_DUST;
  public static ItemEntry<Item> BLUETOPAZ_GEM;
  public static ItemEntry<Item> BLUETOPAZ_INGOT;

  public static ItemEntry<Item> MOONSTONE_POWDERED;
  public static ItemEntry<Item> MOONSTONE_SLURRY;
  public static ItemEntry<Item> MOONSTONE_SOLUTION;
  public static ItemEntry<Item> MOONSTONE_FLAKES;
  public static ItemEntry<Item> MOONSTONE_ITEM;
  public static ItemEntry<Item> MOONSTONE_DUST;
  public static ItemEntry<Item> MOONSTONE_GEM;
  public static ItemEntry<Item> MOONSTONE_INGOT;

  public static ItemEntry<Item> SUNSTONE_POWDERED;
  public static ItemEntry<Item> SUNSTONE_SLURRY;
  public static ItemEntry<Item> SUNSTONE_SOLUTION;
  public static ItemEntry<Item> SUNSTONE_FLAKES;
  public static ItemEntry<Item> SUNSTONE_ITEM;
  public static ItemEntry<Item> SUNSTONE_DUST;
  public static ItemEntry<Item> SUNSTONE_GEM;
  public static ItemEntry<Item> SUNSTONE_INGOT;

  public static ItemEntry<Item> TITANIUM_POWDERED;
  public static ItemEntry<Item> TITANIUM_SLURRY;
  public static ItemEntry<Item> TITANIUM_SOLUTION;
  public static ItemEntry<Item> TITANIUM_FLAKES;
  public static ItemEntry<Item> TITANIUM_ITEM;
  public static ItemEntry<Item> TITANIUM_DUST;
  public static ItemEntry<Item> TITANIUM_GEM;
  public static ItemEntry<Item> TITANIUM_INGOT;

  public static ItemEntry<Item> MAGMANITE_POWDERED;
  public static ItemEntry<Item> MAGMANITE_SLURRY;
  public static ItemEntry<Item> MAGMANITE_SOLUTION;
  public static ItemEntry<Item> MAGMANITE_FLAKES;
  public static ItemEntry<Item> MAGMANITE_ITEM;
  public static ItemEntry<Item> MAGMANITE_DUST;
  public static ItemEntry<Item> MAGMANITE_GEM;
  public static ItemEntry<Item> MAGMANITE_INGOT;

  public static ItemEntry<Item> MAGNETITE_POWDERED;
  public static ItemEntry<Item> MAGNETITE_SLURRY;
  public static ItemEntry<Item> MAGNETITE_SOLUTION;
  public static ItemEntry<Item> MAGNETITE_FLAKES;
  public static ItemEntry<Item> MAGNETITE_ITEM;
  public static ItemEntry<Item> MAGNETITE_DUST;
  public static ItemEntry<Item> MAGNETITE_GEM;
  public static ItemEntry<Item> MAGNETITE_INGOT;

  public static ItemEntry<Item> ESSENCE_POWDERED;
  public static ItemEntry<Item> ESSENCE_SLURRY;
  public static ItemEntry<Item> ESSENCE_SOLUTION;
  public static ItemEntry<Item> ESSENCE_FLAKES;
  public static ItemEntry<Item> ESSENCE_ITEM;
  public static ItemEntry<Item> ESSENCE_DUST;
  public static ItemEntry<Item> ESSENCE_GEM;
  public static ItemEntry<Item> ESSENCE_INGOT;

  public static ItemEntry<Item> MIMICHITE_POWDERED;
  public static ItemEntry<Item> MIMICHITE_SLURRY;
  public static ItemEntry<Item> MIMICHITE_SOLUTION;
  public static ItemEntry<Item> MIMICHITE_FLAKES;
  public static ItemEntry<Item> MIMICHITE_ITEM;
  public static ItemEntry<Item> MIMICHITE_DUST;
  public static ItemEntry<Item> MIMICHITE_GEM;
  public static ItemEntry<Item> MIMICHITE_INGOT;

  public static ItemEntry<Item> QUANTUM_POWDERED;
  public static ItemEntry<Item> QUANTUM_SLURRY;
  public static ItemEntry<Item> QUANTUM_SOLUTION;
  public static ItemEntry<Item> QUANTUM_FLAKES;
  public static ItemEntry<Item> QUANTUM_ITEM;
  public static ItemEntry<Item> QUANTUM_DUST;
  public static ItemEntry<Item> QUANTUM_GEM;
  public static ItemEntry<Item> QUANTUM_INGOT;

  public static ItemEntry<Item> DARKIRON_POWDERED;
  public static ItemEntry<Item> DARKIRON_SLURRY;
  public static ItemEntry<Item> DARKIRON_SOLUTION;
  public static ItemEntry<Item> DARKIRON_FLAKES;
  public static ItemEntry<Item> DARKIRON_ITEM;
  public static ItemEntry<Item> DARKIRON_DUST;
  public static ItemEntry<Item> DARKIRON_GEM;
  public static ItemEntry<Item> DARKIRON_INGOT;

  public static ItemEntry<Item> CHROMITE_POWDERED;
  public static ItemEntry<Item> CHROMITE_SLURRY;
  public static ItemEntry<Item> CHROMITE_SOLUTION;
  public static ItemEntry<Item> CHROMITE_FLAKES;
  public static ItemEntry<Item> CHROMITE_ITEM;
  public static ItemEntry<Item> CHROMITE_DUST;
  public static ItemEntry<Item> CHROMITE_GEM;
  public static ItemEntry<Item> CHROMITE_INGOT;

  public static ItemEntry<Item> SILICON_POWDERED;
  public static ItemEntry<Item> SILICON_SLURRY;
  public static ItemEntry<Item> SILICON_SOLUTION;
  public static ItemEntry<Item> SILICON_FLAKES;
  public static ItemEntry<Item> SILICON_ITEM;
  public static ItemEntry<Item> SILICON_DUST;
  public static ItemEntry<Item> SILICON_GEM;
  public static ItemEntry<Item> SILICON_INGOT;

  public static ItemEntry<Item> RUTILE_POWDERED;
  public static ItemEntry<Item> RUTILE_SLURRY;
  public static ItemEntry<Item> RUTILE_SOLUTION;
  public static ItemEntry<Item> RUTILE_FLAKES;
  public static ItemEntry<Item> RUTILE_ITEM;
  public static ItemEntry<Item> RUTILE_DUST;
  public static ItemEntry<Item> RUTILE_GEM;
  public static ItemEntry<Item> RUTILE_INGOT;

  public static ItemEntry<Item> AMETHYST_POWDERED;
  public static ItemEntry<Item> AMETHYST_SLURRY;
  public static ItemEntry<Item> AMETHYST_SOLUTION;
  public static ItemEntry<Item> AMETHYST_FLAKES;
  public static ItemEntry<Item> AMETHYST_ITEM;
  public static ItemEntry<Item> AMETHYST_DUST;
  public static ItemEntry<Item> AMETHYST_GEM;
  public static ItemEntry<Item> AMETHYST_INGOT;

  public static ItemEntry<Item> TESLATITE_POWDERED;
  public static ItemEntry<Item> TESLATITE_SLURRY;
  public static ItemEntry<Item> TESLATITE_SOLUTION;
  public static ItemEntry<Item> TESLATITE_FLAKES;
  public static ItemEntry<Item> TESLATITE_ITEM;
  public static ItemEntry<Item> TESLATITE_DUST;
  public static ItemEntry<Item> TESLATITE_GEM;
  public static ItemEntry<Item> TESLATITE_INGOT;

  public static ItemEntry<Item> MANA_POWDERED;
  public static ItemEntry<Item> MANA_SLURRY;
  public static ItemEntry<Item> MANA_SOLUTION;
  public static ItemEntry<Item> MANA_FLAKES;
  public static ItemEntry<Item> MANA_ITEM;
  public static ItemEntry<Item> MANA_DUST;
  public static ItemEntry<Item> MANA_GEM;
  public static ItemEntry<Item> MANA_INGOT;

  public static ItemEntry<Item> THORIUM_POWDERED;
  public static ItemEntry<Item> THORIUM_SLURRY;
  public static ItemEntry<Item> THORIUM_SOLUTION;
  public static ItemEntry<Item> THORIUM_FLAKES;
  public static ItemEntry<Item> THORIUM_ITEM;
  public static ItemEntry<Item> THORIUM_DUST;
  public static ItemEntry<Item> THORIUM_GEM;
  public static ItemEntry<Item> THORIUM_INGOT;

  public static ItemEntry<Item> DRACONIUM_POWDERED;
  public static ItemEntry<Item> DRACONIUM_SLURRY;
  public static ItemEntry<Item> DRACONIUM_SOLUTION;
  public static ItemEntry<Item> DRACONIUM_FLAKES;
  public static ItemEntry<Item> DRACONIUM_ITEM;
  public static ItemEntry<Item> DRACONIUM_DUST;
  public static ItemEntry<Item> DRACONIUM_GEM;
  public static ItemEntry<Item> DRACONIUM_INGOT;

  public static ItemEntry<Item> ENDIUM_POWDERED;
  public static ItemEntry<Item> ENDIUM_SLURRY;
  public static ItemEntry<Item> ENDIUM_SOLUTION;
  public static ItemEntry<Item> ENDIUM_FLAKES;
  public static ItemEntry<Item> ENDIUM_ITEM;
  public static ItemEntry<Item> ENDIUM_DUST;
  public static ItemEntry<Item> ENDIUM_GEM;
  public static ItemEntry<Item> ENDIUM_INGOT;

  public static ItemEntry<Item> DILITHIUM_POWDERED;
  public static ItemEntry<Item> DILITHIUM_SLURRY;
  public static ItemEntry<Item> DILITHIUM_SOLUTION;
  public static ItemEntry<Item> DILITHIUM_FLAKES;
  public static ItemEntry<Item> DILITHIUM_ITEM;
  public static ItemEntry<Item> DILITHIUM_DUST;
  public static ItemEntry<Item> DILITHIUM_GEM;
  public static ItemEntry<Item> DILITHIUM_INGOT;

  public static ItemEntry<Item> EXIMITE_POWDERED;
  public static ItemEntry<Item> EXIMITE_SLURRY;
  public static ItemEntry<Item> EXIMITE_SOLUTION;
  public static ItemEntry<Item> EXIMITE_FLAKES;
  public static ItemEntry<Item> EXIMITE_ITEM;
  public static ItemEntry<Item> EXIMITE_DUST;
  public static ItemEntry<Item> EXIMITE_GEM;
  public static ItemEntry<Item> EXIMITE_INGOT;
  
  public static ItemEntry<Item> MEUTOITE_POWDERED;
  public static ItemEntry<Item> MEUTOITE_SLURRY;
  public static ItemEntry<Item> MEUTOITE_SOLUTION;
  public static ItemEntry<Item> MEUTOITE_FLAKES;
  public static ItemEntry<Item> MEUTOITE_ITEM;
  public static ItemEntry<Item> MEUTOITE_DUST;
  public static ItemEntry<Item> MEUTOITE_GEM;
  public static ItemEntry<Item> MEUTOITE_INGOT;


  private static void registerMetal(String name, String displayName,
                                    Consumer<ItemEntry<Item>> powderedSetter,
                                    Consumer<ItemEntry<Item>> slurrySetter,
                                    Consumer<ItemEntry<Item>> solutionSetter,
                                    Consumer<ItemEntry<Item>> flakesSetter,
                                    Consumer<ItemEntry<Item>> itemSetter,
                                    Consumer<ItemEntry<Item>> dustSetter,
                                    Consumer<ItemEntry<Item>> gemSetter,
                                    Consumer<ItemEntry<Item>> ingotSetter) {
    String powdered = name + "_powdered";
    powderedSetter.accept(RCURegistrates.REGISTRATE.item(powdered, Item::new)
        .lang(displayName + " Powdered")
        .model((ctx, prov) -> prov.generated(ctx, prov.modLoc("item/ore/" + name + "/" + powdered))).register());

    String slurry = name + "_slurry";
    slurrySetter.accept(RCURegistrates.REGISTRATE.item(slurry, Item::new)
        .lang(displayName + " Slurry")
        .model((ctx, prov) -> prov.generated(ctx, prov.modLoc("item/ore/" + name + "/" + slurry))).register());

    String solution = name + "_solution";
    solutionSetter.accept(RCURegistrates.REGISTRATE.item(solution, Item::new)
        .lang(displayName + " Solution")
        .model((ctx, prov) -> prov.generated(ctx, prov.modLoc("item/ore/" + name + "/" + solution))).register());

    String flakes = name + "_flakes";
    flakesSetter.accept(RCURegistrates.REGISTRATE.item(flakes, Item::new)
        .lang(displayName + " Flakes")
        .model((ctx, prov) -> prov.generated(ctx, prov.modLoc("item/ore/" + name + "/" + flakes))).register());

    String item = name + "_item";
    itemSetter.accept(RCURegistrates.REGISTRATE.item(item, Item::new)
        .lang(displayName + "vItem")
        .model((ctx, prov) -> prov.generated(ctx, prov.modLoc("item/ore/" + name + "/" + item))).register());

    String dust = name + "_dust";
    dustSetter.accept(RCURegistrates.REGISTRATE.item(dust, Item::new)
        .lang(displayName + " Dust")
        .model((ctx, prov) -> prov.generated(ctx, prov.modLoc("item/ore/" + name + "/" + dust))).register());

    String gem = name + "_gem";
    gemSetter.accept(RCURegistrates.REGISTRATE.item(gem, Item::new)
        .lang(displayName + " Gem")
        .model((ctx, prov) -> prov.generated(ctx, prov.modLoc("item/ore/" + name + "/" + gem))).register());

    String ingot = name + "_ingot";
    ingotSetter.accept(RCURegistrates.REGISTRATE.item(ingot, Item::new)
        .lang(displayName + " Ingot")
        .model((ctx, prov) -> prov.generated(ctx, prov.modLoc("item/ore/" + name + "/" + ingot))).register());
  }

  public static void registerAll() {
    registerMetal("tin", "Tin",
        entry -> TIN_POWDERED = entry,
        entry -> TIN_SLURRY = entry,
        entry -> TIN_SOLUTION = entry,
        entry -> TIN_FLAKES = entry,
        entry -> TIN_ITEM = entry,
        entry -> TIN_DUST = entry,
        entry -> TIN_GEM = entry,
        entry -> TIN_INGOT = entry);

    registerMetal("copper", "Copper",
        entry -> COPPER_POWDERED = entry,
        entry -> COPPER_SLURRY = entry,
        entry -> COPPER_SOLUTION = entry,
        entry -> COPPER_FLAKES = entry,
        entry -> COPPER_ITEM = entry,
        entry -> COPPER_DUST = entry,
        entry -> COPPER_GEM = entry,
        entry -> COPPER_INGOT = entry);

    registerMetal("lead", "Lead",
        entry -> LEAD_POWDERED = entry,
        entry -> LEAD_SLURRY = entry,
        entry -> LEAD_SOLUTION = entry,
        entry -> LEAD_FLAKES = entry,
        entry -> LEAD_ITEM = entry,
        entry -> LEAD_DUST = entry,
        entry -> LEAD_GEM = entry,
        entry -> LEAD_INGOT = entry);

    registerMetal("nickel", "Nickel",
        entry -> NICKEL_POWDERED = entry,
        entry -> NICKEL_SLURRY = entry,
        entry -> NICKEL_SOLUTION = entry,
        entry -> NICKEL_FLAKES = entry,
        entry -> NICKEL_ITEM = entry,
        entry -> NICKEL_DUST = entry,
        entry -> NICKEL_GEM = entry,
        entry -> NICKEL_INGOT = entry);

    registerMetal("silver", "Silver",
        entry -> SILVER_POWDERED = entry,
        entry -> SILVER_SLURRY = entry,
        entry -> SILVER_SOLUTION = entry,
        entry -> SILVER_FLAKES = entry,
        entry -> SILVER_ITEM = entry,
        entry -> SILVER_DUST = entry,
        entry -> SILVER_GEM = entry,
        entry -> SILVER_INGOT = entry);

    registerMetal("galena", "Galena",
        entry -> GALENA_POWDERED = entry,
        entry -> GALENA_SLURRY = entry,
        entry -> GALENA_SOLUTION = entry,
        entry -> GALENA_FLAKES = entry,
        entry -> GALENA_ITEM = entry,
        entry -> GALENA_DUST = entry,
        entry -> GALENA_GEM = entry,
        entry -> GALENA_INGOT = entry);

    registerMetal("aluminum", "Aluminum",
        entry -> ALUMINUM_POWDERED = entry,
        entry -> ALUMINUM_SLURRY = entry,
        entry -> ALUMINUM_SOLUTION = entry,
        entry -> ALUMINUM_FLAKES = entry,
        entry -> ALUMINUM_ITEM = entry,
        entry -> ALUMINUM_DUST = entry,
        entry -> ALUMINUM_GEM = entry,
        entry -> ALUMINUM_INGOT = entry);

    registerMetal("iridium", "Iridium",
        entry -> IRIDIUM_POWDERED = entry,
        entry -> IRIDIUM_SLURRY = entry,
        entry -> IRIDIUM_SOLUTION = entry,
        entry -> IRIDIUM_FLAKES = entry,
        entry -> IRIDIUM_ITEM = entry,
        entry -> IRIDIUM_DUST = entry,
        entry -> IRIDIUM_GEM = entry,
        entry -> IRIDIUM_INGOT = entry);

    registerMetal("firestone", "Firestone",
        entry -> FIRESTONE_POWDERED = entry,
        entry -> FIRESTONE_SLURRY = entry,
        entry -> FIRESTONE_SOLUTION = entry,
        entry -> FIRESTONE_FLAKES = entry,
        entry -> FIRESTONE_ITEM = entry,
        entry -> FIRESTONE_DUST = entry,
        entry -> FIRESTONE_GEM = entry,
        entry -> FIRESTONE_INGOT = entry);

    registerMetal("certus_quartz", "Certus Quartz",
        entry -> CERTUSQUARTZ_POWDERED = entry,
        entry -> CERTUSQUARTZ_SLURRY = entry,
        entry -> CERTUSQUARTZ_SOLUTION = entry,
        entry -> CERTUSQUARTZ_FLAKES = entry,
        entry -> CERTUSQUARTZ_ITEM = entry,
        entry -> CERTUSQUARTZ_DUST = entry,
        entry -> CERTUSQUARTZ_GEM = entry,
        entry -> CERTUSQUARTZ_INGOT = entry);

    registerMetal("uranium", "Uranium",
        entry -> URANIUM_POWDERED = entry,
        entry -> URANIUM_SLURRY = entry,
        entry -> URANIUM_SOLUTION = entry,
        entry -> URANIUM_FLAKES = entry,
        entry -> URANIUM_ITEM = entry,
        entry -> URANIUM_DUST = entry,
        entry -> URANIUM_GEM = entry,
        entry -> URANIUM_INGOT = entry);

    registerMetal("mercury", "Mercury",
        entry -> CINNABAR_POWDERED = entry,
        entry -> CINNABAR_SLURRY = entry,
        entry -> CINNABAR_SOLUTION = entry,
        entry -> CINNABAR_FLAKES = entry,
        entry -> CINNABAR_ITEM = entry,
        entry -> CINNABAR_DUST = entry,
        entry -> CINNABAR_GEM = entry,
        entry -> CINNABAR_INGOT = entry);

    registerMetal("amber", "Amber",
        entry -> AMBER_POWDERED = entry,
        entry -> AMBER_SLURRY = entry,
        entry -> AMBER_SOLUTION = entry,
        entry -> AMBER_FLAKES = entry,
        entry -> AMBER_ITEM = entry,
        entry -> AMBER_DUST = entry,
        entry -> AMBER_GEM = entry,
        entry -> AMBER_INGOT = entry);

    registerMetal("apatite", "Apatite",
        entry -> APATITE_POWDERED = entry,
        entry -> APATITE_SLURRY = entry,
        entry -> APATITE_SOLUTION = entry,
        entry -> APATITE_FLAKES = entry,
        entry -> APATITE_ITEM = entry,
        entry -> APATITE_DUST = entry,
        entry -> APATITE_GEM = entry,
        entry -> APATITE_INGOT = entry);

    registerMetal("saltpeter", "Saltpeter",
        entry -> SALTPETER_POWDERED = entry,
        entry -> SALTPETER_SLURRY = entry,
        entry -> SALTPETER_SOLUTION = entry,
        entry -> SALTPETER_FLAKES = entry,
        entry -> SALTPETER_ITEM = entry,
        entry -> SALTPETER_DUST = entry,
        entry -> SALTPETER_GEM = entry,
        entry -> SALTPETER_INGOT = entry);

    registerMetal("tungsten", "Tungsten",
        entry -> TUNGSTEN_POWDERED = entry,
        entry -> TUNGSTEN_SLURRY = entry,
        entry -> TUNGSTEN_SOLUTION = entry,
        entry -> TUNGSTEN_FLAKES = entry,
        entry -> TUNGSTEN_ITEM = entry,
        entry -> TUNGSTEN_DUST = entry,
        entry -> TUNGSTEN_GEM = entry,
        entry -> TUNGSTEN_INGOT = entry);

    registerMetal("nikolite", "Nikolite",
        entry -> NIKOLITE_POWDERED = entry,
        entry -> NIKOLITE_SLURRY = entry,
        entry -> NIKOLITE_SOLUTION = entry,
        entry -> NIKOLITE_FLAKES = entry,
        entry -> NIKOLITE_ITEM = entry,
        entry -> NIKOLITE_DUST = entry,
        entry -> NIKOLITE_GEM = entry,
        entry -> NIKOLITE_INGOT = entry);

    registerMetal("peridot", "Peridot",
        entry -> PERIDOT_POWDERED = entry,
        entry -> PERIDOT_SLURRY = entry,
        entry -> PERIDOT_SOLUTION = entry,
        entry -> PERIDOT_FLAKES = entry,
        entry -> PERIDOT_ITEM = entry,
        entry -> PERIDOT_DUST = entry,
        entry -> PERIDOT_GEM = entry,
        entry -> PERIDOT_INGOT = entry);

    registerMetal("ruby", "Ruby",
        entry -> RUBY_POWDERED = entry,
        entry -> RUBY_SLURRY = entry,
        entry -> RUBY_SOLUTION = entry,
        entry -> RUBY_FLAKES = entry,
        entry -> RUBY_ITEM = entry,
        entry -> RUBY_DUST = entry,
        entry -> RUBY_GEM = entry,
        entry -> RUBY_INGOT = entry);

    registerMetal("sapphire", "Sapphire",
        entry -> SAPPHIRE_POWDERED = entry,
        entry -> SAPPHIRE_SLURRY = entry,
        entry -> SAPPHIRE_SOLUTION = entry,
        entry -> SAPPHIRE_FLAKES = entry,
        entry -> SAPPHIRE_ITEM = entry,
        entry -> SAPPHIRE_DUST = entry,
        entry -> SAPPHIRE_GEM = entry,
        entry -> SAPPHIRE_INGOT = entry);

    registerMetal("monazit", "Monazit",
        entry -> MONAZIT_POWDERED = entry,
        entry -> MONAZIT_SLURRY = entry,
        entry -> MONAZIT_SOLUTION = entry,
        entry -> MONAZIT_FLAKES = entry,
        entry -> MONAZIT_ITEM = entry,
        entry -> MONAZIT_DUST = entry,
        entry -> MONAZIT_GEM = entry,
        entry -> MONAZIT_INGOT = entry);

    registerMetal("force", "Force",
        entry -> FORCE_POWDERED = entry,
        entry -> FORCE_SLURRY = entry,
        entry -> FORCE_SOLUTION = entry,
        entry -> FORCE_FLAKES = entry,
        entry -> FORCE_ITEM = entry,
        entry -> FORCE_DUST = entry,
        entry -> FORCE_GEM = entry,
        entry -> FORCE_INGOT = entry);

    registerMetal("cobalt", "Cobalt",
        entry -> COBALT_POWDERED = entry,
        entry -> COBALT_SLURRY = entry,
        entry -> COBALT_SOLUTION = entry,
        entry -> COBALT_FLAKES = entry,
        entry -> COBALT_ITEM = entry,
        entry -> COBALT_DUST = entry,
        entry -> COBALT_GEM = entry,
        entry -> COBALT_INGOT = entry);

    registerMetal("platinum", "Platinum",
        entry -> PLATINUM_POWDERED = entry,
        entry -> PLATINUM_SLURRY = entry,
        entry -> PLATINUM_SOLUTION = entry,
        entry -> PLATINUM_FLAKES = entry,
        entry -> PLATINUM_ITEM = entry,
        entry -> PLATINUM_DUST = entry,
        entry -> PLATINUM_GEM = entry,
        entry -> PLATINUM_INGOT = entry);

    registerMetal("zinc", "Zinc",
        entry -> ZINC_POWDERED = entry,
        entry -> ZINC_SLURRY = entry,
        entry -> ZINC_SOLUTION = entry,
        entry -> ZINC_FLAKES = entry,
        entry -> ZINC_ITEM = entry,
        entry -> ZINC_DUST = entry,
        entry -> ZINC_GEM = entry,
        entry -> ZINC_INGOT = entry);

    registerMetal("osmium", "Osmium",
        entry -> OSMIUM_POWDERED = entry,
        entry -> OSMIUM_SLURRY = entry,
        entry -> OSMIUM_SOLUTION = entry,
        entry -> OSMIUM_FLAKES = entry,
        entry -> OSMIUM_ITEM = entry,
        entry -> OSMIUM_DUST = entry,
        entry -> OSMIUM_GEM = entry,
        entry -> OSMIUM_INGOT = entry);

    registerMetal("pig_iron", "Pig Iron",
        entry -> PIGIRON_POWDERED = entry,
        entry -> PIGIRON_SLURRY = entry,
        entry -> PIGIRON_SOLUTION = entry,
        entry -> PIGIRON_FLAKES = entry,
        entry -> PIGIRON_ITEM = entry,
        entry -> PIGIRON_DUST = entry,
        entry -> PIGIRON_GEM = entry,
        entry -> PIGIRON_INGOT = entry);

    registerMetal("sulfur", "Sulfur",
        entry -> SULFUR_POWDERED = entry,
        entry -> SULFUR_SLURRY = entry,
        entry -> SULFUR_SOLUTION = entry,
        entry -> SULFUR_FLAKES = entry,
        entry -> SULFUR_ITEM = entry,
        entry -> SULFUR_DUST = entry,
        entry -> SULFUR_GEM = entry,
        entry -> SULFUR_INGOT = entry);

    registerMetal("pitchblende", "Pitchblende",
        entry -> PITCHBLENDE_POWDERED = entry,
        entry -> PITCHBLENDE_SLURRY = entry,
        entry -> PITCHBLENDE_SOLUTION = entry,
        entry -> PITCHBLENDE_FLAKES = entry,
        entry -> PITCHBLENDE_ITEM = entry,
        entry -> PITCHBLENDE_DUST = entry,
        entry -> PITCHBLENDE_GEM = entry,
        entry -> PITCHBLENDE_INGOT = entry);

    registerMetal("cadmium", "Cadmium",
        entry -> CADMIUM_POWDERED = entry,
        entry -> CADMIUM_SLURRY = entry,
        entry -> CADMIUM_SOLUTION = entry,
        entry -> CADMIUM_FLAKES = entry,
        entry -> CADMIUM_ITEM = entry,
        entry -> CADMIUM_DUST = entry,
        entry -> CADMIUM_GEM = entry,
        entry -> CADMIUM_INGOT = entry);

    registerMetal("indium", "Indium",
        entry -> INDIUM_POWDERED = entry,
        entry -> INDIUM_SLURRY = entry,
        entry -> INDIUM_SOLUTION = entry,
        entry -> INDIUM_FLAKES = entry,
        entry -> INDIUM_ITEM = entry,
        entry -> INDIUM_DUST = entry,
        entry -> INDIUM_GEM = entry,
        entry -> INDIUM_INGOT = entry);

    registerMetal("fluorite", "Fluorite",
        entry -> FLUORITE_POWDERED = entry,
        entry -> FLUORITE_SLURRY = entry,
        entry -> FLUORITE_SOLUTION = entry,
        entry -> FLUORITE_FLAKES = entry,
        entry -> FLUORITE_ITEM = entry,
        entry -> FLUORITE_DUST = entry,
        entry -> FLUORITE_GEM = entry,
        entry -> FLUORITE_INGOT = entry);

    registerMetal("bauxite", "Bauxite",
        entry -> BAUXITE_POWDERED = entry,
        entry -> BAUXITE_SLURRY = entry,
        entry -> BAUXITE_SOLUTION = entry,
        entry -> BAUXITE_FLAKES = entry,
        entry -> BAUXITE_ITEM = entry,
        entry -> BAUXITE_DUST = entry,
        entry -> BAUXITE_GEM = entry,
        entry -> BAUXITE_INGOT = entry);

    registerMetal("sodalite", "Sodalite",
        entry -> SODALITE_POWDERED = entry,
        entry -> SODALITE_SLURRY = entry,
        entry -> SODALITE_SOLUTION = entry,
        entry -> SODALITE_FLAKES = entry,
        entry -> SODALITE_ITEM = entry,
        entry -> SODALITE_DUST = entry,
        entry -> SODALITE_GEM = entry,
        entry -> SODALITE_INGOT = entry);

    registerMetal("pyrite", "Pyrite",
        entry -> PYRITE_POWDERED = entry,
        entry -> PYRITE_SLURRY = entry,
        entry -> PYRITE_SOLUTION = entry,
        entry -> PYRITE_FLAKES = entry,
        entry -> PYRITE_ITEM = entry,
        entry -> PYRITE_DUST = entry,
        entry -> PYRITE_GEM = entry,
        entry -> PYRITE_INGOT = entry);

    registerMetal("ammonium_chloride", "Ammonium Chloride",
        entry -> AMMONIUM_POWDERED = entry,
        entry -> AMMONIUM_SLURRY = entry,
        entry -> AMMONIUM_SOLUTION = entry,
        entry -> AMMONIUM_FLAKES = entry,
        entry -> AMMONIUM_ITEM = entry,
        entry -> AMMONIUM_DUST = entry,
        entry -> AMMONIUM_GEM = entry,
        entry -> AMMONIUM_INGOT = entry);

    registerMetal("calcite", "Calcite",
        entry -> CALCITE_POWDERED = entry,
        entry -> CALCITE_SLURRY = entry,
        entry -> CALCITE_SOLUTION = entry,
        entry -> CALCITE_FLAKES = entry,
        entry -> CALCITE_ITEM = entry,
        entry -> CALCITE_DUST = entry,
        entry -> CALCITE_GEM = entry,
        entry -> CALCITE_INGOT = entry);

    registerMetal("chimerite", "Chimerite",
        entry -> CHIMERITE_POWDERED = entry,
        entry -> CHIMERITE_SLURRY = entry,
        entry -> CHIMERITE_SOLUTION = entry,
        entry -> CHIMERITE_FLAKES = entry,
        entry -> CHIMERITE_ITEM = entry,
        entry -> CHIMERITE_DUST = entry,
        entry -> CHIMERITE_GEM = entry,
        entry -> CHIMERITE_INGOT = entry);

    registerMetal("vinteum", "Vinteum",
        entry -> VINTEUM_POWDERED = entry,
        entry -> VINTEUM_SLURRY = entry,
        entry -> VINTEUM_SOLUTION = entry,
        entry -> VINTEUM_FLAKES = entry,
        entry -> VINTEUM_ITEM = entry,
        entry -> VINTEUM_DUST = entry,
        entry -> VINTEUM_GEM = entry,
        entry -> VINTEUM_INGOT = entry);

    registerMetal("blue_topaz", "Blue Topaz",
        entry -> BLUETOPAZ_POWDERED = entry,
        entry -> BLUETOPAZ_SLURRY = entry,
        entry -> BLUETOPAZ_SOLUTION = entry,
        entry -> BLUETOPAZ_FLAKES = entry,
        entry -> BLUETOPAZ_ITEM = entry,
        entry -> BLUETOPAZ_DUST = entry,
        entry -> BLUETOPAZ_GEM = entry,
        entry -> BLUETOPAZ_INGOT = entry);

    registerMetal("moonstone", "Moonstone",
        entry -> MOONSTONE_POWDERED = entry,
        entry -> MOONSTONE_SLURRY = entry,
        entry -> MOONSTONE_SOLUTION = entry,
        entry -> MOONSTONE_FLAKES = entry,
        entry -> MOONSTONE_ITEM = entry,
        entry -> MOONSTONE_DUST = entry,
        entry -> MOONSTONE_GEM = entry,
        entry -> MOONSTONE_INGOT = entry);

    registerMetal("sunstone", "Sunstone",
        entry -> SUNSTONE_POWDERED = entry,
        entry -> SUNSTONE_SLURRY = entry,
        entry -> SUNSTONE_SOLUTION = entry,
        entry -> SUNSTONE_FLAKES = entry,
        entry -> SUNSTONE_ITEM = entry,
        entry -> SUNSTONE_DUST = entry,
        entry -> SUNSTONE_GEM = entry,
        entry -> SUNSTONE_INGOT = entry);

    registerMetal("titanium", "Titanium",
        entry -> TITANIUM_POWDERED = entry,
        entry -> TITANIUM_SLURRY = entry,
        entry -> TITANIUM_SOLUTION = entry,
        entry -> TITANIUM_FLAKES = entry,
        entry -> TITANIUM_ITEM = entry,
        entry -> TITANIUM_DUST = entry,
        entry -> TITANIUM_GEM = entry,
        entry -> TITANIUM_INGOT = entry);

    registerMetal("magmanite", "Magmanite",
        entry -> MAGMANITE_POWDERED = entry,
        entry -> MAGMANITE_SLURRY = entry,
        entry -> MAGMANITE_SOLUTION = entry,
        entry -> MAGMANITE_FLAKES = entry,
        entry -> MAGMANITE_ITEM = entry,
        entry -> MAGMANITE_DUST = entry,
        entry -> MAGMANITE_GEM = entry,
        entry -> MAGMANITE_INGOT = entry);

    registerMetal("magnetite", "Magnetite",
        entry -> MAGNETITE_POWDERED = entry,
        entry -> MAGNETITE_SLURRY = entry,
        entry -> MAGNETITE_SOLUTION = entry,
        entry -> MAGNETITE_FLAKES = entry,
        entry -> MAGNETITE_ITEM = entry,
        entry -> MAGNETITE_DUST = entry,
        entry -> MAGNETITE_GEM = entry,
        entry -> MAGNETITE_INGOT = entry);

    registerMetal("essence", "Essence",
        entry -> ESSENCE_POWDERED = entry,
        entry -> ESSENCE_SLURRY = entry,
        entry -> ESSENCE_SOLUTION = entry,
        entry -> ESSENCE_FLAKES = entry,
        entry -> ESSENCE_ITEM = entry,
        entry -> ESSENCE_DUST = entry,
        entry -> ESSENCE_GEM = entry,
        entry -> ESSENCE_INGOT = entry);

    registerMetal("mimichite", "Mimichite",
        entry -> MIMICHITE_POWDERED = entry,
        entry -> MIMICHITE_SLURRY = entry,
        entry -> MIMICHITE_SOLUTION = entry,
        entry -> MIMICHITE_FLAKES = entry,
        entry -> MIMICHITE_ITEM = entry,
        entry -> MIMICHITE_DUST = entry,
        entry -> MIMICHITE_GEM = entry,
        entry -> MIMICHITE_INGOT = entry);

    registerMetal("quantum", "Quantum",
        entry -> QUANTUM_POWDERED = entry,
        entry -> QUANTUM_SLURRY = entry,
        entry -> QUANTUM_SOLUTION = entry,
        entry -> QUANTUM_FLAKES = entry,
        entry -> QUANTUM_ITEM = entry,
        entry -> QUANTUM_DUST = entry,
        entry -> QUANTUM_GEM = entry,
        entry -> QUANTUM_INGOT = entry);

    registerMetal("dark_iron", "Dark Iron",
        entry -> DARKIRON_POWDERED = entry,
        entry -> DARKIRON_SLURRY = entry,
        entry -> DARKIRON_SOLUTION = entry,
        entry -> DARKIRON_FLAKES = entry,
        entry -> DARKIRON_ITEM = entry,
        entry -> DARKIRON_DUST = entry,
        entry -> DARKIRON_GEM = entry,
        entry -> DARKIRON_INGOT = entry);

    registerMetal("chromite", "Chromite",
        entry -> CHROMITE_POWDERED = entry,
        entry -> CHROMITE_SLURRY = entry,
        entry -> CHROMITE_SOLUTION = entry,
        entry -> CHROMITE_FLAKES = entry,
        entry -> CHROMITE_ITEM = entry,
        entry -> CHROMITE_DUST = entry,
        entry -> CHROMITE_GEM = entry,
        entry -> CHROMITE_INGOT = entry);

    registerMetal("silicon", "Silicon",
        entry -> SILICON_POWDERED = entry,
        entry -> SILICON_SLURRY = entry,
        entry -> SILICON_SOLUTION = entry,
        entry -> SILICON_FLAKES = entry,
        entry -> SILICON_ITEM = entry,
        entry -> SILICON_DUST = entry,
        entry -> SILICON_GEM = entry,
        entry -> SILICON_INGOT = entry);

    registerMetal("rutile", "Rutile",
        entry -> RUTILE_POWDERED = entry,
        entry -> RUTILE_SLURRY = entry,
        entry -> RUTILE_SOLUTION = entry,
        entry -> RUTILE_FLAKES = entry,
        entry -> RUTILE_ITEM = entry,
        entry -> RUTILE_DUST = entry,
        entry -> RUTILE_GEM = entry,
        entry -> RUTILE_INGOT = entry);

    registerMetal("amethyst", "Amethyst",
        entry -> AMETHYST_POWDERED = entry,
        entry -> AMETHYST_SLURRY = entry,
        entry -> AMETHYST_SOLUTION = entry,
        entry -> AMETHYST_FLAKES = entry,
        entry -> AMETHYST_ITEM = entry,
        entry -> AMETHYST_DUST = entry,
        entry -> AMETHYST_GEM = entry,
        entry -> AMETHYST_INGOT = entry);

    registerMetal("teslatite", "Teslatite",
        entry -> TESLATITE_POWDERED = entry,
        entry -> TESLATITE_SLURRY = entry,
        entry -> TESLATITE_SOLUTION = entry,
        entry -> TESLATITE_FLAKES = entry,
        entry -> TESLATITE_ITEM = entry,
        entry -> TESLATITE_DUST = entry,
        entry -> TESLATITE_GEM = entry,
        entry -> TESLATITE_INGOT = entry);

    registerMetal("mana", "Mana",
        entry -> MANA_POWDERED = entry,
        entry -> MANA_SLURRY = entry,
        entry -> MANA_SOLUTION = entry,
        entry -> MANA_FLAKES = entry,
        entry -> MANA_ITEM = entry,
        entry -> MANA_DUST = entry,
        entry -> MANA_GEM = entry,
        entry -> MANA_INGOT = entry);

    registerMetal("thorium", "Thorium",
        entry -> THORIUM_POWDERED = entry,
        entry -> THORIUM_SLURRY = entry,
        entry -> THORIUM_SOLUTION = entry,
        entry -> THORIUM_FLAKES = entry,
        entry -> THORIUM_ITEM = entry,
        entry -> THORIUM_DUST = entry,
        entry -> THORIUM_GEM = entry,
        entry -> THORIUM_INGOT = entry);

    registerMetal("draconium", "Draconium",
        entry -> DRACONIUM_POWDERED = entry,
        entry -> DRACONIUM_SLURRY = entry,
        entry -> DRACONIUM_SOLUTION = entry,
        entry -> DRACONIUM_FLAKES = entry,
        entry -> DRACONIUM_ITEM = entry,
        entry -> DRACONIUM_DUST = entry,
        entry -> DRACONIUM_GEM = entry,
        entry -> DRACONIUM_INGOT = entry);

    registerMetal("endium", "Endium",
        entry -> ENDIUM_POWDERED = entry,
        entry -> ENDIUM_SLURRY = entry,
        entry -> ENDIUM_SOLUTION = entry,
        entry -> ENDIUM_FLAKES = entry,
        entry -> ENDIUM_ITEM = entry,
        entry -> ENDIUM_DUST = entry,
        entry -> ENDIUM_GEM = entry,
        entry -> ENDIUM_INGOT = entry);

    registerMetal("dilithium", "Dilithium",
        entry -> DILITHIUM_POWDERED = entry,
        entry -> DILITHIUM_SLURRY = entry,
        entry -> DILITHIUM_SOLUTION = entry,
        entry -> DILITHIUM_FLAKES = entry,
        entry -> DILITHIUM_ITEM = entry,
        entry -> DILITHIUM_DUST = entry,
        entry -> DILITHIUM_GEM = entry,
        entry -> DILITHIUM_INGOT = entry);

    registerMetal("eximite", "Eximite",
        entry -> EXIMITE_POWDERED = entry,
        entry -> EXIMITE_SLURRY = entry,
        entry -> EXIMITE_SOLUTION = entry,
        entry -> EXIMITE_FLAKES = entry,
        entry -> EXIMITE_ITEM = entry,
        entry -> EXIMITE_DUST = entry,
        entry -> EXIMITE_GEM = entry,
        entry -> EXIMITE_INGOT = entry);

    registerMetal("meutoite", "Meutoite",
        entry -> MEUTOITE_POWDERED = entry,
        entry -> MEUTOITE_SLURRY = entry,
        entry -> MEUTOITE_SOLUTION = entry,
        entry -> MEUTOITE_FLAKES = entry,
        entry -> MEUTOITE_ITEM = entry,
        entry -> MEUTOITE_DUST = entry,
        entry -> MEUTOITE_GEM = entry,
        entry -> MEUTOITE_INGOT = entry);

  }

  public static void init() {
    registerAll();
  }
}
