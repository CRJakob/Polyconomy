package com.crjakob.polyconomy.blockentity;

import com.crjakob.polyconomy.Polyconomy;
import com.crjakob.polyconomy.block.ModBlocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static BlockEntityType<ATMBlockEntity> ATM_BLOCK_ENTITY;

    public static void registerAllBlockEntities() {
        ATM_BLOCK_ENTITY = Registry.register(
                Registries.BLOCK_ENTITY_TYPE,
                new Identifier(Polyconomy.MOD_ID, "atm_block_entity"),
                BlockEntityType.Builder.create(ATMBlockEntity::new, ModBlocks.ATM).build(null)
        );
    }
}
