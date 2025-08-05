package com.crjakob.polyconomy;

import com.crjakob.polyconomy.block.ModBlocks;
import com.crjakob.polyconomy.blockentity.ModBlockEntities;
import com.crjakob.polyconomy.item.ModItems;
import com.crjakob.polyconomy.screen.ModScreenHandlers;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Polyconomy implements ModInitializer {
    public static final String MOD_ID = "polyconomy";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


    @Override
    public void onInitialize() {
        ModScreenHandlers.registerAll();
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
        ModItemGroups.registerItemGroups();
        ModBlockEntities.registerAllBlockEntities();
    }

}
