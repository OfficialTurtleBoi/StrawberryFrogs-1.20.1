package net.turtleboi.strawberryfrogs.worldgen;

import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;
import net.turtleboi.strawberryfrogs.StrawberryFrogs;

public class ModBiomeModifiers {
    public static final ResourceKey<BiomeModifier> ADD_VEGETATION_STRAWBERRY_BUSH = registerKey("add_vegetation_strawberry_bush");

    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        //context.register(ADD_VEGETATION_STRAWBERRY_BUSH, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
        //        biomes.getOrThrow(Tags.Biomes.IS_PLAINS),
        //        HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.STRAWBERRY_BUSH_PLACED_KEY)),
        //        GenerationStep.Decoration.VEGETAL_DECORATION));

       //context.register(ADD_VEGETATION_STRAWBERRY_BUSH, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
       //        biomes.getOrThrow(Tags.Biomes.IS_DENSE_OVERWORLD),
       //        HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.STRAWBERRY_BUSH_PLACED_KEY)),
       //        GenerationStep.Decoration.VEGETAL_DECORATION));
    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(StrawberryFrogs.MOD_ID, name));
    }
}
