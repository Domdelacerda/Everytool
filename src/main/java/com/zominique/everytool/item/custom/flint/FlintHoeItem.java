package com.zominique.everytool.item.custom.flint;

import com.zominique.everytool.item.ModToolAttributes;
import com.zominique.everytool.item.ModToolTiers;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;

import static com.zominique.everytool.item.ModToolAttributes.*;

public class FlintHoeItem extends HoeItem implements IFlintTool {
    public FlintHoeItem(Item.Properties properties) {
        super(ModToolTiers.FLINT, properties.component(
                DataComponents.ATTRIBUTE_MODIFIERS,
                ModToolAttributes.flintToolBase(
                ModToolAttributes.toolBase(ModToolTiers.FLINT, HOE_BASE_DAMAGE, HOE_BASE_ATTACK_SPEED_MODIFIER))
                .build())
        );
    }
}
