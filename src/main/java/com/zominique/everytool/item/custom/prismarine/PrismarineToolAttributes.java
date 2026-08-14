package com.zominique.everytool.item.custom.prismarine;

import com.zominique.everytool.Everytool;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.component.ItemAttributeModifiers;

public class PrismarineToolAttributes {

    private static final ResourceLocation BASE_ATTACK_DAMAGE_ID = Item.BASE_ATTACK_DAMAGE_ID;
    private static final ResourceLocation BASE_ATTACK_SPEED_ID = Item.BASE_ATTACK_SPEED_ID;

    protected static final float MINING_SPEED_BOOST = 1.3f;
    protected static final ResourceLocation SUBMERGED_MINING_ID =
            ResourceLocation.fromNamespaceAndPath(Everytool.MOD_ID, "prismarine_submerged_mining");

    public static ItemAttributeModifiers.Builder toolBase(Tier tier, float baseDamage, float baseAttackSpeed) {
        return ItemAttributeModifiers.builder()
                .add(
                        Attributes.ATTACK_DAMAGE,
                        new AttributeModifier(BASE_ATTACK_DAMAGE_ID, baseDamage + tier.getAttackDamageBonus(), AttributeModifier.Operation.ADD_VALUE),
                        EquipmentSlotGroup.MAINHAND
                )
                .add(
                        Attributes.ATTACK_SPEED,
                        new AttributeModifier(BASE_ATTACK_SPEED_ID, baseAttackSpeed, AttributeModifier.Operation.ADD_VALUE),
                        EquipmentSlotGroup.MAINHAND
                );
    }

    public static ItemAttributeModifiers.Builder sword(Tier tier) {
        return toolBase(tier, 3.0F, -2.4F);
    }

    public static ItemAttributeModifiers.Builder pickaxe(Tier tier) {
        return toolBase(tier, 1.0F, -2.8F);
    }

    public static ItemAttributeModifiers.Builder shovel(Tier tier) {
        return toolBase(tier, 1.5F, -3.0F);
    }

    // No axe()/hoe() default — vanilla's own per-material axe damage doesn't
    // follow tier.getAttackDamageBonus() cleanly, so pass an explicit damage value
    public static ItemAttributeModifiers.Builder axe(Tier tier, float baseDamage) {
        return toolBase(tier, baseDamage, -3.0F);
    }
}