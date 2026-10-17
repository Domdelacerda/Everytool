package com.zominique.everytool.item.custom.amethyst;

import com.zominique.everytool.item.ModToolTiers;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;

public class AmethystHoeItem extends HoeItem implements IAmethystTool {
    public AmethystHoeItem(Item.Properties properties) {
        super(ModToolTiers.AMETHYST, properties);
    }
}
