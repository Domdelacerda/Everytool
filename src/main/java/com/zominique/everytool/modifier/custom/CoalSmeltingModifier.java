package com.zominique.everytool.modifier.custom;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.zominique.everytool.modifier.ModLootModifiers;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.item.crafting.SmeltingRecipe;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;

import java.util.Optional;

public class CoalSmeltingModifier extends LootModifier {

    public static final MapCodec<CoalSmeltingModifier> CODEC = RecordCodecBuilder.mapCodec(inst ->
            codecStart(inst).apply(inst, CoalSmeltingModifier::new));

    public CoalSmeltingModifier(LootItemCondition[] conditionsIn) {
        super(conditionsIn);
    }

    @Override
    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        if (!(context.getLevel() instanceof ServerLevel serverLevel)) {
            return generatedLoot;
        }

        ObjectArrayList<ItemStack> smelted = new ObjectArrayList<>();
        for (ItemStack drop : generatedLoot) {
            Optional<RecipeHolder<SmeltingRecipe>> recipe = serverLevel.getRecipeManager()
                    .getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput(drop), serverLevel);

            if (recipe.isPresent()) {
                ItemStack result = recipe.get().value().getResultItem(serverLevel.registryAccess()).copy();
                result.setCount(result.getCount() * drop.getCount());
                smelted.add(result);
            } else {
                smelted.add(drop);
            }
        }
        return smelted;
    }

    @Override
    public MapCodec<? extends IGlobalLootModifier> codec() {
        return ModLootModifiers.COAL_SMELTING.get();
    }
}
