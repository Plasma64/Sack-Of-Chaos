package net.plasma.sack_of_chaos.Item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.plasma.sack_of_chaos.Item.custom.DashroomItem;
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
    public static final RegistryObject<Item> Dashroom = ITEMS.register("dashroom",
            () -> new DashroomItem(new Item.Properties().durability(50)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
