package com.zircky.rotarycraft_unofficial.common.item.rail_gun;

import com.zircky.rotarycraft_unofficial.api.interfaces.RailGunAmmo;
import com.zircky.rotarycraft_unofficial.base.item.tools.ItemRailgunAmmoBase;
import com.zircky.rotarycraft_unofficial.common.data.tools.RCUTools;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;

import java.util.HashMap;

public class ItemRailGunAmmo extends ItemRailgunAmmoBase {

  public ItemRailGunAmmo(Item.Properties properties) {
    super(properties);
  }

//  @Override
//  public void fillItemCategory(CreativeModeTab.Output output) {
//    for (int i = 0; i < 16; i++) {
//      output.accept(new ItemStack(this, 1, i));
//    }
//  }

  @Override
  public String getDescriptionId(ItemStack stack) {
    int d = stack.getDamageValue();
    return super.getDescriptionId(stack) + "." + d;
  }

  @Override
  public RailGunAmmoType getAmmo(ItemStack stack) {
    return getType(stack.getDamageValue());
  }

  public static RailGunAmmoType getType(int pw) {
    BasicRailGunAmmo ret = BasicRailGunAmmo.cache.get(pw);
    if (ret == null) {
      ret = new BasicRailGunAmmo(pw);
      BasicRailGunAmmo.cache.put(pw, ret);
    }
    return ret;
  }

  // 🔹 Вложенный класс, как и раньше
  public static class BasicRailGunAmmo implements RailGunAmmo.RailGunAmmoType {

    private static final HashMap<Integer, BasicRailGunAmmo> cache = new HashMap<>();

    private final int power;

    private BasicRailGunAmmo(int p) {
      power = p;
    }

    @Override
    public Entity getProjectileEntity(Level level, double x, double y, double z,
                                      double vx, double vy, double vz,
                                      BlockEntity railgun) {
//      if (railgun instanceof TileEntityRailGun rg) {
//        return new EntityRailGunShot(level, x, y, z, vx, vy, vz, power, rg);
//      }
      return null;
    }

    @Override
    public ItemStack getItem() {
      return RCUTools.RailGunAmmo.asStack(power);
    }

    @Override
    public int getRequiredTorque() {
      return (int) Math.sqrt(512 * (1 << power));
    }

    @Override
    public int compareTo(RailGunAmmo.RailGunAmmoType type) {
      return Integer.compare(this.power, ((BasicRailGunAmmo) type).power);
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
      return 1 << power;
    }
  }
}
