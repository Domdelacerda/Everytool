package com.zominique.everytool.item.custom;

import com.zominique.everytool.component.ModDataComponentTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;

/**
 * All CoalXxxItem classes implement this. Vanilla's tool item classes
 * (PickaxeItem, AxeItem, SwordItem, ShovelItem, HoeItem) don't share a
 * common non-Item superclass we can hook into, so we use default methods
 * here and call them from each item's overrides instead of duplicating logic.
 */
public interface ICoalTool {

    default boolean isLit(ItemStack stack) {
        return stack.getOrDefault(ModDataComponentTypes.LIT.get(), false);
    }

    default void setLit(ItemStack stack, boolean lit) {
        stack.set(ModDataComponentTypes.LIT.get(), lit);
    }

    default InteractionResult tryIgnite(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        BlockState state = level.getBlockState(pos);

        if (state.is(BlockTags.FIRE)) {
            ItemStack stack = context.getItemInHand();
            if (!isLit(stack)) {
                if (!level.isClientSide) {
                    setLit(stack, true);
                    level.playSound(null, pos, SoundEvents.FIRECHARGE_USE,
                            SoundSource.PLAYERS, 1.0F, 1.0F);
                }
                return InteractionResult.sidedSuccess(level.isClientSide);
            }
        }
        return InteractionResult.PASS;
    }

    default void applyIgniteOnHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (isLit(stack)) {
            target.setRemainingFireTicks(Math.max(target.getRemainingFireTicks(), 100)); // 5 seconds
        }
    }

    default void extinguish(ItemStack stack) {
        setLit(stack, false);
    }
}