package com.zircky.rotarycraft_unofficial.common.entities;

import com.zircky.rotarycraft_unofficial.api.interfaces.RailGunAmmo;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.protocol.Packet;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.*;

import java.util.List;
import java.util.Random;

//public class EntityRailGunShot extends Projectile {
//
//  private static final Random RAND = new Random();
//
//  private int power;
//  private TileEntityRailGun gun;
//  private RailGunAmmo.RailGunAmmoType ammoType;
//
//  // Конструктор для регистрации / десериализации
//  public EntityRailGunShot(EntityType<? extends EntityRailGunShot> type, Level level) {
//    super(type, level);
//  }
//
//  // Удобный конструктор для спавна
//  public EntityRailGunShot(EntityType<? extends EntityRailGunShot> type, Level level,
//                           double x, double y, double z,
//                           double vx, double vy, double vz,
//                           int power,
//                           TileEntityRailGun gun,
//                           RailGunAmmo.RailGunAmmoType ammoType) {
//    this(type, level);
//    this.setPos(x, y, z);
//    this.setDeltaMovement(vx, vy, vz);
//    this.power = power;
//    this.gun = gun;
//    this.ammoType = ammoType;
//    this.setNoGravity(true);
//  }
//
//  // Спрятанная утилита для получения ItemStack представления
//  public ItemStack getItemStack() {
//    return ammoType != null ? ammoType.getItem() : ItemStack.EMPTY;
//  }
//
//  @Override
//  public void tick() {
//    super.tick();
//
//    ++this.age; // projectile.tick уже не даёт public ticksExisted; используем age
//
//    // Если на стороне сервера — проверяем уничтожение/невалидность стрелка
//    if (!this.level.isClientSide) {
//      Entity shooter = this.getOwner();
//      if (shooter != null && shooter.isRemoved()) {
//        this.remove(RemovalReason.KILLED);
//        return;
//      }
//    }
//
//    // По аналогии с старым кодом: если прошло слишком много тиков — триггерим взрыв/импакт
//    if (!this.level.isClientSide && this.age > 80) {
//      this.onHit(new HitResult(this.position(), HitResult.Type.MISS, new BlockPos(this.blockPosition()))); // вызов onImpact-подобного
//      this.remove(RemovalReason.KILLED);
//      return;
//    }
//
//    // 1) Проверка блоков рэйкастом
//    Vec3 from = this.position();
//    Vec3 to = from.add(this.getDeltaMovement());
//    ClipContext context = new ClipContext(from, to, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, this);
//    BlockHitResult blockHit = this.level.clip(context);
//
//    if (blockHit.getType() != HitResult.Type.MISS) {
//      to = Vec3.atCenterOf(blockHit.getBlockPos());
//    }
//
//    // 2) Проверка сущностей
//    EntityHitResult entityHit = ProjectileUtil.getEntityHitResult(this.level, this, from, to,
//        this.getBoundingBox().expandTowards(this.getDeltaMovement()).inflate(1.0D),
//        (entity) -> !entity.isSpectator() && entity.isAlive() && entity != this.getOwner());
//
//    HitResult hit = entityHit != null ? entityHit : blockHit;
//
//    if (hit != null && hit.getType() != HitResult.Type.MISS) {
//      this.onHit(hit);
//      return; // после удара сущность удалится/обработается внутри onHit
//    }
//
//    // Двигаем снаряд
//    this.setPos(this.getX() + this.getDeltaMovement().x,
//        this.getY() + this.getDeltaMovement().y,
//        this.getZ() + this.getDeltaMovement().z);
//
//    // Эффект частиц при полёте (сервер посылает клиенту при необходимости)
//    if (this.level.isClientSide) {
//      this.level.addParticle(ParticleTypes.END_ROD, this.getX(), this.getY(), this.getZ(),
//          this.getDeltaMovement().x * -0.1, this.getDeltaMovement().y * -0.1, this.getDeltaMovement().z * -0.1);
//    }
//
//    // Если вода — создаём небольшую мощную реакцию (аналог старого поведения)
//    if (this.isInWater()) {
//      if (!this.level.isClientSide) {
//        this.level.explode(null, DamageSource.explosion(this.getOwner()), null,
//            this.getX(), this.getY(), this.getZ(), Math.min(3f + power * 0.1f, 10f),
//            Explosion.BlockInteraction.KEEP);
//      }
//      this.remove(RemovalReason.KILLED);
//    }
//  }
//
//  /**
//   * Обработка попадания по блоку/сущности.
//   * Вся разрушительная логика и урон мобам хранится здесь.
//   */
//  protected void onHit(HitResult result) {
//    if (this.level.isClientSide) return;
//
//    // Если уже удалена — ничего не делаем
//    if (!this.isAlive()) return;
//
//    // Если попали в блок и это тот же railgun — игнорируем
//    if (result.getType() == HitResult.Type.BLOCK) {
//      BlockHitResult bhr = (BlockHitResult) result;
//      BlockPos pos = bhr.getBlockPos();
//      BlockState bs = this.level.getBlockState(pos);
//      // TODO: заменить MachineRegistry.getMachine с твоей реализацей
//      // if (MachineRegistry.getMachine(level, pos) == MachineRegistry.RAILGUN) { this.remove(...); return; }
//    }
//
//    // Европа: небольшой взрыв частиц в точке
//    BlockPos center = new BlockPos(this.position());
//    // Спавним клиентские частицы через серверный вызов к игрокам в чанке
//    if (this.level instanceof ServerLevel serverLevel) {
//      serverLevel.sendParticles(ParticleTypes.EXPLOSION, this.getX(), this.getY(), this.getZ(),
//          1, 0.0, 0.0, 0.0, 0.0);
//    }
//
//    // Постим событие — если у тебя есть собственное событие
//    // MinecraftForge.EVENT_BUS.post(new RailgunImpactEvent(level, center.getX(), center.getY(), center.getZ(), this.power));
//
//    // Разрушаем блоки в области (приближённая адаптация старой логики)
//    // Диапазон и условная фильтрация зависят от power
//    int range = Math.min(6 + this.power / 3, 20); // примерная шкала
//    int r = range;
//    for (int dx = -r; dx <= r; dx++) {
//      for (int dy = -r; dy <= r; dy++) {
//        for (int dz = -r; dz <= r; dz++) {
//          BlockPos p = center.offset(dx, dy, dz);
//          double distSq = center.distSqr(p);
//          if (distSq > (r * r)) continue;
//
//          BlockState state = this.level.getBlockState(p);
//          Block b = state.getBlock();
//
//          // TODO: тут заменить условия на твою логику ReikaWorldHelper.softBlocks и ConfigRegistry
//          boolean soft = b != Blocks.AIR; // замени на реальную проверку мягких блоков
//          if (soft) {
//            // Ограничения: не ломаем закрепленные/неразрушаемые блоки, не трогаем блоки рельгана
//            // TODO: использовать ReikaBlockHelper.isUnbreakable и MachineRegistry.RAILGUN
//            if (!this.level.isClientSide && this.level.getBlockState(p).getDestroySpeed(level, p) >= 0) {
//              // Более сильная мощь — более серьёзное разрушение
//              if (this.power >= 5 || RAND.nextFloat() < Math.min(0.25f + this.power * 0.05f, 1f)) {
//                // Сбрасываем дропы и удаляем блок
//                // TODO: использовать ReikaItemHelper.dropItems если нужно контролируемо
//                this.level.destroyBlock(p, true, this.getOwner()); // true -> drop block
//              } else {
//                // частичное "повреждение" — альтернативное поведение:
//                // можно заменить блок на cobblestone, dirt и т.п. по старой логике
//              }
//            }
//          }
//        }
//      }
//    }
//
//    // Наносим урон сущностям в области — похожая на старую логическую "splash"
//    AABB splash = new AABB(center).inflate(6.0 + this.power * 0.5);
//    List<Entity> entities = this.level.getEntities(this, splash, (e) -> e instanceof LivingEntity || e instanceof ItemEntity || e instanceof EnderCrystal);
//    for (Entity ent : entities) {
//      if (ent == this) continue;
//      if (ent instanceof LivingEntity living) {
//        // Убираем баффы/дропы экипировки как в старом коде
//        // TODO: очистка эффектов и удаление экипировки по необходимости
//        // Наносим урон
//        int dmg = this.getAttackDamage();
//        DamageSource ds = this.getDamageSource();
//        if (living instanceof EnderDragon) {
//          // урон по частям дракона нужно обрабатывать по-особенному — упрощаем:
//          living.hurt(ds, dmg);
//        } else {
//          living.hurt(ds, dmg);
//        }
//
//        // knockback
//        Vec3 motion = this.getDeltaMovement();
//        double kbMult = 1.0;
//        if (living instanceof TargetEntity te) {
//          kbMult = te.getKnockbackMultiplier(gun, this.ammoType);
//        }
//        living.setDeltaMovement(motion.x * kbMult * this.power / 15.0, motion.y * kbMult * this.power / 15.0, motion.z * kbMult * this.power / 15.0);
//
//        // Если игрок убит — можно триггерить advancement
//        if (living instanceof Player pl && pl.isDeadOrDying()) {
//          // TODO: триггерить advancement — в 1.20.1 это делается через Criteria/Advancement JSONs и триггеры
//        }
//      } else if (ent instanceof ItemEntity ie) {
//        // старый код только оставлял возможность уничтожить фреймы/кристаллы
//        ie.hurt(DamageSource.GENERIC, this.getAttackDamage());
//      } else {
//        // например EntityItemFrame, EnderCrystal и т.д.
//        ent.hurt(DamageSource.GENERIC, this.getAttackDamage());
//      }
//    }
//
//    // Лава/частицы вокруг
//    for (int i = 0; i < Math.min(10, 1 + this.power); i++) {
//      double px = this.getX() + (RAND.nextDouble() - 0.5) * 2;
//      double py = this.getY() + (RAND.nextDouble() - 0.5) * 2;
//      double pz = this.getZ() + (RAND.nextDouble() - 0.5) * 2;
//      if (this.level instanceof ServerLevel sl) {
//        sl.sendParticles(ParticleTypes.LAVA, px, py, pz, 1, 0.1, 0.1, 0.1, 0.0);
//      }
//    }
//
//    // Финал — удаляем сущность
//    this.remove(RemovalReason.KILLED);
//  }
//
//  protected int getAttackDamage() {
//    if (this.power >= 15) return Integer.MAX_VALUE / 4;
//    double pow = Math.pow(4D, this.power) / 16384D;
//    return (int) (1 + this.power + pow);
//  }
//
//  protected DamageSource getDamageSource() {
//    Entity owner = this.getOwner();
//    if (owner != null) return DamageSource.indirectMagic(this, owner);
//    return DamageSource.GENERIC;
//  }
//
//  // Нужен для сетевого спавна сущности через packets
//  @Override
//  public Packet<?> getAddEntityPacket() {
//    return NetworkHooks.getEntitySpawningPacket(this);
//  }
//
//  // Сохраняем/загружаем NBT
//  @Override
//  protected void addAdditionalSaveData(net.minecraft.nbt.CompoundTag compound) {
//    compound.putInt("Power", this.power);
//    // TODO: сохранить позицию gun (если нужно), id ammoType, и т.д.
//  }
//
//  @Override
//  protected void readAdditionalSaveData(net.minecraft.nbt.CompoundTag compound) {
//    this.power = compound.getInt("Power");
//    // TODO: восстановить gun/ammoType по ссылкам/идентификаторам
//  }
//
//  // projectile не имеет default render item, если нужно — реализуй getItem
//  @Override
//  public Packet<?> getSharePacket() {
//    return super.getSharePacket();
//  }
//}
