package me.cosmicdev.aimoderator;

import me.cosmicdev.aimoderator.events.PlayerMessageHandler;
import org.bukkit.plugin.java.JavaPlugin;

public final class AIModerator extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new PlayerMessageHandler(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
