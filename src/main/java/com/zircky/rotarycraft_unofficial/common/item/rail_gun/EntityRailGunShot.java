package com.zircky.rotarycraft_unofficial.common.item.rail_gun;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraftforge.network.NetworkHooks;
public class EntityRailGunShot extends Projectile {

  private static final EntityDataAccessor<Integer> POWER =
      SynchedEntityData.defineId(EntityRailGunShot.class, EntityDataSerializers.INT);

  private double damage = 4.0; // базовый урон

  public EntityRailGunShot(EntityType<? extends EntityRailGunShot> type, Level level) {
    super(type, level);
  }

  public EntityRailGunShot(EntityType<? extends EntityRailGunShot> type,
                           Level level,
                           double x, double y, double z,
                           double vx, double vy, double vz,
                           int power,
                           Object railgun) {
    this(type, level);
    this.setPos(x, y, z);
    this.setDeltaMovement(vx, vy, vz);
    this.setPower(power);
    this.damage = Math.max(2.0, Math.pow(2, power) * 0.5); // урон растёт от мощности
  }

  @Override
  protected void defineSynchedData() {
    this.entityData.define(POWER, 0);
  }

  public void setPower(int power) {
    this.entityData.set(POWER, power);
  }

  public int getPower() {
    return this.entityData.get(POWER);
  }

  @Override
  protected void onHitEntity(EntityHitResult result) {
    super.onHitEntity(result);
    Entity target = result.getEntity();
    if (target instanceof LivingEntity living) {
      living.hurt(this.damageSources().thrown(this, this.getOwner()), (float) damage);
    }
    this.discard(); // исчезает после удара
  }

  @Override
  protected void onHitBlock(BlockHitResult result) {
    super.onHitBlock(result);
    this.discard(); // исчезает при попадании в блок
  }

  @Override
  protected void addAdditionalSaveData(CompoundTag tag) {
    tag.putInt("Power", getPower());
    tag.putDouble("Damage", damage);
  }

  @Override
  protected void readAdditionalSaveData(CompoundTag tag) {
    setPower(tag.getInt("Power"));
    damage = tag.getDouble("Damage");
  }

  @Override
  public Packet<ClientGamePacketListener> getAddEntityPacket() {
    return NetworkHooks.getEntitySpawningPacket(this);
  }
}
