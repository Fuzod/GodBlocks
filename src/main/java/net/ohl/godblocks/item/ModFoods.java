package net.ohl.godblocks.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties STRAWBERRY = new FoodProperties.Builder().nutrition(3).saturationModifier(0.5F).build();
    public static final FoodProperties STRAWBERRY_CAKE = new FoodProperties.Builder().nutrition(8)
            .saturationModifier(0.3F).effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200), 0.5f).build();

    public static final FoodProperties COCONUT_HALF = new FoodProperties.Builder().nutrition(3).saturationModifier(0.5F).build();
    public static final FoodProperties COCONUT_MILK = new FoodProperties.Builder().nutrition(2).saturationModifier(1F).build();
}
