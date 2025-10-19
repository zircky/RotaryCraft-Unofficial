package com.zircky.rotarycraft_unofficial.common;

import com.tterrag.registrate.util.entry.MenuEntry;
import com.zircky.rotarycraft_unofficial.api.registry.RCURegistrates;
import com.zircky.rotarycraft_unofficial.common.menu.WorktableMenu;
import com.zircky.rotarycraft_unofficial.common.screen.WorktableScreen;

public class RCUMenu {
  public static final MenuEntry<WorktableMenu> WORKTABLE_MENU = RCURegistrates.REGISTRATE
      .menu("worktable", (type, id, inv, buf) -> new WorktableMenu(type, id, inv, buf), () -> WorktableScreen::new).register();


  public static void init() {}
}
