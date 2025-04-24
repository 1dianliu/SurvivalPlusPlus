package dev.anvilcraft.rg.survival.event;

import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;

public class ModifyIsSpectatorEvent extends PlayerEvent {
    public ModifyIsSpectatorEvent(Player player) {
        super(player);
    }
}
