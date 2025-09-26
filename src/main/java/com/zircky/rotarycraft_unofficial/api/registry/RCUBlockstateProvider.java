package com.zircky.rotarycraft_unofficial.api.registry;

import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.tterrag.registrate.AbstractRegistrate;
import com.tterrag.registrate.providers.ProviderType;
import com.tterrag.registrate.providers.RegistrateBlockstateProvider;
import com.tterrag.registrate.providers.RegistrateProvider;
import com.zircky.rotarycraft_unofficial.client.util.ExtendedBlockModelRotation;
import net.minecraft.core.Direction;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.PackOutput;
import net.minecraft.data.models.blockstates.*;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraftforge.client.model.generators.IGeneratedBlockState;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public class RCUBlockstateProvider extends RegistrateBlockstateProvider {
  public static final String Z_ROT_PROPERTY_NAME = "rotarycraft_unofficial:z";
  private static final VariantProperty<VariantProperties.Rotation> X_ROT = VariantProperties.X_ROT;
  private static final VariantProperty<VariantProperties.Rotation> Y_ROT = VariantProperties.Y_ROT;
  private static final VariantProperty<VariantProperties.Rotation> Z_ROT = new VariantProperty<>(Z_ROT_PROPERTY_NAME,
      r -> new JsonPrimitive(r.ordinal() * 90));

  public static final ExistingFileHelper.ResourceType TEXTURE = new ExistingFileHelper.ResourceType(PackType.CLIENT_RESOURCES, ".png", "textures");
  public static final ExistingFileHelper.ResourceType MODEL = new ExistingFileHelper.ResourceType(PackType.CLIENT_RESOURCES, ".json", "models");

  private static RCUBlockstateProvider CURRENT_PROVIDER = null;

  public RCUBlockstateProvider(AbstractRegistrate<?> parent, GatherDataEvent event,
                               Map<ProviderType<?>, RegistrateProvider> existing) {
    this(parent, event.getGenerator().getPackOutput(), event.getExistingFileHelper());
    existing.put(ProviderType.BLOCKSTATE, this);
  }

  public RCUBlockstateProvider(AbstractRegistrate<?> parent, PackOutput packOutput, ExistingFileHelper exFileHelper) {
    super(parent, packOutput, exFileHelper);
  }

  public static RCUBlockstateProvider getCurrentProvider() {
    return CURRENT_PROVIDER;
  }

  @Override
  public @NotNull CompletableFuture<?> run(CachedOutput cache) {
    CURRENT_PROVIDER = this;
    var value = super.run(cache);
    CURRENT_PROVIDER = null;
    return value;
  }

  public ExistingFileHelper getExistingFileHelper() {
    return this.models().existingFileHelper;
  }

  public MultiVariantGenerator multiVariantGenerator(Block block) {
    var multiVariant = MultiVariantGenerator.multiVariant(block);
    registeredBlocks.put(block, new BlockStateGeneratorWrapper(multiVariant));
    return multiVariant;
  }

  public MultiVariantGenerator multiVariantGenerator(Block block, Variant baseVariant) {
    var multiVariant = MultiVariantGenerator.multiVariant(block, baseVariant);
    registeredBlocks.put(block, new BlockStateGeneratorWrapper(multiVariant));
    return multiVariant;
  }

  public MultiPartGenerator multiPartGenerator(Block block) {
    var multiPart = MultiPartGenerator.multiPart(block);
    registeredBlocks.put(block, new BlockStateGeneratorWrapper(multiPart));
    return multiPart;
  }

  /**
   * Универсальная версия createFacingDispatch без MachineDefinition
   */
  public static @Nullable PropertyDispatch createFacingDispatch(Property<Direction> facingProperty,
                                                                @Nullable BooleanProperty upwardsFacing) {
    if (facingProperty == null) return null;

    PropertyDispatch dispatch;
    if (upwardsFacing == null) {
      // обычное вращение только по "front"
      var disp = PropertyDispatch.property(facingProperty);

      dispatch = disp.generate((front) -> {
        var orientation = ExtendedBlockModelRotation.get(front, Direction.NORTH);
        return applyOrientation(Variant.variant(), orientation);
      });
    } else {
      var disp = PropertyDispatch.properties(facingProperty, upwardsFacing);

      dispatch = disp.generate((front, up) -> {
        var orientation = ExtendedBlockModelRotation.get(front, up ? Direction.UP : Direction.NORTH);
        return applyOrientation(Variant.variant(), orientation);
      });
    }
    return dispatch;
  }

  public static Variant applyOrientation(Variant variant, ExtendedBlockModelRotation orientation) {
    return applyRotation(variant, orientation.getAngleX(), orientation.getAngleY(), orientation.getAngleZ());
  }

  public static Variant applyRotation(Variant variant, int angleX, int angleY, int angleZ) {
    angleX = normalizeAngle(angleX);
    angleY = normalizeAngle(angleY);
    angleZ = normalizeAngle(angleZ);

    if (angleX != 0) variant = variant.with(X_ROT, rotationByAngle(angleX));
    if (angleY != 0) variant = variant.with(Y_ROT, rotationByAngle(angleY));
    if (angleZ != 0) variant = variant.with(Z_ROT, rotationByAngle(angleZ));
    return variant;
  }

  private static int normalizeAngle(int angle) {
    return angle - (angle / 360) * 360;
  }

  private static VariantProperties.Rotation rotationByAngle(int angle) {
    return switch (angle) {
      case 0 -> VariantProperties.Rotation.R0;
      case 90 -> VariantProperties.Rotation.R90;
      case 180 -> VariantProperties.Rotation.R180;
      case 270 -> VariantProperties.Rotation.R270;
      default -> throw new IllegalArgumentException("Invalid angle: " + angle);
    };
  }

  protected Optional<BlockStateGeneratorWrapper> getExistingBlockStateGenerator(Block block) {
    return Optional.ofNullable(registeredBlocks.get(block))
        .filter(g -> g instanceof BlockStateGeneratorWrapper)
        .map(g -> (BlockStateGeneratorWrapper) g);
  }

  public Optional<MultiVariantGenerator> getExistingMultiVariantGenerator(Block block) {
    return getExistingBlockStateGenerator(block)
        .filter(g -> g.generator() instanceof MultiVariantGenerator)
        .map(g -> (MultiVariantGenerator) g.generator());
  }

  public Optional<MultiPartGenerator> getExistingMultipartGenerator(Block block) {
    return getExistingBlockStateGenerator(block)
        .filter(g -> g.generator() instanceof MultiPartGenerator)
        .map(g -> (MultiPartGenerator) g.generator());
  }

  public record BlockStateGeneratorWrapper(BlockStateGenerator generator) implements IGeneratedBlockState {
    @Override
    public JsonObject toJson() {
      return generator.get().getAsJsonObject();
    }
  }
}
