package com.zominique.everytool.item.custom.echo;

import com.zominique.everytool.item.ModToolTiers;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;

public class EchoSwordItem extends SwordItem implements IEchoTool {
    public EchoSwordItem(Item.Properties properties) {
        super(ModToolTiers.ECHO, properties);
    }
}
