package dev.anvilcraft.rg.survival.mixin;

import dev.anvilcraft.rg.survival.SurvivalPlusPlusServerRules;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.LevelRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(LevelRenderer.class)
public class LevelRendererCreativeNoClipMixin {
    @Redirect(method = "renderLevel", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/player/LocalPlayer;isSpectator()Z"))
    private boolean canSeeWorld(LocalPlayer clientPlayerEntity) {
        return clientPlayerEntity.isSpectator() || (SurvivalPlusPlusServerRules.creativeNoClip && clientPlayerEntity.isCreative());
    }

}