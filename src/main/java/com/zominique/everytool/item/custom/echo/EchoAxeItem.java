package com.zominique.everytool.item.custom.echo;

import com.zominique.everytool.item.ModToolTiers;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.AxeItem;

public class EchoAxeItem extends AxeItem implements IEchoTool {
    public EchoAxeItem(Item.Properties properties) {
        super(ModToolTiers.ECHO, properties);
    }
}
