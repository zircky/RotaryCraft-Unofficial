package com.zircky.rotarycraft_unofficial.common.data.material.shaft;

import com.zircky.rotarycraft_unofficial.api.library.EngLibrary;

public class ShaftMaterials {
  public static final ShaftMaterial WOOD = new ShaftMaterial("wood", -1, EngLibrary.Ewood, EngLibrary.Gwood, EngLibrary.Twood, EngLibrary.Swood, EngLibrary.rhowood, false);
  public static final ShaftMaterial STONE = new ShaftMaterial("stone", 0, EngLibrary.Estone, EngLibrary.Gstone, EngLibrary.Tstone, EngLibrary.Sstone, EngLibrary.rhorock, false);
  public static final ShaftMaterial STEEL = new ShaftMaterial("steel", 1, EngLibrary.Esteel, EngLibrary.Gsteel, EngLibrary.Tsteel, EngLibrary.Ssteel, EngLibrary.rhoiron, false);
  public static final ShaftMaterial TUNGSETN = new ShaftMaterial("tungsten", 1, EngLibrary.Etungsten, EngLibrary.Gtungsten, EngLibrary.Ttungsten, EngLibrary.Stungsten, EngLibrary.tungstenDensity, false);
  public static final ShaftMaterial DIAMOND = new ShaftMaterial("diamond", 2, EngLibrary.Ediamond, EngLibrary.Gdiamond, EngLibrary.Tdiamond, EngLibrary.Sdiamond, EngLibrary.rhodiamond, false);
  public static final ShaftMaterial BEDROCK = new ShaftMaterial("bedrock", 3, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, EngLibrary.rhodiamond, true);

  public static void register() {}
}
