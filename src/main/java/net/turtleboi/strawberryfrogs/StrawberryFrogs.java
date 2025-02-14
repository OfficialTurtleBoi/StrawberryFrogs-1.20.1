package net.turtleboi.strawberryfrogs;

import com.mojang.logging.LogUtils;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.turtleboi.strawberryfrogs.block.ModBlocks;
import net.turtleboi.strawberryfrogs.entity.ModEntities;
import net.turtleboi.strawberryfrogs.entity.StrawberryFrogEntity;
import net.turtleboi.strawberryfrogs.item.ModCreativeModeTabs;
import net.turtleboi.strawberryfrogs.item.ModItems;
import net.turtleboi.strawberryfrogs.loot.ModLootModifiers;
import org.slf4j.Logger;

@Mod(StrawberryFrogs.MOD_ID)
public class StrawberryFrogs {
    public static final String MOD_ID = "strawberryfrogs";
    private static final Logger LOGGER = LogUtils.getLogger();

    public StrawberryFrogs() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModCreativeModeTabs.register(modEventBus);
        ModEntities.register(modEventBus);
        ModLootModifiers.register(modEventBus);
        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            SpawnPlacements.register(ModEntities.STRAWBERRY_FROG.get(), SpawnPlacements.Type.NO_RESTRICTIONS, Heightmap.Types.WORLD_SURFACE, StrawberryFrogEntity::canSpawn);
        });
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {

    }


}
