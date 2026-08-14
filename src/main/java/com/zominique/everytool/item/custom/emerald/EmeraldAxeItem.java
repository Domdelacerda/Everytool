package com.zominique.everytool.item.custom.emerald;

import com.zominique.everytool.item.ModToolTiers;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;

public class EmeraldAxeItem extends AxeItem implements IEmeraldTool {
    public EmeraldAxeItem(Item.Properties properties) {
        super(ModToolTiers.EMERALD, properties);
    }
}
