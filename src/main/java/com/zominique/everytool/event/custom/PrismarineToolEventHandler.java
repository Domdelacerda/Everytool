package com.zominique.everytool.event.custom;

import com.zominique.everytool.Everytool;
import com.zominique.everytool.item.custom.prismarine.IPrismarineTool;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Everytool.MOD_ID)
public class PrismarineToolEventHandler {

    private static final ResourceLocation DAMAGE_BOOST_ID =
            ResourceLocation.fromNamespaceAndPath(Everytool.MOD_ID, "prismarine_submerged_damage");
    private static final ResourceLocation SPEED_BOOST_ID =
            ResourceLocation.fromNamespaceAndPath(Everytool.MOD_ID, "prismarine_submerged_attack_speed");
    private static final ResourceLocation MINING_EFFICIENCY_BOOST_ID =
            ResourceLocation.fromNamespaceAndPath(Everytool.MOD_ID, "prismarine_submerged_mining_efficiency");

    public static final float ATTACK_DAMAGE_BOOST = 3.0f;
    public static final float ATTACK_SPEED_BOOST = 0.5f;
    public static final float MINING_EFFICIENCY_BOOST = 5.0f;

    private static final AttributeModifier DAMAGE_MODIFIER =
            new AttributeModifier(DAMAGE_BOOST_ID, ATTACK_DAMAGE_BOOST, AttributeModifier.Operation.ADD_VALUE);
    private static final AttributeModifier SPEED_MODIFIER =
            new AttributeModifier(SPEED_BOOST_ID, ATTACK_SPEED_BOOST, AttributeModifier.Operation.ADD_VALUE);
    public static final AttributeModifier MINING_EFFICIENCY_MODIFIER =
            new AttributeModifier(MINING_EFFICIENCY_BOOST_ID, MINING_EFFICIENCY_BOOST, AttributeModifier.Operation.ADD_VALUE);

    @SubscribeEvent
    public static void onLivingTick(LivingEvent.LivingTickEvent event) {
        LivingEntity entity = event.getEntity();
        Level level = entity.level();
        BlockPos pos = BlockPos.containing(entity.position());
        ItemStack mainHand = entity.getMainHandItem();

        boolean shouldBoost = mainHand.getItem() instanceof IPrismarineTool && entity.isInWaterOrRain();

        toggle(entity.getAttribute(Attributes.ATTACK_DAMAGE), DAMAGE_MODIFIER, shouldBoost, level, pos);
        toggle(entity.getAttribute(Attributes.ATTACK_SPEED), SPEED_MODIFIER, shouldBoost, null, null);
        toggle(entity.getAttribute(Attributes.MINING_EFFICIENCY), MINING_EFFICIENCY_MODIFIER, shouldBoost, null, null);
    }

    private static void toggle(AttributeInstance attribute, AttributeModifier modifier, boolean shouldBeActive,
                               Level level, BlockPos pos) {
        if (attribute == null) {
            return;
        }

        boolean currentlyActive = attribute.getModifier(modifier.id()) != null;

        if (shouldBeActive && !currentlyActive) {
            attribute.addTransientModifier(modifier);
            if (level != null && pos != null) {
                level.playSound(null, pos, SoundEvents.CONDUIT_ACTIVATE,
                        SoundSource.PLAYERS, 1.0F, 1.0F);
            }
        } else if (!shouldBeActive && currentlyActive) {
            attribute.removeModifier(modifier.id());
            if (level != null && pos != null) {
                level.playSound(null, pos, SoundEvents.CONDUIT_DEACTIVATE,
                        SoundSource.PLAYERS, 1.0F, 1.0F);
            }
        }
    }
}
