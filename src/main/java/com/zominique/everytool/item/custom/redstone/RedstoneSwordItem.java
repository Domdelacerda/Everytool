package com.zominique.everytool.item.custom.redstone;

import com.zominique.everytool.item.ModToolAttributes;
import com.zominique.everytool.item.ModToolTiers;
import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class RedstoneSwordItem extends SwordItem implements IRedstoneTool {
    public RedstoneSwordItem(Item.Properties properties) {
        super(ModToolTiers.REDSTONE, properties.component(
                DataComponents.ATTRIBUTE_MODIFIERS,
                ModToolAttributes.hideDefaultTooltip(ModToolAttributes.sword(ModToolTiers.REDSTONE).build())
        ));
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flag) {
        double baseDamage = ModToolAttributes.SWORD_BASE_DAMAGE + ModToolTiers.REDSTONE.getAttackDamageBonus();
        double baseSpeed = ModToolAttributes.effectiveAttackSpeed(ModToolAttributes.SWORD_BASE_ATTACK_SPEED_MODIFIER);
        appendMainHandTooltip(tooltip, baseDamage, baseSpeed);
        super.appendHoverText(stack, context, tooltip, flag);
    }
}
