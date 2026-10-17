package com.zominique.everytool.item.custom.amethyst;

import com.zominique.everytool.item.ModToolTiers;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;

public class AmethystSwordItem extends SwordItem implements IAmethystTool {
    public AmethystSwordItem(Item.Properties properties) {
        super(ModToolTiers.AMETHYST, properties);
    }
}
