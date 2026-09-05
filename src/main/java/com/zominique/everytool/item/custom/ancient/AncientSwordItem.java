package com.zominique.everytool.item.custom.ancient;

import com.zominique.everytool.item.ModToolTiers;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ShovelItem;

public class AncientSwordItem extends ShovelItem implements IAncientTool {
    public AncientSwordItem(Item.Properties properties) {
        super(ModToolTiers.ANCIENT, properties);
    }
}
