package com.zominique.everytool.item.custom.chorus;

import com.zominique.everytool.item.ModToolTiers;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;

public class ChorusAxeItem extends AxeItem implements IChorusTool {
    public ChorusAxeItem(Item.Properties properties) {
        super(ModToolTiers.CHORUS, properties);
    }
}
