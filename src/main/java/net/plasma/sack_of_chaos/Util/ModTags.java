package net.plasma.sack_of_chaos.Util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.plasma.sack_of_chaos.Sack_Of_Chaos;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_PRISMA_ALLOY_TOOL = tag("needs_prisma_alloy_tool");


        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(Sack_Of_Chaos.MOD_ID, name));
        }
    }

    public static class Items {


        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(Sack_Of_Chaos.MOD_ID, name));
        }
    }
}