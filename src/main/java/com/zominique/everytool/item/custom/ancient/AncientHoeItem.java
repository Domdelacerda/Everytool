package com.zominique.everytool.item.custom.ancient;

import com.zominique.everytool.item.ModToolTiers;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;

public class AncientHoeItem extends HoeItem implements IAncientTool {
    public AncientHoeItem(Item.Properties properties) {
        super(ModToolTiers.ANCIENT, properties);
    }
}
