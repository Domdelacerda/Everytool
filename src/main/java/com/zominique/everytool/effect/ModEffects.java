package com.zominique.everytool.effect;

import com.zominique.everytool.Everytool;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(Registries.MOB_EFFECT, Everytool.MOD_ID);

    public static final RegistryObject<MobEffect> CHARGED = MOB_EFFECTS.register("charged",
            () -> new MobEffect(MobEffectCategory.NEUTRAL, 0xFF3333) { } );
}
