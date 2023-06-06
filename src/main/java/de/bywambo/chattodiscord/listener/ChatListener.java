package de.bywambo.chattodiscord.listener;

import de.bywambo.chattodiscord.config.Config;
import de.bywambo.chattodiscord.utils.Connector;
import de.bywambo.chattodiscord.utils.MessageBuilder;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

    // Still wondering if this is a good idea
    @EventHandler (priority = EventPriority.MONITOR)
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        // If the config is turned off then we don't do anything
        if (!Config.isEnabled()) {
            return;
        }

        // if event is null, tell the admins and return
        if (event == null) {
            Bukkit.getLogger().info("Couldn't send message to Discord due to event being null!");
            return;
        }
        // Gets the player who wrote a message
        Player player = event.getPlayer();
        // Content of the message
        String message = event.getMessage();

        Connector.sendToWebhook(Config.getWebhookURL(), MessageBuilder.buildPlainChatMessage(player, message));

    }

}
