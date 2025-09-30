package com.zircky.rotarycraft_unofficial.common.entities;

import com.zircky.rotarycraft_unofficial.api.interfaces.RailGunAmmo;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;

public class BlockEntityRailGun extends BlockEntity implements Container {
  public static final int MAXLOWANGLE = -10;
  // inventory
  protected final int INVENTORY_SIZE = 54;
  protected final SimpleContainer inv = new SimpleContainer(INVENTORY_SIZE);

  // state
  private RailGunAmmo.RailGunAmmoType ammoType;
  private int torque = 0;      // current torque/power input (замени на твою логику питания)
  private int power = 0;       // internal power value (if used)
  private int tickcount = 0;   // tick counter
  private int MINPOWER = 1;    // минимальная мощность для стрельбы (подставь свою)
  private Entity closestMob;   // last target found
  private int dir = 1;         // направление по вертикали (1 / -1) — сохранил из старого
  private UUID placerUUID;     // хранит плейсера (если нужно)
  private int age = 0;

  public BlockEntityRailGun(BlockPos pos, BlockState state, BlockEntityType<?> type) {
    super((BlockEntityType<BlockEntityRailGun>) type, pos, state);
  }

  // ----------------------------------------
  // Inventory / Container простая реализация
  // ----------------------------------------
  @Override
  public int getContainerSize() { return INVENTORY_SIZE; }

  @Override
  public boolean isEmpty() { return inv.isEmpty(); }

  @Override
  public ItemStack getItem(int slot) { return inv.getItem(slot); }

  @Override
  public ItemStack removeItem(int slot, int amount) { return inv.removeItem(slot, amount); }

  @Override
  public ItemStack removeItemNoUpdate(int slot) { return inv.removeItemNoUpdate(slot); }

  @Override
  public void setItem(int slot, @NotNull ItemStack stack) {
    inv.setItem(slot, stack);
    setChangedAndSync();
  }

  @Override
  public boolean stillValid(@NotNull Player player) { return true; }

  @Override
  public void clearContent() { inv.clearContent(); setChangedAndSync(); }

  @Override
  public void setChanged() { super.setChanged(); }

  protected void setChangedAndSync() {
    this.setChanged();
    if (level != null) {
      level.sendBlockUpdated(this.worldPosition, this.getBlockState(), this.getBlockState(), 3);
    }
  }

  // ----------------------------------------
  // Ammo checking / selection
  // ----------------------------------------
  public boolean hasAmmo() {
    ammoType = null;
    this.checkAmmo();
    return ammoType != null;
  }

  private void checkAmmo() {
    for (int i = 0; i < this.getContainerSize(); i++) {
      ItemStack stack = this.getItem(i);
      RailGunAmmo.RailGunAmmoType rg = getAmmo(stack);
      if (rg != null) {
        if (this.torque >= rg.getRequiredTorque()) {
          if (ammoType == null || rg.compareTo(ammoType) > 0) {
            ammoType = rg;
          }
        }
      }
    }
  }

  private static RailGunAmmo.RailGunAmmoType getAmmo(ItemStack is) {
    if (is == null || is.isEmpty()) return null;
    if (is.getItem() instanceof RailGunAmmo) {
      return ((RailGunAmmo)is.getItem()).getAmmo(is);
    }
    return null;
  }

  // ----------------------------------------
  // Tick logic (вызвать через регистрационный тикер / tick method)
  // ----------------------------------------
  public void tick() {
    if (level == null) return;
    age++;
    tickcount++;

    // TODO: подставь свою логику power/minpower/torque (источник энергии)
    if (power < MINPOWER) return;

    if (!this.hasAmmo()) return;

    // Получаем цель
    double[] target = this.getTarget(level, worldPosition.getX(), worldPosition.getY(), worldPosition.getZ());
    if (!this.isAimingAtTarget(level, worldPosition.getX(), worldPosition.getY(), worldPosition.getZ(), target)) return;
    if (tickcount < this.getOperationTime()) return;
    tickcount = 0;

    if ((int) target[3] == 1) {
      if (!level.isClientSide) {
        this.fire(level, target);
        this.setChangedAndSync();
      }
    }
  }

