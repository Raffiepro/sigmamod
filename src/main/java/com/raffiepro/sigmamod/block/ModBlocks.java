package com.raffiepro.sigmamod.block;

import com.raffiepro.sigmamod.SIGMAMOD;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block COCAINE_BLOCK = registerBlock("cocaine_block",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.WHITE).strength(2f).requiresTool().sounds(BlockSoundGroup.ROOTED_DIRT)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(SIGMAMOD.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(SIGMAMOD.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        SIGMAMOD.LOGGER.info("SIGMAMOD IS REGISTERING SIGMA THINGS (blocks) >:)>:)");

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
            entries.add(COCAINE_BLOCK);
        });
    }
}