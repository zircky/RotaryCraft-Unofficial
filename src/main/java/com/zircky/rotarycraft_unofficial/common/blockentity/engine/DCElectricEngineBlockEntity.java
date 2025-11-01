package com.zircky.rotarycraft_unofficial.common.blockentity.engine;

import com.zircky.rotarycraft_unofficial.api.block.entity_block.BaseEngineBlockEntity;
import com.zircky.rotarycraft_unofficial.common.data.RCUBlockEntities;
import com.zircky.rotarycraft_unofficial.common.data.material.engine.EngineDefinitions;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class DCElectricEngineBlockEntity extends BaseEngineBlockEntity {
  public DCElectricEngineBlockEntity(BlockPos pPos, BlockState pBlockState) {
    super(RCUBlockEntities.DC_ELECTRIC_ENGINE_ENTITY.get(), pPos, pBlockState, EngineDefinitions.getById("dc_electric_engine").getOmega());
    System.out.println("Test Entity Omega: " + EngineDefinitions.getById("dc_electric_engine").getOmega());
  }

  @OnlyIn(Dist.CLIENT)
  public float getClientRotation(float partialTicks) {
    return (this.rotation + EngineDefinitions.getById("dc_electric_engine").getOmega() * partialTicks) % 360f;
  }
}