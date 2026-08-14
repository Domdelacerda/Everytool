package com.zominique.everytool.item.custom.emerald;

import com.zominique.everytool.item.ModToolTiers;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;

public class EmeraldSwordItem extends SwordItem implements IEmeraldTool {
    public EmeraldSwordItem(Item.Properties properties) { super(ModToolTiers.EMERALD, properties); }
}
