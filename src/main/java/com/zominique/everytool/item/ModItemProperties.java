package com.zominique.everytool.item;

import com.zominique.everytool.Everytool;
import com.zominique.everytool.item.custom.ICoalTool;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = Everytool.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModItemProperties {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            registerLitProperty(ModItems.COAL_PICKAXE.get());
            registerLitProperty(ModItems.COAL_SWORD.get());
            registerLitProperty(ModItems.COAL_AXE.get());
            registerLitProperty(ModItems.COAL_SHOVEL.get());
            registerLitProperty(ModItems.COAL_HOE.get());
        });
    }

    private static void registerLitProperty(Item item) {
        ItemProperties.register(
                item,
                ResourceLocation.fromNamespaceAndPath(Everytool.MOD_ID, "lit"),
                (stack, level, entity, seed) ->
                        item instanceof ICoalTool coalTool && coalTool.isLit(stack) ? 1.0F : 0.0F
        );
    }
}