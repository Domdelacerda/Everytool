package com.zominique.everytool.item.custom.flint;

import com.zominique.everytool.item.ModToolAttributes;
import com.zominique.everytool.item.ModToolTiers;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;

public class FlintPickaxeItem extends PickaxeItem implements IFlintTool {
    public FlintPickaxeItem(Item.Properties properties) {
        super(ModToolTiers.FLINT, properties.component(
                DataComponents.ATTRIBUTE_MODIFIERS,
                ModToolAttributes.flintToolBase(
                ModToolAttributes.pickaxe(ModToolTiers.FLINT))
                .build())
        );
    }
}
