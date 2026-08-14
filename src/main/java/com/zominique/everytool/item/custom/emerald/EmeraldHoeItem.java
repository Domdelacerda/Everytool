package com.zominique.everytool.item.custom.emerald;

import com.zominique.everytool.item.ModToolTiers;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.HoeItem;

public class EmeraldHoeItem extends HoeItem implements IEmeraldTool {
    public EmeraldHoeItem(Item.Properties properties) {
        super(ModToolTiers.EMERALD, properties);
    }
}
