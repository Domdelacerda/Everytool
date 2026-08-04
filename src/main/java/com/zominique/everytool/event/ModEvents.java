package com.zominique.everytool.event;

import com.zominique.everytool.Everytool;
import com.zominique.everytool.item.custom.coal.ICoalTool;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Everytool.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModEvents {

    @SubscribeEvent
    public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        ItemStack stack = event.getItemStack();
        if (!(stack.getItem() instanceof ICoalTool coalTool)) {
            return;
        }

        Level level = event.getLevel();
        BlockPos pos = event.getPos();
        BlockState state = level.getBlockState(pos);

        if (state.is(BlockTags.FIRE) || state.is(BlockTags.CAMPFIRES)
                || state.is(Blocks.LAVA) || state.is(Blocks.LAVA_CAULDRON)) {
            ignite(coalTool, stack, level, pos);
            event.setCanceled(true);
            event.setCancellationResult(InteractionResult.sidedSuccess(level.isClientSide));
        }
        else if (state.is(Blocks.WATER) || state.is(Blocks.WATER_CAULDRON)) {
            if (!level.isClientSide) {
                coalTool.setLit(stack, false);
                level.playSound(null, pos, SoundEvents.LAVA_EXTINGUISH,
                        SoundSource.PLAYERS, 1.0F, 1.0F);
            }
            event.setCanceled(true);
            event.setCancellationResult(InteractionResult.sidedSuccess(level.isClientSide));
        }
    }

    @SubscribeEvent
    public static void onRightClickItem(PlayerInteractEvent.RightClickItem event) {
        ItemStack stack = event.getItemStack();
        if (!(stack.getItem() instanceof ICoalTool coalTool)) {
            return;
        }

        Player player = event.getEntity();
        Level level = event.getLevel();
        BlockHitResult hit = raytraceIncludingFluids(level, player);
        if (hit.getType() != HitResult.Type.BLOCK) {
            return;
        }

        BlockPos pos = hit.getBlockPos();
        FluidState fluidState = level.getFluidState(pos);

        if (fluidState.is(FluidTags.LAVA) && !coalTool.isLit(stack)) {
            ignite(coalTool, stack, level, pos);
            event.setCanceled(true);
            event.setCancellationResult(InteractionResult.sidedSuccess(level.isClientSide));
        } else if (fluidState.is(FluidTags.WATER) && coalTool.isLit(stack)) {
            if (!level.isClientSide) {
                coalTool.extinguish(stack);
                level.playSound(null, pos, SoundEvents.FIRE_EXTINGUISH,
                        SoundSource.PLAYERS, 0.7F, 1.6F);
            }
            event.setCanceled(true);
            event.setCancellationResult(InteractionResult.sidedSuccess(level.isClientSide));
        }
    }

    @SubscribeEvent
    public static void onAttackEntity(AttackEntityEvent event) {
        Player player = event.getEntity();
        ItemStack stack = player.getMainHandItem();

        if (stack.getItem() instanceof ICoalTool coalTool && coalTool.isLit(stack)) {
            Entity target = event.getTarget();
            // Every 20 ticks is one second, so burning for 2 seconds is 40 ticks
            target.setRemainingFireTicks(Math.max(target.getRemainingFireTicks(), 40));
        }
    }

    private static BlockHitResult raytraceIncludingFluids(Level level, Player player) {
        double reach = player.blockInteractionRange();
        Vec3 eyePos = player.getEyePosition();
        Vec3 viewVector = player.getViewVector(1.0F);
        Vec3 endPos = eyePos.add(viewVector.x * reach, viewVector.y * reach, viewVector.z * reach);
        return level.clip(new ClipContext(
                eyePos,
                endPos,
                ClipContext.Block.OUTLINE,
                ClipContext.Fluid.SOURCE_ONLY,
                player
        ));
    }

    private static void ignite(ICoalTool coalTool, ItemStack stack, Level level, BlockPos pos) {
        if (!level.isClientSide) {
            coalTool.setLit(stack, true);
            level.playSound(null, pos, SoundEvents.FIRECHARGE_USE,
                    SoundSource.PLAYERS, 1.0F, 1.0F);
        }
    }
}
