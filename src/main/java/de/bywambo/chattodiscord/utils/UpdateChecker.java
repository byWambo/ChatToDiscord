package de.bywambo.chattodiscord.utils;

import org.bukkit.Bukkit;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.SafeConstructor;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class UpdateChecker {
    public static void checkForUpdate(String version) throws IOException {

        Bukkit.getLogger().info("Checking for update");

        Yaml yaml = new Yaml(new SafeConstructor());
        // link to the master branch
        URL url = new URL("https://raw.githubusercontent.com/byWambo/ChatToDiscord/master/src/plugin.yml");
        HttpURLConnection postConnection = (HttpURLConnection) url.openConnection();
        postConnection.setRequestMethod("GET");

        // this looks so shitty imo
        Map<String, Object> obj = (Map<String, Object>) yaml.load(postConnection.getInputStream());

        String remoteVersion = obj.get("version").toString();

        if (!remoteVersion.equals(version)) {
            Bukkit.getLogger().info(
                    String.format("A new version for ChatToDiscord is available! (%s) " +
                            "Download it here: https://github.com/byWambo/ChatToDiscord", remoteVersion)
            );
        }
    }
}
