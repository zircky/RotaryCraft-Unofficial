package com.zircky.rotarycraft_unofficial.common.data;

import com.zircky.rotarycraft_unofficial.api.registry.RCURegistrates;
import com.zircky.rotarycraft_unofficial.common.data.ores.RCUBlockOres;


public class RCUBlocks {
  static {
    RCURegistrates.REGISTRATE.creativeModeTab(() -> RCUCreativeModeTabs.POWER);
  }


  public static void init() {
    RCUBlockOres.init();
    RCUContent.init();
  }
}

