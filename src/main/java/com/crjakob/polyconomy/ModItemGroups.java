package com.crjakob.polyconomy;

import com.crjakob.polyconomy.block.ModBlocks;
import com.crjakob.polyconomy.item.ModItems;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.item.ItemGroup;

public class ModItemGroups {
    public static final ItemGroup POLYCONOMY_TAB = Registry.register(
            Registries.ITEM_GROUP,
            new Identifier("polyconomy", "main"),
            FabricItemGroup.builder()
                    .displayName(Text.translatable("itemGroup.polyconomy.main"))
                    .icon(() -> new ItemStack(ModItems.PolyCoin))
                    .entries((context, entries) -> {
                        entries.add(ModItems.PolyCoin);
                    })
                    .build()
    );

    public static void registerItemGroups() {
        Polyconomy.LOGGER.info("Registering creative tab for Polyconomy");
    }
}
