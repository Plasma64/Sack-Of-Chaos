package net.plasma.sack_of_chaos.Item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.plasma.sack_of_chaos.Block.ModBlocks;
import net.plasma.sack_of_chaos.Sack_Of_Chaos;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Sack_Of_Chaos.MOD_ID);

    public static final RegistryObject<CreativeModeTab> SACK_OF_CHAOS = CREATIVE_MODE_TABS.register("sack_of_chaos_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SACK_OF_CHAOS_TAB_ICON.get()))
                    .title(Component.translatable("creativetab.sack_of_chaos_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.RAW_BISMUTH.get());
                        pOutput.accept(ModItems.BISMUTH_INGOT.get());
                        pOutput.accept(ModItems.DASHROOM.get());

                        pOutput.accept(ModBlocks.BLOCK_OF_RAW_BISMUTH.get());
                        pOutput.accept(ModBlocks.BISMUTH_BLOCK.get());
                        pOutput.accept(ModBlocks.BISMUTH_ORE.get());

                        pOutput.accept(ModBlocks.MAROONSTONE.get());

                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}