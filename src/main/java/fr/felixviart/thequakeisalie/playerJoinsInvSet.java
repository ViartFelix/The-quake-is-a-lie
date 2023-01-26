package fr.felixviart.thequakeisalie;


import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public class playerJoinsInvSet implements Listener {
    @EventHandler
    public void onPlayerJoins(PlayerJoinEvent event) {
        Player p=event.getPlayer();
        p.getInventory().clear();
        p.getInventory().setItem(0,new ItemStack(Material.IRON_HOE));
        p.getInventory().setItem(7, new ItemStack(Material.MAGMA_CREAM));
        p.getInventory().setItem(8,new ItemStack(Material.NETHER_STAR));
        //p.getInventory().getItem(8).addEnchantment(Enchantment.DIG_SPEED,1);
    }
}