  // Возвращает {x,y,z,flag} — flag==1 если цель найдена
  protected double[] getTarget(Level world, int x, int y, int z) {
    double[] xyzb = new double[4];
    int r = this.getRange();
    AABB range = new AABB(x - r, y - r, z - r, x + 1 + r, y + 1 + r, z + 1 + r);
    List<Entity> inrange = world.getEntities((Entity) null, range, (e) -> true);
    double mindist = this.getRange() + 2;
    Entity i_at_min = null;
    for (Entity ent : inrange) {
      double dx = ent.getX() - x - 0.5;
      double dy = ent.getY() - y - 0.5;
      double dz = ent.getZ() - z - 0.5;
      double dist = Math.sqrt(dx*dx + dy*dy + dz*dz);
      if (this.isValidTarget(ent)) {
        // TODO: заменить ReikaWorldHelper.canBlockSee на более точную проверку (raytrace)
        boolean canSee = canBlockSee(world, x, y, z, ent.getX(), ent.getY(), ent.getZ(), this.getRange());
        if (canSee) {
          double dyAbs = - (ent.getY() - y);
          double reqtheta = -90 + Math.toDegrees(Math.abs(Math.acos(Math.max(-1.0, Math.min(1.0, dyAbs / Math.max(1E-6, dist))))));
          if ((reqtheta <= dir * MAXLOWANGLE && dir == -1) || (reqtheta >= dir * MAXLOWANGLE && dir == 1)) {
            if (dist < mindist) {
              mindist = dist;
              i_at_min = ent;
            }
          }
        }
      }
    }
    if (i_at_min == null) return xyzb;
    closestMob = i_at_min;
    double rx = closestMob.getX() + this.randomOffset();
    double ry = closestMob.getY() + closestMob.getEyeHeight() * 0.25 + this.randomOffset();
    double rz = closestMob.getZ() + this.randomOffset();
    xyzb[0] = rx;
    xyzb[1] = ry;
    xyzb[2] = rz;
    xyzb[3] = 1;
    return xyzb;
  }

  // NOTE: very simple visibility check (raytrace) — replace with ReikaWorldHelper.canBlockSee if you have it
  protected boolean canBlockSee(Level world, int bx, int by, int bz, double tx, double ty, double tz, int maxRange) {
    Vec3 from = new Vec3(bx + 0.5, by + 0.5, bz + 0.5);
    Vec3 to = new Vec3(tx, ty, tz);
    // ClipContext: BLOCK -> COLLIDER, include fluids? NONE
    net.minecraft.world.level.ClipContext cc = new net.minecraft.world.level.ClipContext(from, to,
        net.minecraft.world.level.ClipContext.Block.COLLIDER, net.minecraft.world.level.ClipContext.Fluid.NONE, null);
    var res = world.clip(cc);
    return res.getType() == net.minecraft.world.phys.HitResult.Type.MISS;
  }

  protected boolean isAimingAtTarget(Level world, int x, int y, int z, double[] target) {
    return target != null && target.length >= 4 && (int) target[3] == 1;
  }

  protected int getOperationTime() {
    // TODO: подставь свою операционную длительность
    return 20;
  }

  public void fire(Level world, double[] xyz) {
    double speed = 4.0;
    if (ammoType == null) this.checkAmmo();
    if (ammoType == null) return;

    ItemStack is = ammoType.getItem();
    int slot = locateInInventory(is);
    if (slot >= 0) {
      // consume one
      ItemStack s = this.getItem(slot);
      s.shrink(1);
      if (s.isEmpty()) this.setItem(slot, ItemStack.EMPTY);
    }

    double dx = xyz[0] - this.worldPosition.getX();
    double dy = xyz[1] - this.worldPosition.getY();
    double dz = xyz[2] - this.worldPosition.getZ();
    double dd = Math.sqrt(dx*dx + dy*dy + dz*dz);
    if (dd <= 0.0001) dd = 1.0;
    double vx = dx / dd * speed;
    double vy = dy / dd * speed;
    double vz = dz / dd * speed;

    if (!world.isClientSide) {
      double spawnY = this.getFiringPositionY(dy);
      // spawn entity using ammoType
      Entity e = ammoType.getProjectileEntity(world,
          this.worldPosition.getX() + 0.5 + vx / speed,
          spawnY,
          this.worldPosition.getZ() + 0.5 + vz / speed,
          vx, vy, vz, this);
      if (e != null) {
        // spawn via server-level
        if (world instanceof ServerLevel srv) {
          srv.addFreshEntity((Entity) e);
        } else {
          world.addFreshEntity(e);
        }
      }
    }
  }

