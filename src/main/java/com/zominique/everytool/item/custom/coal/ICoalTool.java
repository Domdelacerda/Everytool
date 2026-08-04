package com.zominique.everytool.item.custom.coal;

import com.zominique.everytool.component.ModDataComponentTypes;
import net.minecraft.world.item.ItemStack;

public interface ICoalTool {

    default boolean isLit(ItemStack stack) {
        return stack.getOrDefault(ModDataComponentTypes.LIT.get(), false);
    }

    default void setLit(ItemStack stack, boolean lit) {
        stack.set(ModDataComponentTypes.LIT.get(), lit);
    }

    default void extinguish(ItemStack stack) {
        setLit(stack, false);
    }
}