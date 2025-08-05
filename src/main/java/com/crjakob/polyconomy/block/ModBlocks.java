package com.crjakob.polyconomy.block;

import com.crjakob.polyconomy.Polyconomy;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.registry.Registries;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registry;


public class ModBlocks {
    public static final Block ATM = registerBlock("atm",
            new ATMBlock(AbstractBlock.Settings.create()
            .sounds(BlockSoundGroup.METAL)
            .hardness(1.2F)
    ));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Polyconomy.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, new Identifier(Polyconomy.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        Polyconomy.LOGGER.info("Registering blocks for " + Polyconomy.MOD_ID);
        // Trigger class loading / static init
    }
}
