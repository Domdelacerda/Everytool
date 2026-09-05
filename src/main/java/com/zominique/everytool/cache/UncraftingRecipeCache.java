package com.zominique.everytool.cache;

import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingRecipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeType;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UncraftingRecipeCache {

    private static RecipeManager cachedManager;
    private static Map<Item, RecipeHolder<CraftingRecipe>> cache = new HashMap<>();

    public static Optional<RecipeHolder<CraftingRecipe>> getUncraftRecipe(
            RecipeManager manager, HolderLookup.Provider registries, Item resultItem) {
        if (manager != cachedManager) {
            rebuild(manager, registries);
        }
        return Optional.ofNullable(cache.get(resultItem));
    }

    private static void rebuild(RecipeManager manager, HolderLookup.Provider registries) {
        cachedManager = manager;
        Map<Item, RecipeHolder<CraftingRecipe>> built = new HashMap<>();

        for (RecipeHolder<CraftingRecipe> holder : manager.getAllRecipesFor(RecipeType.CRAFTING)) {
            ItemStack result = holder.value().getResultItem(registries);

            if (result.getCount() == 1 && !built.containsKey(result.getItem())) {
                built.put(result.getItem(), holder);
            }
        }

        cache = built;
    }
}
