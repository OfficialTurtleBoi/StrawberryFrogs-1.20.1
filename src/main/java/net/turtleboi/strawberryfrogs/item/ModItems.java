package net.turtleboi.strawberryfrogs.item;

import net.minecraft.ChatFormatting;
import net.minecraft.core.Direction;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.turtleboi.strawberryfrogs.StrawberryFrogs;
import net.turtleboi.strawberryfrogs.block.ModBlocks;

public class ModItems {
    public static final Rarity LEGENDARY = Rarity.create("LEGENDARY", ChatFormatting.GOLD);

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, StrawberryFrogs.MOD_ID);

    public static final RegistryObject<Item> STRAWBERRY = ITEMS.register("strawberry",
            () -> new ItemNameBlockItem(ModBlocks.STRAWBERRY_BUSH.get(), new Item.Properties().rarity(Rarity.COMMON)
                    .food(new FoodProperties.Builder().nutrition(4).saturationMod(0.25F).build())));

    public static final RegistryObject<Item> FLOUR = ITEMS.register("flour",
            () -> new Item(new Item.Properties().rarity(Rarity.COMMON)));

    public static final RegistryObject<Item> DOUGH = ITEMS.register("dough",
            () -> new Item(new Item.Properties().rarity(Rarity.COMMON)
                    .food(new FoodProperties.Builder().nutrition(1).saturationMod(0.1F).build())));

    public static final RegistryObject<Item> BUTTER = ITEMS.register("butter",
            () -> new Item(new Item.Properties().rarity(Rarity.COMMON)
                    .food(new FoodProperties.Builder().nutrition(3).saturationMod(-0.1F).build())));

    public static final RegistryObject<Item> SUGAR_CUBE = ITEMS.register("sugar_cube",
            () -> new Item(new Item.Properties().rarity(Rarity.COMMON)
                    .food(new FoodProperties.Builder().nutrition(2).saturationMod(0.1F).build())));

    public static final RegistryObject<Item> SUGAR_COOKIE = ITEMS.register("sugar_cookie",
            () -> new Item(new Item.Properties().rarity(Rarity.COMMON)
                    .food(new FoodProperties.Builder().nutrition(4).saturationMod(0.3F).build())));

    public static final RegistryObject<Item> VANILLA_BEAN = ITEMS.register("vanilla_bean",
            () -> new Item(new Item.Properties().rarity(Rarity.COMMON)));

    public static final RegistryObject<Item> VANILLA_EXTRACT = ITEMS.register("vanilla_extract",
            () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));

    public static final RegistryObject<Item> SWEET_BREAD = ITEMS.register("sweet_bread",
            () -> new Item(new Item.Properties().rarity(Rarity.COMMON)
                    .food(new FoodProperties.Builder().nutrition(5).saturationMod(0.4F).build())));

    public static final RegistryObject<Item> SCONE = ITEMS.register("scone",
            () -> new Item(new Item.Properties().rarity(Rarity.COMMON)
                    .food(new FoodProperties.Builder().nutrition(6).saturationMod(0.75F).build())));

    public static final RegistryObject<Item> MUFFIN = ITEMS.register("muffin",
            () -> new Item(new Item.Properties().rarity(Rarity.COMMON)
                    .food(new FoodProperties.Builder().nutrition(5).saturationMod(0.6F).build())));

    public static final RegistryObject<Item> CHOCOLATE_STRAWBERRY = ITEMS.register("chocolate_strawberry",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE)
                    .food(new FoodProperties.Builder().nutrition(6).saturationMod(0.5F).build())));

    public static final RegistryObject<Item> STRAWBERRY_JAM = ITEMS.register("strawberry_jam",
            () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)
                    .food(new FoodProperties.Builder().nutrition(5).saturationMod(0.75F).build())));

    public static final RegistryObject<Item> STRAWBERRY_MILK = ITEMS.register("strawberry_milk",
            () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)
                    .food(new FoodProperties.Builder().nutrition(6).saturationMod(0.4F).build())));

    public static final RegistryObject<Item> STRAWBERRY_TOAST = ITEMS.register("strawberry_toast",
            () -> new Item(new Item.Properties().rarity(Rarity.EPIC)
                    .food(new FoodProperties.Builder().nutrition(8).saturationMod(0.8F).build())));

    public static final RegistryObject<Item> STRAWBERRY_MUFFIN = ITEMS.register("strawberry_muffin",
            () -> new Item(new Item.Properties().rarity(Rarity.EPIC)
                    .food(new FoodProperties.Builder().nutrition(10).saturationMod(1.0F).build())));

    public static final RegistryObject<Item> STRAWBERRY_SHORTCAKE = ITEMS.register("strawberry_shortcake",
            () -> new Item(new Item.Properties().rarity(Rarity.EPIC)
                    .food(new FoodProperties.Builder().nutrition(10).saturationMod(1.0F).build())));

    public static final RegistryObject<Item> STRAWBERRY_ICE_CREAM = ITEMS.register("strawberry_ice_cream",
            () -> new Item(new Item.Properties().rarity(Rarity.EPIC)
                    .food(new FoodProperties.Builder().nutrition(8).saturationMod(0.75F).build())));

    public static final RegistryObject<Item> STRAWBERRY_MILKSHAKE = ITEMS.register("strawberry_milkshake",
            () -> new Item(new Item.Properties().rarity(Rarity.EPIC)
                    .food(new FoodProperties.Builder().nutrition(10).saturationMod(1.0F).build())));
