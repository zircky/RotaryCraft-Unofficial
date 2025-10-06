package com.zircky.rotarycraft_unofficial.common.data.block;

import com.zircky.rotarycraft_unofficial.common.blockentity.GearboxBlockEntity;
import com.zircky.rotarycraft_unofficial.common.blockentity.ShaftBlockEntity;
import com.zircky.rotarycraft_unofficial.common.registry.MaterialRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class GearboxBlock extends Block implements EntityBlock {

  private final MaterialRegistry material;
  private final GearRatio ratio;

  public GearboxBlock(MaterialRegistry material, Properties pProperties, GearRatio ratio) {
    super(pProperties);
    this.material = material;
    this.ratio = ratio;
  }

  public MaterialRegistry  getMaterial() {
    return material;
  }

  public GearRatio getRatio() {
    return ratio;
  }


  @Override
  public @Nullable BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
    GearboxBlockEntity be = new GearboxBlockEntity(pPos, pState);
    be.setMaterial(material);
    return be;
  }

  @Override
  public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
    return EntityBlock.super.getTicker(pLevel, pState, pBlockEntityType);
  }

  public enum GearRatio {
    TWO(2),
    FOUR(4),
    EIGHT(8),
    SIXTEEN(16);

    private final int ratio;

    GearRatio(int ratio) {
      this.ratio = ratio;
    }

    public int getRatio() {
      return ratio;
    }
  }
}
