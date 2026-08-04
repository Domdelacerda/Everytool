package com.zominique.everytool.item.custom.coal;

import com.zominique.everytool.item.ModToolTiers;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ShovelItem;

public class CoalShovelItem extends ShovelItem implements ICoalTool {
    public CoalShovelItem(Item.Properties properties) {
        super(ModToolTiers.COAL, properties);
    }
}