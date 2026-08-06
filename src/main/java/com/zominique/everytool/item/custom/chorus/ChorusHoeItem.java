package com.zominique.everytool.item.custom.chorus;

import com.zominique.everytool.item.ModToolTiers;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;

public class ChorusHoeItem extends HoeItem implements IChorusTool{
    public ChorusHoeItem(Item.Properties properties) {
        super(ModToolTiers.CHORUS, properties);
    }
}
