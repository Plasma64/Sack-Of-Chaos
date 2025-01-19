package net.plasma.sack_of_chaos.Item.custom;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class Blushcap extends Item {
    public Blushcap(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack itemStack = pPlayer.getItemInHand(pUsedHand);
        boolean isOnCooldown = pPlayer.getCooldowns().isOnCooldown(this);

        if (!isOnCooldown) {
            if (!pLevel.isClientSide) {
                pPlayer.heal( 4.5f);
                pPlayer.getCooldowns().addCooldown(this, 480);
                itemStack.hurtAndBreak(1, pPlayer, (player) -> player.broadcastBreakEvent(pUsedHand));
                pPlayer.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 120, 2, false, false, false));
            }
        }
        return InteractionResultHolder.success(itemStack);
    }
}
