package com.zominique.everytool.item.custom;

import com.zominique.everytool.item.ModToolTiers;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.context.UseOnContext;

public class CoalPickaxeItem extends PickaxeItem implements ICoalTool {
    public CoalPickaxeItem(Item.Properties properties) {
        super(ModToolTiers.COAL, properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        InteractionResult ignite = tryIgnite(context);
        if (ignite != InteractionResult.PASS) {
            return ignite;
        }
        return super.useOn(context);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        applyIgniteOnHit(stack, target, attacker);
        return super.hurtEnemy(stack, target, attacker);
    }
}
