package com.zominique.everytool.item.custom.amethyst;

import com.zominique.everytool.item.ModToolTiers;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;

public class AmethystPickaxeItem extends PickaxeItem implements IAmethystTool {
    public AmethystPickaxeItem(Item.Properties properties) {
        super(ModToolTiers.AMETHYST, properties);
    }
}
