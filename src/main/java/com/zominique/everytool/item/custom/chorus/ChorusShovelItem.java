package com.zominique.everytool.item.custom.chorus;

import com.zominique.everytool.item.ModToolTiers;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ShovelItem;

public class ChorusShovelItem extends ShovelItem implements IChorusTool {
    public ChorusShovelItem(Item.Properties properties) {
        super(ModToolTiers.CHORUS, properties);
    }
}
