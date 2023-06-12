package de.bywambo.chattodiscord.models;

import java.net.URL;

/**
 * Editable Configuration object class, covering parts of config.yaml
 */
public class ConfigModel {

    private static boolean enabled = false;
    private static URL webhookURL = null;

    private ConfigModel() {
        throw new IllegalStateException("Utility class");
    }

    public static boolean isEnabled() {
        return enabled;
    }

    public static void setEnabled(boolean enabled) {
        ConfigModel.enabled = enabled;
    }

    public static URL getWebhookURL() {
        return webhookURL;
    }

    public static void setWebhookURL(URL webhookURL) {
        ConfigModel.webhookURL = webhookURL;
    }
}
