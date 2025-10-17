package com.zircky.rotarycraft_unofficial.common.data;

import com.tterrag.registrate.util.entry.BlockEntry;
import com.zircky.rotarycraft_unofficial.common.data.block.RCUBlock;
import com.zircky.rotarycraft_unofficial.common.data.block.RCUTabsPower;
import com.zircky.rotarycraft_unofficial.common.data.block.WorktableBlock;
import com.zircky.rotarycraft_unofficial.common.data.block.engine.*;
import com.zircky.rotarycraft_unofficial.common.data.register.RCUFlywheelRegister;
import com.zircky.rotarycraft_unofficial.common.data.register.RCUGearboxRegister;
import com.zircky.rotarycraft_unofficial.common.data.register.RCUShaftRegister;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.GlassBlock;
import net.minecraft.world.level.block.IronBarsBlock;

public class RCUBlocks {
  public static BlockEntry<DCElectricEngineBlock> DC_ELECTRIC_ENGINE;
  public static BlockEntry<ACElectricEngineBlock> AC_ELECTRIC_ENGINE;
  public static BlockEntry<WindTurbineBlock> WIND_TURBINE;
  public static BlockEntry<SteamEngineBlock> STEAM_ENGINE;
  public static BlockEntry<GasolineEngineBlock> GASOLINE_ENGINE;
  public static BlockEntry<PerformanceEngineBlock> PERFORMANCE_ENGINE;
  public static BlockEntry<HydrokineticEngineBlock> HYDROKINETIC_ENGINE;
  public static BlockEntry<MicroturbineBlock> MICROTURBINE;
  public static BlockEntry<GasTurbine> GAS_TURBINE;

  public static BlockEntry<Block> STEEL_BLOCK;
  public static BlockEntry<Block> ANTHRACITE_BLOCK;
  public static BlockEntry<Block> LONSDALEITE_BLOCK;
  public static BlockEntry<Block> BORER_SHIELD_BLOCK;
  public static BlockEntry<Block> BEDROCK_INGOT_BLOCK;
  public static BlockEntry<Block> COAL_COKE_BLOCK;
  public static BlockEntry<GlassBlock> BLAST_GLASS;
  public static BlockEntry<IronBarsBlock> BLAST_GLASS_PANE;
  public static BlockEntry<Block> DECORATIVE_TANK;

  public static BlockEntry<WorktableBlock> WORKTABLE;

  public static void init() {
    RCUBlock.init();
    RCUTabsPower.init();
    RCUShaftRegister.init();
    RCUFlywheelRegister.init();
    RCUGearboxRegister.init();
  }
}

