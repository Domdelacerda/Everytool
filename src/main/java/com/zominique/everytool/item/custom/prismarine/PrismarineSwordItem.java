package com.zominique.everytool.item.custom.prismarine;

import com.zominique.everytool.Everytool;
import com.zominique.everytool.item.ModToolTiers;
import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;

import static com.zominique.everytool.item.custom.prismarine.PrismarineToolAttributes.MINING_SPEED_BOOST;
import static com.zominique.everytool.item.custom.prismarine.PrismarineToolAttributes.SUBMERGED_MINING_ID;

public class PrismarineSwordItem extends SwordItem implements IPrismarineTool {
    public PrismarineSwordItem(Item.Properties properties) {
        super(ModToolTiers.PRISMARINE, properties.component(
                DataComponents.ATTRIBUTE_MODIFIERS,
                PrismarineToolAttributes.sword(ModToolTiers.PRISMARINE) // base pickaxe damage/speed
                        .add(
                                Attributes.SUBMERGED_MINING_SPEED,
                                new AttributeModifier(SUBMERGED_MINING_ID,
                                        MINING_SPEED_BOOST, AttributeModifier.Operation.ADD_VALUE),
                                EquipmentSlotGroup.MAINHAND
                        )
                        .build()
        ));
    }
}
