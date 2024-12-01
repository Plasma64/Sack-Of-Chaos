package net.plasma.sack_of_chaos.Item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties TESTFOOD = new FoodProperties.Builder().nutrition(200)
            .saturationMod(2000.0f)
            .effect(() -> new MobEffectInstance(MobEffects.BLINDNESS, 200),0.5f).build();

}
