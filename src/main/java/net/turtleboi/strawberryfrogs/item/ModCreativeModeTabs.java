package net.turtleboi.strawberryfrogs.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.turtleboi.strawberryfrogs.StrawberryFrogs;
import net.turtleboi.strawberryfrogs.block.ModBlocks;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, StrawberryFrogs.MOD_ID);

    public static final RegistryObject<CreativeModeTab> STRAWBERRYFROGS_TAB = CREATIVE_MODE_TABS.register("strawberryfrogs_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(Items.SWEET_BERRIES))
                    .title(Component.translatable("creativetab.strawberryfrogs_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(Items.SWEET_BERRIES);
                        pOutput.accept(ModItems.STRAWBERRY.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
