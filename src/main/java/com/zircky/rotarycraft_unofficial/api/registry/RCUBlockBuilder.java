package com.zircky.rotarycraft_unofficial.api.registry;

import com.tterrag.registrate.AbstractRegistrate;
import com.tterrag.registrate.builders.BlockBuilder;
import com.tterrag.registrate.builders.BlockEntityBuilder;
import com.tterrag.registrate.builders.BuilderCallback;
import com.tterrag.registrate.providers.*;
import com.tterrag.registrate.providers.loot.RegistrateBlockLootTables;
import com.tterrag.registrate.util.nullness.NonNullBiConsumer;
import com.tterrag.registrate.util.nullness.NonNullFunction;
import com.tterrag.registrate.util.nullness.NonNullSupplier;
import com.tterrag.registrate.util.nullness.NonNullUnaryOperator;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Supplier;

public class RCUBlockBuilder<T extends Block, P> extends BlockBuilder<T, P> {

  public static <T extends Block, P> RCUBlockBuilder<T, P> create(AbstractRegistrate<?> owner, P parent, String name,
                                                                 BuilderCallback callback,
                                                                 NonNullFunction<BlockBehaviour.Properties, T> factory) {
    return new RCUBlockBuilder<>(owner, parent, name, callback, factory, BlockBehaviour.Properties::of)
        .defaultBlockstate().defaultLoot().defaultLang();
  }

  protected RCUBlockBuilder(AbstractRegistrate<?> owner, P parent, String name, BuilderCallback callback,
                           NonNullFunction<BlockBehaviour.Properties, T> factory,
                           NonNullSupplier<BlockBehaviour.Properties> initialProperties) {
    super(owner, parent, name, callback, factory, initialProperties);
  }

  public RCUBlockBuilder<T, P> exBlockstate(NonNullBiConsumer<DataGenContext<Block, ? extends Block>, RCUBlockstateProvider> cons) {
    return setDataGeneric(ProviderType.BLOCKSTATE, (ctx, prov) -> cons.accept(ctx, (RCUBlockstateProvider) prov));
  }

  // region default overrides

  @Override
  public RCUBlockBuilder<T, P> properties(NonNullUnaryOperator<BlockBehaviour.Properties> func) {
    return (RCUBlockBuilder<T, P>) super.properties(func);
  }

  @Override
  public RCUBlockBuilder<T, P> initialProperties(NonNullSupplier<? extends Block> block) {
    return (RCUBlockBuilder<T, P>) super.initialProperties(block);
  }

  @SuppressWarnings("removal")
  @Override
  public RCUBlockBuilder<T, P> addLayer(Supplier<Supplier<RenderType>> layer) {
    return (RCUBlockBuilder<T, P>) super.addLayer(layer);
  }

  @Override
  public RCUBlockBuilder<T, P> simpleItem() {
    return (RCUBlockBuilder<T, P>) super.simpleItem();
  }

  @Override
  public <BE extends BlockEntity> RCUBlockBuilder<T, P> simpleBlockEntity(BlockEntityBuilder.BlockEntityFactory<BE> factory) {
    return (RCUBlockBuilder<T, P>) super.simpleBlockEntity(factory);
  }

  @Override
  public <BE extends BlockEntity> BlockEntityBuilder<BE, BlockBuilder<T, P>> blockEntity(BlockEntityBuilder.BlockEntityFactory<BE> factory) {
    return super.blockEntity(factory);
  }

  @Override
  public RCUBlockBuilder<T, P> color(NonNullSupplier<Supplier<BlockColor>> colorHandler) {
    return (RCUBlockBuilder<T, P>) super.color(colorHandler);
  }

  @Override
  public RCUBlockBuilder<T, P> defaultBlockstate() {
    return (RCUBlockBuilder<T, P>) super.defaultBlockstate();
  }

  @Override
  public RCUBlockBuilder<T, P> blockstate(NonNullBiConsumer<DataGenContext<Block, T>, RegistrateBlockstateProvider> cons) {
    return (RCUBlockBuilder<T, P>) setData(ProviderType.BLOCKSTATE, cons);
  }

  @Override
  public RCUBlockBuilder<T, P> defaultLang() {
    return (RCUBlockBuilder<T, P>) super.defaultLang();
  }

  @Override
  public RCUBlockBuilder<T, P> lang(String name) {
    return (RCUBlockBuilder<T, P>) super.lang(name);
  }

  @Override
  public RCUBlockBuilder<T, P> defaultLoot() {
    return (RCUBlockBuilder<T, P>) super.defaultLoot();
  }

  @Override
  public RCUBlockBuilder<T, P> loot(NonNullBiConsumer<RegistrateBlockLootTables, T> cons) {
    return (RCUBlockBuilder<T, P>) super.loot(cons);
  }

  @Override
  public RCUBlockBuilder<T, P> recipe(NonNullBiConsumer<DataGenContext<Block, T>, RegistrateRecipeProvider> cons) {
    return (RCUBlockBuilder<T, P>) super.recipe(cons);
  }

  // why is it final >:(
  // @SafeVarargs
  // public final BlockBuilder<T, P> tag(TagKey<Block>... tags) {
  //     return tag(ProviderType.BLOCK_TAGS, tags);
  // }

  public <D extends RegistrateProvider> RCUBlockBuilder<T, P> setDataGeneric(ProviderType<? extends D> type, NonNullBiConsumer<DataGenContext<Block, ? extends Block>, D> cons) {
    getOwner().setDataGenerator(this, type, prov -> cons.accept(DataGenContext.from(this), prov));
    return this;
  }
}
