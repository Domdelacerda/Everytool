package com.zominique.everytool.datagen;

import com.zominique.everytool.Everytool;
import com.zominique.everytool.item.ModItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Everytool.MOD_ID, existingFileHelper);
    }

    private void handheldItem(Item item) {
        ResourceLocation id = BuiltInRegistries.ITEM.getKey(item);
        String baseName = id.getPath();

        getBuilder(baseName)
                .parent(new ModelFile.UncheckedModelFile("item/handheld"))
                .texture("layer0", modLoc("item/" + baseName));
    }

    private void handheldCoalItem(Item item) {
        ResourceLocation id = BuiltInRegistries.ITEM.getKey(item);
        String baseName = id.getPath();
        String activeName = "item/" + baseName + "_active";

        ItemModelBuilder builder = getBuilder(baseName)
                .parent(new ModelFile.UncheckedModelFile("item/handheld"))
                .texture("layer0", modLoc("item/" + baseName));
        withExistingParent(activeName, mcLoc("item/handheld")).texture
                ("layer0", modLoc(activeName));
        builder.override().predicate(ResourceLocation.fromNamespaceAndPath
                        (Everytool.MOD_ID, "lit"), 1).model(getExistingFile(
                                modLoc(activeName))).end();
    }

    private void handheldEchoItem(Item item) {
        ResourceLocation id = BuiltInRegistries.ITEM.getKey(item);
        String baseName = id.getPath();
        String activeName = "item/" + baseName + "_active";

        ItemModelBuilder builder = getBuilder(baseName)
                .parent(new ModelFile.UncheckedModelFile("item/handheld"))
                .texture("layer0", modLoc("item/" + baseName));
        withExistingParent(activeName, mcLoc("item/handheld")).texture
                ("layer0", modLoc(activeName));
        builder.override().predicate(ResourceLocation.fromNamespaceAndPath
                (Everytool.MOD_ID, "resonating"), 1).model(getExistingFile(
                modLoc(activeName))).end();
    }

    @Override
    protected void registerModels() {
        handheldCoalItem(ModItems.COAL_SWORD.get());
        handheldItem(ModItems.FLINT_SWORD.get());
        handheldItem(ModItems.REDSTONE_SWORD.get());
        handheldItem(ModItems.LAPIS_SWORD.get());
        handheldItem(ModItems.EMERALD_SWORD.get());
        handheldItem(ModItems.AMETHYST_SWORD.get());
        handheldItem(ModItems.QUARTZ_SWORD.get());
        handheldItem(ModItems.PRISMARINE_SWORD.get());
        handheldItem(ModItems.ANCIENT_SWORD.get());
        handheldEchoItem(ModItems.ECHO_SWORD.get());
        handheldItem(ModItems.CHORUS_SWORD.get());

        handheldCoalItem(ModItems.COAL_PICKAXE.get());
        handheldItem(ModItems.FLINT_PICKAXE.get());
        handheldItem(ModItems.REDSTONE_PICKAXE.get());
        handheldItem(ModItems.LAPIS_PICKAXE.get());
        handheldItem(ModItems.EMERALD_PICKAXE.get());
        handheldItem(ModItems.AMETHYST_PICKAXE.get());
        handheldItem(ModItems.QUARTZ_PICKAXE.get());
        handheldItem(ModItems.PRISMARINE_PICKAXE.get());
        handheldItem(ModItems.ANCIENT_PICKAXE.get());
        handheldEchoItem(ModItems.ECHO_PICKAXE.get());
        handheldItem(ModItems.CHORUS_PICKAXE.get());

        handheldCoalItem(ModItems.COAL_AXE.get());
        handheldItem(ModItems.FLINT_AXE.get());
        handheldItem(ModItems.REDSTONE_AXE.get());
        handheldItem(ModItems.LAPIS_AXE.get());
        handheldItem(ModItems.EMERALD_AXE.get());
        handheldItem(ModItems.AMETHYST_AXE.get());
        handheldItem(ModItems.QUARTZ_AXE.get());
        handheldItem(ModItems.PRISMARINE_AXE.get());
        handheldItem(ModItems.ANCIENT_AXE.get());
        handheldEchoItem(ModItems.ECHO_AXE.get());
        handheldItem(ModItems.CHORUS_AXE.get());

        handheldCoalItem(ModItems.COAL_SHOVEL.get());
        handheldItem(ModItems.FLINT_SHOVEL.get());
        handheldItem(ModItems.REDSTONE_SHOVEL.get());
        handheldItem(ModItems.LAPIS_SHOVEL.get());
        handheldItem(ModItems.EMERALD_SHOVEL.get());
        handheldItem(ModItems.AMETHYST_SHOVEL.get());
        handheldItem(ModItems.QUARTZ_SHOVEL.get());
        handheldItem(ModItems.PRISMARINE_SHOVEL.get());
        handheldItem(ModItems.ANCIENT_SHOVEL.get());
        handheldEchoItem(ModItems.ECHO_SHOVEL.get());
        handheldItem(ModItems.CHORUS_SHOVEL.get());

        handheldCoalItem(ModItems.COAL_HOE.get());
        handheldItem(ModItems.FLINT_HOE.get());
        handheldItem(ModItems.REDSTONE_HOE.get());
        handheldItem(ModItems.LAPIS_HOE.get());
        handheldItem(ModItems.EMERALD_HOE.get());
        handheldItem(ModItems.AMETHYST_HOE.get());
        handheldItem(ModItems.QUARTZ_HOE.get());
        handheldItem(ModItems.PRISMARINE_HOE.get());
        handheldItem(ModItems.ANCIENT_HOE.get());
        handheldEchoItem(ModItems.ECHO_HOE.get());
        handheldItem(ModItems.CHORUS_HOE.get());
    }
}
