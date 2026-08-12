package com.zominique.everytool.event.custom;

import com.zominique.everytool.Everytool;
import com.zominique.everytool.item.ModItems;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.dimension.end.EndDragonFight;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Everytool.MOD_ID)
public class DragonDropEventHandler {

    @SubscribeEvent
    public static void onDragonDeath(LivingDeathEvent event) {
        if (!(event.getEntity() instanceof EnderDragon dragon)) {
            return;
        }

        if (!(dragon.level() instanceof ServerLevel serverLevel)) {
            return;
        }

        EndDragonFight fight = serverLevel.getDragonFight();
        if (fight == null) {
            return;
        }

        if (!fight.hasPreviouslyKilledDragon()) {
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
