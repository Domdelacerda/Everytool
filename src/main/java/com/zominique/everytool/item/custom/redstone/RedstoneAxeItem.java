package com.zominique.everytool.item.custom.redstone;

import com.zominique.everytool.item.ModToolAttributes;
import com.zominique.everytool.item.ModToolTiers;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class RedstoneAxeItem extends AxeItem implements IRedstoneTool {
    private static final int BASE_DAMAGE = 5;

    public RedstoneAxeItem(Item.Properties properties) {
        super(ModToolTiers.REDSTONE, properties.component(
                DataComponents.ATTRIBUTE_MODIFIERS,
                ModToolAttributes.hideDefaultTooltip(ModToolAttributes.axe(ModToolTiers.REDSTONE, BASE_DAMAGE).build())
        ));
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flag) {
        double baseDamage = BASE_DAMAGE + ModToolTiers.REDSTONE.getAttackDamageBonus();
        double baseSpeed = ModToolAttributes.effectiveAttackSpeed(ModToolAttributes.AXE_BASE_ATTACK_SPEED_MODIFIER);
        appendMainHandTooltip(tooltip, baseDamage, baseSpeed);
        super.appendHoverText(stack, context, tooltip, flag);
    }
}
