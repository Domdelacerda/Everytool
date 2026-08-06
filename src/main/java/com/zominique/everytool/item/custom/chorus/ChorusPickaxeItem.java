package com.zominique.everytool.item.custom.chorus;

import com.zominique.everytool.item.ModToolTiers;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;

public class ChorusPickaxeItem extends PickaxeItem implements IChorusTool {
    public ChorusPickaxeItem(Item.Properties properties) {
        super(ModToolTiers.CHORUS, properties);
    }
}
