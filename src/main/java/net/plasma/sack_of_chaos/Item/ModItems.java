package net.plasma.sack_of_chaos.Item;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.plasma.sack_of_chaos.Block.ModBlocks;
import net.plasma.sack_of_chaos.Item.custom.Cave_Lemon;
import net.plasma.sack_of_chaos.Item.custom.DashroomItem;
import net.plasma.sack_of_chaos.Item.custom.FuelBlockItem;
import net.plasma.sack_of_chaos.Item.custom.Shade_Berry;
import net.plasma.sack_of_chaos.Sack_Of_Chaos;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Sack_Of_Chaos.MOD_ID);

    public static final RegistryObject<Item> BISMUTH_INGOT = ITEMS.register("bismuth_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_BISMUTH = ITEMS.register("raw_bismuth",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SACK_OF_CHAOS_TAB_ICON = ITEMS.register("sack_of_chaos_tab_icon",
            () -> new Item(new Item.Properties()));

    public static final  RegistryObject<Item> MAROONSTONE_ITEM = ITEMS.register("maroonstone_item",
            () -> new BlockItem(ModBlocks.MAROONSTONE.get(), new Item.Properties().fireResistant()));
    public static final  RegistryObject<Item> BLOCK_OF_CONDENSED_COAL_ITEM = ITEMS.register("block_of_condensed_coal_item",
            () -> new FuelBlockItem(ModBlocks.BLOCK_OF_CONDENSED_COAL.get(), new Item.Properties(), 1600));

    public static final RegistryObject<Item> TESTFOOD = ITEMS.register("testfood",
            () -> new Item(new Item.Properties().food(ModFoods.TESTFOOD)));
    public static final RegistryObject<Item> LEMON = ITEMS.register("lemon",
            () -> new Cave_Lemon(new Item.Properties().food(ModFoods.LEMON)));
    public static final RegistryObject<Item> ORANGE = ITEMS.register("orange",
            () -> new Item(new Item.Properties().food(ModFoods.ORANGE)));
    public static final RegistryObject<Item> SHADE_BERRY = ITEMS.register("shade_berry",
            () -> new Shade_Berry(new Item.Properties().food(ModFoods.SHADE_BERRY)));


    public static final RegistryObject<Item> DASHROOM = ITEMS.register("dashroom",
            () -> new DashroomItem(new Item.Properties().durability(50)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
