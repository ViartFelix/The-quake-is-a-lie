package fr.felixviart.thequakeisalie;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;


public class RClickListen implements Listener {
    @EventHandler
    public void onPlayerInteractEvent(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        Material item_held=player.getInventory().getItemInMainHand().getType();

        if((e.getAction() == Action.RIGHT_CLICK_AIR) | (e.getAction() == Action.RIGHT_CLICK_BLOCK) && e.getHand()==EquipmentSlot.HAND) {

            switch (item_held) {
                case IRON_HOE:
                    Location player_coords=e.getPlayer().getLocation();

                    //Entity fired_projectile=player.getWorld().spawnEntity(player_coords.add(new Location(player.getWorld(),0,1.5,0)),EntityType.ARROW);
                    //fired_projectile.setVelocity(player.getLocation().getDirection().multiply(3));

                    Projectile projectile=player.launchProjectile(Arrow.class);
                    projectile.setVelocity(player.getLocation().getDirection().multiply(3));
                    projectile.setBounce(false);
                    player.playSound(player_coords, Sound.ENTITY_ARROW_SHOOT,0.5f,1f);
                    break;
                case MAGMA_CREAM:
                case SLIME_BALL:
                    global.isGhost=!global.isGhost;

                    if(global.isGhost) {
                        player.getInventory().setItemInMainHand(new ItemStack(Material.SLIME_BALL));
                    } else {
                        player.getInventory().setItemInMainHand(new ItemStack(Material.MAGMA_CREAM));
                    }
                    break;
                case NETHER_STAR:
                    player.openInventory(global.main_menu);
            }
        }
    }
}

