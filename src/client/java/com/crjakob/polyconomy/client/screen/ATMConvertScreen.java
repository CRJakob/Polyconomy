package com.crjakob.polyconomy.client.screen;

import com.crjakob.polyconomy.screen.ATMGuiDescription;
import io.github.cottonmc.cotton.gui.client.CottonInventoryScreen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;

public class ATMConvertScreen extends CottonInventoryScreen<ATMGuiDescription> {
    public ATMConvertScreen(ATMGuiDescription gui, PlayerEntity player, Text title) {
        super(gui, player, title);
    }
}
