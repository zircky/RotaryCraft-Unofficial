package com.zircky.rotarycraft_unofficial.common.blockentity;

import com.zircky.rotarycraft_unofficial.api.interfaces.IPowerHandler;
import com.zircky.rotarycraft_unofficial.api.library.EngLibrary;
import com.zircky.rotarycraft_unofficial.common.data.RCUTransmission;
import com.zircky.rotarycraft_unofficial.common.registry.MaterialRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ShaftBlockEntity extends BlockEntity implements IPowerHandler {

  private long torque = 0;
  private long omega = 0;
  private long power = 0;
  private boolean failed = false;

  private MaterialRegistry material = MaterialRegistry.WOOD;

  public float phi = 0;
  public float crossPhi1 = 0;
  public float crossPhi2 = 0;


  public ShaftBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
    super(type, pos, state);
  }

  public ShaftBlockEntity(BlockPos pos, BlockState state) {
    super(RCUTransmission.SHAFT_BE.get(), pos, state);
  }

  public void setMaterial(MaterialRegistry mat) {
    this.material = mat;
    setChanged();
  }

  public MaterialRegistry getMaterialType() {
    return material;
  }

  public void setTorqueOmega(long torque, long omega) {
    this.torque = torque;
    this.omega = omega;
    this.power = torque * omega;
    setChanged();
  }

  public boolean isFailed() {
    return failed;
  }

  public void fail(@Nullable Level level, boolean speedFailure) {
    this.failed = true;
    setChanged();
    if (level == null || level.isClientSide) return;

    // дроп в зависимости от материала
    ItemStack drop = switch (material) {
      case WOOD -> new ItemStack(Blocks.OAK_SLAB); // пример
      case STONE -> new ItemStack(Blocks.COBBLESTONE);
      case STEEL, TUNGSTEN -> new ItemStack(Blocks.IRON_BLOCK);
      case DIAMOND -> new ItemStack(Blocks.DIAMOND_BLOCK);
      case BEDROCK -> new ItemStack(Blocks.BEDROCK);
    };

    ItemEntity ie = new ItemEntity(level, worldPosition.getX() + 0.5, worldPosition.getY() + 1.0, worldPosition.getZ() + 0.5, drop);
    ie.setDeltaMovement( (level.random.nextFloat()-0.5)*0.2, 0.2 + level.random.nextFloat()*0.4, (level.random.nextFloat()-0.5)*0.2 );
    ((ServerLevel)level).addFreshEntity(ie);

    if (speedFailure) {
      level.explode(null, worldPosition.getX()+0.5, worldPosition.getY()+0.5, worldPosition.getZ()+0.5, 1.0f, Level.ExplosionInteraction.BLOCK);
    }
  }

  public static void tick(Level level, BlockPos pos, BlockState state, ShaftBlockEntity be) {
    if (level.isClientSide) {
      be.phi += Math.pow(Math.log(be.omega + 1) / Math.log(2.0), 1.25);
      return;
    }

    // Проверки разрушения
    if (!be.material.isInfiniteStrength()) {
      if (EngLibrary.mat_rotfailure(be.material.rho, 0.0625, be.omega, be.material.tensile)) {
        be.fail(level, true);
        return;
      }
      if (EngLibrary.mat_twistfailure((int) be.torque, 0.0625, be.material.shear)) {
        be.fail(level, false);
        return;
      }
    }

    // --- Новая логика ---
    long avgOmega = be.omega;
    long totalTorque = be.torque;
    int count = 1;

    for (Direction dir : Direction.values()) {
      BlockEntity neighbor = level.getBlockEntity(pos.relative(dir));
      if (neighbor instanceof IPowerHandler handler && handler.canReceive()) {
        avgOmega += handler.getOmega();
        totalTorque += handler.getTorque();
        count++;
      }
    }

    // Средняя скорость вращения
    long newOmega = avgOmega / count;
    long newTorque = totalTorque / count;

    // Обновляем себя
    be.setTorqueOmega(newTorque, newOmega);

    // Передаём соседям
    for (Direction dir : Direction.values()) {
      BlockEntity neighbor = level.getBlockEntity(pos.relative(dir));
      if (neighbor instanceof IPowerHandler handler && handler.canReceive()) {
        handler.setPower(newTorque, newOmega);
      }
    }
  }

  @Override
  public long getOmega() {
    return omega;
  }

  @Override
  public long getTorque() {
    return torque;
  }

  @Override
  public void setPower(long torque, long omega) {
    this.torque = torque;
    this.omega = omega;
    this.power = torque * omega;
    setChanged();
  }

  @Override
  public boolean canReceive() {
    return !failed;
  }

  // Сохранение / загрузка
  @Override
  protected void saveAdditional(@NotNull CompoundTag pTag) {
    super.saveAdditional(pTag);
    pTag.putLong("torque", torque);
    pTag.putLong("omega", omega);
    pTag.putLong("power", power);
    pTag.putBoolean("failed", failed);
    pTag.putString("material", material.name());
    pTag.putFloat("phi", phi);
    pTag.putFloat("cphi1", crossPhi1);
    pTag.putFloat("cphi2", crossPhi2);
  }

  @Override
  public void load(@NotNull CompoundTag pTag) {
    super.load(pTag);
    if (pTag.contains("torque")) torque = pTag.getLong("torque");
    if (pTag.contains("omega")) omega = pTag.getLong("omega");
    if (pTag.contains("power")) power = pTag.getLong("power");
    failed = pTag.getBoolean("failed");
    if (pTag.contains("material")) {
      try {
        material = MaterialRegistry.valueOf(pTag.getString("material"));
      } catch (IllegalArgumentException e) {
        material = MaterialRegistry.WOOD;
      }
    }
    phi = pTag.getFloat("phi");
    crossPhi1 = pTag.getFloat("cphi1");
    crossPhi2 = pTag.getFloat("cphi2");
  }
}