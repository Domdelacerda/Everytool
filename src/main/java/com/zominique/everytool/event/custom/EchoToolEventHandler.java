package com.zominique.everytool.event.custom;

import com.zominique.everytool.Everytool;
import com.zominique.everytool.item.custom.echo.IEchoTool;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Everytool.MOD_ID)
public class EchoToolEventHandler {

    // Scan radius for echo tool
    private static final int SCAN_RADIUS = 3;

    @SubscribeEvent
    public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        Player player = event.getEntity();
        if (!player.isShiftKeyDown()) {
            return;
        }

        ItemStack stack = event.getItemStack();
        if (!(stack.getItem() instanceof IEchoTool echoTool)) {
            return;
        }

        Level level = event.getLevel();
        BlockPos pos = event.getPos();
        BlockState state = level.getBlockState(pos);
        Block clickedBlock = state.getBlock();

        if (clickedBlock == Blocks.AIR) {
            return;
        }

        if (!level.isClientSide) {
            echoTool.setTunedBlock(stack, clickedBlock);
            echoTool.setResonatingUntil(stack, level.getGameTime()); // clear until the next break scan
            level.playSound(null, pos, SoundEvents.SCULK_CLICKING_STOP,
                    SoundSource.PLAYERS, 1.0F, 1.0F);

            if (player instanceof ServerPlayer serverPlayer) {
                serverPlayer.displayClientMessage(
                        Component.translatable("message.yourmod.echo_tuned", clickedBlock.getName()),
                        true // action bar, not chat
                );
            }
        }

        event.setCanceled(true);
        event.setCancellationResult(InteractionResult.sidedSuccess(level.isClientSide));
    }

    @SubscribeEvent
    public static void onBlockBreak(BlockEvent.BreakEvent event) {
        Player player = event.getPlayer();
        ItemStack stack = player.getMainHandItem();

        if (!(stack.getItem() instanceof IEchoTool echoTool) || !echoTool.isTuned(stack)) {
            return;
        }

        Block tunedBlock = echoTool.getTunedBlock(stack);
        Level level = player.level();
        BlockPos center = event.getPos();

        boolean found = false;
        for (BlockPos pos : BlockPos.betweenClosed(
                center.offset(-SCAN_RADIUS, -SCAN_RADIUS, -SCAN_RADIUS),
                center.offset(SCAN_RADIUS, SCAN_RADIUS, SCAN_RADIUS))) {
            if (level.getBlockState(pos).is(tunedBlock)) {
                found = true;
                break;
            }
        }

        if (found) {
            // On a miss we deliberately leave the existing window alone —
            // if a previous break is still within its 1-second window, it
            // expires naturally rather than being reset early.
            echoTool.setResonatingUntil(stack, level.getGameTime() + 20L); // 20 ticks = 1 second

            if (!level.isClientSide) {
                level.playSound(null, center, SoundEvents.SCULK_CLICKING,
                        SoundSource.PLAYERS, 1.0F, 1.2F);
            }
        }
    }
}