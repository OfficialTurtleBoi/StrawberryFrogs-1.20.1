package net.turtleboi.strawberryfrogs.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.turtleboi.strawberryfrogs.StrawberryFrogs;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, StrawberryFrogs.MOD_ID);

    public static final RegistryObject<CreativeModeTab> STRAWBERRYFROGS_TAB = CREATIVE_MODE_TABS.register("strawberryfrogs_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.STRAWBERRY.get()))
                    .title(Component.translatable("creativetab.strawberryfrogs_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.STRAWBERRY.get());
                        pOutput.accept(ModItems.CHOCOLATE_STRAWBERRY.get());
                        pOutput.accept(ModItems.FLOUR.get());
                        pOutput.accept(ModItems.DOUGH.get());
                        pOutput.accept(ModItems.BUTTER.get());
                        pOutput.accept(ModItems.SUGAR_CUBE.get());
                        pOutput.accept(ModItems.SUGAR_COOKIE.get());
                        pOutput.accept(ModItems.VANILLA_BEAN.get());
                        pOutput.accept(ModItems.VANILLA_EXTRACT.get());
                        pOutput.accept(ModItems.STRAWBERRY_JAM.get());
                        pOutput.accept(ModItems.TOAST.get());
                        pOutput.accept(ModItems.BUTTERED_TOAST.get());
                        pOutput.accept(ModItems.STRAWBERRY_TOAST.get());
                        pOutput.accept(ModItems.SCONE.get());
                        pOutput.accept(ModItems.STRAWBERRY_SHORTCAKE.get());
                        pOutput.accept(ModItems.MUFFIN.get());
                        pOutput.accept(ModItems.STRAWBERRY_MUFFIN.get());
                        pOutput.accept(ModItems.STRAWBERRY_MILK.get());
                        pOutput.accept(ModItems.STRAWBERRY_ICE_CREAM.get());
                        pOutput.accept(ModItems.VANILLA_ICE_CREAM.get());
                        pOutput.accept(ModItems.STRAWBERRY_MILKSHAKE.get());
                        pOutput.accept(ModItems.STRAWBERRY_FROG_SPAWN_EGG.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
