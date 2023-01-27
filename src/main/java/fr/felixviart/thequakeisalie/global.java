package fr.felixviart.thequakeisalie;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class global {
    public static boolean isGhost=false;
    public static Material current_projecile=Material.ARROW;
    public static Integer projectile_damage=5;
    public static Float projectile_rayon=3f;

    public static Material[] possible_projectiles = new Material[]{
            Material.ARROW,
            Material.SNOWBALL,
            Material.EGG,
            Material.ENDER_PEARL,
            Material.ENDER_EYE,
    };
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

    /*
    4 trucs changeables par les menus:
        - Rayon du cercle (la force du du projectile)
        - Le nombre de dégâts du projectile
        - Le type de projectile
        - Direction et trajectoire du projectile
     */

    /*
    Faire le contenu des menus ici
     */

    /*
    Faire une fonction setProjectile qui vas set le projectile
     */
}
