package com.zominique.everytool.item.custom.prismarine;

import com.zominique.everytool.item.ModToolTiers;
import com.zominique.everytool.item.ModToolAttributes;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class PrismarineShovelItem extends ShovelItem implements IPrismarineTool {
    public PrismarineShovelItem(Item.Properties properties) {
        super(ModToolTiers.PRISMARINE, properties.component(
                DataComponents.ATTRIBUTE_MODIFIERS,
                ModToolAttributes.hideDefaultTooltip(ModToolAttributes.shovel(ModToolTiers.PRISMARINE).build()
        )));
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flag) {
        int baseDamage = (int) (ModToolAttributes.SHOVEL_BASE_DAMAGE + ModToolTiers.PRISMARINE.getAttackDamageBonus() + 1);
        double baseSpeed = ModToolAttributes.effectiveAttackSpeed(ModToolAttributes.SHOVEL_BASE_ATTACK_SPEED_MODIFIER);
        appendMainHandTooltip(tooltip, baseDamage, baseSpeed);
        super.appendHoverText(stack, context, tooltip, flag);
    }
}
