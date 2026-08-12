package com.zominique.everytool.modifier;

import com.mojang.serialization.MapCodec;
import com.zominique.everytool.Everytool;
import com.zominique.everytool.modifier.custom.ChorusAutoCollectModifier;
import com.zominique.everytool.modifier.custom.CoalSmeltingModifier;
import com.zominique.everytool.modifier.custom.WardenEchoTemplateDropModifier;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModLootModifiers {

    public static final DeferredRegister<MapCodec<? extends IGlobalLootModifier>> LOOT_MODIFIER_SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, Everytool.MOD_ID);

    public static final RegistryObject<MapCodec<CoalSmeltingModifier>> COAL_SMELTING =
            LOOT_MODIFIER_SERIALIZERS.register("coal_smelting", () -> CoalSmeltingModifier.CODEC);
    public static final RegistryObject<MapCodec<ChorusAutoCollectModifier>> CHORUS_AUTO_COLLECT =
            LOOT_MODIFIER_SERIALIZERS.register("chorus_auto_collect", () -> ChorusAutoCollectModifier.CODEC);
    public static final RegistryObject<MapCodec<WardenEchoTemplateDropModifier>> WARDEN_ECHO_TEMPLATE_DROP =
            LOOT_MODIFIER_SERIALIZERS.register("warden_echo_template_drop", () -> WardenEchoTemplateDropModifier.CODEC);

    public static void register(IEventBus eventBus) {
        LOOT_MODIFIER_SERIALIZERS.register(eventBus);
    }
}