package com.zominique.everytool.item.custom.coal;

import com.zominique.everytool.item.ModToolTiers;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;

public class CoalPickaxeItem extends PickaxeItem implements ICoalTool {
    public CoalPickaxeItem(Item.Properties properties) {
        super(ModToolTiers.COAL, properties);
    }
}
