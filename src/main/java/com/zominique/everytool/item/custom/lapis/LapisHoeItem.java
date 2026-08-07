package com.zominique.everytool.item.custom.lapis;

import com.zominique.everytool.item.ModToolTiers;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.HoeItem;

public class LapisHoeItem extends HoeItem implements ILapisTool {
    public LapisHoeItem(Item.Properties properties) {
        super(ModToolTiers.LAPIS, properties);
    }
}
