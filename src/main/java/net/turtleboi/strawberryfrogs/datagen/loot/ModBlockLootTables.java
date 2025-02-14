package net.turtleboi.strawberryfrogs.datagen.loot;

import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;
import net.turtleboi.strawberryfrogs.block.ModBlocks;
import net.turtleboi.strawberryfrogs.block.StrawberryBushBlock;
import net.turtleboi.strawberryfrogs.item.ModItems;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        //this.dropSelf(ModBlocks.COLDSTEEL_BLOCK.get());
        //this.dropSelf(ModBlocks.GREYPINE_LOG.get());
        //this.dropSelf(ModBlocks.GREYPINE_WOOD.get());
        //this.dropSelf(ModBlocks.STRIPPED_GREYPINE_LOG.get());
        //this.dropSelf(ModBlocks.STRIPPED_GREYPINE_WOOD.get());
        //this.dropSelf(ModBlocks.GREYPINE_PLANKS.get());
        //this.dropSelf(ModBlocks.WONDER_SHROOM.get());
        //this.dropSelf(ModBlocks.WONDER_TREE_SHROOM.get());
        //this.dropOther(ModBlocks.WONDER_TREE_SHROOM_WALL.get(), ModItems.WONDER_TREE_SHROOM.get());
        //this.dropSelf(ModBlocks.GREYPINE_SAPLING.get());
        //this.dropSelf(ModBlocks.MYST_WILLOW_SAPLING.get());
//
        //this.add(ModBlocks.GREYPINE_LEAVES.get(), block ->
        //        createLeavesDrops(block, ModBlocks.GREYPINE_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
//
        //this.dropWhenSilkTouch(ModBlocks.ICE_SLUSH.get());
        //this.dropWhenSilkTouch(ModBlocks.ICY_VINES.get());
        //this.dropWhenSilkTouch(ModBlocks.ICY_VINES_PLANT.get());

        LootItemCondition.Builder lootitemcondition$builder2 = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.STRAWBERRY_BUSH.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(StrawberryBushBlock.AGE, 3))
                .or(LootItemBlockStatePropertyCondition
                        .hasBlockStateProperties(ModBlocks.STRAWBERRY_BUSH.get())
                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(StrawberryBushBlock.AGE,4)));

        this.add(ModBlocks.STRAWBERRY_BUSH.get(),
                createCropDrops(
                        ModBlocks.STRAWBERRY_BUSH.get(),
                        ModItems.STRAWBERRY.get(),
                        ModItems.STRAWBERRY.get(),
                        lootitemcondition$builder2));
    }

    protected LootTable.Builder createCopperLikeOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
