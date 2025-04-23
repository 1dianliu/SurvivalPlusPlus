package dev.anvilcraft.rg.survival.mixin;

import dev.anvilcraft.rg.survival.SurvivalPlusPlusServerRules;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Player.class)
public abstract class PlayerCreativeNoClipMixin {
    @Redirect(
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
    private boolean redirectAllSpectatorChecks(Player player) {
        return player.isSpectator() || (SurvivalPlusPlusServerRules.creativeNoClip && player.isCreative() && player.getAbilities().flying);
    }
}