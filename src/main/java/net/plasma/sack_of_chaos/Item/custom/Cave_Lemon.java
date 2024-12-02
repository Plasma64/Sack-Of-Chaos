package net.plasma.sack_of_chaos.Item.custom;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class Cave_Lemon extends Item {
    public Cave_Lemon(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity) {
        if (!pLevel.isClientSide && pLivingEntity instanceof Player player) {
            if (pLevel.random.nextFloat() < 0.2) {
                pLevel.explode(player, player.getX(), player.getY(), player.getZ(),
                        4.0f, Level.ExplosionInteraction.TNT);
                player.hurt(player.damageSources().generic(),30.0f);

                Vec3 knockback = new Vec3(pLevel.random.nextDouble() - 0.5, 0.5,
                        pLevel.random.nextDouble() - 0.5).normalize().scale(3.0);
                player.setDeltaMovement(player.getDeltaMovement().add(knockback));
            }
        }
        return super.finishUsingItem(pStack, pLevel, pLivingEntity);
    }
}
