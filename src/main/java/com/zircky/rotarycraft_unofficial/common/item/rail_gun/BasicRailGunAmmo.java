package com.zircky.rotarycraft_unofficial.common.item.rail_gun;

import com.zircky.rotarycraft_unofficial.common.data.tools.RCUTools;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import javax.swing.text.html.parser.Entity;
import java.util.HashMap;
import java.util.Map;

public class BasicRailGunAmmo implements RailGunAmmoType {

  private static final Map<Integer, BasicRailGunAmmo> CACHE = new HashMap<>();

  private final int power;

  private BasicRailGunAmmo(int power) {
    this.power = power;
  }

  /**
   * Получить или создать боеприпас с указанной мощностью.
   */
  public static BasicRailGunAmmo getOrCreate(int power) {
    return CACHE.computeIfAbsent(power, BasicRailGunAmmo::new);
  }

  @Override
  public Entity createProjectile(Level level,
                                 double x, double y, double z,
                                 double vx, double vy, double vz,
                                 Object railgun) {
    // ⚠️ Тебе нужно будет заменить EntityRailGunShot на твой класс сущности!
    // railgun также заменить на твой BlockEntityRailGun
    return null;
  }

  @Override
  public ItemStack getItem() {
    // ⚠️ Здесь возвращай ItemStack для текущего боеприпаса.
    // Например, если ты регистрируешь предмет через DeferredRegister:
    // return new ItemStack(ModItems.RAILGUN_AMMO.get(), 1);
    return RCUTools.RailGunAmmo.get().getDefaultInstance();
  }

  @Override
  public int getRequiredTorque() {
    // Аналогично твоему старому коду:
    // sqrt(512 * 2^power)
    return (int) Math.sqrt(512 * (1 << power));
  }

  @Override
  public boolean isExplosive() {
    return false;
  }

  @Override
  public boolean isMagic() {
    return false;
  }

  @Override
  public int getMass() {
    // Масса = 2^power
    return 1 << power;
  }

  @Override
  public int compareTo(RailGunAmmoType other) {
    if (other instanceof BasicRailGunAmmo ammo) {
      return Integer.compare(this.power, ammo.power);
    }
    return 0;
  }

  public int getPower() {
    return power;
  }
}
