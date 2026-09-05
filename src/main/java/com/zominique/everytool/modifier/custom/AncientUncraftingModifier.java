package com.zominique.everytool.modifier.custom;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.zominique.everytool.cache.UncraftingRecipeCache;
import com.zominique.everytool.modifier.ModLootModifiers;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class AncientUncraftingModifier extends LootModifier {

    public static final MapCodec<AncientUncraftingModifier> CODEC = RecordCodecBuilder.mapCodec(inst ->
            codecStart(inst).apply(inst, AncientUncraftingModifier::new));

    public AncientUncraftingModifier(LootItemCondition[] conditionsIn) {
        super(conditionsIn);
    }

    @Override
    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        BlockState state = context.getParamOrNull(LootContextParams.BLOCK_STATE);
        if (state == null || !(context.getLevel() instanceof ServerLevel serverLevel)) {
            return generatedLoot;
        }

        Item blockItem = state.getBlock().asItem();
        if (blockItem.getDefaultInstance().isEmpty()) {
            return generatedLoot; // block has no corresponding item (fire, water, etc.)
        }

        Optional<RecipeHolder<CraftingRecipe>> recipeHolder = UncraftingRecipeCache.getUncraftRecipe(
                serverLevel.getRecipeManager(), serverLevel.registryAccess(), blockItem);

        if (recipeHolder.isEmpty()) {
            return generatedLoot; // no qualifying single-output recipe — drop normally
        }

        return buildUncraftedDrops(recipeHolder.get().value());
    }

    private static ObjectArrayList<ItemStack> buildUncraftedDrops(CraftingRecipe recipe) {
        Map<Item, Integer> counts = new LinkedHashMap<>();

        for (Ingredient ingredient : recipe.getIngredients()) {
            if (ingredient.isEmpty()) {
                continue; // shaped recipes have empty slots (e.g. furnace's center)
            }

            ItemStack[] matchingItems = ingredient.getItems();
            if (matchingItems.length == 0) {
                continue;
            }
            Item representative = matchingItems[0].getItem();
            counts.merge(representative, 1, Integer::sum);
        }

        ObjectArrayList<ItemStack> drops = new ObjectArrayList<>();
        for (Map.Entry<Item, Integer> entry : counts.entrySet()) {
            drops.add(new ItemStack(entry.getKey(), entry.getValue()));
        }
        return drops;
    }

    @Override
    public MapCodec<? extends IGlobalLootModifier> codec() {
        return ModLootModifiers.ANCIENT_UNCRAFTING.get();
    }
}
