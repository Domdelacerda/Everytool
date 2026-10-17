package com.zominique.everytool.client;

import com.zominique.everytool.block.ModBlocks;
import com.zominique.everytool.item.custom.amethyst.IAmethystTool;
import net.minecraft.core.BlockPos;
import net.minecraft.network.protocol.game.ClientboundBlockUpdatePacket;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class AmethystGlassTracker {

    private static BlockPos clientPos;
    private static BlockState clientRealState;

    public static void captureClientRealState(BlockPos pos, BlockState realState) {
        clientPos = pos.immutable();
        clientRealState = realState;
    }

    /** Null unless pos is the block this client most recently started mining. */
    public static BlockState getClientRealState(BlockPos pos) {
        return pos.equals(clientPos) ? clientRealState : null;
    }

    private static final long MAX_VISIBLE_TICKS = 600;

    private record ActiveGhost(ResourceKey<Level> dimension, BlockPos pos, long startTick) {}

    private static final Map<UUID, ActiveGhost> ACTIVE = new ConcurrentHashMap<>();

    public static void start(ServerPlayer player, ServerLevel level, BlockPos pos) {
        end(player, true); // never leave an older ghost behind

        BlockState real = level.getBlockState(pos);
        if (!isEligible(player, level, pos, real)) {
            return;
        }

        ACTIVE.put(player.getUUID(), new ActiveGhost(level.dimension(), pos.immutable(), level.getGameTime()));
        player.connection.send(new ClientboundBlockUpdatePacket(
                pos, ModBlocks.AMETHYST_GLASS.get().defaultBlockState()));
    }

    public static void end(ServerPlayer player, boolean restoreVisual) {
        ActiveGhost ghost = ACTIVE.remove(player.getUUID());
        if (ghost == null || !restoreVisual) {
            return;
        }

        if (player.level() instanceof ServerLevel level && level.dimension().equals(ghost.dimension())) {
            player.connection.send(new ClientboundBlockUpdatePacket(
                    ghost.pos(), level.getBlockState(ghost.pos())));
        }
    }

    public static void tick(ServerPlayer player) {
        ActiveGhost ghost = ACTIVE.get(player.getUUID());
        if (ghost == null) {
            return;
        }

        boolean stillHolding = player.getMainHandItem().getItem() instanceof IAmethystTool;
        boolean expired = player.level().getGameTime() - ghost.startTick() > MAX_VISIBLE_TICKS;

        if (!stillHolding || !player.isAlive() || expired) {
            end(player, true);
        }
    }

    public static void forget(ServerPlayer player) {
        ACTIVE.remove(player.getUUID());
    }

    private static boolean isEligible(ServerPlayer player, ServerLevel level, BlockPos pos, BlockState state) {
        if (player.isCreative() || player.isSpectator()) {
            return false;
        }
        if (state.isAir() || state.hasBlockEntity()) {
            return false;
        }
        if (!state.canOcclude() || !state.isCollisionShapeFullBlock(level, pos)) {
            return false;
        }

        float progressPerTick = state.getDestroyProgress(player, level, pos);
        return progressPerTick > 0.0F && progressPerTick < 1.0F;
    }
}
