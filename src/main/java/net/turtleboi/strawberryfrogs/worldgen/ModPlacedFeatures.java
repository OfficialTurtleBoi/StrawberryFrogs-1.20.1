package net.turtleboi.strawberryfrogs.worldgen;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.turtleboi.strawberryfrogs.StrawberryFrogs;

import java.util.List;

public final class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> GREYPINE_PLACED_KEY = registerKey("greypine_placed");
    public static final ResourceKey<PlacedFeature> MYST_WILLOW_PLACED_KEY = registerKey("myst_willow_placed");
    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        //register(context, GREYPINE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.GREYPINE_KEY),
        //        VegetationPlacements.treePlacement(PlacementUtils.countExtra(8, 0.5f, 4),
        //                ModBlocks.GREYPINE_SAPLING.get()));
//
        //register(context, MYST_WILLOW_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.MYST_WILLOW_KEY),
        //        VegetationPlacements.treePlacement(PlacementUtils.countExtra(8, 0.5f, 4),
        //                ModBlocks.MYST_WILLOW_SAPLING.get()));
    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(StrawberryFrogs.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
