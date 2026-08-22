package com.zominique.everytool.item.custom.prismarine;

import com.zominique.everytool.event.custom.PrismarineToolEventHandler;
import com.zominique.everytool.event.custom.RedstoneToolEventHandler;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;

import java.util.List;

public interface IPrismarineTool {
    default void appendMainHandTooltip(List<Component> tooltip, double baseAttackDamage, double baseAttackSpeed) {
        tooltip.add(Component.translatable("item.modifiers.mainhand").withStyle(ChatFormatting.GRAY));
        tooltip.add(Component.translatable("item.everytool.prismarine.base_damage",
                        formatNumber((int) baseAttackDamage))
                .withStyle(ChatFormatting.DARK_GREEN));
        tooltip.add(Component.translatable("item.everytool.prismarine.base_speed",
                        formatNumber(baseAttackSpeed))
                .withStyle(ChatFormatting.DARK_GREEN));
        tooltip.add(Component.translatable("item.everytool.prismarine.submerged_damage",
                        formatSigned((int) PrismarineToolEventHandler.ATTACK_DAMAGE_BOOST))
                .withStyle(ChatFormatting.BLUE));
        tooltip.add(Component.translatable("item.everytool.prismarine.submerged_speed",
                        formatSigned(PrismarineToolEventHandler.ATTACK_SPEED_BOOST))
                .withStyle(ChatFormatting.BLUE));
        tooltip.add(Component.translatable("item.everytool.prismarine.submerged_efficiency",
                        formatSigned((int) PrismarineToolEventHandler.MINING_EFFICIENCY_BOOST))
                .withStyle(ChatFormatting.BLUE));
    }

    private static String formatNumber(double amount) {
        return String.format("%.1f", amount);
    }

    private static String formatNumber(int amount) {
        return String.format("%d", amount);
    }

    private static String formatSigned(double amount) {
        return (amount >= 0 ? "+" : "") + amount;
    }

    private static String formatSigned(int amount) {
        return (amount >= 0 ? "+" : "") + amount;
    }
}
