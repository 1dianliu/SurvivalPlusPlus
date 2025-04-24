package dev.anvilcraft.rg.survival.event;

import net.minecraft.world.item.StandingAndWallBlockItem;
import net.neoforged.bus.api.Event;

public class CanCreativePlayerPlace extends Event {
    private final StandingAndWallBlockItem standingAndWallBlockItem;

    public CanCreativePlayerPlace(StandingAndWallBlockItem standingAndWallBlockItem) {
        this.standingAndWallBlockItem = standingAndWallBlockItem;
    }

    public StandingAndWallBlockItem getStandingAndWallBlockItem() {
        return standingAndWallBlockItem;
    }
}
