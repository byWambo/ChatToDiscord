package de.bywambo.chattodiscord;

import de.bywambo.chattodiscord.models.ConfigModel;
import de.bywambo.chattodiscord.listener.ChatListener;
import de.bywambo.chattodiscord.utils.UpdateChecker;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

public class ChatToDiscord extends JavaPlugin {

    FileConfiguration config = getConfig();

    @Override
    public void onEnable() {
        // Sets up the config.yml and the static Config class
        // If it fails to load, the plugin disables itself.
        if (!setupConfig())
            return;

        try {
            UpdateChecker.checkForUpdate(Float.valueOf(this.getDescription().getVersion()));
        } catch (IOException e) {
            Bukkit.getLogger().info("Couldn't check version on GitHub. Please check your internet connection");
        }

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
            ConfigModel.setEnabled(config.getBoolean("enabled"));
            ConfigModel.setWebhookURL(new URL(config.getString("webhookURL")));
            List<Map<?, ?>> test = config.getMapList("embed");
            Bukkit.getLogger().info(String.valueOf(test.size()));

            return true;
        } catch (MalformedURLException e) {
            // Evaluate logging '[ERROR]' before the string here
            Bukkit.getLogger().log(Level.SEVERE, "[ERROR] webhookURL in plugin.yml is malformed! Please change the URL!");
            getServer().getPluginManager().disablePlugin(this);
            return false;
        }

    }

}