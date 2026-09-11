package com.zominique.everytool.mixin;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.entity.player.Player;
import com.zominique.everytool.Everytool;
import com.zominique.everytool.effect.ModEffects;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Gui.class)
public class ArmorDisplayMixin {
    private static final int CORROSION_ASMOR_REDUCTION = 4;
    private static final int MAX_ARMOR_POINTS = 20;
    private static final int ARMOR_ICONS = 10;
    private static final int ARMOR_ICON_SIZE = 9;

    @Inject(
            method = "renderArmor",
            at = @At("TAIL")
    )
    private static void renderCorrodedArmor(GuiGraphics pGuiGraphics, Player pPlayer, int pY, int pHeartRows, int pHeight, int pX, CallbackInfo ci) {
        if (pPlayer == null) return;

        MobEffectInstance corrosion = pPlayer.getEffect(ModEffects.CORROSION.getHolder().get());
        if (corrosion == null) return;

        int amplifier = corrosion.getAmplifier();
        int corrosionPoints = CORROSION_ASMOR_REDUCTION * (amplifier + 1);

        int pristineArmor = pPlayer.getArmorValue();
        int totalArmor = pristineArmor + Math.min(pristineArmor, corrosionPoints);
        if (totalArmor == 0) return;
        totalArmor = Math.min(totalArmor, MAX_ARMOR_POINTS);

        int yPos = pY - (pHeartRows - 1) * pHeight - (ARMOR_ICON_SIZE + 1);

        ResourceLocation corrodedFull = ResourceLocation.fromNamespaceAndPath(Everytool.MOD_ID, "textures/gui/sprites/hud/armor_corroded.png");
        ResourceLocation corrodedHalf = ResourceLocation.fromNamespaceAndPath(Everytool.MOD_ID, "textures/gui/sprites/hud/armor_half_corroded_half_empty.png");
        ResourceLocation pristineHalf = ResourceLocation.fromNamespaceAndPath(Everytool.MOD_ID, "textures/gui/sprites/hud/armor_half_pristine_half_corroded.png");

        RenderSystem.enableBlend();
        for (int iconIndex = 0; iconIndex < ARMOR_ICONS; iconIndex++) {
            int xPos = pX + iconIndex * (ARMOR_ICON_SIZE - 1);
            int iconValue = iconIndex * 2 + 1;

            if (iconValue >= pristineArmor && iconValue <= totalArmor) {
                if (iconValue == pristineArmor && (totalArmor % 2 == 1)) {
                    pGuiGraphics.blit(pristineHalf, xPos, yPos, 0, 0,
                            ARMOR_ICON_SIZE, ARMOR_ICON_SIZE, ARMOR_ICON_SIZE, ARMOR_ICON_SIZE);
                } else if (iconValue == totalArmor && (totalArmor % 2 == 1)) {
                    pGuiGraphics.blit(corrodedHalf, xPos, yPos, 0, 0,
                            ARMOR_ICON_SIZE, ARMOR_ICON_SIZE, ARMOR_ICON_SIZE, ARMOR_ICON_SIZE);
                } else {
                    pGuiGraphics.blit(corrodedFull, xPos, yPos, 0, 0,
                            ARMOR_ICON_SIZE, ARMOR_ICON_SIZE, ARMOR_ICON_SIZE, ARMOR_ICON_SIZE);
                }
            }
        }
        RenderSystem.disableBlend();
    }
}
