package com.zominique.everytool.modifier.custom;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.zominique.everytool.modifier.ModLootModifiers;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;
import java.util.ArrayList;
import java.util.List;

public class ChorusAutoCollectModifier extends LootModifier {

    public static final MapCodec<ChorusAutoCollectModifier> CODEC = RecordCodecBuilder.mapCodec(inst ->
            codecStart(inst).apply(inst, ChorusAutoCollectModifier::new));

    public ChorusAutoCollectModifier(LootItemCondition[] conditionsIn) {
        super(conditionsIn);
    }

    @Override
    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        Player collector = resolveCollector(context);
        if (collector == null || !(context.getLevel() instanceof ServerLevel serverLevel)) {
            return generatedLoot;
        }

        List<ItemStack> leftover = new ArrayList<>();
        boolean pickedUpAnything = false;

        for (ItemStack drop : generatedLoot) {
            ItemStack toInsert = drop.copy();
            collector.getInventory().add(toInsert);

            if (!toInsert.isEmpty()) {
                leftover.add(toInsert); // no room — drop it normally instead
            } else {
                pickedUpAnything = true;
            }
        }

        if (pickedUpAnything) {
            serverLevel.playSound(null, collector.blockPosition(), SoundEvents.ITEM_PICKUP,
                    SoundSource.PLAYERS, 0.2F, 1.4F + serverLevel.getRandom().nextFloat() * 0.5F);
        }

        return new ObjectArrayList<>(leftover);
    }

    private static Player resolveCollector(LootContext context) {
        Entity thisEntity = context.getParamOrNull(LootContextParams.THIS_ENTITY);
        if (thisEntity instanceof Player player) {
            return player;
        }

        Entity killer = context.getParamOrNull(LootContextParams.ATTACKING_ENTITY);
        if (killer instanceof Player player) {
            return player;
        }

        return null;
    }

    @Override
    public MapCodec<? extends IGlobalLootModifier> codec() {
        return ModLootModifiers.CHORUS_AUTO_COLLECT.get();
    }
}