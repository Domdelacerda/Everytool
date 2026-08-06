package com.zominique.everytool.item.custom.chorus;

import com.zominique.everytool.item.ModToolTiers;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;

public class ChorusSwordItem extends SwordItem implements IChorusTool {
    public ChorusSwordItem(Item.Properties properties) {
        super(ModToolTiers.CHORUS, properties);
    }
}
