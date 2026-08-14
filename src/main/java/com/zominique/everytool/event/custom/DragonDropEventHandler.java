package com.zominique.everytool.event.custom;

import com.zominique.everytool.Everytool;
import com.zominique.everytool.item.ModItems;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.dimension.end.EndDragonFight;
import net.minecraftforge.event.entity.EntityLeaveLevelEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Collections;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Mod.EventBusSubscriber(modid = Everytool.MOD_ID)
public class DragonDropEventHandler {

    private static final Set<UUID> REFIGHT_DRAGONS = Collections.newSetFromMap(new ConcurrentHashMap<>());

    @SubscribeEvent
    public static void onDragonDeath(LivingDeathEvent event) {
        if (!(event.getEntity() instanceof EnderDragon dragon)) {
            return;
        }

        if (!(dragon.level() instanceof ServerLevel serverLevel)) {
            return;
        }

        EndDragonFight fight = serverLevel.getDragonFight();
        if (fight != null && fight.hasPreviouslyKilledDragon()) {
            REFIGHT_DRAGONS.add(dragon.getUUID());
        }
    }

    @SubscribeEvent
    public static void onDragonRemoved(EntityLeaveLevelEvent event) {
        if (!(event.getEntity() instanceof EnderDragon dragon)) {
            return;
        }

        if (dragon.getRemovalReason() != Entity.RemovalReason.KILLED) {
            return; // dimension change (e.g. outer-end gateway), not an actual death
        }

        if (!REFIGHT_DRAGONS.remove(dragon.getUUID())) {
            return; // wasn't flagged as a re-fight death at LivingDeathEvent time
        }

        if (!(event.getLevel() instanceof ServerLevel serverLevel)) {
            return;
        }

        ItemStack template = new ItemStack(ModItems.CHORUS_UPGRADE_TEMPLATE.get());
        ItemEntity itemEntity = new ItemEntity(
                serverLevel, dragon.getX(), dragon.getY(), dragon.getZ(), template
        );
        itemEntity.setDefaultPickUpDelay();
        serverLevel.addFreshEntity(itemEntity);
    }
}
