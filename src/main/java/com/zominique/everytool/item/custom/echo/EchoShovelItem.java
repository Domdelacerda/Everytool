package com.zominique.everytool.item.custom.echo;

import com.zominique.everytool.item.ModToolTiers;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ShovelItem;

public class EchoShovelItem extends ShovelItem implements IEchoTool {
    public EchoShovelItem(Item.Properties properties) {
        super(ModToolTiers.ECHO, properties);
    }
}
