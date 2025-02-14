package net.turtleboi.strawberryfrogs.worldgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.VegetationPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.placement.CaveSurface;
import net.turtleboi.strawberryfrogs.StrawberryFrogs;
import net.turtleboi.strawberryfrogs.block.ModBlocks;

public final class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> STRAWBERRY_BUSH_KEY = registerKey("strawberry_bush");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        //register(context, STRAWBERRY_BUSH_KEY, Feature.VEGETATION_PATCH, new VegetationPatchConfiguration(
        //        TagKey.create(Registries.BLOCK, new ResourceLocation("minecraft", "replaceable_plants")),
        //        // Ground state – here we simply use the strawberry bush block.
        //        BlockStateProvider.simple(ModBlocks.STRAWBERRY_BUSH.get()),
        //        // Vegetation feature – a placed feature you’ve created for strawberry bushes.
        //        context.lookup(Registries.PLACED_FEATURE).getOrThrow(ModPlacedFeatures.STRAWBERRY_BUSH_PLACED_KEY),
        //        // Surface type – for example, FLOOR.
        //        CaveSurface.FLOOR,
        //        // Depth – how many blocks deep the patch extends. Here we use a constant 1.
        //        ConstantInt.of(1),
        //        // Extra bottom block chance – 0 means no extra bottom block.
        //        0.0F,
        //        // Vertical range – how many blocks tall the patch is; here, 1.
        //        1,
        //        // Vegetation chance – e.g., a 50% chance that vegetation spawns.
        //        0.5F,
        //        // XZ radius – e.g., a constant radius of 2 blocks.
        //        ConstantInt.of(2),
        //        // Extra edge column chance – e.g., 0 means no extra edge columns.
        //        0.0F
        //));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(StrawberryFrogs.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
