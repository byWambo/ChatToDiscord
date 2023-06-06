package de.bywambo.chattodiscord.config;

import java.net.URL;

/**
 * Editable Configuration object class, covering parts of config.yaml
 */
public class Config {

    private Config() {
        throw new IllegalStateException("Utility class");
    }

    private static boolean enabled = false;
    private static URL webhookURL = null;

    public static boolean isEnabled() {
        return enabled;
    }

    public static void setEnabled(boolean enabled) {
        Config.enabled = enabled;
    }

    public static URL getWebhookURL() {
        return webhookURL;
    }

    public static void setWebhookURL(URL webhookURL) {
        Config.webhookURL = webhookURL;
    }
}
