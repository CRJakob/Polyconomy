package com.crjakob.polyconomy.screen;

import com.crjakob.polyconomy.item.ModItems;
import io.github.cottonmc.cotton.gui.SyncedGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WButton;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import io.github.cottonmc.cotton.gui.widget.WItemSlot;
import io.github.cottonmc.cotton.gui.widget.data.HorizontalAlignment;
import io.github.cottonmc.cotton.gui.widget.data.Insets;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.text.Text;

import java.util.concurrent.atomic.AtomicReference;

public class ATMGuiDescription extends SyncedGuiDescription {
    private static final int INVENTORY_SIZE = 2;

    public static Inventory getBlockInventory(ScreenHandlerContext context, int size) {
        AtomicReference<Inventory> inventoryRef = new AtomicReference<>(new SimpleInventory(size));
        context.run((world, pos) -> {
            BlockEntity be = world.getBlockEntity(pos);
            if (be instanceof Inventory) {
                inventoryRef.set((Inventory) be);
            }
        });
        return inventoryRef.get();
    }


    public ATMGuiDescription(int syncId, PlayerInventory playerInventory, ScreenHandlerContext context) {
        super(ModScreenHandlers.ATM_SCREEN_HANDLER, syncId, playerInventory, getBlockInventory(context, INVENTORY_SIZE), getBlockPropertyDelegate(context));

        WGridPanel root = new WGridPanel();


        setRootPanel(root);
        root.setSize(9 * 18, 6 * 18);
        root.setInsets(Insets.ROOT_PANEL);

        titleAlignment = HorizontalAlignment.CENTER;

        WItemSlot inputSlot = WItemSlot.of(blockInventory, 0);
        inputSlot.setInputFilter(stack ->
                stack.isOf(Items.DIAMOND) || stack.isOf(ModItems.PolyCoin)
        );
        root.add(inputSlot, 1, 1);

        WItemSlot outputSlot = WItemSlot.of(blockInventory, 1);
        outputSlot.setInsertingAllowed(false);
        root.add(outputSlot, 7, 1);

        WButton convertButton = new WButton(null, Text.translatable("convertscreen.polyconomy.convertbutton"));
        convertButton.setOnClick(() -> {
            // Your procedure code here
            System.out.println("Convert button clicked!");
            convertItems();
        });
        root.add(convertButton, 3, 1, 3, 1);

        root.add(this.createPlayerInventoryPanel(), 0, 3);

        root.validate(this);
    }

    public void convertItems() {
        ItemStack input = this.blockInventory.getStack(0);
        ItemStack output = this.blockInventory.getStack(1);

        // Only proceed if input is diamonds
        if (input.getItem() == Items.DIAMOND) {
            int maxOutputStackSize = ModItems.PolyCoin.getMaxCount(); // usually 64

            int inputCount = input.getCount();
            int outputCount = output.getCount();
            boolean outputIsEmpty = output.isEmpty();
            boolean outputIsPolycoin = !outputIsEmpty && output.isOf(ModItems.PolyCoin);

            // Calculate how many diamonds can be converted, considering output space
            int maxConvertibleDiamonds = (maxOutputStackSize - outputCount) / 5;

            // Clamp to input count
            int diamondsToConvert = Math.min(inputCount, maxConvertibleDiamonds);

            if (diamondsToConvert > 0) {
                int coinsToAdd = diamondsToConvert * 5;

                // Update output slot
                if (outputIsEmpty) {
                    output = new ItemStack(ModItems.PolyCoin, coinsToAdd);
                } else if (outputIsPolycoin) {
                    output.increment(coinsToAdd);
                } else {
                    // Output slot is something else, cannot convert
                    return;
                }

                // Decrement input slot diamonds
                input.decrement(diamondsToConvert);

                // Write back updated stacks
                this.blockInventory.setStack(0, input);
                this.blockInventory.setStack(1, output);
            }
        }
    }

}
