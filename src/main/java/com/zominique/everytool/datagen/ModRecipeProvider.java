package com.zominique.everytool.datagen;

import com.zominique.everytool.Everytool;
import com.zominique.everytool.block.ModBlocks;
import com.zominique.everytool.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.Dictionary;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        buildSwordItem(pRecipeOutput, Items.COAL, ModItems.COAL_SWORD.get(), "has_coal");
        buildSwordItem(pRecipeOutput, Items.FLINT, ModItems.FLINT_SWORD.get(), "has_flint");
        buildSwordItem(pRecipeOutput, Items.REDSTONE, ModItems.REDSTONE_SWORD.get(), "has_redstone");
        buildSwordItem(pRecipeOutput, Items.LAPIS_LAZULI, ModItems.LAPIS_SWORD.get(), "has_lapis_lazuli");
        buildSwordItem(pRecipeOutput, Items.EMERALD, ModItems.EMERALD_SWORD.get(), "has_emerald");
        buildSwordItem(pRecipeOutput, Items.AMETHYST_SHARD, ModItems.AMETHYST_SWORD.get(), "has_amethyst");
        buildSwordItem(pRecipeOutput, Items.QUARTZ, ModItems.QUARTZ_SWORD.get(), "has_quartz");
        buildSwordItem(pRecipeOutput, Items.PRISMARINE_CRYSTALS, ModItems.PRISMARINE_SWORD.get(), "has_prismarine_crystals");
        buildSwordItem(pRecipeOutput, Items.NETHERITE_SCRAP, ModItems.ANCIENT_SWORD.get(), "has_netherite_scrap");
        buildSwordItem(pRecipeOutput, Items.ECHO_SHARD, ModItems.ECHO_SWORD.get(), "has_echo_shard");
        buildSwordItem(pRecipeOutput, Items.POPPED_CHORUS_FRUIT, ModItems.CHORUS_SWORD.get(), "has_popped_chorus_fruit");

        buildPickaxeItem(pRecipeOutput, Items.COAL, ModItems.COAL_PICKAXE.get(), "has_coal");
        buildPickaxeItem(pRecipeOutput, Items.FLINT, ModItems.FLINT_PICKAXE.get(), "has_flint");
        buildPickaxeItem(pRecipeOutput, Items.REDSTONE, ModItems.REDSTONE_PICKAXE.get(), "has_redstone");
        buildPickaxeItem(pRecipeOutput, Items.LAPIS_LAZULI, ModItems.LAPIS_PICKAXE.get(), "has_lapis_lazuli");
        buildPickaxeItem(pRecipeOutput, Items.EMERALD, ModItems.EMERALD_PICKAXE.get(), "has_emerald");
        buildPickaxeItem(pRecipeOutput, Items.AMETHYST_SHARD, ModItems.AMETHYST_PICKAXE.get(), "has_amethyst");
        buildPickaxeItem(pRecipeOutput, Items.QUARTZ, ModItems.QUARTZ_PICKAXE.get(), "has_quartz");
        buildPickaxeItem(pRecipeOutput, Items.PRISMARINE_CRYSTALS, ModItems.PRISMARINE_PICKAXE.get(), "has_prismarine_crystals");
        buildPickaxeItem(pRecipeOutput, Items.NETHERITE_SCRAP, ModItems.ANCIENT_PICKAXE.get(), "has_netherite_scrap");
        buildPickaxeItem(pRecipeOutput, Items.ECHO_SHARD, ModItems.ECHO_PICKAXE.get(), "has_echo_shard");
        buildPickaxeItem(pRecipeOutput, Items.POPPED_CHORUS_FRUIT, ModItems.CHORUS_PICKAXE.get(), "has_popped_chorus_fruit");

        buildAxeItem(pRecipeOutput, Items.COAL, ModItems.COAL_AXE.get(), "has_coal");
        buildAxeItem(pRecipeOutput, Items.FLINT, ModItems.FLINT_AXE.get(), "has_flint");
        buildAxeItem(pRecipeOutput, Items.REDSTONE, ModItems.REDSTONE_AXE.get(), "has_redstone");
        buildAxeItem(pRecipeOutput, Items.LAPIS_LAZULI, ModItems.LAPIS_AXE.get(), "has_lapis_lazuli");
        buildAxeItem(pRecipeOutput, Items.EMERALD, ModItems.EMERALD_AXE.get(), "has_emerald");
        buildAxeItem(pRecipeOutput, Items.AMETHYST_SHARD, ModItems.AMETHYST_AXE.get(), "has_amethyst");
        buildAxeItem(pRecipeOutput, Items.QUARTZ, ModItems.QUARTZ_AXE.get(), "has_quartz");
        buildAxeItem(pRecipeOutput, Items.PRISMARINE_CRYSTALS, ModItems.PRISMARINE_AXE.get(), "has_prismarine_crystals");
        buildAxeItem(pRecipeOutput, Items.NETHERITE_SCRAP, ModItems.ANCIENT_AXE.get(), "has_netherite_scrap");
        buildAxeItem(pRecipeOutput, Items.ECHO_SHARD, ModItems.ECHO_AXE.get(), "has_echo_shard");
        buildAxeItem(pRecipeOutput, Items.POPPED_CHORUS_FRUIT, ModItems.CHORUS_AXE.get(), "has_popped_chorus_fruit");

        buildShovelItem(pRecipeOutput, Items.COAL, ModItems.COAL_SHOVEL.get(), "has_coal");
        buildShovelItem(pRecipeOutput, Items.FLINT, ModItems.FLINT_SHOVEL.get(), "has_flint");
        buildShovelItem(pRecipeOutput, Items.REDSTONE, ModItems.REDSTONE_SHOVEL.get(), "has_redstone");
        buildShovelItem(pRecipeOutput, Items.LAPIS_LAZULI, ModItems.LAPIS_SHOVEL.get(), "has_lapis_lazuli");
        buildShovelItem(pRecipeOutput, Items.EMERALD, ModItems.EMERALD_SHOVEL.get(), "has_emerald");
        buildShovelItem(pRecipeOutput, Items.AMETHYST_SHARD, ModItems.AMETHYST_SHOVEL.get(), "has_amethyst");
        buildShovelItem(pRecipeOutput, Items.QUARTZ, ModItems.QUARTZ_SHOVEL.get(), "has_quartz");
        buildShovelItem(pRecipeOutput, Items.PRISMARINE_CRYSTALS, ModItems.PRISMARINE_SHOVEL.get(), "has_prismarine_crystals");
        buildShovelItem(pRecipeOutput, Items.NETHERITE_SCRAP, ModItems.ANCIENT_SHOVEL.get(), "has_netherite_scrap");
        buildShovelItem(pRecipeOutput, Items.ECHO_SHARD, ModItems.ECHO_SHOVEL.get(), "has_echo_shard");
        buildShovelItem(pRecipeOutput, Items.POPPED_CHORUS_FRUIT, ModItems.CHORUS_SHOVEL.get(), "has_popped_chorus_fruit");

        buildHoeItem(pRecipeOutput, Items.COAL, ModItems.COAL_HOE.get(), "has_coal");
        buildHoeItem(pRecipeOutput, Items.FLINT, ModItems.FLINT_HOE.get(), "has_flint");
        buildHoeItem(pRecipeOutput, Items.REDSTONE, ModItems.REDSTONE_HOE.get(), "has_redstone");
        buildHoeItem(pRecipeOutput, Items.LAPIS_LAZULI, ModItems.LAPIS_HOE.get(), "has_lapis_lazuli");
        buildHoeItem(pRecipeOutput, Items.EMERALD, ModItems.EMERALD_HOE.get(), "has_emerald");
        buildHoeItem(pRecipeOutput, Items.AMETHYST_SHARD, ModItems.AMETHYST_HOE.get(), "has_amethyst");
        buildHoeItem(pRecipeOutput, Items.QUARTZ, ModItems.QUARTZ_HOE.get(), "has_quartz");
        buildHoeItem(pRecipeOutput, Items.PRISMARINE_CRYSTALS, ModItems.PRISMARINE_HOE.get(), "has_prismarine_crystals");
        buildHoeItem(pRecipeOutput, Items.NETHERITE_SCRAP, ModItems.ANCIENT_HOE.get(), "has_netherite_scrap");
        buildHoeItem(pRecipeOutput, Items.ECHO_SHARD, ModItems.ECHO_HOE.get(), "has_echo_shard");
        buildHoeItem(pRecipeOutput, Items.POPPED_CHORUS_FRUIT, ModItems.CHORUS_HOE.get(), "has_popped_chorus_fruit");
    }

    private void buildSwordItem(RecipeOutput pRecipeOutput, Item item, Item sword, String unlockedBy) {
        ResourceLocation id = BuiltInRegistries.ITEM.getKey(sword);
        String baseName = id.getPath();
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, sword)
                .pattern(" A ")
                .pattern(" A ")
                .pattern(" B ")
                .define('A', item)
                .define('B', Items.STICK)
                .unlockedBy(unlockedBy, has(item))
                .save(pRecipeOutput, ResourceLocation.fromNamespaceAndPath
                        (id.getNamespace(), baseName));
    }

    private void buildPickaxeItem(RecipeOutput pRecipeOutput, Item item, Item pickaxe, String unlockedBy) {
        ResourceLocation id = BuiltInRegistries.ITEM.getKey(pickaxe);
        String baseName = id.getPath();
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, pickaxe)
                .pattern("AAA")
                .pattern(" B ")
                .pattern(" B ")
                .define('A', item)
                .define('B', Items.STICK)
                .unlockedBy(unlockedBy, has(item))
                .save(pRecipeOutput, ResourceLocation.fromNamespaceAndPath
                        (id.getNamespace(), baseName));
    }

    private void buildAxeItem(RecipeOutput pRecipeOutput, Item item, Item axe, String unlockedBy) {
        ResourceLocation id = BuiltInRegistries.ITEM.getKey(axe);
        String baseName = id.getPath();
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, axe)
                .pattern(" AA")
                .pattern(" BA")
                .pattern(" B ")
                .define('A', item)
                .define('B', Items.STICK)
                .unlockedBy(unlockedBy, has(item))
                .save(pRecipeOutput, ResourceLocation.fromNamespaceAndPath
                        (id.getNamespace(), baseName));
    }

    private void buildShovelItem(RecipeOutput pRecipeOutput, Item item, Item shovel, String unlockedBy) {
        ResourceLocation id = BuiltInRegistries.ITEM.getKey(shovel);
        String baseName = id.getPath();
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, shovel)
                .pattern(" A ")
                .pattern(" B ")
                .pattern(" B ")
                .define('A', item)
                .define('B', Items.STICK)
                .unlockedBy(unlockedBy, has(item))
                .save(pRecipeOutput, ResourceLocation.fromNamespaceAndPath
                        (id.getNamespace(), baseName));
    }

    private void buildHoeItem(RecipeOutput pRecipeOutput, Item item, Item hoe, String unlockedBy) {
        ResourceLocation id = BuiltInRegistries.ITEM.getKey(hoe);
        String baseName = id.getPath();
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, hoe)
                .pattern(" AA")
                .pattern(" B ")
                .pattern(" B ")
                .define('A', item)
                .define('B', Items.STICK)
                .unlockedBy(unlockedBy, has(item))
                .save(pRecipeOutput, ResourceLocation.fromNamespaceAndPath
                        (id.getNamespace(), baseName));
    }

    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, Everytool.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
