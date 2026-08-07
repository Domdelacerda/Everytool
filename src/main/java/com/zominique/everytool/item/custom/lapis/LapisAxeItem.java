package com.zominique.everytool.item.custom.lapis;

import com.zominique.everytool.item.ModToolTiers;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.AxeItem;

public class LapisAxeItem extends AxeItem implements ILapisTool {
    public LapisAxeItem(Item.Properties properties) {
        super(ModToolTiers.LAPIS, properties);
    }
}
