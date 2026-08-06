package com.zominique.everytool.item.custom.echo;

import com.zominique.everytool.item.ModToolTiers;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;

public class EchoPickaxeItem extends PickaxeItem implements IEchoTool {
    public EchoPickaxeItem(Item.Properties properties) {
        super(ModToolTiers.ECHO, properties);
    }
}
