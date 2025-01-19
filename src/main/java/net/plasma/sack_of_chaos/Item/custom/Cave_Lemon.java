package net.plasma.sack_of_chaos.Item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class Cave_Lemon extends Item {
    public Cave_Lemon(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity) {
        if (!pLevel.isClientSide && pLivingEntity instanceof Player player) {
            if (pLevel.random.nextFloat() < 0.2) {
                Explosion cave_lemon = new Explosion(pLevel, player, player.getX(), player.getY(), player.getZ(), 4.0f, false, Explosion.BlockInteraction.DESTROY);
                pLevel.explode(player, player.getX(), player.getY(), player.getZ(),
                        4.0f, Level.ExplosionInteraction.TNT);
                player.hurt(player.damageSources().explosion(cave_lemon), 30f);


                Vec3 knockback = new Vec3(pLevel.random.nextDouble() - 0.5, 0.5,
                        pLevel.random.nextDouble() - 0.5).normalize().scale(3.0);
                player.setDeltaMovement(player.getDeltaMovement().add(knockback));
            }
        }
        return super.finishUsingItem(pStack, pLevel, pLivingEntity);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.sack_of_chaos.lemon.tooltip").withStyle(ChatFormatting.RED));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
