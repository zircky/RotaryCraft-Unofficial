package com.zircky.rotarycraft_unofficial.api.block.engine;

import com.zircky.rotarycraft_unofficial.common.data.material.engine.EngineDefinition;
import com.zircky.rotarycraft_unofficial.common.data.material.engine.EngineDefinitions;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class AbstractEngineBlock extends Block {

  public AbstractEngineBlock(Properties pProperties) {
    super(pProperties);
  }

  @Override
  public void appendHoverText(ItemStack pStack, @Nullable BlockGetter pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
    EngineDefinition<?> engineDefinition = EngineDefinitions.getByBlock(this);

    if (engineDefinition == null) {
      pTooltip.add(Component.literal("Unknown Engine Type").withStyle(ChatFormatting.RED));
      return;
    }

    double powerW = engineDefinition.getPower();
    double torqueNm = engineDefinition.getTorque();
    double omegaRads = engineDefinition.getOmega();

    String powerStr = formatValue(powerW, "W", "kW", "MW");
    String torqueStr = formatValue(torqueNm, "Nm", "kNm", "MNm");
    String omegaStr = formatValue(omegaRads, "rad/s", "krad/s", "Mrad/s");

    pTooltip.add(Component.literal("Power: " + powerStr).withStyle(ChatFormatting.GRAY));
    pTooltip.add(Component.literal("Torque: " + torqueStr).withStyle(ChatFormatting.GRAY));
    pTooltip.add(Component.literal("Speed: " + omegaStr).withStyle(ChatFormatting.GRAY));
  }

  private static String formatValue(double value, String unit, String kiloUnit, String megaUnit) {
    if (value >= 1_000_000) {
      return String.format("%.3f %s", value / 1_000_000D, megaUnit);
    } else if (value >= 1_000) {
      return String.format("%.3f %s", value / 1_000D, kiloUnit);
    } else {
      return String.format("%.3f %s", value, unit);
    }
  }
}
