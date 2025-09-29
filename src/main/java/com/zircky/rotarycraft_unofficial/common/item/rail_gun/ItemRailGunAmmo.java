package com.zircky.rotarycraft_unofficial.common.item.rail_gun;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class ItemRailGunAmmo extends Item {

  public static final String AMMO_TYPE_TAG = "AmmoType";

  public ItemRailGunAmmo(Properties properties) {
    super(properties.stacksTo(16));
  }

//  @Override
//  public void fillItemCategory(CreativeModeTab group, List<ItemStack> items) {
//    if (allowedIn(group)) {
//      for (int i = 0; i < 16; i++) {
//        items.add(withType(this, i));
//      }
//    }
//  }

  @Override
  public String getDescriptionId(ItemStack stack) {
    int type = getType(stack);
    return super.getDescriptionId(stack) + "." + type;
  }

  public static ItemStack withType(Item item, int type) {
    ItemStack stack = new ItemStack(item);
    CompoundTag tag = stack.getOrCreateTag();
    tag.putInt(AMMO_TYPE_TAG, type);
    return stack;
  }

  public static int getType(ItemStack stack) {
    CompoundTag tag = stack.getTag();
    return tag != null ? tag.getInt(AMMO_TYPE_TAG) : 0;
  }

  public RailGunAmmoType getAmmo(ItemStack stack) {
    return BasicRailGunAmmo.getOrCreate(getType(stack));
  }


}