  protected double getFiringPositionY(double dy) {
    // старая логика: getFiringPositionY(dy)
    // TODO: поправь под реальное расположение ствола
    return this.worldPosition.getY() + 1.0;
  }

  public int getRange() { return 164; }

  public Entity getClosestMob() { return closestMob; }

  protected double randomOffset() { return 0.0; }

  public int getSizeInventory() { return INVENTORY_SIZE; }

  public boolean hasModelTransparency() { return false; }

  // TODO: заменить на return MachineRegistry.RAILGUN
  public Object getTile() { return null; }

  @Override
  public boolean canPlaceItem(int slot, ItemStack stack) {
    return stack.getItem() instanceof RailGunAmmo;
  }

  public int getMaxRange() { return 256; }

  public int getRedstoneOverride() { return 0; }

  protected boolean isValidTarget(Entity ent) {
    if (ent == null) return false;
    if (!ent.isAlive()) return false;
    if (ent instanceof LivingEntity elb) {
      return elb.getHealth() > 0 && this.isMobOrUnlistedPlayer(elb);
    }
    // optionally TargetEntity handling
    // TODO: if (ent instanceof TargetEntity) { ... }
    return false;
  }

  protected boolean isMobOrUnlistedPlayer(LivingEntity el) {
    // TODO: replicate your previous logic that filters mobs/players
    return el instanceof Mob || el instanceof Player;
  }

  protected int locateInInventory(ItemStack needle) {
    for (int i = 0; i < this.getContainerSize(); i++) {
      ItemStack s = this.getItem(i);
      if (!s.isEmpty() && ItemStack.matches(s, needle)) return i;
    }
    return -1;
  }

  // ----------------------------------------
  // NBT (save/load)
  // ----------------------------------------
  @Override
  protected void saveAdditional(@NotNull CompoundTag tag) {
    super.saveAdditional(tag);
    // inventory
    for (int i = 0; i < INVENTORY_SIZE; i++) {
      ItemStack stack = inv.getItem(i);
      if (!stack.isEmpty()) {
        tag.put("Item" + i, stack.save(new CompoundTag()));
      }
    }
    tag.putInt("Torque", torque);
    tag.putInt("Power", power);
    tag.putInt("TickCount", tickcount);
    tag.putInt("Age", age);
    // TODO: save placerUUID if needed
  }

  @Override
  public void load(@NotNull CompoundTag tag) {
    super.load(tag);
    for (int i = 0; i < INVENTORY_SIZE; i++) {
      if (tag.contains("Item" + i)) {
        inv.setItem(i, ItemStack.of(tag.getCompound("Item" + i)));
      } else {
        inv.setItem(i, ItemStack.EMPTY);
      }
    }
    torque = tag.getInt("Torque");
    power = tag.getInt("Power");
    tickcount = tag.getInt("TickCount");
    age = tag.getInt("Age");
  }

  // ----------------------------------------
  // Networking: sync BlockEntity to client
  // ----------------------------------------
  @Nullable
  @Override
  public ClientboundBlockEntityDataPacket getUpdatePacket() {
    return ClientboundBlockEntityDataPacket.create(this);
  }

  @Override
  public CompoundTag getUpdateTag() {
    CompoundTag tag = new CompoundTag();
    this.saveAdditional(tag);
    return tag;
  }

  // ----------------------------------------
  // Helpers / getters / setters
  // ----------------------------------------
  public void setTorque(int t) { this.torque = t; setChangedAndSync(); }
  public int getTorque() { return torque; }
  public void setPower(int p) { this.power = p; setChangedAndSync(); }
  public int getPower() { return power; }

  // ----------------------------------------
  // Optional: register a ticker (пример)
  // ----------------------------------------
  public static <T extends BlockEntity> void tickServer(Level level, BlockPos pos, BlockState state, T be) {
    if (be instanceof BlockEntityRailGun rg) {
      rg.tick();
    }
  }
}
