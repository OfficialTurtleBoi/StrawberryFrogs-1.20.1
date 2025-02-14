package net.turtleboi.strawberryfrogs.event;

import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.turtleboi.strawberryfrogs.StrawberryFrogs;
import net.turtleboi.strawberryfrogs.entity.ModEntities;
import net.turtleboi.strawberryfrogs.entity.StrawberryFrogEntity;
import net.turtleboi.strawberryfrogs.entity.client.renderer.StrawberryFrogRenderer;

@Mod.EventBusSubscriber(modid = StrawberryFrogs.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBus {
    @SubscribeEvent
    public static void onClientSetupEvent(FMLClientSetupEvent event) {
        EntityRenderers.register(ModEntities.STRAWBERRY_FROG.get(), StrawberryFrogRenderer::new);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event){
        event.put(ModEntities.STRAWBERRY_FROG.get(), StrawberryFrogEntity.createAttributes().build());
    }
}
