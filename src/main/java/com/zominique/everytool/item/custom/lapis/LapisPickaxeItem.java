package com.zominique.everytool.item.custom.lapis;

import com.zominique.everytool.item.ModToolTiers;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;

public class LapisPickaxeItem extends PickaxeItem implements ILapisTool {
    public LapisPickaxeItem(Item.Properties properties) {
        super(ModToolTiers.LAPIS, properties);
    }
}
