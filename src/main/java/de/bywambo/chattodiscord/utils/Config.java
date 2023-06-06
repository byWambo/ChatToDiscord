package de.bywambo.chattodiscord.utils;

import java.net.URL;

public class Config {

    private Config() {
        throw new IllegalStateException("Utility class");
    }

    public static boolean Enabled = false;
    public static URL WebhookURL = null;

}
