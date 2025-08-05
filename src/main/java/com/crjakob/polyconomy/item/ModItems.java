package com.crjakob.polyconomy.item;

import com.crjakob.polyconomy.Polyconomy;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {
    public static void registerModItems() {
        Polyconomy.LOGGER.info("Registering mod items for " + Polyconomy.MOD_ID);
    }

    private static Item register(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Polyconomy.MOD_ID, name), item);
    }

    public static final Item PolycoinMold = register("polycoin_mold", new PolycoinMold(new FabricItemSettings().maxDamage(100)));


    //PolyCoin
    public static final Item PolyCoin = register(
            "polycoin",
            new Item(new FabricItemSettings()
                    .rarity(Rarity.RARE)
            )
    );
}