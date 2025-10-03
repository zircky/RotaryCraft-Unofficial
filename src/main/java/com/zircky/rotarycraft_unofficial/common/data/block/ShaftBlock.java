package com.zircky.rotarycraft_unofficial.common.data.block;

import com.zircky.rotarycraft_unofficial.common.blockentity.ShaftBlockEntity;
import com.zircky.rotarycraft_unofficial.common.data.RCUContent;
import com.zircky.rotarycraft_unofficial.common.registry.MaterialRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class ShaftBlock extends Block implements EntityBlock {

  private final MaterialRegistry material;

  public ShaftBlock(MaterialRegistry mat, BlockBehaviour.Properties props) {
    super(props);
    this.material = mat;
  }

  public MaterialRegistry getMaterialType() {
    return material;
  }

  @Override
  public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
    ShaftBlockEntity be = new ShaftBlockEntity(pos, state);
    be.setMaterial(material);
    return be;
  }

  @Override
  public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
    return RCUContent.SHAFT_BE.get() == type ? (lvl, pos, st, be) -> ShaftBlockEntity.tick(lvl, pos, st, (ShaftBlockEntity) be) : null;
  }
}
