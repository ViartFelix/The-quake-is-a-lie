package fr.felixviart.thequakeisalie;

import org.bukkit.plugin.java.JavaPlugin;

public final class TheQuakeIsALie extends JavaPlugin {
    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("onEnable is called!");
        getServer().getPluginManager().registerEvents(new RClickListen(), this);
        getServer().getPluginManager().registerEvents(new ProjectileListener(), this);
    }
    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("onDisable is called!");
    }
}
