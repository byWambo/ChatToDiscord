package de.bywambo.chattodiscord;

import de.bywambo.chattodiscord.listener.ChatListener;
import de.bywambo.chattodiscord.utils.Config;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ChatToDiscord extends JavaPlugin{

    FileConfiguration config = getConfig();

    @Override
    public void onEnable() {
        // Sets up the config.yml and the static Config class
        // If it fails to load, the plugin disables itself.
        if (!setupConfig())
            return;
        // Registers the ChatListener
        getServer().getPluginManager().registerEvents(new ChatListener(), this);

        Bukkit.getLogger().info("ChatToDiscord succeeded!");
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("ChatToDiscord shutdown!");
    }

    private boolean setupConfig() {
        config.options().copyDefaults(true);
        saveConfig();

        try {
            Config.Enabled = config.getBoolean("enabled");
            Config.WebhookURL = new URL(config.getString("webhookURL"));
            List<Map<?, ?>> test = config.getMapList("embed");
            Bukkit.getLogger().info(String.valueOf(test.size()));

            return true;
        } catch (MalformedURLException e) {
            Bukkit.getLogger().info("[ERROR] webhookURL in plugin.yml is malformed! Please change the URL");
            getServer().getPluginManager().disablePlugin(this);
            return false;
        }

    }

}