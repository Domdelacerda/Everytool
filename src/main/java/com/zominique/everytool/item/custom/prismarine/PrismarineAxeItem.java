package com.zominique.everytool.item.custom.prismarine;

import com.zominique.everytool.item.ModToolTiers;
import com.zominique.everytool.item.ModToolAttributes;
import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

import static com.zominique.everytool.item.ModToolAttributes.MINING_SPEED_BOOST;
import static com.zominique.everytool.item.ModToolAttributes.SUBMERGED_MINING_ID;

public class PrismarineAxeItem extends AxeItem implements IPrismarineTool {
    private static final int BASE_DAMAGE = 6;

    public PrismarineAxeItem(Item.Properties properties) {
        super(ModToolTiers.PRISMARINE, properties.component(
                DataComponents.ATTRIBUTE_MODIFIERS,
                ModToolAttributes.hideDefaultTooltip(ModToolAttributes.axe(ModToolTiers.PRISMARINE, BASE_DAMAGE)
                        .add(
                                Attributes.SUBMERGED_MINING_SPEED,
                                new AttributeModifier(SUBMERGED_MINING_ID,
                                        MINING_SPEED_BOOST, AttributeModifier.Operation.ADD_VALUE),
                                EquipmentSlotGroup.MAINHAND
                        )
                        .build()
        )));
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flag) {
        double baseDamage = BASE_DAMAGE + ModToolTiers.PRISMARINE.getAttackDamageBonus();
        double baseSpeed = ModToolAttributes.effectiveAttackSpeed(ModToolAttributes.AXE_BASE_ATTACK_SPEED_MODIFIER);
        appendMainHandTooltip(tooltip, baseDamage, baseSpeed);

        // Also re-added by hand — showInTooltip=false above suppresses the
        // WHOLE attribute set's auto-rendering, not just attack damage/speed,
        // so the submerged mining speed line would otherwise vanish too.
        tooltip.add(Component.translatable("item.everytool.prismarine.submerged_mining", "+1.3")
                .withStyle(ChatFormatting.BLUE));

        super.appendHoverText(stack, context, tooltip, flag);
    }
}
