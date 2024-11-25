package net.plasma.sack_of_chaos.Item.custom;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class DashroomItem extends Item {
    public DashroomItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pUsedHand);
        Vec3 playerlook = pPlayer.getLookAngle();
        boolean isOnCooldown = pPlayer.getCooldowns().isOnCooldown(this);

        if (!isOnCooldown && playerlook.y > -0.5 && playerlook.y < 0.5 && !pPlayer.isCrouching()) { // Checks if the player is not looking at the ground or sky
            if (pLevel.isClientSide) {
                Vec3 dashvec = playerlook.normalize().scale(1.5); // Scale for Speed
                pPlayer.setDeltaMovement(dashvec);
            } else {
                pPlayer.getCooldowns().addCooldown(this, 60);
                itemstack.hurtAndBreak(1, pPlayer, (player) -> player.broadcastBreakEvent(pUsedHand));

            }
        }
        return InteractionResultHolder.success(pPlayer.getItemInHand(pUsedHand));
    }
}