package de.bywambo.chattodiscord;

import de.bywambo.chattodiscord.listener.ChatListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class ChatToDiscord extends JavaPlugin{

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new ChatListener(), this);
        Bukkit.getLogger().info("ChatToDiscord succeeded!");
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("ChatToDiscord shutdown!");
    }

}