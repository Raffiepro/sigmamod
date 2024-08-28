package com.raffiepro.sigmamod.item;

import com.raffiepro.sigmamod.SIGMAMOD;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item CRUSHED_COCAINE = registerItem("crushed_cocaine", new Item(new Item.Settings()));
    public static final Item MAYONNAISE = registerItem("mayonnaise", new Item(new Item.Settings()));


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