package com.zircky.rotarycraft_unofficial.api.registry;

import com.zircky.rotarycraft_unofficial.api.registry.registry.RCURegistrate;
import net.minecraftforge.fml.common.Mod;

import static com.zircky.rotarycraft_unofficial.RotaryCraftUnofficial.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class RCURegistrates {
  public static final RCURegistrate REGISTRATE = RCURegistrate.create(MODID);
//    public static final Registrate REGISTRATE = Registrate.create(MODID);
}
