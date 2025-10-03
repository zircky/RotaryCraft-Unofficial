package com.zircky.rotarycraft_unofficial.common.registry;

import com.zircky.rotarycraft_unofficial.RotaryCraftUnofficial;
import com.zircky.rotarycraft_unofficial.api.library.EngLibrary;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public enum MaterialRegistry {
  WOOD(-1,EngLibrary.Ewood, EngLibrary.Gwood, EngLibrary.Twood, EngLibrary.Swood, EngLibrary.rhowood, Blocks.OAK_PLANKS),
  STONE(0, EngLibrary.Estone, EngLibrary.Gstone, EngLibrary.Tstone, EngLibrary.Sstone, EngLibrary.rhorock, Blocks.STONE),
  STEEL(1, EngLibrary.Esteel, EngLibrary.Gsteel, EngLibrary.Tsteel, EngLibrary.Ssteel, EngLibrary.rhoiron, Blocks.IRON_BLOCK),
  TUNGSTEN(1, EngLibrary.Etungsten, EngLibrary.Gtungsten, EngLibrary.Ttungsten, EngLibrary.Stungsten, EngLibrary.rhotungsten, Blocks.IRON_BLOCK),
  DIAMOND(2, EngLibrary.Ediamond, EngLibrary.Gdiamond, EngLibrary.Tdiamond, EngLibrary.Sdiamond, EngLibrary.rhodiamond, Blocks.DIAMOND_BLOCK),
  BEDROCK(3, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, EngLibrary.rhoiron, Blocks.BEDROCK);

  public final double Emod;
  public final double Smod;
  public final double tensile;
  public final double shear;
  public final double rho;
  public final int harvestLevel;
  public final net.minecraft.world.level.block.Block baseBlock;

  MaterialRegistry(int h, double E, double G, double TS, double S, double den, Block base) {
    this.Emod = E;
    this.Smod = G;
    this.tensile = TS;
    this.shear = S;
    this.rho = den;
    this.harvestLevel = h;
    this.baseBlock = base;
  }

  public String idName() {
    return name().toLowerCase();
  }

  public Block getBaseBlock() {
    return baseBlock;
  }

  public boolean isInfiniteStrength() {
    return this == BEDROCK;
  }

  /** Текстуры: используются имена вида modyid:block/shaft_<material>_<side> (down, up, north, south, west, east) */
  public ResourceLocation tex(String side) {
    return new ResourceLocation(RotaryCraftUnofficial.MODID, "block/shaft_" + idName() + "_" + side);
  }

  // вспомогательные вычисления (скелет)
  public double getMaxShaftTorque() {
    if (isInfiniteStrength()) return Double.POSITIVE_INFINITY;
    double r = 0.0625;
    double tau = shear;
    return 0.5 * Math.PI * r * r * r * tau / 16.0;
  }

  public double getMaxShaftSpeed() {
    if (isInfiniteStrength()) return Double.POSITIVE_INFINITY;
    double f = 1.0 / this.getSpeedForceExponent();
    double rho = this.rho;
    double r = 0.0625;
    double sigma = tensile;
    double base = Math.sqrt(2 * sigma / (rho * r * r));
    return Math.pow(base, f);
  }

  public double getSpeedForceExponent() {
    switch (this) {
      case WOOD:
      case STONE:
      case STEEL:
        return 1 - (0.11 * this.ordinal());
      case TUNGSTEN:
        return 0.70;
      case DIAMOND:
        return 0.67;
      default:
        return 1;
    }
  }
}
