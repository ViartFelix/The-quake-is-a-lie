package fr.felixviart.thequakeisalie;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class ProjectileHitEntity implements Listener {
    @EventHandler
    public void EntityDamageByEntityEvent(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Projectile) {
            Projectile arrow = (Projectile) event.getDamager();

            if(arrow.getShooter() instanceof Player) {
                Entity shooter = (Entity) arrow.getShooter();
                Player player = (Player) shooter;

                    player.playSound(player.getLocation(), Sound.ENTITY_ARROW_HIT_PLAYER,0.5f,1f);

                    event.setDamage(global.projectile_damage);
                    Location arrow_loc=arrow.getLocation();

                    arrow.remove();

                    Projectile projectile=player.launchProjectile(global.current_projectile);
                    projectile.setVelocity(arrow.getVelocity().normalize().multiply(global.projectile_rayon*0.90));
                    projectile.teleport(arrow_loc.add(arrow.getVelocity().normalize().multiply(5))); //Default: 3
            }

        }


/*
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
}
