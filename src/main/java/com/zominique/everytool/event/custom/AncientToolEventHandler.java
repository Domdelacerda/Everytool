package com.zominique.everytool.event.custom;

import com.zominique.everytool.Everytool;
import com.zominique.everytool.effect.ModEffects;
import com.zominique.everytool.item.custom.ancient.IAncientTool;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Everytool.MOD_ID)
public class AncientToolEventHandler {

    private static final int CORROSION_DURATION_TICKS = 200; // 10 seconds — tune to taste
    private static final int CORROSION_AMPLIFIER = 0;

    @SubscribeEvent
    public static void onAttackEntity(AttackEntityEvent event) {
        Player player = event.getEntity();
        ItemStack mainHand = player.getMainHandItem();

        if (!(mainHand.getItem() instanceof IAncientTool)) {
            return;
        }

        Entity targetEntity = event.getTarget();
        if (targetEntity instanceof LivingEntity target) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {

            } finally {
                target.addEffect(new MobEffectInstance(
                        ModEffects.CORROSION.getHolder().get(), CORROSION_DURATION_TICKS, CORROSION_AMPLIFIER
                ));
            }
        }
    }

    @SubscribeEvent
    public static void onBreak(BlockEvent.BreakEvent event) {
        if (event.isCanceled()) {
            return;
        }

        Player player = event.getPlayer();
        ItemStack tool = player.getMainHandItem();
        if (!(tool.getItem() instanceof IAncientTool)) {
            return;
        }

        BlockState state = event.getState();
        if (!(state.getBlock() instanceof BedBlock)) {
            return;
        }

        if (!(event.getLevel() instanceof ServerLevel serverLevel)) {
            return;
        }

        BlockPos primaryPos = event.getPos();
        Direction otherHalfDirection = BedBlock.getConnectedDirection(state);
        BlockPos otherHalfPos = primaryPos.relative(otherHalfDirection);

        serverLevel.getServer().execute(() -> {
            BlockState otherHalfState = serverLevel.getBlockState(otherHalfPos);
            if (otherHalfState.getBlock() instanceof BedBlock) {
                serverLevel.removeBlock(otherHalfPos, false);
            }
        });
    }
}
