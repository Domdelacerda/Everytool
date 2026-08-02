package com.zominique.everytool.fluid;

import com.zominique.everytool.Everytool;
import com.zominique.everytool.block.ModBlocks;
import com.zominique.everytool.item.ModItems;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFluids {
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(ForgeRegistries.FLUIDS, Everytool.MOD_ID);

    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}
