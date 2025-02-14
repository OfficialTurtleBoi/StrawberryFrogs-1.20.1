package net.turtleboi.strawberryfrogs.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.turtleboi.strawberryfrogs.StrawberryFrogs;

public class ModEntities
{
    public static final DeferredRegister<EntityType<?>> TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, StrawberryFrogs.MOD_ID);

    public static final RegistryObject<EntityType<StrawberryFrogEntity>> STRAWBERRY_FROG =
            TYPES.register("strawberry_frog",()-> EntityType.Builder.of(StrawberryFrogEntity::new, MobCategory.AMBIENT)
                    .sized(0.5F, 0.5F).build("strawberry_frog"));

    public static void register(IEventBus eventBus)
    {
        TYPES.register(eventBus);
    }
}
