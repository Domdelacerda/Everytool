package com.zominique.everytool.util;

import com.zominique.everytool.Everytool;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_COAL_TOOL = createTag("needs_coal_tool");
        public static final TagKey<Block> INCORRECT_FOR_COAL_TOOL = createTag("incorrect_for_coal_tool");
        public static final TagKey<Block> NEEDS_FLINT_TOOL = createTag("needs_flint_tool");
        public static final TagKey<Block> INCORRECT_FOR_FLINT_TOOL = createTag("incorrect_for_flint_tool");
        public static final TagKey<Block> NEEDS_EMERALD_TOOL = createTag("needs_emerald_tool");
        public static final TagKey<Block> INCORRECT_FOR_EMERALD_TOOL = createTag("incorrect_for_emerald_tool");
        public static final TagKey<Block> NEEDS_RESIN_TOOL = createTag("needs_resin_tool");
        public static final TagKey<Block> INCORRECT_FOR_RESIN_TOOL = createTag("incorrect_for_resin_tool");
        public static final TagKey<Block> NEEDS_AMETHYST_TOOL = createTag("needs_amethyst_tool");
        public static final TagKey<Block> INCORRECT_FOR_AMETHYST_TOOL = createTag("incorrect_for_amethyst_tool");
        public static final TagKey<Block> NEEDS_PRISMARINE_TOOL = createTag("needs_prismarine_tool");
        public static final TagKey<Block> INCORRECT_FOR_PRISMARINE_TOOL = createTag("incorrect_for_prismarine_tool");
        public static final TagKey<Block> NEEDS_REDSTONE_TOOL = createTag("needs_redstone_tool");
        public static final TagKey<Block> INCORRECT_FOR_REDSTONE_TOOL = createTag("incorrect_for_redstone_tool");
        public static final TagKey<Block> NEEDS_LAPIS_TOOL = createTag("needs_lapis_tool");
        public static final TagKey<Block> INCORRECT_FOR_LAPIS_TOOL = createTag("incorrect_for_lapis_tool");
        public static final TagKey<Block> NEEDS_QUARTZ_TOOL = createTag("needs_quartz_tool");
        public static final TagKey<Block> INCORRECT_FOR_QUARTZ_TOOL = createTag("incorrect_for_quartz_tool");
        public static final TagKey<Block> NEEDS_ANCIENT_TOOL = createTag("needs_ancient_tool");
        public static final TagKey<Block> INCORRECT_FOR_ANCIENT_TOOL = createTag("incorrect_for_ancient_tool");
        public static final TagKey<Block> NEEDS_ECHO_TOOL = createTag("needs_echo_tool");
        public static final TagKey<Block> INCORRECT_FOR_ECHO_TOOL = createTag("incorrect_for_echo_tool");
        public static final TagKey<Block> NEEDS_PURPUR_TOOL = createTag("needs_purpur_tool");
        public static final TagKey<Block> INCORRECT_FOR_PURPUR_TOOL = createTag("incorrect_for_purpur_tool");

        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(Everytool.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> TRANSFORMABLE_ITEMS = createTag("transformable_items");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(Everytool.MOD_ID, name));
        }
    }
}
