package com.zominique.everytool.block.custom;

import com.zominique.everytool.client.AmethystGlassTracker;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.TransparentBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class AmethystGlassBlock extends TransparentBlock {
    public AmethystGlassBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    public float getDestroyProgress(BlockState state, Player player, BlockGetter level, BlockPos pos) {
        BlockState real = AmethystGlassTracker.getClientRealState(pos);

        if (real != null && !real.is(this)) {
            return real.getDestroyProgress(player, level, pos);
        }
        return super.getDestroyProgress(state, player, level, pos);
    }
}
