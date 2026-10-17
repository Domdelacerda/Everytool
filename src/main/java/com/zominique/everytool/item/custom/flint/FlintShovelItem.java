package com.zominique.everytool.item.custom.flint;

import com.zominique.everytool.item.ModToolAttributes;
import com.zominique.everytool.item.ModToolTiers;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ShovelItem;

public class FlintShovelItem extends ShovelItem implements IFlintTool {
    public FlintShovelItem(Item.Properties properties) {
        super(ModToolTiers.FLINT, properties.component(
                DataComponents.ATTRIBUTE_MODIFIERS,
                ModToolAttributes.flintToolBase(
                ModToolAttributes.sword(ModToolTiers.FLINT))
                .build())
        );
    }
}
