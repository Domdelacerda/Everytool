package com.zominique.everytool.conditions.custom;

import com.mojang.serialization.MapCodec;
import com.zominique.everytool.conditions.ModLootConditions;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.monster.warden.Warden;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditionType;

public record IsWardenCondition() implements LootItemCondition {

    public static final MapCodec<IsWardenCondition> CODEC = MapCodec.unit(IsWardenCondition::new);

    @Override
    public boolean test(LootContext lootContext) {
        Entity entity = lootContext.getParamOrNull(LootContextParams.THIS_ENTITY);
        return entity instanceof Warden;
    }

    @Override
    public LootItemConditionType getType() {
        return ModLootConditions.IS_WARDEN.get();
    }
}
