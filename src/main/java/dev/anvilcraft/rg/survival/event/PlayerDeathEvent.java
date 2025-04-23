package dev.anvilcraft.rg.survival.event;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;

public class PlayerDeathEvent extends PlayerEvent {
    private final DamageSource cause;
    public PlayerDeathEvent(Player player, DamageSource cause) {
        super(player);
        this.cause = cause;
    }

    public DamageSource getCause() {
        return cause;
    }
}
