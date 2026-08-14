package com.zominique.everytool.item;

import com.zominique.everytool.Everytool;
import com.zominique.everytool.item.custom.coal.ICoalTool;
import com.zominique.everytool.item.custom.echo.IEchoTool;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraftforge.api.distmarker.Dist;
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

            registerResonatingProperty(ModItems.ECHO_PICKAXE.get());
            registerResonatingProperty(ModItems.ECHO_SWORD.get());
            registerResonatingProperty(ModItems.ECHO_AXE.get());
            registerResonatingProperty(ModItems.ECHO_SHOVEL.get());
            registerResonatingProperty(ModItems.ECHO_HOE.get());

            registerSubmergedProperty(ModItems.PRISMARINE_PICKAXE.get());
            registerSubmergedProperty(ModItems.PRISMARINE_SWORD.get());
            registerSubmergedProperty(ModItems.PRISMARINE_AXE.get());
            registerSubmergedProperty(ModItems.PRISMARINE_SHOVEL.get());
            registerSubmergedProperty(ModItems.PRISMARINE_HOE.get());
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

    private static void registerResonatingProperty(Item item) {
        ItemProperties.register(
                item,
                ResourceLocation.fromNamespaceAndPath(Everytool.MOD_ID, "resonating"),
                (stack, level, entity, seed) -> {
                    if (!(item instanceof IEchoTool echoTool) || level == null) {
                        return 0.0F;
                    }
                    return echoTool.isResonating(stack, level.getGameTime()) ? 1.0F : 0.0F;
                }
        );
    }

    private static void registerSubmergedProperty(Item item) {
        ItemProperties.register(
                item,
                ResourceLocation.fromNamespaceAndPath(Everytool.MOD_ID, "submerged"),
                (stack, level, entity, seed) -> entity != null && entity.isInWater() ? 1.0F : 0.0F
        );
    }
}