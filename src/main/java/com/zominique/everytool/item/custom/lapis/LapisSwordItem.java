package com.zominique.everytool.item.custom.lapis;

import com.zominique.everytool.item.ModToolTiers;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;

public class LapisSwordItem extends SwordItem implements ILapisTool {
    public LapisSwordItem(Item.Properties properties) {
        super(ModToolTiers.LAPIS, properties);
    }
}
