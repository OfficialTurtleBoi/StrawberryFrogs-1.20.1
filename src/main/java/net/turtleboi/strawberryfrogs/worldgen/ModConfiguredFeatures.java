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
        //        BlockStateProvider.simple(ModBlocks.STRAWBERRY_BUSH.get()),
        //        context.lookup(Registries.PLACED_FEATURE).getOrThrow(ModPlacedFeatures.STRAWBERRY_BUSH_PLACED_KEY),
        //        CaveSurface.FLOOR,
        //        ConstantInt.of(1),
        //        0.0F,
        //        1,
        //        0.5F,
        //        ConstantInt.of(2),
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
