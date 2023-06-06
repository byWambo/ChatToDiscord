package de.bywambo.chattodiscord.utils;

import org.bukkit.entity.Player;
import org.json.simple.JSONObject;

public class MessageBuilder {

    private MessageBuilder() {
        throw new IllegalStateException("Utility class");
    }

    public static String buildPlainChatMessage(Player player, String message) {
        JSONObject json = new JSONObject();

        json.put("content", String.format("[%s] %s", player.getDisplayName(), message));

        return json.toString();
    }
}
