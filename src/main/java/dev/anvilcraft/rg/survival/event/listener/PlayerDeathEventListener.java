package dev.anvilcraft.rg.survival.event.listener;

import dev.anvilcraft.rg.RollingGate;
import dev.anvilcraft.rg.survival.SurvivalPlusPlusServerRules;
import dev.anvilcraft.rg.survival.event.PlayerDeathEvent;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.ClickEvent;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.HoverEvent;
import net.minecraft.network.chat.Style;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.players.PlayerList;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;

@EventBusSubscriber(modid = RollingGate.MODID)
public class PlayerDeathEventListener {
    @SubscribeEvent
    private static void onPlayerDeath(PlayerDeathEvent event) {
        if (!SurvivalPlusPlusServerRules.broadcastDeathPosition) return;
        Player entity = event.getEntity();
        if (!(entity instanceof ServerPlayer player)) return;
        MinecraftServer server = player.getServer();
        if (server == null) return;
        PlayerList playerList = server.getPlayerList();
        Component pos = Component.translatable(
            "broadcast_death_position.message.position",
            player.getOnPos().getX(),
            player.getOnPos().getY(),
            player.getOnPos().getZ()
        ).withStyle(
            Style.EMPTY
                .applyFormats(ChatFormatting.DARK_GREEN)
                .withHoverEvent(
                    new HoverEvent(
                        HoverEvent.Action.SHOW_TEXT,
                        Component.translatable("broadcast_death_position.message.position.hover")
                    )
                )
                .withClickEvent(
                    new ClickEvent(
                        ClickEvent.Action.COPY_TO_CLIPBOARD,
                        "[%s, %s, %s]".formatted(
                            player.getOnPos().getX(),
                            player.getOnPos().getY(),
                            player.getOnPos().getZ()
                        )
                    )
                )
        );
        Component component = Component.translatable("broadcast_death_position.message", player.getDisplayName(), pos);
        playerList.broadcastSystemMessage(component, false);
    }
}
