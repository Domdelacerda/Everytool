package com.zominique.everytool.item.custom.redstone;

import com.zominique.everytool.item.ModToolAttributes;
import com.zominique.everytool.item.ModToolTiers;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class RedstoneShovelItem extends ShovelItem implements IRedstoneTool {
    public RedstoneShovelItem(Item.Properties properties) {
        super(ModToolTiers.REDSTONE, properties.component(
                DataComponents.ATTRIBUTE_MODIFIERS,
                ModToolAttributes.hideDefaultTooltip(ModToolAttributes.shovel(ModToolTiers.REDSTONE).build())
        ));
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flag) {
        double baseDamage = ModToolAttributes.SHOVEL_BASE_DAMAGE + ModToolTiers.REDSTONE.getAttackDamageBonus();
        double baseSpeed = ModToolAttributes.effectiveAttackSpeed(ModToolAttributes.SHOVEL_BASE_ATTACK_SPEED_MODIFIER);
        appendMainHandTooltip(tooltip, baseDamage, baseSpeed);
        super.appendHoverText(stack, context, tooltip, flag);
    }
}
