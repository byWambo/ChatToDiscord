package de.bywambo.chattodiscord.utils;

import de.bywambo.chattodiscord.models.PluginModel;
import org.bukkit.Bukkit;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;

public class UpdateChecker {

    private UpdateChecker() {
        throw new IllegalStateException("Utility class");
    }

    public static void checkForUpdate(String version) throws IOException {

        Bukkit.getLogger().info("Checking for update");

        Yaml yaml = new Yaml(new Constructor(PluginModel.class));
        // link to the master branch
        URL url = new URL("https://raw.githubusercontent.com/byWambo/ChatToDiscord/master/src/plugin.yml");
        HttpURLConnection postConnection = (HttpURLConnection) url.openConnection();
        postConnection.setRequestMethod("GET");

        PluginModel pluginConfigMap = (PluginModel) yaml.load(postConnection.getInputStream());
        String remoteVersion = pluginConfigMap.getVersion();

        if (!remoteVersion.equals(version)) {
            String message = String.format("A new version for ChatToDiscord is available! (%s) " +
                    "Download it here: https://github.com/byWambo/ChatToDiscord", remoteVersion);
            Bukkit.getLogger().log(Level.INFO, message);
        }
    }
}
