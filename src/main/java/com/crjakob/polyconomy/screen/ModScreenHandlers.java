package com.crjakob.polyconomy.screen;

import com.crjakob.polyconomy.Polyconomy;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.util.Identifier;
import net.minecraft.registry.RegistryKey;
import net.minecraft.resource.featuretoggle.FeatureFlags;

public class ModScreenHandlers {
    // 1) The static field
    public static ScreenHandlerType<ATMGuiDescription> ATM_SCREEN_HANDLER;

    // 2) Call this from your main ModInitializer#onInitialize()
    public static void registerAll() {
        ATM_SCREEN_HANDLER = Registry.register(
                Registries.SCREEN_HANDLER,
                // 3) The Identifier—either inline or pull from a public constant
                new Identifier(Polyconomy.MOD_ID, "atm"),
                // 4) Correct constructor: (factory, featureFlags)
                new ScreenHandlerType<>(
                        // factory: syncId, playerInv -> new ATMGuiDescription(...)
                        (syncId, inv) -> new ATMGuiDescription(syncId, inv, ScreenHandlerContext.EMPTY),
                        FeatureFlags.VANILLA_FEATURES
                )
        );
    }
}
