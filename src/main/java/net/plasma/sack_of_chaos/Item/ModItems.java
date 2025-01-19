package net.plasma.sack_of_chaos.Item;

import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.plasma.sack_of_chaos.Item.custom.*;
import net.plasma.sack_of_chaos.Sack_Of_Chaos;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Sack_Of_Chaos.MOD_ID);

    public static final RegistryObject<Item> BISMUTH_INGOT = ITEMS.register("bismuth_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_BISMUTH = ITEMS.register("raw_bismuth",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PRISMA_ALLOY = ITEMS.register("prisma_alloy",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SACK_OF_CHAOS_TAB_ICON = ITEMS.register("sack_of_chaos_tab_icon",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TESTFOOD = ITEMS.register("testfood",
            () -> new Item(new Item.Properties().food(ModFoods.TESTFOOD)));

    public static final RegistryObject<Item> LEMON = ITEMS.register("lemon",
            () -> new Cave_Lemon(new Item.Properties().food(ModFoods.LEMON)));
    public static final RegistryObject<Item> ORANGE = ITEMS.register("orange",
            () -> new Item(new Item.Properties().food(ModFoods.ORANGE)));
    public static final RegistryObject<Item> SHADE_BERRY = ITEMS.register("shade_berry",
            () -> new Shade_Berry(new Item.Properties().food(ModFoods.SHADE_BERRY)));


    public static final RegistryObject<Item> DASHCAP = ITEMS.register("dashcap",
            () -> new Dashcap(new Item.Properties().durability(75)));
    public static final RegistryObject<Item> BLUSHCAP = ITEMS.register("blushcap",
            () -> new Blushcap(new Item.Properties().durability(75)));

    public static final RegistryObject<Item> PRISMA_ALLOY_HAMMER = ITEMS.register("prisma_alloy_hammer",
            () -> new Prisma_Alloy_Hammer(ModToolTiers.PRISMA_ALLOY, 7, -3.5f, new Item.Properties()));
    public static final RegistryObject<Item> PRISMA_ALLOY_PICKAXE = ITEMS.register("prisma_alloy_pickaxe",
            () -> new Prisma_Alloy_Pickaxe(ModToolTiers.PRISMA_ALLOY, 1, -2.8f, new Item.Properties()));
    public static final RegistryObject<Item> PRISMA_ALLOY_AXE = ITEMS.register("prisma_alloy_axe",
            () -> new Prisma_Alloy_Axe(ModToolTiers.PRISMA_ALLOY, 6, -3.1f, new Item.Properties()));
    public static final RegistryObject<Item> PRISMA_ALLOY_SHOVEL = ITEMS.register("prisma_alloy_shovel",
            () -> new Prisma_Alloy_Shovel(ModToolTiers.PRISMA_ALLOY, 1.5f, -3, new Item.Properties()));
    public static final RegistryObject<Item> PRISMA_ALLOY_HOE = ITEMS.register("prisma_alloy_hoe",
            () -> new HoeItem(ModToolTiers.PRISMA_ALLOY, -2, -1, new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
