package com.zominique.everytool.item.custom.ancient;

import com.zominique.everytool.item.ModToolTiers;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;

public class AncientAxeItem extends AxeItem implements IAncientTool {
    public AncientAxeItem(Item.Properties properties) {
        super(ModToolTiers.ANCIENT, properties);
    }
}
