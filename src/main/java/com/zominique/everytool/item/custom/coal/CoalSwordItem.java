package com.zominique.everytool.item.custom.coal;

import com.zominique.everytool.item.ModToolTiers;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;

public class CoalSwordItem extends SwordItem implements ICoalTool {
    public CoalSwordItem(Item.Properties properties) {
        super(ModToolTiers.COAL, properties);
    }
}