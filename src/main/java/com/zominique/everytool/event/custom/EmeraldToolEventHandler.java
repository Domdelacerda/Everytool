package com.zominique.everytool.event.custom;

import com.zominique.everytool.Everytool;
import com.zominique.everytool.item.custom.emerald.IEmeraldTool;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Everytool.MOD_ID)
public class EmeraldToolEventHandler {

    @SubscribeEvent
    public static void onBlockBreak(BlockEvent.BreakEvent event) {
        if (event.isCanceled()) {
            return;
        }

        Player player = event.getPlayer();
        ItemStack mainHand = player.getMainHandItem();
        if (!(mainHand.getItem() instanceof IEmeraldTool)) {
            return;
        }

        ItemStack offhand = player.getOffhandItem();
        if (!(offhand.getItem() instanceof BlockItem)) {
            return; // nothing placeable in the offhand — leave the space empty as normal
        }

        if (!(player.level() instanceof ServerLevel serverLevel)) {
            return;
        }

        BlockPos pos = event.getPos();

        // Deferred to after this tick's vanilla removal step finishes —
        // doing this placement directly inside BreakEvent would just get
        // overwritten when vanilla removes the original block afterward.
        serverLevel.getServer().execute(() -> attemptReplant(serverLevel, player, pos));
    }

    private static void attemptReplant(ServerLevel level, Player player, BlockPos pos) {
        if (!player.isAlive() || !level.isLoaded(pos)) {
            return;
        }

        ItemStack offhand = player.getOffhandItem();
        if (!(offhand.getItem() instanceof BlockItem blockItem)) {
            return; // offhand changed in the meantime — nothing to place
        }

        BlockHitResult hitResult = new BlockHitResult(
                Vec3.atCenterOf(pos), Direction.UP, pos, false
        );
        UseOnContext useOnContext = new UseOnContext(level, player, InteractionHand.OFF_HAND, offhand, hitResult);
        BlockPlaceContext placeContext = new BlockPlaceContext(useOnContext);

        if (!placeContext.canPlace()) {
            return; // e.g. something else already occupies the space now
        }

        // place() unconditionally shrinks the stack by 1 — restore the
        // count afterward for creative players, same as vanilla's own
        // BlockItem#useOn does internally.
        boolean creative = player.getAbilities().instabuild;
        int originalCount = offhand.getCount();

        blockItem.place(placeContext);

        if (creative) {
            offhand.setCount(originalCount);
        }
    }
}
