package com.zominique.everytool.fluid;

import com.zominique.everytool.Everytool;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.joml.Vector3f;

public class ModFluidTypes {
    public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create
            (ForgeRegistries.Keys.FLUID_TYPES, Everytool.MOD_ID);

    public static void register(IEventBus eventBus) {
        FLUID_TYPES.register(eventBus);
    }
}
