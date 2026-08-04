package com.zominique.everytool.item.custom.coal;

import com.zominique.everytool.item.ModToolTiers;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.HoeItem;

public class CoalHoeItem extends HoeItem implements ICoalTool {
    public CoalHoeItem(Item.Properties properties) {
        super(ModToolTiers.COAL, properties);
    }
}