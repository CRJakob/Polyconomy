package com.crjakob.polyconomy.client;

import com.crjakob.polyconomy.client.screen.ATMConvertScreen;
import com.crjakob.polyconomy.screen.ATMGuiDescription;
import com.crjakob.polyconomy.screen.ModScreenHandlers;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;

public class PolyconomyClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ScreenRegistry.<ATMGuiDescription, ATMConvertScreen>register(
                ModScreenHandlers.ATM_SCREEN_HANDLER,
                (handler, playerInventory, title) ->
                        // handler == your ATMGuiDescription
                        // playerInventory.player == the PlayerEntity
                        new ATMConvertScreen(handler, playerInventory.player, title)
        );
    }
}
