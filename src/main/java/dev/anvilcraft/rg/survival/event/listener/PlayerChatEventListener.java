package dev.anvilcraft.rg.survival.event.listener;

import dev.anvilcraft.rg.RollingGate;
import dev.anvilcraft.rg.api.event.ServerPlayerChatEvent;
import dev.anvilcraft.rg.survival.SurvivalPlusPlusServerRules;
import dev.anvilcraft.rg.survival.util.SimpleInGameCalculator;
import dev.anvilcraft.rg.tools.TriConsumer;
import net.minecraft.network.chat.Component;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import org.jetbrains.annotations.NotNull;

@EventBusSubscriber(modid = RollingGate.MODID)
public class PlayerChatEventListener {
    @SubscribeEvent
    public static void onPlayerChat(@NotNull ServerPlayerChatEvent event) {
        ServerPlayer player = event.getEntity();
        Component component = event.getComponent();
        PlayerChatEventListener.handleChat(
            SurvivalPlusPlusServerRules.simpleInGameCalculator,
            "=",
            player,
            component,
            SimpleInGameCalculator::handleChat
        );
    }

    private static void handleChat(
        boolean rule,
        @SuppressWarnings("SameParameterValue") String prefix,
        ServerPlayer player,
        Component component,
        TriConsumer<MinecraftServer, ServerPlayer, String> handle
    ) {
        if (!rule) return;
        String string = component.getString();
        if (!string.startsWith(prefix)) return;
        string = string.substring(prefix.length());
        MinecraftServer server = player.getServer();
        handle.accept(server, player, string);
    }
}