//
    //public static final RegistryObject<Item> TRUEICE_SHARD = ITEMS.register("trueice_shard",
    //        () -> new Item(new Item.Properties().rarity(Rarity.RARE)));
//
    //public static final RegistryObject<Item> FROZEN_HEART = ITEMS.register("frozen_heart",
    //        () -> new Item(new Item.Properties().rarity(Rarity.EPIC)));
//
    //public static final RegistryObject<Item> COLDSTEEL_SCRAP = ITEMS.register("coldsteel_scrap",
    //        () -> new Item(new Item.Properties().rarity(Rarity.RARE)));
//
    //public static final RegistryObject<Item> COLDSTEEL_INGOT = ITEMS.register("coldsteel_ingot",
    //        () -> new Item(new Item.Properties().rarity(Rarity.RARE)));
//
    //public static final RegistryObject<Item> COLDSTEEL_SWORD = ITEMS.register("coldsteel_sword",
    //        () -> new SwordItem(ModToolTiers.COLDSTEEL, 3, -2.4f, new Item.Properties().rarity(Rarity.RARE)));
//
    //public static final RegistryObject<Item> COLDSTEEL_PICKAXE = ITEMS.register("coldsteel_pickaxe",
    //        () -> new PickaxeItem(ModToolTiers.COLDSTEEL, 1, -2.8f, new Item.Properties().rarity(Rarity.RARE)));
//
    //public static final RegistryObject<Item> COLDSTEEL_AXE = ITEMS.register("coldsteel_axe",
    //        () -> new AxeItem(ModToolTiers.COLDSTEEL, 6, -3f, new Item.Properties().rarity(Rarity.RARE)));
//
    //public static final RegistryObject<Item> COLDSTEEL_SHOVEL = ITEMS.register("coldsteel_shovel",
    //        () -> new ShovelItem(ModToolTiers.COLDSTEEL, 2, -3f, new Item.Properties().rarity(Rarity.RARE)));
//
    //public static final RegistryObject<Item> COLDSTEEL_HOE = ITEMS.register("coldsteel_hoe",
    //        () -> new HoeItem(ModToolTiers.COLDSTEEL, -2, -0.5f, new Item.Properties().rarity(Rarity.RARE)));
//
    //public static final RegistryObject<Item> COLDSTEEL_HELMET = ITEMS.register("coldsteel_helmet",
    //        () -> new ArmorItem(ModArmorMaterials.COLDSTEEL, ArmorItem.Type.HELMET, new Item.Properties().rarity(Rarity.RARE)));
//
    //public static final RegistryObject<Item> COLDSTEEL_CHESTPLATE = ITEMS.register("coldsteel_chestplate",
    //        () -> new ArmorItem(ModArmorMaterials.COLDSTEEL, ArmorItem.Type.CHESTPLATE, new Item.Properties().rarity(Rarity.RARE)));
//
    //public static final RegistryObject<Item> COLDSTEEL_LEGGINGS = ITEMS.register("coldsteel_leggings",
    //        () -> new ArmorItem(ModArmorMaterials.COLDSTEEL, ArmorItem.Type.LEGGINGS, new Item.Properties().rarity(Rarity.RARE)));
//
    //public static final RegistryObject<Item> COLDSTEEL_BOOTS = ITEMS.register("coldsteel_boots",
    //        () -> new ArmorItem(ModArmorMaterials.COLDSTEEL, ArmorItem.Type.BOOTS, new Item.Properties().rarity(Rarity.RARE)));
//
    //public static final RegistryObject<Item> FROSTBITE_WAND = ITEMS.register("frostbite_wand",
    //        () -> new FrostbiteWandItem(new Item.Properties().rarity(Rarity.RARE)));
//
    //public static final RegistryObject<Item> SNOW_WISP_SPAWN_EGG = ITEMS.register("snow_wisp_spawn_egg",
    //        ()-> new ForgeSpawnEggItem(ModEntities.SNOW_WISP,0xffffff,0xc5ebeb,new Item.Properties()));
//
    //public static final RegistryObject<Item> REVENANT_SPAWN_EGG = ITEMS.register("revenant_spawn_egg",
    //        ()-> new ForgeSpawnEggItem(ModEntities.REVENANT,0x6e6e6e,0x6c8696,new Item.Properties()));
//
    //public static final RegistryObject<Item> BRISK_SPAWN_EGG = ITEMS.register("brisk_spawn_egg",
    //        ()-> new ForgeSpawnEggItem(ModEntities.BRISK,0xBFEEF2,0xFFFFFF,new Item.Properties()));
//
    //public static final RegistryObject<Item> PINGIN_SPAWN_EGG = ITEMS.register("pingin_spawn_egg",
    //        ()-> new ForgeSpawnEggItem(ModEntities.PINGIN,0x374859,0xFF914A,new Item.Properties()));
//
    //public static final RegistryObject<Item> WONDER_TREE_SHROOM = ITEMS.register("wonder_tree_shroom",
    //        () -> new StandingAndWallBlockItem(ModBlocks.WONDER_TREE_SHROOM.get(), ModBlocks.WONDER_TREE_SHROOM_WALL.get(), new Item.Properties(), Direction.DOWN));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
