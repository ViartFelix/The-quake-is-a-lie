package fr.felixviart.thequakeisalie;

import org.bukkit.*;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.util.Vector;

import java.lang.reflect.Array;
import java.util.Optional;

public class ProjectileListener implements Listener {
    @EventHandler
    public void ArrowShootEvent(ProjectileHitEvent event) {
        Entity entity = event.getEntity();
        //Si l'entité qui damage est une flèche
        if (event.getEntity() instanceof Arrow){
            Arrow arrow = (Arrow) entity;

            //Si l'entité qui a tirée la flèche est un joueur et qu'elle touche un autre entité
            if(arrow.getShooter() instanceof Player){
                if(event.getHitEntity() != null) {
                    Entity shooter = (Entity) arrow.getShooter();
                    Player player = (Player) shooter;
                    Location player_coords=player.getLocation();

                    //Si le joueur a une houe en fer dans la main
                    if(player.getInventory().getItemInMainHand().getType()==Material.IRON_HOE) {
                        player.playSound(player.getLocation(),Sound.ENTITY_ARROW_HIT_PLAYER,0.5f,1f);

                        World world=player.getWorld();
                        Location arrow_loc=arrow.getLocation();
                        arrow.remove();

                        Projectile projectile=player.launchProjectile(Arrow.class);
                        projectile.setVelocity(arrow.getVelocity().normalize().multiply(2));
                        projectile.teleport(arrow_loc.add(arrow.getVelocity().normalize().multiply(3)));

                        /*
                        world.spawnArrow(arrow.getLocation().add(arrow.getVelocity().normalize().multiply(2)),arrow.getVelocity(),2f,12f);
                        arrow.setShooter(player);
                        */

                    }
                } else if (event.getHitEntity() == null) {
                    Bukkit.broadcastMessage("Tentative traverser block");
                        /*
                        Location arrow_loc=arrow.getLocation();

                        Double final_x=arrow_loc.getX();
                        Double final_y;
                        Double final_z=arrow_loc.getZ();

                        BlockFace arrow_facing=arrow.getFacing();

                        Location block_hit=arrow.getLocation().getBlock().getLocation();

                        switch (arrow_facing) {
                            case EAST:
                                final_x=arrow_loc.getX()+shooted.getBoundingBox().getWidthX()+0.25f;
                                break;
                            case WEST:
                                final_x=arrow_loc.getX()-shooted.getBoundingBox().getWidthX()-0.25f;
                                break;
                            case NORTH:
                                final_z=arrow_loc.getZ()-shooted.getBoundingBox().getWidthZ()-0.25f;
                                break;
                            case SOUTH:
                                final_z=arrow_loc.getZ()+shooted.getBoundingBox().getWidthZ()+0.25f;
                                break;
                        }

                         */
                }
            }
        }
    }

    /* Pour après
    @EventHandler
    public void EntityDamageByEntityEvent(EntityDamageByEntityEvent event) {

        Entity entity=e.getEntity();
        if(e.getDamager() instanceof Projectile) {
            Entity player=e.getDamager();
        } else {
            Bukkit.broadcastMessage("Entity damaged by other entity");
        }

        Bukkit.broadcastMessage(e.getDamager().toString());
        Entity entity = event.getEntity();
        if (event.getEntity() instanceof Arrow){
            Arrow arrow = (Arrow) entity;
            if(arrow.getShooter() instanceof Player && event.getEntity() != null){
                Entity shooter = (Entity) arrow.getShooter();
                Player player = (Player) shooter;
                player.playSound(player.getLocation(),Sound.ENTITY_ARROW_HIT_PLAYER,0.5f,1f);
                Bukkit.broadcastMessage("Entité touché par le joueur !");
            }
        }
    }
    */

}
