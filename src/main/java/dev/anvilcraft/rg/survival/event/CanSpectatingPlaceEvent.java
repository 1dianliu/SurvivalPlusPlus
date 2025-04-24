package dev.anvilcraft.rg.survival.event;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.Event;

public class CanSpectatingPlaceEvent extends Event {
    private final Item blockItem;

    public CanSpectatingPlaceEvent(Item blockItem) {
        this.blockItem = blockItem;
    }

    public Item getBlockItem() {
        return blockItem;
    }
}
