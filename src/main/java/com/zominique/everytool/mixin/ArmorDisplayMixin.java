package com.zominique.everytool.mixin;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;

@Mixin(Gui.class)
public class ArmorDisplayMixin {
    @Inject(
            method = "renderArmor",
            at = @At("TAIL")
    )
    private static void renderCorrodedArmor(GuiGraphics pGuiGraphics, Player pPlayer, int pY, int pHeartRows, int pHeight, int pX) {
        System.out.println("Rendering Corroded Armor Points...");
    }
}
