package net.plasma.sack_of_chaos.Block;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.plasma.sack_of_chaos.Item.ModItems;
import net.plasma.sack_of_chaos.Sack_Of_Chaos;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Sack_Of_Chaos.MOD_ID);

    public static final SoundType MAROONSTONE_SOUNDS = new SoundType(1.0f, 0.5F,
            SoundEvents.LANTERN_STEP,
            SoundEvents.LANTERN_BREAK,
            SoundEvents.LANTERN_HIT,
            SoundEvents.LANTERN_PLACE,
            SoundEvents.LANTERN_FALL);


    public static final RegistryObject<Block>  BLOCK_OF_RAW_BISMUTH = registerBlock("block_of_raw_bismuth",
    () -> new Block(BlockBehaviour.Properties.copy(Blocks.RAW_IRON_BLOCK).sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> BISMUTH_BLOCK = registerBlock("bismuth_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block>  MAROONSTONE = registerBlock("maroonstone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.BLACKSTONE).sound(MAROONSTONE_SOUNDS)
                    .strength(6f)));

    public static final RegistryObject<Block> BISMUTH_ORE = registerBlock("bismuth_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(2f).requiresCorrectToolForDrops(), UniformInt.of(3, 6)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;

    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));

    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
