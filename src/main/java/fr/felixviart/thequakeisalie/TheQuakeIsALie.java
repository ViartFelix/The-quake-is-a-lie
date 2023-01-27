package fr.felixviart.thequakeisalie;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public final class TheQuakeIsALie extends JavaPlugin {
    @Override
    public void onEnable() {
        //Ajout des Listeners
        getLogger().info("onEnable is called!");
        getServer().getPluginManager().registerEvents(new RClickListen(), this);
        getServer().getPluginManager().registerEvents(new ProjectileListener(), this);
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
