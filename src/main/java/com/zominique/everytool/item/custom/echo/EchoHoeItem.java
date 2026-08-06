package com.zominique.everytool.item.custom.echo;

import com.zominique.everytool.item.ModToolTiers;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.HoeItem;

public class EchoHoeItem extends HoeItem implements IEchoTool {
    public EchoHoeItem(Item.Properties properties) {
        super(ModToolTiers.ECHO, properties);
    }
}
