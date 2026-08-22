package com.zominique.everytool.item.custom.prismarine;

import com.zominique.everytool.item.ModToolTiers;
import com.zominique.everytool.item.ModToolAttributes;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

import static com.zominique.everytool.item.ModToolAttributes.*;

public class PrismarineHoeItem extends HoeItem implements IPrismarineTool {
    public PrismarineHoeItem(Item.Properties properties) {
        super(ModToolTiers.PRISMARINE, properties.component(
                DataComponents.ATTRIBUTE_MODIFIERS,
                ModToolAttributes.hideDefaultTooltip(ModToolAttributes.toolBase(ModToolTiers.PRISMARINE,
                                HOE_BASE_DAMAGE, HOE_BASE_ATTACK_SPEED_MODIFIER).build()
        )));
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flag) {
        int baseDamage = (int) (ModToolAttributes.HOE_BASE_DAMAGE + ModToolTiers.PRISMARINE.getAttackDamageBonus() + 1);
        double baseSpeed = ModToolAttributes.effectiveAttackSpeed(ModToolAttributes.HOE_BASE_ATTACK_SPEED_MODIFIER);
        appendMainHandTooltip(tooltip, baseDamage, baseSpeed);
        super.appendHoverText(stack, context, tooltip, flag);
    }
}
