package fr.felixviart.thequakeisalie;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
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

public class ProjectileListener implements Listener {
    @EventHandler
    public void ArrowShootEvent(ProjectileHitEvent event){
        Entity entity = event.getEntity();
        //Si l'entité qui damage est une flèche
        if (event.getEntity() instanceof Arrow){
            Arrow arrow = (Arrow) entity;

            //Si l'entité qui a tirée la flèche est un joueur et qu'elle touche un autre entité
            if(arrow.getShooter() instanceof Player && event.getHitEntity() != null){
                Entity shooter = (Entity) arrow.getShooter();
                Player player = (Player) shooter;
                Location player_coords=player.getLocation();

                //Si le joueur a une houe en fer dans la main
                if(player.getInventory().getItemInMainHand().getType()==Material.IRON_HOE) {
                    player.playSound(player.getLocation(),Sound.ENTITY_ARROW_HIT_PLAYER,0.5f,1f);
                    //Bukkit.broadcastMessage("Entité touché par le joueur !");

                    /* Solution 1
                    Location arrow_loc=arrow.getLocation();
                    Vector arrow_loc_vec=arrow.getLocation().getDirection();
                    arrow.remove();
                    Projectile projectile=player.launchProjectile(Arrow.class,arrow_loc_vec);
                    projectile.setBounce(false);
                    projectile.teleport(arrow_loc);
                    projectile.setVelocity(arrow_loc_vec);
                     */

                    /* Solution 2
                    Location arrow_loc=arrow.getLocation();
                    arrow.remove();
                    double n_arrow_X=Math.cos(Math.toRadians(arrow_loc.getYaw()));
                    double n_arrow_Z=Math.sin(Math.toRadians(arrow_loc.getYaw()));

                    Vector arrowDir=new Vector(n_arrow_X,arrow_loc.getY(),n_arrow_Z);
                    Projectile projectile=player.launchProjectile(Arrow.class);
                    projectile.setVelocity(arrowDir);
                    projectile.teleport(arrow_loc);
                     */
                }
            }
        }
    }

    /*
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
