package com.zominique.everytool.event;

import com.zominique.everytool.Everytool;
import com.zominique.everytool.item.custom.ICoalTool;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.item.crafting.SmeltingRecipe;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.*;

@Mod.EventBusSubscriber(modid = Everytool.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModEvents {
    @SubscribeEvent
    public static void onCoalToolUsage(BlockEvent.BreakEvent event) {
        Player player = event.getPlayer();
        ItemStack mainHandItem = player.getMainHandItem();

        if (!(mainHandItem.getItem() instanceof ICoalTool coalTool)
                //|| !coalTool.isLit(mainHandItem)
                || !(player instanceof ServerPlayer serverPlayer)) {
            return;
        }

        ServerLevel serverLevel = serverPlayer.serverLevel();
        LootParams.Builder params = new LootParams.Builder(serverLevel)
                .withParameter(LootContextParams.ORIGIN, Vec3.atCenterOf(event.getPos()))
                .withParameter(LootContextParams.TOOL, mainHandItem)
                .withOptionalParameter(LootContextParams.BLOCK_ENTITY, serverLevel.getBlockEntity(event.getPos()));
        List<ItemStack> smeltedDrops = new ArrayList<>();
        for (ItemStack drop : event.getState().getDrops(params)) {
            Optional<RecipeHolder<SmeltingRecipe>> recipe = serverLevel.getRecipeManager()
                    .getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput(drop), serverLevel);

            if (recipe.isPresent()) {
                ItemStack result = recipe.get().value().getResultItem(serverLevel.registryAccess()).copy();
                result.setCount(result.getCount() * drop.getCount());
                smeltedDrops.add(result);
            } else {
                smeltedDrops.add(drop);
            }
        }

        event.getState().getDrops(params).clear();
        event.getState().getDrops(params).addAll(smeltedDrops);
    }
}
