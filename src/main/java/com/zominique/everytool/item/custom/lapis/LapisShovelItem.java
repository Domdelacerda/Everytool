package com.zominique.everytool.item.custom.lapis;

import com.zominique.everytool.item.ModToolTiers;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ShovelItem;

public class LapisShovelItem extends ShovelItem implements ILapisTool {
    public LapisShovelItem(Item.Properties properties) {
        super(ModToolTiers.LAPIS, properties);
    }
}
