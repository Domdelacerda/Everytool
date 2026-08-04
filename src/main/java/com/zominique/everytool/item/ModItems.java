package com.zominique.everytool.item;

import com.zominique.everytool.Everytool;
import com.zominique.everytool.item.custom.coal.*;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Everytool.MOD_ID);

    public static final RegistryObject<Item> COAL_SWORD = ITEMS.register("coal_sword",
            () -> new CoalSwordItem(new Item.Properties().attributes(SwordItem.createAttributes(
                    ModToolTiers.COAL, 3, -2.4f))));
    public static final RegistryObject<Item> FLINT_SWORD = ITEMS.register("flint_sword",
            () -> new SwordItem(ModToolTiers.FLINT, new Item.Properties().attributes(SwordItem.createAttributes(
                    ModToolTiers.FLINT, 3, -2.2f))));
    public static final RegistryObject<Item> REDSTONE_SWORD = ITEMS.register("redstone_sword",
            () -> new SwordItem(ModToolTiers.REDSTONE, new Item.Properties().attributes(SwordItem.createAttributes(
                    ModToolTiers.REDSTONE, 3, -2.4f))));
    public static final RegistryObject<Item> LAPIS_SWORD = ITEMS.register("lapis_sword",
            () -> new SwordItem(ModToolTiers.LAPIS, new Item.Properties().attributes(SwordItem.createAttributes(
                    ModToolTiers.LAPIS, 3, -2.4f))));
    public static final RegistryObject<Item> EMERALD_SWORD = ITEMS.register("emerald_sword",
            () -> new SwordItem(ModToolTiers.EMERALD, new Item.Properties().attributes(SwordItem.createAttributes(
                    ModToolTiers.EMERALD, 3, -2.4f))));
    public static final RegistryObject<Item> AMETHYST_SWORD = ITEMS.register("amethyst_sword",
            () -> new SwordItem(ModToolTiers.AMETHYST, new Item.Properties().attributes(SwordItem.createAttributes(
                    ModToolTiers.AMETHYST, 3, -2.0f))));
    public static final RegistryObject<Item> QUARTZ_SWORD = ITEMS.register("quartz_sword",
            () -> new SwordItem(ModToolTiers.QUARTZ, new Item.Properties().attributes(SwordItem.createAttributes(
                    ModToolTiers.QUARTZ, 3, -2.2f))));
    public static final RegistryObject<Item> PRISMARINE_SWORD = ITEMS.register("prismarine_sword",
            () -> new SwordItem(ModToolTiers.PRISMARINE, new Item.Properties().attributes(SwordItem.createAttributes(
                    ModToolTiers.PRISMARINE, 3, -2.4f))));
    public static final RegistryObject<Item> ANCIENT_SWORD = ITEMS.register("ancient_sword",
            () -> new SwordItem(ModToolTiers.ANCIENT, new Item.Properties().fireResistant().attributes(SwordItem.createAttributes(
                    ModToolTiers.ANCIENT, 4, -3.4f))));
    public static final RegistryObject<Item> ECHO_SWORD = ITEMS.register("echo_sword",
            () -> new SwordItem(ModToolTiers.ECHO, new Item.Properties().fireResistant().attributes(SwordItem.createAttributes(
                    ModToolTiers.ECHO, 3, -2.4f))));

    public static final RegistryObject<Item> COAL_PICKAXE = ITEMS.register("coal_pickaxe",
            () -> new CoalPickaxeItem(new Item.Properties().attributes(PickaxeItem.createAttributes(
                    ModToolTiers.COAL, 1, -2.8f))));
    public static final RegistryObject<Item> FLINT_PICKAXE = ITEMS.register("flint_pickaxe",
            () -> new PickaxeItem(ModToolTiers.FLINT, new Item.Properties().attributes(PickaxeItem.createAttributes(
                    ModToolTiers.FLINT, 1, -2.6f))));
    public static final RegistryObject<Item> REDSTONE_PICKAXE = ITEMS.register("redstone_pickaxe",
            () -> new PickaxeItem(ModToolTiers.REDSTONE, new Item.Properties().attributes(PickaxeItem.createAttributes(
                    ModToolTiers.REDSTONE, 1, -2.8f))));
    public static final RegistryObject<Item> LAPIS_PICKAXE = ITEMS.register("lapis_pickaxe",
            () -> new PickaxeItem(ModToolTiers.LAPIS, new Item.Properties().attributes(PickaxeItem.createAttributes(
                    ModToolTiers.LAPIS, 1, -2.8f))));
    public static final RegistryObject<Item> EMERALD_PICKAXE = ITEMS.register("emerald_pickaxe",
            () -> new PickaxeItem(ModToolTiers.EMERALD, new Item.Properties().attributes(PickaxeItem.createAttributes(
                    ModToolTiers.EMERALD, 1, -2.8f))));
    public static final RegistryObject<Item> AMETHYST_PICKAXE = ITEMS.register("amethyst_pickaxe",
            () -> new PickaxeItem(ModToolTiers.AMETHYST, new Item.Properties().attributes(PickaxeItem.createAttributes(
                    ModToolTiers.AMETHYST, 1, -2.4f))));
    public static final RegistryObject<Item> QUARTZ_PICKAXE = ITEMS.register("quartz_pickaxe",
            () -> new PickaxeItem(ModToolTiers.QUARTZ, new Item.Properties().attributes(PickaxeItem.createAttributes(
                    ModToolTiers.QUARTZ, 1, -2.6f))));
    public static final RegistryObject<Item> PRISMARINE_PICKAXE = ITEMS.register("prismarine_pickaxe",
            () -> new PickaxeItem(ModToolTiers.PRISMARINE, new Item.Properties().attributes(PickaxeItem.createAttributes(
                    ModToolTiers.PRISMARINE, 1, -2.8f))));
    public static final RegistryObject<Item> ANCIENT_PICKAXE = ITEMS.register("ancient_pickaxe",
            () -> new PickaxeItem(ModToolTiers.ANCIENT, new Item.Properties().fireResistant().attributes(PickaxeItem.createAttributes(
                    ModToolTiers.ANCIENT, 2, -3.8f))));
    public static final RegistryObject<Item> ECHO_PICKAXE = ITEMS.register("echo_pickaxe",
            () -> new PickaxeItem(ModToolTiers.ECHO, new Item.Properties().fireResistant().attributes(PickaxeItem.createAttributes(
                    ModToolTiers.ECHO, 1, -2.8f))));

    public static final RegistryObject<Item> COAL_AXE = ITEMS.register("coal_axe",
            () -> new CoalAxeItem(new Item.Properties().attributes(AxeItem.createAttributes(
                    ModToolTiers.COAL, 6, -3.2f))));
    public static final RegistryObject<Item> FLINT_AXE = ITEMS.register("flint_axe",
            () -> new AxeItem(ModToolTiers.FLINT, new Item.Properties().attributes(AxeItem.createAttributes(
                    ModToolTiers.FLINT, 6, -3.0f))));
    public static final RegistryObject<Item> REDSTONE_AXE = ITEMS.register("redstone_axe",
            () -> new AxeItem(ModToolTiers.REDSTONE, new Item.Properties().attributes(AxeItem.createAttributes(
                    ModToolTiers.REDSTONE, 6, -3.1f))));
    public static final RegistryObject<Item> LAPIS_AXE = ITEMS.register("lapis_axe",
            () -> new AxeItem(ModToolTiers.LAPIS, new Item.Properties().attributes(AxeItem.createAttributes(
                    ModToolTiers.LAPIS, 6, -3.1f))));
    public static final RegistryObject<Item> EMERALD_AXE = ITEMS.register("emerald_axe",
            () -> new AxeItem(ModToolTiers.EMERALD, new Item.Properties().attributes(AxeItem.createAttributes(
                    ModToolTiers.EMERALD, 6, -3.1f))));
    public static final RegistryObject<Item> AMETHYST_AXE = ITEMS.register("amethyst_axe",
            () -> new AxeItem(ModToolTiers.AMETHYST, new Item.Properties().attributes(AxeItem.createAttributes(
                    ModToolTiers.AMETHYST, 6, -2.7f))));
    public static final RegistryObject<Item> QUARTZ_AXE = ITEMS.register("quartz_axe",
            () -> new AxeItem(ModToolTiers.QUARTZ, new Item.Properties().attributes(AxeItem.createAttributes(
                    ModToolTiers.QUARTZ, 6, -2.9f))));
    public static final RegistryObject<Item> PRISMARINE_AXE = ITEMS.register("prismarine_axe",
            () -> new AxeItem(ModToolTiers.PRISMARINE, new Item.Properties().attributes(AxeItem.createAttributes(
                    ModToolTiers.PRISMARINE, 6, -3.1f))));
    public static final RegistryObject<Item> ANCIENT_AXE = ITEMS.register("ancient_axe",
            () -> new AxeItem(ModToolTiers.ANCIENT, new Item.Properties().fireResistant().attributes(AxeItem.createAttributes(
                    ModToolTiers.ANCIENT, 6, -3.8f))));
    public static final RegistryObject<Item> ECHO_AXE = ITEMS.register("echo_axe",
            () -> new AxeItem(ModToolTiers.ECHO, new Item.Properties().fireResistant().attributes(AxeItem.createAttributes(
                    ModToolTiers.ECHO, 5, -3.0f))));

    public static final RegistryObject<Item> COAL_SHOVEL = ITEMS.register("coal_shovel",
            () -> new CoalShovelItem(new Item.Properties().attributes(ShovelItem.createAttributes(
                    ModToolTiers.COAL, 2, -3.0f))));
    public static final RegistryObject<Item> FLINT_SHOVEL = ITEMS.register("flint_shovel",
            () -> new ShovelItem(ModToolTiers.FLINT, new Item.Properties().attributes(ShovelItem.createAttributes(
                    ModToolTiers.FLINT, 2, -2.8f))));
    public static final RegistryObject<Item> REDSTONE_SHOVEL = ITEMS.register("redstone_shovel",
            () -> new ShovelItem(ModToolTiers.REDSTONE, new Item.Properties().attributes(ShovelItem.createAttributes(
                    ModToolTiers.REDSTONE, 2, -3.0f))));
    public static final RegistryObject<Item> LAPIS_SHOVEL = ITEMS.register("lapis_shovel",
            () -> new ShovelItem(ModToolTiers.LAPIS, new Item.Properties().attributes(ShovelItem.createAttributes(
                    ModToolTiers.LAPIS, 2, -3.0f))));
    public static final RegistryObject<Item> EMERALD_SHOVEL = ITEMS.register("emerald_shovel",
            () -> new ShovelItem(ModToolTiers.EMERALD, new Item.Properties().attributes(ShovelItem.createAttributes(
                    ModToolTiers.EMERALD, 2, -3.0f))));
    public static final RegistryObject<Item> AMETHYST_SHOVEL = ITEMS.register("amethyst_shovel",
            () -> new ShovelItem(ModToolTiers.AMETHYST, new Item.Properties().attributes(ShovelItem.createAttributes(
                    ModToolTiers.AMETHYST, 2, -2.6f))));
    public static final RegistryObject<Item> QUARTZ_SHOVEL = ITEMS.register("quartz_shovel",
            () -> new ShovelItem(ModToolTiers.QUARTZ, new Item.Properties().attributes(ShovelItem.createAttributes(
                    ModToolTiers.QUARTZ, 2, -2.8f))));
    public static final RegistryObject<Item> PRISMARINE_SHOVEL = ITEMS.register("prismarine_shovel",
            () -> new ShovelItem(ModToolTiers.PRISMARINE, new Item.Properties().attributes(ShovelItem.createAttributes(
                    ModToolTiers.PRISMARINE, 2, -3.0f))));
    public static final RegistryObject<Item> ANCIENT_SHOVEL = ITEMS.register("ancient_shovel",
            () -> new ShovelItem(ModToolTiers.ANCIENT, new Item.Properties().fireResistant().attributes(ShovelItem.createAttributes(
                    ModToolTiers.ANCIENT, 3, -3.8f))));
    public static final RegistryObject<Item> ECHO_SHOVEL = ITEMS.register("echo_shovel",
            () -> new ShovelItem(ModToolTiers.ECHO, new Item.Properties().fireResistant().attributes(ShovelItem.createAttributes(
                    ModToolTiers.ECHO, 2, -3.0f))));

    public static final RegistryObject<Item> COAL_HOE = ITEMS.register("coal_hoe",
            () -> new CoalHoeItem(new Item.Properties().attributes(HoeItem.createAttributes(
                    ModToolTiers.COAL, 0, -3.0f))));
    public static final RegistryObject<Item> FLINT_HOE = ITEMS.register("flint_hoe",
            () -> new HoeItem(ModToolTiers.FLINT, new Item.Properties().attributes(HoeItem.createAttributes(
                    ModToolTiers.FLINT, 0, -1.8f))));
    public static final RegistryObject<Item> REDSTONE_HOE = ITEMS.register("redstone_hoe",
            () -> new HoeItem(ModToolTiers.REDSTONE, new Item.Properties().attributes(HoeItem.createAttributes(
                    ModToolTiers.REDSTONE, 0, -1.0f))));
    public static final RegistryObject<Item> LAPIS_HOE = ITEMS.register("lapis_hoe",
            () -> new HoeItem(ModToolTiers.LAPIS, new Item.Properties().attributes(HoeItem.createAttributes(
                    ModToolTiers.LAPIS, 0, -1.0f))));
    public static final RegistryObject<Item> EMERALD_HOE = ITEMS.register("emerald_hoe",
            () -> new HoeItem(ModToolTiers.EMERALD, new Item.Properties().attributes(HoeItem.createAttributes(
                    ModToolTiers.EMERALD, 0, -1.0f))));
    public static final RegistryObject<Item> AMETHYST_HOE = ITEMS.register("amethyst_hoe",
            () -> new HoeItem(ModToolTiers.AMETHYST, new Item.Properties().attributes(HoeItem.createAttributes(
                    ModToolTiers.AMETHYST, 0, -0.6f))));
    public static final RegistryObject<Item> QUARTZ_HOE = ITEMS.register("quartz_hoe",
            () -> new HoeItem(ModToolTiers.QUARTZ, new Item.Properties().attributes(HoeItem.createAttributes(
                    ModToolTiers.QUARTZ, 0, -0.8f))));
    public static final RegistryObject<Item> PRISMARINE_HOE = ITEMS.register("prismarine_hoe",
            () -> new HoeItem(ModToolTiers.PRISMARINE, new Item.Properties().attributes(HoeItem.createAttributes(
                    ModToolTiers.PRISMARINE, 0, -1.0f))));
    public static final RegistryObject<Item> ANCIENT_HOE = ITEMS.register("ancient_hoe",
            () -> new HoeItem(ModToolTiers.ANCIENT, new Item.Properties().fireResistant().attributes(HoeItem.createAttributes(
                    ModToolTiers.ANCIENT, 0, -1.0f))));
    public static final RegistryObject<Item> ECHO_HOE = ITEMS.register("echo_hoe",
            () -> new HoeItem(ModToolTiers.ECHO, new Item.Properties().fireResistant().attributes(HoeItem.createAttributes(
                    ModToolTiers.ECHO, 1, -0.0f))));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
