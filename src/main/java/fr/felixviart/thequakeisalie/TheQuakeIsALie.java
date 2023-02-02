package fr.felixviart.thequakeisalie;

import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Handler;

public final class TheQuakeIsALie extends JavaPlugin {
    @Override
    public void onEnable() {
        //Ajout des Listeners
        getServer().getPluginManager().registerEvents(new RClickListen(), this);
        getServer().getPluginManager().registerEvents(new ProjectileHitBlock(), this);
        getServer().getPluginManager().registerEvents(new ProjectileHitEntity(),this);
        getServer().getPluginManager().registerEvents(new playerJoinsInvSet(), this);
        getServer().getPluginManager().registerEvents(new MenuInteractions(), this);

        //Setups des menus
        global.setMainMenu();
        global.setDmgMenu();
        global.setRayonMenu();
        global.setProjectileMenu();

        //Setup des commandes
        this.getCommand("quake").setExecutor(new CustomCommands());

    }
    @Override
    public void onDisable() {
        HandlerList.unregisterAll();
    }
}
