package net.plasma.sack_of_chaos.Block;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.plasma.sack_of_chaos.Block.custom.Echo_AnchorBlock;
import net.plasma.sack_of_chaos.Item.ModItems;
import net.plasma.sack_of_chaos.Item.custom.FuelBlockItem;
import net.plasma.sack_of_chaos.Sack_Of_Chaos;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Sack_Of_Chaos.MOD_ID);

    public static final RegistryObject<Block>  BLOCK_OF_RAW_BISMUTH = registerBlock("block_of_raw_bismuth",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.RAW_IRON_BLOCK).sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> BISMUTH_BLOCK = registerBlock("bismuth_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> MAROONSTONE = registerFireResistantBlock("maroonstone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.BLACKSTONE)
                    .sound(SoundType.LANTERN)
                    .strength(3f, 6f)));
    public static final RegistryObject<Block> MAROONSTONE_STAIRS = registerFireResistantBlock("maroonstone_stairs",
            () -> new StairBlock(() -> ModBlocks.MAROONSTONE.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.BLACKSTONE)
                    .sound(SoundType.LANTERN)
                    .strength(3f, 6f)));
    public static final RegistryObject<Block> MAROONSTONE_SLAB = registerFireResistantBlock("maroonstone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.BLACKSTONE)
                    .sound(SoundType.LANTERN)
                    .strength(3f, 6f)));
    public static final RegistryObject<Block> MAROONSTONE_WALL = registerFireResistantBlock("maroonstone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.BLACKSTONE)
                    .sound(SoundType.LANTERN)
                    .strength(3f, 6f)));
    public static final RegistryObject<Block> POLISHED_MAROONSTONE = registerFireResistantBlock("polished_maroonstone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.BLACKSTONE)
                    .sound(SoundType.LANTERN)
                    .strength(3f, 6f)));
    public static final RegistryObject<Block> POLISHED_MAROONSTONE_BRICKS = registerFireResistantBlock("polished_maroonstone_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.BLACKSTONE)
                    .sound(SoundType.LANTERN)
                    .strength(3f, 6f)));
    public static final RegistryObject<Block> POLISHED_MAROONSTONE_BRICK_STAIRS = registerFireResistantBlock("polished_maroonstone_brick_stairs",
            () -> new StairBlock(() -> ModBlocks.POLISHED_MAROONSTONE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.BLACKSTONE)
                    .sound(SoundType.LANTERN)
                    .strength(3f, 6f)));
    public static final RegistryObject<Block> POLISHED_MAROONSTONE_BRICK_SLAB = registerFireResistantBlock("polished_maroonstone_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.BLACKSTONE)
                    .sound(SoundType.LANTERN)
                    .strength(2f, 3f)));
    public static final RegistryObject<Block> POLISHED_MAROONSTONE_BRICK_WALL = registerFireResistantBlock("polished_maroonstone_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.BLACKSTONE)
                    .sound(SoundType.LANTERN)
                    .strength(2f, 3f)));
    public static final RegistryObject<Block> CRACKED_POLISHED_MAROONSTONE_BRICKS = registerFireResistantBlock("cracked_polished_maroonstone_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.BLACKSTONE)
                    .sound(SoundType.LANTERN)
                    .strength(3f, 6f)));
    public static final RegistryObject<Block> POLISHED_MAROONSTONE_STAIRS = registerFireResistantBlock("polished_maroonstone_stairs",
            () -> new StairBlock(() -> ModBlocks.POLISHED_MAROONSTONE.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.BLACKSTONE)
                    .sound(SoundType.LANTERN)
                    .strength(3f, 6f)));
    public static final RegistryObject<Block> POLISHED_MAROONSTONE_SLAB = registerFireResistantBlock("polished_maroonstone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.BLACKSTONE)
                    .sound(SoundType.LANTERN)
                    .strength(2f, 3f)));
    public static final RegistryObject<Block> POLISHED_MAROONSTONE_WALL = registerFireResistantBlock("polished_maroonstone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.BLACKSTONE)
                    .sound(SoundType.LANTERN)
                    .strength(2f, 3f)));
    public static final RegistryObject<Block> POLISHED_MAROONSTONE_BUTTON = registerFireResistantBlock("polished_maroonstone_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.POLISHED_BLACKSTONE_BUTTON).sound(SoundType.LANTERN),
                    BlockSetType.POLISHED_BLACKSTONE, 20, false));
    public static final RegistryObject<Block> POLISHED_MAROONSTONE_PRESSURE_PLATE = registerFireResistantBlock("polished_maroonstone_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.POLISHED_BLACKSTONE).sound(SoundType.LANTERN),
                    BlockSetType.POLISHED_BLACKSTONE));


    public static final RegistryObject<Block> BLOCK_OF_CONDENSED_COAL = registerBlock_Of_Condensed_CoalBlock("block_of_condensed_coal",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COAL_BLOCK)));
    public static final RegistryObject<Block> ECHO_ANCHOR = registerBlock("echo_anchor",
            () -> new Echo_AnchorBlock(BlockBehaviour.Properties.copy(Blocks.OBSIDIAN)));

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

    private static <T extends Block> RegistryObject<T> registerFireResistantBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerFireResistantBlockItem(name, toReturn);
        return toReturn;

    }

    private static <T extends Block> RegistryObject<Item> registerFireResistantBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().fireResistant()));

    }

    private static <T extends Block> RegistryObject<T> registerFuelBlockItemBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerFuelBlockItem(name, toReturn);
        return toReturn;

    }

    private static <T extends Block> RegistryObject<Item> registerFuelBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new FuelBlockItem(block.get(), new Item.Properties(), 0));

    }

    private static <T extends Block> RegistryObject<T> registerBlock_Of_Condensed_CoalBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlock_Of_Condensed_CoalBlockItem(name, toReturn);
        return toReturn;

    }

    private static <T extends Block> RegistryObject<Item> registerBlock_Of_Condensed_CoalBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new FuelBlockItem(block.get(), new Item.Properties(), 1600));

    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
