package com.zominique.everytool.item.custom.flint;

import com.zominique.everytool.item.ModToolAttributes;
import com.zominique.everytool.item.ModToolTiers;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;

public class FlintAxeItem extends AxeItem implements IFlintTool {
    private static final int BASE_DAMAGE = 3;

    public FlintAxeItem(Item.Properties properties) {
        super(ModToolTiers.FLINT, properties.component(
                DataComponents.ATTRIBUTE_MODIFIERS,
                ModToolAttributes.flintToolBase(
                ModToolAttributes.axe(ModToolTiers.FLINT, BASE_DAMAGE))
                .build())
        );
    }
}
