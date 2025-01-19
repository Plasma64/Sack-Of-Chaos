package net.plasma.sack_of_chaos.Item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Illusioner;
import net.minecraft.world.entity.monster.Phantom;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Random;

public class Prisma_Alloy_Axe extends AxeItem {
    public Prisma_Alloy_Axe(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public boolean mineBlock(ItemStack pStack, Level pLevel, BlockState pState, BlockPos pPos, LivingEntity pEntityLiving) {
        if (!pLevel.isClientSide() && pEntityLiving instanceof Player player) {
            Random random = new Random();
            if (random.nextFloat(1) < 0.2) { // Chance
                player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 60, 0, false, false, false));
            }
        }
        return super.mineBlock(pStack, pLevel, pState, pPos, pEntityLiving);
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        if (!pTarget.level().isClientSide()) {
            if (pAttacker instanceof Player player) {
                if (player.getAttackStrengthScale(0) >= 1.0f) {
                    if (pTarget instanceof Phantom || pTarget instanceof Illusioner) {
                        pTarget.hurt(pTarget.damageSources().generic(), 3f);
                    }
                }
            }
        }
        return super.hurtEnemy(pStack, pTarget, pAttacker);
    }
}