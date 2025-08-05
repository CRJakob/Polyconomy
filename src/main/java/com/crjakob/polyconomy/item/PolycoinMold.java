package com.crjakob.polyconomy.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class PolycoinMold extends Item {
    public PolycoinMold(Settings settings) {
        super(settings);
    }

    @Override
    public boolean hasRecipeRemainder() {
        return true;
    }

    @Override
    public ItemStack getRecipeRemainder(ItemStack stack) {
        ItemStack remainder = stack.copy();
        remainder.setDamage(stack.getDamage() + 1);

        if (remainder.getDamage() >= remainder.getMaxDamage()) {
            return ItemStack.EMPTY; // item breaks
        }

        return remainder;
    }
}

