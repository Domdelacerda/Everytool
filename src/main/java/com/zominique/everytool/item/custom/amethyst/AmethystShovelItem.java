package com.zominique.everytool.item.custom.amethyst;

import com.zominique.everytool.item.ModToolTiers;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ShovelItem;

public class AmethystShovelItem extends ShovelItem implements IAmethystTool {
    public AmethystShovelItem(Item.Properties properties) {
        super(ModToolTiers.AMETHYST, properties);
    }
}
