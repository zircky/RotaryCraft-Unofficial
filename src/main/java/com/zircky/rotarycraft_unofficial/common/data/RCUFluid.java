package com.zircky.rotarycraft_unofficial.common.data;

import com.tterrag.registrate.util.entry.FluidEntry;
import com.zircky.rotarycraft_unofficial.RotaryCraftUnofficial;
import com.zircky.rotarycraft_unofficial.api.registry.RCURegistrates;
import net.minecraftforge.fluids.ForgeFlowingFluid;

public class RCUFluid {
  public static final FluidEntry<ForgeFlowingFluid.Flowing> LUBRICANT = RCURegistrates.REGISTRATE
      .fluid("lubricant", RotaryCraftUnofficial.id("block/fluid/lubricant_still"),
          RotaryCraftUnofficial.id("block/fluid/lubricant_flow"))
      .lang("Lubricant")
      .properties(p -> p.viscosity(1000).density(1000).temperature(300))
      .source(ForgeFlowingFluid.Source::new)
      .bucket()
      .build()
      .register();



  public static void init() {}
}
