package net.plasma.sack_of_chaos.Item;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;
import net.plasma.sack_of_chaos.Sack_Of_Chaos;
import net.plasma.sack_of_chaos.Util.ModTags;

import java.util.List;

public class ModToolTiers {
    public static final Tier PRISMA_ALLOY = TierSortingRegistry.registerTier(
            new ForgeTier(2, 560, 6.5f, 2.0f, 12,
                    ModTags.Blocks.NEEDS_PRISMA_ALLOY_TOOL, () -> Ingredient.of(ModItems.PRISMA_ALLOY.get())),
            new ResourceLocation(Sack_Of_Chaos.MOD_ID, "prisma_alloy"), List.of(Tiers.IRON), List.of());
}
