package com.zominique.everytool.item.custom.amethyst;

import com.zominique.everytool.item.ModToolTiers;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;

public class AmethystAxeItem extends AxeItem implements IAmethystTool {
    public AmethystAxeItem(Item.Properties properties) {
        super(ModToolTiers.AMETHYST, properties);
    }
}
