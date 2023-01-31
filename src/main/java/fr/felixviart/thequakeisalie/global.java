package fr.felixviart.thequakeisalie;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Projectile;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.Objects;

public class global {
    public static boolean isGhost=false;
    //public static Material current_projectile=Material.ARROW;
    public static Class current_projectile=Egg.class;

    public static Double deca_X=0.0;
    public static Double deca_Y=1.0;
    public static Double deca_Z=0.0;

    /*
    public static void checkGravity(String projectile) {
        switch (projectile) {
            case "dragonfireball":
            case "fireball":
            case "largefireball":
            case "llamaspit":
            case "shulkerbullet":
            case "smallfireball":
            case "witherskull":
                needs_gravity=true;
                break;
            default:
                needs_gravity=false;
        }
    }
    public static Boolean needs_gravity=false;

     */

    public static Double projectile_damage=5.0;
    public static Float projectile_rayon=3f;

    public static Inventory main_menu=Bukkit.createInventory(null,27,"Paramètres");

    public static void setMainMenu() {
        for(int i=0;i<=26;i++) {
            ItemStack target_item = null;
            String cutsom_name=null;

            switch (i) {
                case 10:
                    target_item=new ItemStack(Material.DIAMOND_SWORD);
                    cutsom_name="Dégats du projectile";
                    break;
                case 12:
                    target_item=new ItemStack(Material.BOW);
                    cutsom_name="Rayon du cercle";
                    break;
                case 14:
                    target_item=new ItemStack(Material.COMPASS);
                    cutsom_name="Direction du projectile";
                    break;
                case 16:
                    target_item=new ItemStack(Material.ARROW);
                    cutsom_name="Type de projectile";
                    break;
                default:
                    target_item=new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
                    cutsom_name="";
                    break;
            }

            if(i%2==0 && !target_item.equals(Material.BLACK_STAINED_GLASS_PANE)) {
                ItemMeta item_data=target_item.getItemMeta();
                item_data.setDisplayName(cutsom_name);
                target_item.setItemMeta(item_data);
            }

            main_menu.setItem(i,target_item);
        }
    }

    public static Vector rotateVectorY(Vector vector, double degrees) {
        double rad = Math.toRadians(degrees);

        double currentX = vector.getX();
        double currentZ = vector.getZ();

        double cosine = Math.cos(rad);
        double sine = Math.sin(rad);

        return new Vector((cosine * currentX - sine * currentZ), vector.getY(), (sine * currentX + cosine * currentZ));
    }

    public static void AddPasengerSafe(Projectile target,Entity passenger) {
        new BukkitRunnable() {
            @Override
            public void run() {
                target.addPassenger(passenger);
            }
        }.runTaskLater(Objects.requireNonNull(Bukkit.getPluginManager().getPlugin("TheQuakeIsALie")), 150);
    }
}
