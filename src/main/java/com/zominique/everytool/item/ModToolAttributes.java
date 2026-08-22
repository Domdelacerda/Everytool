package com.zominique.everytool.item;

import com.zominique.everytool.Everytool;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.component.ItemAttributeModifiers;

public class ModToolAttributes {

    private static final ResourceLocation BASE_ATTACK_DAMAGE_ID = Item.BASE_ATTACK_DAMAGE_ID;
    private static final ResourceLocation BASE_ATTACK_SPEED_ID = Item.BASE_ATTACK_SPEED_ID;

    public static final double DEFAULT_ATTACK_SPEED_BASE = 4.0;

    public static final float HOE_BASE_DAMAGE = 0.0F;
    public static final float HOE_BASE_ATTACK_SPEED_MODIFIER = 0F;
    public static final float SWORD_BASE_DAMAGE = 3.0F;
    public static final float SWORD_BASE_ATTACK_SPEED_MODIFIER = -2.4F;
    public static final float PICKAXE_BASE_DAMAGE = 1.0F;
    public static final float PICKAXE_BASE_ATTACK_SPEED_MODIFIER = -2.8F;
    public static final float SHOVEL_BASE_DAMAGE = 1.5F;
    public static final float SHOVEL_BASE_ATTACK_SPEED_MODIFIER = -3.0F;
    public static final float AXE_BASE_ATTACK_SPEED_MODIFIER = -3.0F;

    public static final float MINING_SPEED_BOOST = 1.3f;
    public static final ResourceLocation SUBMERGED_MINING_ID =
            ResourceLocation.fromNamespaceAndPath(Everytool.MOD_ID, "prismarine_submerged_mining");

    public static double effectiveAttackSpeed(float baseAttackSpeedModifier) {
        return DEFAULT_ATTACK_SPEED_BASE + baseAttackSpeedModifier;
    }

    public static ItemAttributeModifiers hideDefaultTooltip(ItemAttributeModifiers modifiers) {
        return new ItemAttributeModifiers(modifiers.modifiers(), false);
    }

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
        return toolBase(tier, SWORD_BASE_DAMAGE, SWORD_BASE_ATTACK_SPEED_MODIFIER);
    }

    public static ItemAttributeModifiers.Builder pickaxe(Tier tier) {
        return toolBase(tier, PICKAXE_BASE_DAMAGE, PICKAXE_BASE_ATTACK_SPEED_MODIFIER);
    }

    public static ItemAttributeModifiers.Builder shovel(Tier tier) {
        return toolBase(tier, SHOVEL_BASE_DAMAGE, SHOVEL_BASE_ATTACK_SPEED_MODIFIER);
    }

    // No axe()/hoe() default — vanilla's own per-material axe damage doesn't
    // follow tier.getAttackDamageBonus() cleanly, so pass an explicit damage value
    public static ItemAttributeModifiers.Builder axe(Tier tier, float baseDamage) {
        return toolBase(tier, baseDamage, AXE_BASE_ATTACK_SPEED_MODIFIER);
    }
}