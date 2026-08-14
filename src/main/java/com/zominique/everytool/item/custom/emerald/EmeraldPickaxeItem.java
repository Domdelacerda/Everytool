package com.zominique.everytool.item.custom.emerald;

import com.zominique.everytool.item.ModToolTiers;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;

public class EmeraldPickaxeItem extends PickaxeItem implements IEmeraldTool {
    public EmeraldPickaxeItem(Item.Properties properties) { super(ModToolTiers.EMERALD, properties); }
}
