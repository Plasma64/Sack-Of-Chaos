package net.plasma.sack_of_chaos.Item.custom;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class Dashcap extends Item {
    public Dashcap(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pUsedHand);
        Vec3 playerlook = pPlayer.getLookAngle();
        boolean isOnCooldown = pPlayer.getCooldowns().isOnCooldown(this);

        if (!isOnCooldown && playerlook.y > -0.30 && playerlook.y < 0.30 && !pPlayer.isCrouching()) { // Checks if the player is not looking at the ground or sky or crouching
            if (pLevel.isClientSide) {
                Vec3 dashvec = playerlook.normalize().scale(1.5f);
                pPlayer.setDeltaMovement(dashvec);
            } else {
                pPlayer.getCooldowns().addCooldown(this, 120);
                itemstack.hurtAndBreak(1, pPlayer, (player) -> player.broadcastBreakEvent(pUsedHand));
                pPlayer.addEffect((new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 60, 1, false, false, false)));
            }
        }
        return InteractionResultHolder.success(itemstack);
    }
}