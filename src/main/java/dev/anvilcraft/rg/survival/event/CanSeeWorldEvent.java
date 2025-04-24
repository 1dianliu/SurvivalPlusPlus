package dev.anvilcraft.rg.survival.event;

import net.minecraft.client.player.LocalPlayer;
import net.neoforged.bus.api.Event;

public class CanSeeWorldEvent extends Event {
    private final LocalPlayer clientPlayerEntity;

    public CanSeeWorldEvent(LocalPlayer clientPlayerEntity) {
        this.clientPlayerEntity = clientPlayerEntity;
    }

    public LocalPlayer getClientPlayerEntity() {
        return clientPlayerEntity;
    }
}
