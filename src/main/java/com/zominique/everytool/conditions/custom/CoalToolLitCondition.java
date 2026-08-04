package com.zominique.everytool.conditions.custom;

import com.mojang.serialization.MapCodec;
import com.zominique.everytool.conditions.ModLootConditions;
import com.zominique.everytool.item.custom.ICoalTool;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditionType;

public record CoalToolLitCondition() implements LootItemCondition {

    public static final MapCodec<CoalToolLitCondition> CODEC = MapCodec.unit(CoalToolLitCondition::new);

    @Override
    public boolean test(LootContext lootContext) {
        ItemStack tool = lootContext.getParamOrNull(LootContextParams.TOOL);
        if (tool == null || !(tool.getItem() instanceof ICoalTool coalTool)) {
            return false;
        }
        return coalTool.isLit(tool);
    }

    @Override
    public LootItemConditionType getType() {
        return ModLootConditions.COAL_TOOL_LIT.get();
    }
}