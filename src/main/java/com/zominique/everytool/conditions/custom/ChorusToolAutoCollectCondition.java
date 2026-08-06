package com.zominique.everytool.conditions.custom;

import com.mojang.serialization.MapCodec;
import com.zominique.everytool.conditions.ModLootConditions;
import com.zominique.everytool.item.custom.chorus.IChorusTool;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditionType;

public record ChorusToolAutoCollectCondition() implements LootItemCondition {

    public static final MapCodec<ChorusToolAutoCollectCondition> CODEC
            = MapCodec.unit(ChorusToolAutoCollectCondition::new);

    @Override
    public boolean test(LootContext lootContext) {
        ItemStack tool = lootContext.getParamOrNull(LootContextParams.TOOL);
        if (tool != null && tool.getItem() instanceof IChorusTool) {
            return true;
        }

        Entity killer = lootContext.getParamOrNull(LootContextParams.ATTACKING_ENTITY);
        if (killer instanceof LivingEntity livingKiller) {
            return livingKiller.getMainHandItem().getItem() instanceof IChorusTool;
        }

        return false;
    }

    @Override
    public LootItemConditionType getType() {
        return ModLootConditions.CHORUS_TOOL_AUTO_COLLECT.get();
    }
}
