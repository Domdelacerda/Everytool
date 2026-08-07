package com.zominique.everytool.event.custom;

import com.zominique.everytool.Everytool;
import com.zominique.everytool.item.custom.lapis.ILapisTool;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingExperienceDropEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Everytool.MOD_ID)
public class LapisToolEventHandler {

    private static final int XP_MULTIPLIER = 2;

    @SubscribeEvent
    public static void onBlockBreak(BlockEvent.BreakEvent event) {
        Player player = event.getPlayer();
        ItemStack stack = player.getMainHandItem();

        if (stack.getItem() instanceof ILapisTool) {
            event.setExpToDrop(event.getExpToDrop() * XP_MULTIPLIER);
        }
    }

    @SubscribeEvent
    public static void onExperienceDrop(LivingExperienceDropEvent event) {
        Player attacker = event.getAttackingPlayer();
        if (attacker == null) {
            return;
        }

        ItemStack stack = attacker.getMainHandItem();
        if (stack.getItem() instanceof ILapisTool) {
            event.setDroppedExperience(event.getDroppedExperience() * XP_MULTIPLIER);
        }
    }
}
