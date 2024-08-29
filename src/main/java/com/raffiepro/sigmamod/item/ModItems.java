package com.raffiepro.sigmamod.item;

import com.raffiepro.sigmamod.SIGMAMOD;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    private static final FoodComponent CRUSHED_COCAINE_FOOD_COMPONENT = new FoodComponent.Builder()
            .nutrition(0)
            .saturationModifier(0.0f)
            .alwaysEdible()
            .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 600, 255), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 600, 255), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.WITHER, 600, 255), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 600, 255), 1.0f)
            .build();
    private static final FoodComponent MAYONNAISE_FOOD_COMPONENT = new FoodComponent.Builder()
            .nutrition(10)
            .saturationModifier(1.3f)
            .alwaysEdible()
            .statusEffect(new StatusEffectInstance(StatusEffects.HASTE, 6000, 255), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 6000, 255), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 6000, 255), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.LUCK, 6000, 255), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, 6000, 255), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 6000, 255), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 6000, 255), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.HERO_OF_THE_VILLAGE, 6000, 255), 1.0f)
            .build();

    public static final Item CRUSHED_COCAINE = registerItem("crushed_cocaine", new Item(new Item.Settings().food(CRUSHED_COCAINE_FOOD_COMPONENT)));
    public static final Item MAYONNAISE = registerItem("mayonnaise", new Item(new Item.Settings().food(MAYONNAISE_FOOD_COMPONENT)));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(SIGMAMOD.MOD_ID, name), item);
    }

    public static void registerModItems() {
        SIGMAMOD.LOGGER.info("SIGMAMOD IS REGISTERING SIGMA THINGS (items) >:)>:)");

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            entries.add(CRUSHED_COCAINE);
            entries.add(MAYONNAISE);
        });
    }
}