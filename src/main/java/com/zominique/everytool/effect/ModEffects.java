package com.zominique.everytool.effect;

import com.zominique.everytool.Everytool;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(Registries.MOB_EFFECT, Everytool.MOD_ID);

    public static final RegistryObject<MobEffect> CHARGED = MOB_EFFECTS.register("charged",
            () -> new MobEffect(MobEffectCategory.NEUTRAL, 0xFF3333) { } );

    private static final ResourceLocation CORROSION_ARMOR_MODIFIER_ID =
            ResourceLocation.fromNamespaceAndPath(Everytool.MOD_ID, "corrosion_armor");

    public static final RegistryObject<MobEffect> CORROSION = MOB_EFFECTS.register("corrosion",
            () -> new MobEffect(MobEffectCategory.HARMFUL, 0x8B7355) { }
                    .addAttributeModifier(
                            Attributes.ARMOR,
                            CORROSION_ARMOR_MODIFIER_ID,
                            -4.0,
                            AttributeModifier.Operation.ADD_VALUE
                    ));
}
