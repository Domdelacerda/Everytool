package com.zominique.everytool.effect;

import com.zominique.everytool.Everytool;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.RedStoneWireBlock;
import net.minecraft.world.level.block.RedstoneTorchBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Everytool.MOD_ID)
public class ChargedEffectHandler {

    private static final int MAX_CHARGE_TICKS = 1200; // 1 minute

    @SubscribeEvent
    public static void onLivingTick(LivingEvent.LivingTickEvent event) {
        LivingEntity entity = event.getEntity();

        if (entity.level().isClientSide()) {
            return; // effect state is server-authoritative
        }

        if (!isTouchingPoweredRedstone(entity)) {
            return; // let vanilla's own per-tick decay handle the count-down
        }

        MobEffectInstance current = entity.getEffect(ModEffects.CHARGED.getHolder().get());
        int currentDuration = current != null ? current.getDuration() : 0;
        int amplifier = current != null ? current.getAmplifier() : 0;

        if (currentDuration >= MAX_CHARGE_TICKS) {
            return; // already capped, nothing to do
        }

        int newDuration = Math.min(currentDuration + 2, MAX_CHARGE_TICKS);
        entity.addEffect(
                new MobEffectInstance(ModEffects.CHARGED.getHolder().get(), newDuration, amplifier, false, true, true),
                null
        );
    }

    private static boolean isTouchingPoweredRedstone(LivingEntity entity) {
        Level level = entity.level();
        AABB box = entity.getBoundingBox();

        int minX = Mth.floor(box.minX);
        int minY = Mth.floor(box.minY);
        int minZ = Mth.floor(box.minZ);
        int maxX = Mth.floor(box.maxX);
        int maxY = Mth.floor(box.maxY);
        int maxZ = Mth.floor(box.maxZ);

        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
        for (int x = minX; x <= maxX; x++) {
            for (int y = minY; y <= maxY; y++) {
                for (int z = minZ; z <= maxZ; z++) {
                    pos.set(x, y, z);
                    if (!level.isLoaded(pos)) {
                        continue;
                    }
                    if (isPoweredRedstoneComponent(level.getBlockState(pos))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean isPoweredRedstoneComponent(BlockState state) {
        if (state.getBlock() instanceof RedStoneWireBlock) {
            return state.getValue(RedStoneWireBlock.POWER) > 0;
        }

        if (state.is(Blocks.REDSTONE_BLOCK)) {
            return true;
        }

        if (state.getBlock() instanceof RedstoneTorchBlock && state.hasProperty(BlockStateProperties.LIT)) {
            return state.getValue(BlockStateProperties.LIT);
        }

        if (state.hasProperty(BlockStateProperties.POWERED)) {
            return state.getValue(BlockStateProperties.POWERED);
        }

        return false;
    }
}
