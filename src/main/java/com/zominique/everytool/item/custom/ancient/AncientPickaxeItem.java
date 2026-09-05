package com.zominique.everytool.item.custom.ancient;

import com.zominique.everytool.item.ModToolTiers;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Item;

public class AncientPickaxeItem extends PickaxeItem implements IAncientTool {
    public AncientPickaxeItem(Item.Properties properties) {
        super(ModToolTiers.ANCIENT, properties);
    }
}
