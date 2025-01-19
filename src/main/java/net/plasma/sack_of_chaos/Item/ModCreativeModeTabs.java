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

                        pOutput.accept(ModItems.DASHCAP.get());
                        pOutput.accept(ModItems.BLUSHCAP.get());
                        pOutput.accept(ModItems.PRISMA_ALLOY.get());

                        pOutput.accept(ModItems.LEMON.get());
                        pOutput.accept(ModItems.ORANGE.get());
                        pOutput.accept(ModItems.SHADE_BERRY.get());

                        pOutput.accept(ModBlocks.BLOCK_OF_RAW_BISMUTH.get());
                        pOutput.accept(ModBlocks.BISMUTH_BLOCK.get());
                        pOutput.accept(ModBlocks.BISMUTH_ORE.get());

                        pOutput.accept(ModBlocks.ECHO_ANCHOR.get());

                        pOutput.accept(ModBlocks.MAROONSTONE.get());
                        pOutput.accept(ModBlocks.MAROONSTONE_SLAB.get());
                        pOutput.accept(ModBlocks.MAROONSTONE_STAIRS.get());
                        pOutput.accept(ModBlocks.MAROONSTONE_WALL.get());
                        pOutput.accept(ModBlocks.POLISHED_MAROONSTONE.get());
                        pOutput.accept(ModBlocks.POLISHED_MAROONSTONE_BRICKS.get());
                        pOutput.accept(ModBlocks.CRACKED_POLISHED_MAROONSTONE_BRICKS.get());
                        pOutput.accept(ModBlocks.POLISHED_MAROONSTONE_BRICK_SLAB.get());
                        pOutput.accept(ModBlocks.POLISHED_MAROONSTONE_BRICK_STAIRS.get());
                        pOutput.accept(ModBlocks.POLISHED_MAROONSTONE_BRICK_WALL.get());
                        pOutput.accept(ModBlocks.POLISHED_MAROONSTONE_SLAB.get());
                        pOutput.accept(ModBlocks.POLISHED_MAROONSTONE_STAIRS.get());
                        pOutput.accept(ModBlocks.POLISHED_MAROONSTONE_WALL.get());
                        pOutput.accept(ModBlocks.POLISHED_MAROONSTONE_BUTTON.get());
                        pOutput.accept(ModBlocks.POLISHED_MAROONSTONE_PRESSURE_PLATE.get());

                        pOutput.accept(ModBlocks.BLOCK_OF_CONDENSED_COAL.get());

                        pOutput.accept(ModItems.PRISMA_ALLOY_HAMMER.get());
                        pOutput.accept(ModItems.PRISMA_ALLOY_PICKAXE.get());
                        pOutput.accept(ModItems.PRISMA_ALLOY_AXE.get());
                        pOutput.accept(ModItems.PRISMA_ALLOY_SHOVEL.get());
                        pOutput.accept(ModItems.PRISMA_ALLOY_HOE.get());

                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}