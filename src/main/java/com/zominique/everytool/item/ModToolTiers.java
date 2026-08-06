package com.zominique.everytool.item;

import com.zominique.everytool.util.ModTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModToolTiers {
    // STONE STRENGTH TOOLS

    // Coal tools automatically smelt items. Coal weapons deal double damage to targets who are on fire
    public static final Tier COAL = new ForgeTier(15, 1.5f, 0.5f, 3,
            ModTags.Blocks.NEEDS_COAL_TOOL, () -> Ingredient.of(ItemTags.COALS),
            ModTags.Blocks.INCORRECT_FOR_COAL_TOOL);
    // Flint tools deal +1 critical damage
    public static final Tier FLINT = new ForgeTier(191, 5.0f, 1.5f, 7,
            ModTags.Blocks.NEEDS_FLINT_TOOL, () -> Ingredient.of(Items.FLINT),
            ModTags.Blocks.INCORRECT_FOR_FLINT_TOOL);

    // IRON STRENGTH TOOLS

    // Redstone tools and weapons gain a 1.5x efficiency, damage, and swing speed boost while touching
    // powered redstone or a powered redstone component
    public static final Tier REDSTONE = new ForgeTier(59, 4.5f, 1.0f, 16,
            ModTags.Blocks.NEEDS_REDSTONE_TOOL, () -> Ingredient.of(Items.REDSTONE),
            ModTags.Blocks.INCORRECT_FOR_REDSTONE_TOOL);
    // Lapis tools and weapons yield double experience from breaking blocks and killing mobs
    public static final Tier LAPIS = new ForgeTier(191, 5.0f, 1.5f, 25,
            ModTags.Blocks.NEEDS_LAPIS_TOOL, () -> Ingredient.of(Items.LAPIS_LAZULI),
            ModTags.Blocks.INCORRECT_FOR_LAPIS_TOOL);
    // Emerald tools have no special effects
    public static final Tier EMERALD = new ForgeTier(500, 6.5f, 1.5f, 12,
            ModTags.Blocks.NEEDS_EMERALD_TOOL, () -> Ingredient.of(Items.EMERALD),
            ModTags.Blocks.INCORRECT_FOR_EMERALD_TOOL);
    // Amethyst tools play a tone when breaking a block nearby an ore/the tool's breakable blocks
    // Amethyst weapons play a tone when a hostile mob is nearby
    public static final Tier AMETHYST = new ForgeTier(250, 6.0f, 2.0f, 17,
            ModTags.Blocks.NEEDS_AMETHYST_TOOL, () -> Ingredient.of(Items.AMETHYST_SHARD),
            ModTags.Blocks.INCORRECT_FOR_AMETHYST_TOOL);
    // Prismarine tools and weapons gain a 1.5x efficiency, damage, and swing speed boost while underwater
    public static final Tier PRISMARINE = new ForgeTier(500, 7.0f, 2.0f, 14,
            ModTags.Blocks.NEEDS_PRISMARINE_TOOL, () -> Ingredient.of(Items.PRISMARINE_CRYSTALS),
            ModTags.Blocks.INCORRECT_FOR_PRISMARINE_TOOL);
    // Quartz tools and weapons have the same effect as amethyst tools
    public static final Tier QUARTZ = new ForgeTier(750, 7.5f, 2.5f, 7,
            ModTags.Blocks.NEEDS_QUARTZ_TOOL, () -> Ingredient.of(Items.QUARTZ),
            ModTags.Blocks.INCORRECT_FOR_QUARTZ_TOOL);

    // DIAMOND STRENGTH TOOLS

    // Ancient tools and weapons have no special effects
    public static final Tier ANCIENT = new ForgeTier(4062, 8.5f, 3.5f, 22,
            ModTags.Blocks.NEEDS_ANCIENT_TOOL, () -> Ingredient.of(Items.NETHERITE_SCRAP),
            ModTags.Blocks.INCORRECT_FOR_ANCIENT_TOOL);

    // NETHERITE STRENGTH TOOLS

    // Echo tools and weapons can be tuned to a specific enemy or block. When breaking a block or hitting an
    // enemy near the tuned block/mob, the tool will make a sculk sound
    public static final Tier ECHO = new ForgeTier(2531, 10.0f, 5.0f, 17,
            ModTags.Blocks.NEEDS_ECHO_TOOL, () -> Ingredient.of(Items.ECHO_SHARD),
            ModTags.Blocks.INCORRECT_FOR_ECHO_TOOL);
    // Chorus tools automatically teleport items into your inventory when breaking blocks
    // Chorus weapons teleport mob drops into your inventory
    public static final Tier CHORUS = new ForgeTier(2531, 9.5f, 5.0f, 17,
            ModTags.Blocks.NEEDS_CHORUS_TOOL, () -> Ingredient.of(Items.POPPED_CHORUS_FRUIT),
            ModTags.Blocks.INCORRECT_FOR_CHORUS_TOOL);
}
