package de.bywambo.chattodiscord;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class ChatToDiscord extends JavaPlugin{

    @Override
    public void onEnable() {
        Bukkit.getLogger().info("ChatToDiscord succeeded!");
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("ChatToDiscord shutdown!");
    }

}