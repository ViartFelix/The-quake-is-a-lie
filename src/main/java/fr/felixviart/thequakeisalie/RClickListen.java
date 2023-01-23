package fr.felixviart.thequakeisalie;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.util.Vector;

public class RClickListen implements Listener {
    @EventHandler
    public void onPlayerInteractEvent(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        Material item_held=player.getInventory().getItemInMainHand().getType();

        if((e.getAction() == Action.RIGHT_CLICK_AIR) | (e.getAction() == Action.RIGHT_CLICK_BLOCK) && e.getHand()==EquipmentSlot.HAND && (item_held==Material.IRON_HOE)) {
            Location player_coords=e.getPlayer().getLocation();

            //player_coords retourne XYZ mais aussi les params "pitch" et "yaw", ça correspond à l'angle de vue. L'angle de vue est en deg.
            //Bukkit.broadcastMessage("Player @ "+player_coords);

            Entity fired_projectile=player.getWorld().spawnEntity(player_coords.add(new Location(player.getWorld(),0,1.5,0)),EntityType.ARROW);
            fired_projectile.setVelocity(player.getLocation().getDirection().multiply(3));


        }
    }
}