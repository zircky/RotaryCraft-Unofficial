package com.zircky.rotarycraft_unofficial.api.registry.registry.provider;

import com.zircky.rotarycraft_unofficial.RotaryCraftUnofficial;
import com.zircky.rotarycraft_unofficial.common.data.material.ShaftMaterial;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

public class RCULangProvider extends LanguageProvider {
  public RCULangProvider (PackOutput packOutput) {
    super(packOutput, RotaryCraftUnofficial.MODID, "ru_ru");
  }

  @Override
  protected void addTranslations() {
    for (ShaftMaterial mat : ShaftMaterial.all()) {
      String id = mat.getId();
      String displayName = getLocalizedMaterialName(mat);

      add("block." + RotaryCraftUnofficial.MODID + "." + id + "_shaft", displayName + " вал");
    }
  }

  private String getLocalizedMaterialName(ShaftMaterial mat) {
    return switch (mat.getId()) {
      case "wood" -> "Деревянный";
      case "stone" -> "Каменный";
      case "steel" -> "Стальной";
      case "tungsten" -> "Вольфрамовый";
      case "diamond" -> "Алмазный";
      case "bedrock" -> "Бедроковый";
      default -> capitalize(mat.getId());
    };
  }

  private String capitalize(String str) {
    return str.substring(0, 1).toUpperCase() + str.substring(1);
  }
}
