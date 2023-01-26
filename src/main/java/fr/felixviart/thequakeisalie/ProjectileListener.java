package fr.felixviart.thequakeisalie;

import org.bukkit.*;
import org.bukkit.block.Block;
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

                    //Si le joueur a une houe en fer dans la main
                    if(player.getInventory().getItemInMainHand().getType()==Material.IRON_HOE) {
                        player.playSound(player.getLocation(),Sound.ENTITY_ARROW_HIT_PLAYER,0.5f,1f);

                        Location arrow_loc=arrow.getLocation();
                        arrow.remove();

                        Projectile projectile=player.launchProjectile(Arrow.class);
                        projectile.setVelocity(arrow.getVelocity().normalize().multiply(2));
                        projectile.teleport(arrow_loc.add(arrow.getVelocity().normalize().multiply(3)));

                        /*
                            @Source: https://www.spigotmc.org/threads/snowball-that-pass-through-person.35676/
                         */

                        /* Première soluce qui marche
                        world.spawnArrow(arrow.getLocation().add(arrow.getVelocity().normalize().multiply(2)),arrow.getVelocity(),2f,12f);
                        arrow.setShooter(player);
                        */

                    }
                } else if (event.getHitEntity() == null && global.isGhost) {
                    Player shooter = (Player) arrow.getShooter();
                    shooter.playSound(shooter.getLocation(),Sound.ENTITY_ENDERMAN_TELEPORT,0.5f,0.5f);

                    Location arrow_loc=arrow.getLocation();
                    Location shooter_locs=shooter.getLocation();

                    arrow.setGravity(false);
                    arrow.remove();

                    //Pour éviter que la flèche ne se téléporte constament quand elle tombe
                    if(shooter_locs.getY()<arrow_loc.getY()+7) {
                        Projectile projectile=shooter.launchProjectile(Arrow.class);
                        projectile.setVelocity(arrow.getVelocity().normalize().multiply(3));

                        double velo_multiplier = 1;
                        double precision=0.1;
                        Vector dir = arrow.getVelocity();

                        //Tant que le prochian block n'est pas de l'air et si le prochain block n'est pas de l'air
                        while (!arrow_loc.add(dir).getBlock().getType().equals(Material.AIR)) {
                            velo_multiplier+=precision;
                        }

                        projectile.teleport(arrow_loc.add(arrow.getVelocity().normalize().multiply(velo_multiplier)));
                    }
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