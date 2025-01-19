package net.plasma.sack_of_chaos.Item.custom;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.HashMap;
import java.util.Map;

public class Shade_Berry extends Item {
    private static final int COOLDOWN_TICKS = 200;
    private static final int EFFECT_CHECK_DURATION_TICKS = 100; // 5 seconds in game Ticks
    private final Map<Player, Long> cooldownEndTimes = new HashMap<>();

    public Shade_Berry(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity) {
        if (!pLevel.isClientSide && pLivingEntity instanceof Player player) {
            long currentTime = pLevel.getGameTime();

            if (cooldownEndTimes.containsKey(player)) {
                long cooldownEndTime = cooldownEndTimes.get(player);

                if (currentTime < cooldownEndTime + EFFECT_CHECK_DURATION_TICKS) {
                    player.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 160, 3));
                    player.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 160, 1));
                }
            }

            player.getCooldowns().addCooldown(this, COOLDOWN_TICKS);
            cooldownEndTimes.put(player, currentTime + COOLDOWN_TICKS);
        }
        return super.finishUsingItem(pStack, pLevel, pLivingEntity);
    }
}

