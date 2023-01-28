package fr.felixviart.thequakeisalie;

import org.bukkit.plugin.java.JavaPlugin;

public final class TheQuakeIsALie extends JavaPlugin {
    @Override
    public void onEnable() {
        //Ajout des Listeners
        getLogger().info("onEnable is called!");
        getServer().getPluginManager().registerEvents(new RClickListen(), this);
        getServer().getPluginManager().registerEvents(new ProjectileHitBlock(), this);
        getServer().getPluginManager().registerEvents(new ProjectileHitEntity(),this);
        getServer().getPluginManager().registerEvents(new playerJoinsInvSet(), this);

        //Setups des menus
        global.setMainMenu();

        this.getCommand("quake").setExecutor(new CustomCommands());

    }
    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("onDisable is called!");
    }
}
