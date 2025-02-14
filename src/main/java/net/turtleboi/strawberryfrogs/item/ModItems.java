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
import net.turtleboi.strawberryfrogs.entity.ModEntities;

public class ModItems {
    public static final Rarity LEGENDARY = Rarity.create("LEGENDARY", ChatFormatting.GOLD);

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, StrawberryFrogs.MOD_ID);

    public static final RegistryObject<Item> STRAWBERRY = ITEMS.register("strawberry",
            () -> new ItemNameBlockItem(ModBlocks.STRAWBERRY_BUSH.get(), new Item.Properties().rarity(Rarity.COMMON)
                    .food(new FoodProperties.Builder().nutrition(2).saturationMod(0.25F).build())));

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
            () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON).stacksTo(1)));

    public static final RegistryObject<Item> TOAST = ITEMS.register("toast",
            () -> new Item(new Item.Properties().rarity(Rarity.COMMON)
                    .food(new FoodProperties.Builder().nutrition(5).saturationMod(0.4F).build())));

    public static final RegistryObject<Item> BUTTERED_TOAST = ITEMS.register("buttered_toast",
            () -> new Item(new Item.Properties().rarity(Rarity.COMMON)
                    .food(new FoodProperties.Builder().nutrition(7).saturationMod(0.75F).build())));

    public static final RegistryObject<Item> SCONE = ITEMS.register("scone",
            () -> new Item(new Item.Properties().rarity(Rarity.COMMON)
                    .food(new FoodProperties.Builder().nutrition(6).saturationMod(0.75F).build())));

    public static final RegistryObject<Item> MUFFIN = ITEMS.register("muffin",
            () -> new Item(new Item.Properties().rarity(Rarity.COMMON)
                    .food(new FoodProperties.Builder().nutrition(5).saturationMod(0.6F).build())));

    public static final RegistryObject<Item> CHOCOLATE_STRAWBERRY = ITEMS.register("chocolate_strawberry",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE)
                    .food(new FoodProperties.Builder().nutrition(5).saturationMod(0.5F).build())));

    public static final RegistryObject<Item> STRAWBERRY_JAM = ITEMS.register("strawberry_jam",
            () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)
                    .food(new FoodProperties.Builder().nutrition(5).saturationMod(0.75F).build())));

    public static final RegistryObject<Item> STRAWBERRY_MILK = ITEMS.register("strawberry_milk",
            () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)
                    .food(new FoodProperties.Builder().nutrition(6).saturationMod(0.4F).build()).stacksTo(1)));

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
                    .food(new FoodProperties.Builder().nutrition(8).saturationMod(0.75F).build()).stacksTo(1)));

    public static final RegistryObject<Item> VANILLA_ICE_CREAM = ITEMS.register("vanilla_ice_cream",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE)
                    .food(new FoodProperties.Builder().nutrition(7).saturationMod(0.7F).build()).stacksTo(1)));

    public static final RegistryObject<Item> STRAWBERRY_MILKSHAKE = ITEMS.register("strawberry_milkshake",
            () -> new Item(new Item.Properties().rarity(Rarity.EPIC)
                    .food(new FoodProperties.Builder().nutrition(10).saturationMod(1.0F).build()).stacksTo(1)));

    public static final RegistryObject<Item> STRAWBERRY_FROG_SPAWN_EGG = ITEMS.register("strawberry_frog_spawn_egg",
            ()-> new ForgeSpawnEggItem(ModEntities.STRAWBERRY_FROG,0xAD2F41,0xFFDBA3,new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
