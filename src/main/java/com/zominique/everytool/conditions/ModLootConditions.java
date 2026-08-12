package com.zominique.everytool.conditions;

import com.zominique.everytool.Everytool;
import com.zominique.everytool.conditions.custom.ChorusToolAutoCollectCondition;
import com.zominique.everytool.conditions.custom.CoalToolLitCondition;
import com.zominique.everytool.conditions.custom.IsWardenCondition;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditionType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModLootConditions {

    public static final DeferredRegister<LootItemConditionType> LOOT_CONDITIONS =
            DeferredRegister.create(Registries.LOOT_CONDITION_TYPE, Everytool.MOD_ID);

    public static final RegistryObject<LootItemConditionType> COAL_TOOL_LIT =
            LOOT_CONDITIONS.register("coal_tool_lit",
                    () -> new LootItemConditionType(CoalToolLitCondition.CODEC));
    public static final RegistryObject<LootItemConditionType> CHORUS_TOOL_AUTO_COLLECT =
            LOOT_CONDITIONS.register("chorus_tool_auto_collect",
                    () -> new LootItemConditionType(ChorusToolAutoCollectCondition.CODEC));
    public static final RegistryObject<LootItemConditionType> IS_WARDEN =
            LOOT_CONDITIONS.register("is_warden",
                    () -> new LootItemConditionType(IsWardenCondition.CODEC));

    public static void register(IEventBus eventBus) {
        LOOT_CONDITIONS.register(eventBus);
    }
}
