package com.zircky.rotarycraft_unofficial.api.block.entity_block;

import com.zircky.rotarycraft_unofficial.RotaryCraftUnofficial;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public abstract class BaseEngineBlockEntity extends BlockEntity {
  protected boolean active = false;
  protected float rotation = 0;
  protected float prevRotation = 0;
  protected float speedPerTick = 0;

  public BaseEngineBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state, int omega) {
    super(type, pos, state);
    this.speedPerTick = (float) Math.toDegrees(omega) / 20.0f;
  }

  // ─────────────────────────────
  // 🔄 Синхронизация
  // ─────────────────────────────
  @Override
  protected void saveAdditional(CompoundTag tag) {
    super.saveAdditional(tag);
    tag.putBoolean("Active", this.active);
    tag.putFloat("Rotation", this.rotation);
  }

  @Override
  public void load(CompoundTag tag) {
    super.load(tag);
    this.active = tag.getBoolean("Active");
    this.rotation = tag.getFloat("Rotation");
  }

  @Override
  public CompoundTag getUpdateTag() {
    CompoundTag tag = super.getUpdateTag();
    tag.putBoolean("Active", this.active);
    tag.putFloat("Rotation", this.rotation);
    return tag;
  }

  @Override
  public ClientboundBlockEntityDataPacket getUpdatePacket() {
    return ClientboundBlockEntityDataPacket.create(this);
  }

  @Override
  public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt) {
    if (pkt.getTag() != null) this.load(pkt.getTag());
  }

  // ─────────────────────────────
  // ⚙️ Обновление состояния
  // ─────────────────────────────
  public void setActive(boolean active) {
    if (this.active != active) {
      this.active = active;
      if (level != null && !level.isClientSide) {
        setChanged();
        level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), 3);
      }
    }
  }

  public boolean isActive() { return active; }

  // ─────────────────────────────
  // 🎞️ Вращение
  // ─────────────────────────────
  @OnlyIn(Dist.CLIENT)
  public static void clientTick(Level level, BlockPos pos, BlockState state, BaseEngineBlockEntity engine) {
    engine.prevRotation = engine.rotation;
    if (engine.active) {
      engine.rotation = (engine.rotation + engine.speedPerTick) % 360f;
      System.out.println("clientTick rotation=" + engine.rotation);
    }
  }

  public float getInterpolatedRotation(float partialTicks) {
    return prevRotation + (rotation - prevRotation) * partialTicks;
  }
}
