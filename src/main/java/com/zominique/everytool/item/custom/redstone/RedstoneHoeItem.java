package com.zominique.everytool.item.custom.redstone;

import com.zominique.everytool.item.ModToolAttributes;
import com.zominique.everytool.item.ModToolTiers;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

import static com.zominique.everytool.item.ModToolAttributes.HOE_BASE_ATTACK_SPEED_MODIFIER;
import static com.zominique.everytool.item.ModToolAttributes.HOE_BASE_DAMAGE;

public class RedstoneHoeItem extends HoeItem implements IRedstoneTool {
    public RedstoneHoeItem(Item.Properties properties) {
        super(ModToolTiers.REDSTONE, properties.component(
                DataComponents.ATTRIBUTE_MODIFIERS,
                ModToolAttributes.hideDefaultTooltip(ModToolAttributes.toolBase(ModToolTiers.REDSTONE,
                        HOE_BASE_DAMAGE, HOE_BASE_ATTACK_SPEED_MODIFIER).build())
        ));
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flag) {
        int baseDamage = (int) (HOE_BASE_DAMAGE + ModToolTiers.REDSTONE.getAttackDamageBonus() + 1);
        double baseSpeed = ModToolAttributes.effectiveAttackSpeed(HOE_BASE_ATTACK_SPEED_MODIFIER);
        appendMainHandTooltip(tooltip, baseDamage, baseSpeed);
        super.appendHoverText(stack, context, tooltip, flag);
    }
}
