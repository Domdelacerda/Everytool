package com.zominique.everytool.conditions.custom;

import com.mojang.serialization.MapCodec;
import com.zominique.everytool.conditions.ModLootConditions;
import com.zominique.everytool.item.custom.ancient.IAncientTool;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditionType;

public record AncientToolScrapCondition() implements LootItemCondition {

    public static final MapCodec<AncientToolScrapCondition> CODEC = MapCodec.unit(AncientToolScrapCondition::new);

    @Override
    public boolean test(LootContext lootContext) {
        ItemStack tool = lootContext.getParamOrNull(LootContextParams.TOOL);
        return tool != null && tool.getItem() instanceof IAncientTool;
    }

    @Override
    public LootItemConditionType getType() {
        return ModLootConditions.ANCIENT_TOOL.get();
    }
}