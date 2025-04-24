package dev.anvilcraft.rg.survival.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import dev.anvilcraft.rg.survival.SurvivalPlusPlusServerRules;
import dev.anvilcraft.rg.survival.event.ModifyIsSpectatorEvent;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.common.NeoForge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(Player.class)
abstract class PlayerMixin {
    @ModifyExpressionValue(
        method = {
            "tick()V",
            "aiStep()V",
            "updatePlayerPose()V"
        },
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/world/entity/player/Player;isSpectator()Z",
            ordinal = 0
        )
    )
    private boolean modifyIsSpectator(boolean original) {
        Player player = (Player) (Object) this;
        if (SurvivalPlusPlusServerRules.creativeNoClip && player.isCreative() && player.getAbilities().flying) {
            NeoForge.EVENT_BUS.post(new ModifyIsSpectatorEvent(player));
            return true;
        }
        return original;
    }
}