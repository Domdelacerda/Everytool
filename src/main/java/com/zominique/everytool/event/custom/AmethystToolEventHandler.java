package com.zominique.everytool.event.custom;

import com.zominique.everytool.Everytool;
import com.zominique.everytool.block.custom.AmethystGlassBlock;
import com.zominique.everytool.client.AmethystGlassTracker;
import com.zominique.everytool.item.custom.amethyst.IAmethystTool;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Everytool.MOD_ID)
public class AmethystToolEventHandler {
    @SubscribeEvent
    public static void onLeftClickBlock(PlayerInteractEvent.LeftClickBlock event) {
        Player player = event.getEntity();
        Level level = event.getLevel();
        PlayerInteractEvent.LeftClickBlock.Action action = event.getAction();
        boolean holdingAmethyst = player.getMainHandItem().getItem() instanceof IAmethystTool;

        if (level.isClientSide()) {
            // Must capture BEFORE the server's swap packet arrives, i.e. right
            // at START, while the client still sees the real block.
            if (action == PlayerInteractEvent.LeftClickBlock.Action.START && holdingAmethyst) {
                BlockState state = level.getBlockState(event.getPos());
                if (!(state.getBlock() instanceof AmethystGlassBlock)) {
                    AmethystGlassTracker.captureClientRealState(event.getPos(), state);
                }
            }
            return;
        }

        if (!(player instanceof ServerPlayer serverPlayer) || !(level instanceof ServerLevel serverLevel)) {
            return;
        }

        switch (action) {
            case START -> {
                // ABORT/STOP deliberately aren't gated on holdingAmethyst —
                // the player may have swapped tools by the time they arrive.
                if (holdingAmethyst && !event.isCanceled()) {
                    AmethystGlassTracker.start(serverPlayer, serverLevel, event.getPos());
                }
            }
            case ABORT -> AmethystGlassTracker.end(serverPlayer, true);
            case STOP -> AmethystGlassTracker.end(serverPlayer, false);
            default -> { }
        }
    }

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END && event.player instanceof ServerPlayer serverPlayer) {
            AmethystGlassTracker.tick(serverPlayer);
        }
    }

    @SubscribeEvent
    public static void onLogout(PlayerEvent.PlayerLoggedOutEvent event) {
        if (event.getEntity() instanceof ServerPlayer serverPlayer) {
            AmethystGlassTracker.forget(serverPlayer);
        }
    }
}
