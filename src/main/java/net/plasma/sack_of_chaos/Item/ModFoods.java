package net.plasma.sack_of_chaos.Item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties TESTFOOD = new FoodProperties.Builder().nutrition(200)
            .saturationMod(2000.0f)
            .effect(() -> new MobEffectInstance(MobEffects.BLINDNESS, 200),0.5f).build();
    public static final FoodProperties LEMON = new FoodProperties.Builder().nutrition(3)
            .saturationMod(0.2f).build();
    public static final FoodProperties ORANGE = new FoodProperties.Builder().nutrition(4)
            .saturationMod(0.3f).build();
    public static final FoodProperties SHADE_BERRY = new FoodProperties.Builder().nutrition(2)
            .saturationMod(0.3f).fast()
            .effect(() -> new MobEffectInstance(MobEffects.INVISIBILITY, 120), 1.0f).build();


}
