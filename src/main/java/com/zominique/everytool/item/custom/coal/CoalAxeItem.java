package com.zominique.everytool.item.custom.coal;

import com.zominique.everytool.item.ModToolTiers;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.AxeItem;

public class CoalAxeItem extends AxeItem implements ICoalTool {
    public CoalAxeItem(Item.Properties properties) {
        super(ModToolTiers.COAL, properties);
    }
}