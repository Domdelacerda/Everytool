package com.zominique.everytool.item.custom.echo;

import com.zominique.everytool.component.ModDataComponentTypes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public interface IEchoTool {

    default Block getTunedBlock(ItemStack stack) {
        return stack.getOrDefault(ModDataComponentTypes.TUNED_BLOCK.get(), Blocks.AIR);
    }

    default void setTunedBlock(ItemStack stack, Block block) {
        stack.set(ModDataComponentTypes.TUNED_BLOCK.get(), block);
    }

    default boolean isTuned(ItemStack stack) {
        return getTunedBlock(stack) != Blocks.AIR;
    }

    default long getResonatingUntil(ItemStack stack) {
        return stack.getOrDefault(ModDataComponentTypes.RESONATING_UNTIL.get(), 0L);
    }

    default void setResonatingUntil(ItemStack stack, long gameTime) {
        stack.set(ModDataComponentTypes.RESONATING_UNTIL.get(), gameTime);
    }

    default boolean isResonating(ItemStack stack, long currentGameTime) {
        return currentGameTime < getResonatingUntil(stack);
    }

    default int getResonanceLevel(ItemStack stack) {
        return stack.getOrDefault(ModDataComponentTypes.RESONANCE_LEVEL.get(), 0);
    }

    default void setResonanceLevel(ItemStack stack, int level) {
        stack.set(ModDataComponentTypes.RESONANCE_LEVEL.get(), level);
    }
}
