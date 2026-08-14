package com.zominique.everytool.item.custom.emerald;

import com.zominique.everytool.item.ModToolTiers;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Item;

public class EmeraldShovelItem extends ShovelItem implements IEmeraldTool {
    public EmeraldShovelItem(Item.Properties properties) {
        super(ModToolTiers.EMERALD, properties);
    }
}
