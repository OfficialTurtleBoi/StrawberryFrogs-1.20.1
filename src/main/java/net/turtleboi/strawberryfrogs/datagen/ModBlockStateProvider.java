package net.turtleboi.strawberryfrogs.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.turtleboi.strawberryfrogs.StrawberryFrogs;
import net.turtleboi.strawberryfrogs.block.ModBlocks;
import net.turtleboi.strawberryfrogs.block.StrawberryBushBlock;

import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, StrawberryFrogs.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        makeBerryBush((BushBlock) ModBlocks.STRAWBERRY_BUSH.get(), "strawberry_stage", "strawberry_stage");
        //blockWithItem(ModBlocks.COLDSTEEL_BLOCK);
//
        //logBlock(((RotatedPillarBlock) ModBlocks.GREYPINE_LOG.get()));
        //axisBlock(((RotatedPillarBlock) ModBlocks.GREYPINE_WOOD.get()), blockTexture(ModBlocks.GREYPINE_LOG.get()), blockTexture(ModBlocks.GREYPINE_LOG.get()));
//
        //axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_GREYPINE_LOG.get()), blockTexture(ModBlocks.STRIPPED_GREYPINE_LOG.get()),
        //        new ResourceLocation(StrawberryFrogs.MOD_ID, "block/stripped_greypine_log_top"));
        //axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_GREYPINE_WOOD.get()), blockTexture(ModBlocks.STRIPPED_GREYPINE_LOG.get()), blockTexture(ModBlocks.STRIPPED_GREYPINE_LOG.get()));
//
        //blockItem(ModBlocks.GREYPINE_LOG);
        //blockItem(ModBlocks.GREYPINE_WOOD);
        //blockItem(ModBlocks.STRIPPED_GREYPINE_LOG);
        //blockItem(ModBlocks.STRIPPED_GREYPINE_WOOD);
//
        //blockWithItem(ModBlocks.GREYPINE_PLANKS);
//
        //leavesBlock(ModBlocks.GREYPINE_LEAVES);
//
        //saplingBlock(ModBlocks.GREYPINE_SAPLING);
        //saplingBlock(ModBlocks.MYST_WILLOW_SAPLING);
    }

    public void makeBerryBush(BushBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> bushStates(state, block, modelName, textureName);
        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] bushStates(BlockState state, BushBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().cross(modelName + ((StrawberryBushBlock) block).getAge(state),
                new ResourceLocation(StrawberryFrogs.MOD_ID, "block/" + textureName + ((StrawberryBushBlock) block).getAge(state))).renderType("cutout"));

        return models;
    }

    private void saplingBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void leavesBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().singleTexture(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), new ResourceLocation("minecraft:block/leaves"),
                        "all", blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile(StrawberryFrogs.MOD_ID +
                ":block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
