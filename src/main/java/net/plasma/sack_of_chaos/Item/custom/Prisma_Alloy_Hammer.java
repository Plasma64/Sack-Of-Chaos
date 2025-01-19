package net.plasma.sack_of_chaos.Item.custom;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Illusioner;
import net.minecraft.world.entity.monster.Phantom;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;

import java.util.Random;


public class Prisma_Alloy_Hammer extends SwordItem {
    public Prisma_Alloy_Hammer(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        if (enchantment == Enchantments.SWEEPING_EDGE || enchantment == Enchantments.FIRE_ASPECT || enchantment == Enchantments.SMITE || enchantment == Enchantments.SHARPNESS) {
            return false;
        }
        return super.canApplyAtEnchantingTable(stack, enchantment);
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        if (!pTarget.level().isClientSide()) {
            if (pAttacker instanceof Player player) {
                if (player.getAttackStrengthScale(0) >= 1.0f) {
                    if (player.fallDistance > 10.0f) {
                        pTarget.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 255, false, false));
                    }
                    if (pTarget instanceof Phantom || pTarget instanceof Illusioner) {
                        pTarget.hurt(pTarget.damageSources().generic(), 3f);
                    }
                    Random random = new Random();
                    if (random.nextFloat(1) <= 0.5) { // Chance
                        int effectIndex = random.nextInt(4);
                        switch (effectIndex) {
                            case 0:
                                pTarget.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 100, 1));
                                break;
                            case 1:
                                pTarget.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 1));
                                break;
                            case 2:
                                pTarget.addEffect(new MobEffectInstance(MobEffects.POISON, 100, 1));
                                break;
                            case 3:
                                break;

                        }
                    }
                }
            }
        }
        return super.hurtEnemy(pStack, pTarget, pAttacker);
    }

    @Override
    public boolean canDisableShield(ItemStack stack, ItemStack shield, LivingEntity entity, LivingEntity attacker) {
        return true;
    }

    @Override
    public boolean canPerformAction(ItemStack stack, ToolAction toolAction) {
        if (toolAction == ToolActions.SWORD_SWEEP) {
            return false;
        }
        return super.canPerformAction(stack, toolAction);
    }
}