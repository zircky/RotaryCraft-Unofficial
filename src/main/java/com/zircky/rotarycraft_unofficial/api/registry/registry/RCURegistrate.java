package com.zircky.rotarycraft_unofficial.api.registry.registry;

import com.tterrag.registrate.AbstractRegistrate;
import com.tterrag.registrate.builders.BlockEntityBuilder;
import com.tterrag.registrate.builders.Builder;
import com.tterrag.registrate.builders.NoConfigBuilder;
import com.tterrag.registrate.util.OneTimeEventReceiver;
import com.tterrag.registrate.util.entry.ItemEntry;
import com.tterrag.registrate.util.entry.RegistryEntry;
import com.tterrag.registrate.util.nullness.NonNullConsumer;
import com.tterrag.registrate.util.nullness.NonNullFunction;
import com.tterrag.registrate.util.nullness.NonNullSupplier;
import com.zircky.rotarycraft_unofficial.core.mixins.registrate.AbstractRegistrateAccessor;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.RegisterEvent;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;
import java.util.function.Supplier;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class RCURegistrate extends AbstractRegistrate<RCURegistrate> {
  private final AtomicBoolean registered = new AtomicBoolean(false);

  protected RCURegistrate(String modId) {
    super(modId);
  }

  @NotNull
  public static RCURegistrate create(String modId) {
    return new RCURegistrate(modId);
  }

  public void registerRegistrate() {
    registerEventListeners(FMLJavaModLoadingContext.get().getModEventBus());
  }

  @Override
  public RCURegistrate registerEventListeners(IEventBus bus) {
    if (!registered.getAndSet(true)) {
      // recreate the super method so we can register the event listener with LOW priority.
      Consumer<RegisterEvent> onRegister = this::onRegister;
      Consumer<RegisterEvent> onRegisterLate = this::onRegisterLate;
      bus.addListener(EventPriority.LOW, onRegister);
      bus.addListener(EventPriority.LOWEST, onRegisterLate);

      // Fired multiple times when ever tabs need contents rebuilt (changing op tab perms for example)
      bus.addListener(this::onBuildCreativeModeTabContents);
      // Register events fire multiple times, so clean them up on common setup
      OneTimeEventReceiver.addModListener(this, FMLCommonSetupEvent.class, $ -> {
        OneTimeEventReceiver.unregister(this, onRegister, RegisterEvent.class);
        OneTimeEventReceiver.unregister(this, onRegisterLate, RegisterEvent.class);
      });
      if (((AbstractRegistrateAccessor) this).getDoDatagen().get()) {
        OneTimeEventReceiver.addModListener(this, GatherDataEvent.class, this::onData);
      }
    }
    return this;
  }

  protected <P> NoConfigBuilder<CreativeModeTab, CreativeModeTab, P> createCreativeModeTab(P parent, String name,
                                                                                           Consumer<CreativeModeTab.Builder> config) {
    return this.generic(parent, name, Registries.CREATIVE_MODE_TAB, () -> {
      var builder = CreativeModeTab.builder()
          .icon(() -> getAll(Registries.ITEM).stream().findFirst().map(ItemEntry::cast)
              .map(ItemEntry::asStack).orElse(new ItemStack(Items.AIR)));
      config.accept(builder);
      return builder.build();
    });
  }

  // Blocks
  @Override
  public <T extends Block> RCUBlockBuilder<T, RCURegistrate> block(NonNullFunction<BlockBehaviour.Properties, T> factory) {
    return block(this, factory);
  }

  @Override
  public <T extends Block> RCUBlockBuilder<T, RCURegistrate> block(String name,
                                                                 NonNullFunction<BlockBehaviour.Properties, T> factory) {
    return block(this, name, factory);
  }

  @Override
  public <T extends Block, P> RCUBlockBuilder<T, P> block(P parent,
                                                         NonNullFunction<BlockBehaviour.Properties, T> factory) {
    return block(parent, currentName(), factory);
  }

  @Override
  public <T extends Block, P> RCUBlockBuilder<T, P> block(P parent, String name,
                                                         NonNullFunction<BlockBehaviour.Properties, T> factory) {
    return (RCUBlockBuilder<T, P>) entry(name,
        callback -> RCUBlockBuilder.create(this, parent, name, callback, factory));
  }

  private RegistryEntry<CreativeModeTab> currentTab;
  private static final Map<RegistryEntry<?>, RegistryEntry<CreativeModeTab>> TAB_LOOKUP = new IdentityHashMap<>();

  public RegistryEntry<CreativeModeTab> creativeModeTab() {
    return this.currentTab;
  }

  public void creativeModeTab(Supplier<RegistryEntry<CreativeModeTab>> currentTab) {
    this.currentTab = currentTab.get();
  }

  public void creativeModeTab(RegistryEntry<CreativeModeTab> currentTab) {
    this.currentTab = currentTab;
  }

  public boolean isInCreativeTab(RegistryEntry<?> entry, RegistryEntry<CreativeModeTab> tab) {
    return TAB_LOOKUP.get(entry) == tab;
  }

  public void setCreativeTab(RegistryEntry<?> entry, @Nullable RegistryEntry<CreativeModeTab> tab) {
    TAB_LOOKUP.put(entry, tab);
  }

  protected <R,
      T extends R> RegistryEntry<T> accept(String name, ResourceKey<? extends Registry<R>> type,
                                           Builder<R, T, ?, ?> builder, NonNullSupplier<? extends T> creator,
                                           NonNullFunction<RegistryObject<T>, ? extends RegistryEntry<T>> entryFactory) {
    RegistryEntry<T> entry = super.accept(name, type, builder, creator, entryFactory);

    if (this.currentTab != null) {
      TAB_LOOKUP.put(entry, this.currentTab);
    }

    return entry;
  }

  public <P> NoConfigBuilder<CreativeModeTab, CreativeModeTab, P> defaultCreativeTab(P parent, String name,
                                                                                     Consumer<CreativeModeTab.Builder> config) {
    return createCreativeModeTab(parent, name, config);
  }

}
