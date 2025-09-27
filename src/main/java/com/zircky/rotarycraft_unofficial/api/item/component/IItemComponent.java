package com.zircky.rotarycraft_unofficial.api.item.component;

import net.minecraft.world.item.Item;

public interface IItemComponent {

  default void onAttached(Item item) {}
}
