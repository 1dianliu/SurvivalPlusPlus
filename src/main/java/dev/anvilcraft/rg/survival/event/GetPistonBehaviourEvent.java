package dev.anvilcraft.rg.survival.event;

import net.minecraft.world.level.block.entity.ShulkerBoxBlockEntity;
import net.neoforged.bus.api.Event;

public class GetPistonBehaviourEvent extends Event {
    private final ShulkerBoxBlockEntity shulkerBoxBlockEntity;

    public GetPistonBehaviourEvent(ShulkerBoxBlockEntity shulkerBoxBlockEntity) {
        this.shulkerBoxBlockEntity = shulkerBoxBlockEntity;
    }

    public ShulkerBoxBlockEntity getShulkerBoxBlockEntity() {
        return shulkerBoxBlockEntity;
    }
}
