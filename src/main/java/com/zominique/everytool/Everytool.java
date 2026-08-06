package com.zominique.everytool;

import com.zominique.everytool.block.ModBlocks;
import com.zominique.everytool.component.ModDataComponentTypes;
import com.zominique.everytool.conditions.ModLootConditions;
import com.zominique.everytool.fluid.ModFluidTypes;
import com.zominique.everytool.fluid.ModFluids;
import com.zominique.everytool.item.ModItems;
import com.zominique.everytool.modifier.ModLootModifiers;
import com.zominique.everytool.particle.ModParticles;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Everytool.MOD_ID)
public class Everytool
{
    public static final String MOD_ID = "everytool";

    public Everytool()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModParticles.register(modEventBus);
        ModFluids.register(modEventBus);
        ModFluidTypes.register(modEventBus);
        ModDataComponentTypes.register(modEventBus);
        ModLootConditions.register(modEventBus);
        ModLootModifiers.register(modEventBus);

        modEventBus.addListener(this::addCreative);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if(event.getTabKey() == CreativeModeTabs.COMBAT) {
            event.accept(ModItems.COAL_SWORD);
            event.accept(ModItems.FLINT_SWORD);
            event.accept(ModItems.REDSTONE_SWORD);
            event.accept(ModItems.LAPIS_SWORD);
            event.accept(ModItems.EMERALD_SWORD);
            event.accept(ModItems.AMETHYST_SWORD);
            event.accept(ModItems.QUARTZ_SWORD);
            event.accept(ModItems.PRISMARINE_SWORD);
            event.accept(ModItems.ANCIENT_SWORD);
            event.accept(ModItems.ECHO_SWORD);
            event.accept(ModItems.CHORUS_SWORD);

            event.accept(ModItems.COAL_AXE);
            event.accept(ModItems.FLINT_AXE);
            event.accept(ModItems.REDSTONE_AXE);
            event.accept(ModItems.LAPIS_AXE);
            event.accept(ModItems.EMERALD_AXE);
            event.accept(ModItems.AMETHYST_AXE);
            event.accept(ModItems.QUARTZ_AXE);
            event.accept(ModItems.PRISMARINE_AXE);
            event.accept(ModItems.ANCIENT_AXE);
            event.accept(ModItems.ECHO_AXE);
            event.accept(ModItems.CHORUS_AXE);
        }

        if(event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(ModItems.COAL_SHOVEL);
            event.accept(ModItems.COAL_PICKAXE);
            event.accept(ModItems.COAL_AXE);
            event.accept(ModItems.COAL_HOE);

            event.accept(ModItems.FLINT_SHOVEL);
            event.accept(ModItems.FLINT_PICKAXE);
            event.accept(ModItems.FLINT_AXE);
            event.accept(ModItems.FLINT_HOE);

            event.accept(ModItems.REDSTONE_SHOVEL);
            event.accept(ModItems.REDSTONE_PICKAXE);
            event.accept(ModItems.REDSTONE_AXE);
            event.accept(ModItems.REDSTONE_HOE);

            event.accept(ModItems.LAPIS_SHOVEL);
            event.accept(ModItems.LAPIS_PICKAXE);
            event.accept(ModItems.LAPIS_AXE);
            event.accept(ModItems.LAPIS_HOE);

            event.accept(ModItems.EMERALD_SHOVEL);
            event.accept(ModItems.EMERALD_PICKAXE);
            event.accept(ModItems.EMERALD_AXE);
            event.accept(ModItems.EMERALD_HOE);

            event.accept(ModItems.AMETHYST_SHOVEL);
            event.accept(ModItems.AMETHYST_PICKAXE);
            event.accept(ModItems.AMETHYST_AXE);
            event.accept(ModItems.AMETHYST_HOE);

            event.accept(ModItems.QUARTZ_SHOVEL);
            event.accept(ModItems.QUARTZ_PICKAXE);
            event.accept(ModItems.QUARTZ_AXE);
            event.accept(ModItems.QUARTZ_HOE);

            event.accept(ModItems.PRISMARINE_SHOVEL);
            event.accept(ModItems.PRISMARINE_PICKAXE);
            event.accept(ModItems.PRISMARINE_AXE);
            event.accept(ModItems.PRISMARINE_HOE);

            event.accept(ModItems.ANCIENT_SHOVEL);
            event.accept(ModItems.ANCIENT_PICKAXE);
            event.accept(ModItems.ANCIENT_AXE);
            event.accept(ModItems.ANCIENT_HOE);

            event.accept(ModItems.ECHO_SHOVEL);
            event.accept(ModItems.ECHO_PICKAXE);
            event.accept(ModItems.ECHO_AXE);
            event.accept(ModItems.ECHO_HOE);

            event.accept(ModItems.CHORUS_SHOVEL);
            event.accept(ModItems.CHORUS_PICKAXE);
            event.accept(ModItems.CHORUS_AXE);
            event.accept(ModItems.CHORUS_HOE);
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void registerParticleProvider(RegisterParticleProvidersEvent event) {
        }
    }
}
