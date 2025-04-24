package dev.anvilcraft.rg.survival.mixin;

import dev.anvilcraft.rg.survival.SurvivalPlusPlusServerRules;
import dev.anvilcraft.rg.survival.event.GetPistonBehaviourEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.ShulkerBoxBlockEntity;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.neoforge.common.NeoForge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ShulkerBoxBlockEntity.class)
abstract class ShulkerBoxBlockEntityMixin {
    @Redirect(method = "moveCollidedEntities", at = @At(
        value = "INVOKE",


        target = "Lnet/minecraft/world/entity/Entity;getPistonPushReaction()Lnet/minecraft/world/level/material/PushReaction;"
    ))
    private PushReaction getPistonBehaviourOfNoClipPlayers(Entity entity) {
        if (SurvivalPlusPlusServerRules.creativeNoClip
            && entity instanceof Player
            && (((Player) entity).isCreative())
            && ((Player) entity).getAbilities().flying) {
            NeoForge.EVENT_BUS.post(new GetPistonBehaviourEvent((ShulkerBoxBlockEntity) (Object) this));
            return PushReaction.IGNORE;
        }
        return entity.getPistonPushReaction();
    }
}