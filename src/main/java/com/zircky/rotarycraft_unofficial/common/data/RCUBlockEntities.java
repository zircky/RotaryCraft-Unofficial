package com.zircky.rotarycraft_unofficial.common.data;

import com.tterrag.registrate.util.entry.BlockEntityEntry;
import com.zircky.rotarycraft_unofficial.api.registry.RCURegistrates;
import com.zircky.rotarycraft_unofficial.common.blockentity.engine.DCElectricEngineBlockEntity;
import com.zircky.rotarycraft_unofficial.common.blockentity.engine.ACElectricEngineBlockEntity;
import com.zircky.rotarycraft_unofficial.common.blockentity.engine.WindTurbineBlockEntity;
import com.zircky.rotarycraft_unofficial.common.blockentity.engine.SteamEngineBlockEntity;
import com.zircky.rotarycraft_unofficial.common.blockentity.engine.GasolineEngineBlockEntity;
import com.zircky.rotarycraft_unofficial.common.blockentity.engine.PerformanceEngineBlockEntity;
import com.zircky.rotarycraft_unofficial.common.blockentity.engine.HydrokineticEngineBlockEntity;
import com.zircky.rotarycraft_unofficial.common.blockentity.engine.MicroturbineBlockEntity;
import com.zircky.rotarycraft_unofficial.common.blockentity.engine.GasTurbineBlockEntity;
import com.zircky.rotarycraft_unofficial.common.blockentity.WorktableBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class RCUBlockEntities {

  public static final BlockEntityEntry<GasTurbineBlockEntity> GAS_TURBINE_ENTITY = RCURegistrates.REGISTRATE
      .blockEntity("gas_turbine", ((BlockEntityType<GasTurbineBlockEntity> type, BlockPos pos, BlockState blockState) ->
          new GasTurbineBlockEntity(type, pos, blockState)))
      .validBlocks(RCUBlocks.GAS_TURBINE)
      .register();

  public static final BlockEntityEntry<MicroturbineBlockEntity> MICROTURBINE_ENTITY = RCURegistrates.REGISTRATE
      .blockEntity("microturbine", ((BlockEntityType<MicroturbineBlockEntity> type, BlockPos pos, BlockState blockState) ->
          new MicroturbineBlockEntity(type, pos, blockState)))
      .validBlocks(RCUBlocks.MICROTURBINE)
      .register();

  public static final BlockEntityEntry<HydrokineticEngineBlockEntity> HYDROKINETIC_ENGINE_ENTITY = RCURegistrates.REGISTRATE
      .blockEntity("gas_turbine", ((BlockEntityType<HydrokineticEngineBlockEntity> type, BlockPos pos, BlockState blockState) ->
          new HydrokineticEngineBlockEntity(type, pos, blockState)))
      .validBlocks(RCUBlocks.HYDROKINETIC_ENGINE)
      .register();

  public static final BlockEntityEntry<PerformanceEngineBlockEntity> PERFORMANCE_ENGINE_ENTITY = RCURegistrates.REGISTRATE
      .blockEntity("performance_engine", ((BlockEntityType<PerformanceEngineBlockEntity> type, BlockPos pos, BlockState blockState) ->
          new PerformanceEngineBlockEntity(type, pos, blockState)))
      .validBlocks(RCUBlocks.PERFORMANCE_ENGINE)
      .register();

  public static final BlockEntityEntry<GasolineEngineBlockEntity> GASOLINE_ENGINE_ENTITY = RCURegistrates.REGISTRATE
      .blockEntity("gasoline_engine", ((BlockEntityType<GasolineEngineBlockEntity> type, BlockPos pos, BlockState blockState) ->
          new GasolineEngineBlockEntity(type, pos, blockState)))
      .validBlocks(RCUBlocks.GASOLINE_ENGINE)
      .register();

  public static final BlockEntityEntry<SteamEngineBlockEntity> STEAM_ENGINE_ENTITY = RCURegistrates.REGISTRATE
      .blockEntity("steam_engine", ((BlockEntityType<SteamEngineBlockEntity> type, BlockPos pos, BlockState blockState) ->
          new SteamEngineBlockEntity(type, pos, blockState)))
      .validBlocks(RCUBlocks.STEAM_ENGINE)
      .register();

  public static final BlockEntityEntry<WindTurbineBlockEntity> WIND_TURBINE_ENTITY = RCURegistrates.REGISTRATE
      .blockEntity("wind_turbine", ((BlockEntityType<WindTurbineBlockEntity> type, BlockPos pos, BlockState blockState) ->
          new WindTurbineBlockEntity(type, pos, blockState)))
      .validBlocks(RCUBlocks.WIND_TURBINE)
      .register();

  public static final BlockEntityEntry<ACElectricEngineBlockEntity> AC_ELECTRIC_ENGINE_ENTITY = RCURegistrates.REGISTRATE
      .blockEntity("ac_electric_engine", ((BlockEntityType<ACElectricEngineBlockEntity> type, BlockPos pos, BlockState blockState) ->
          new ACElectricEngineBlockEntity(type, pos, blockState)))
      .validBlocks(RCUBlocks.AC_ELECTRIC_ENGINE)
      .register();

  public static final BlockEntityEntry<DCElectricEngineBlockEntity> DC_ELECTRIC_ENGINE_ENTITY = RCURegistrates.REGISTRATE
      .blockEntity("dc_electric_engine", ((BlockEntityType<DCElectricEngineBlockEntity> type, BlockPos pos, BlockState blockState) ->
          new DCElectricEngineBlockEntity(type, pos, blockState)))
      .validBlocks(RCUBlocks.DC_ELECTRIC_ENGINE)
      .register();

  public static final BlockEntityEntry<WorktableBlockEntity> WORKTABLE = RCURegistrates.REGISTRATE
      .blockEntity("worktable", ((BlockEntityType<WorktableBlockEntity> type, BlockPos pos, BlockState blockState) ->
          new WorktableBlockEntity(type, pos, blockState)))
      .validBlocks(RCUBlocks.WORKTABLE)
      .register();

  public static void init() {}
}
