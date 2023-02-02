package fr.felixviart.thequakeisalie;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Projectile;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.Arrays;
import java.util.Objects;

public class global {
    public static boolean isGhost=false;
    //public static Material current_projectile=Material.ARROW;
    public static Class current_projectile=Egg.class;
    public static String projectile_name="Oeuf";
    public static Material material_proj=Material.EGG;

    public static Double deca_X=0.0;
    public static Double deca_Y=1.0;
    public static Double deca_Z=0.0;
    public static Double projectile_damage=5.0;
    public static Float projectile_rayon=3f;

    public static Inventory main_menu=Bukkit.createInventory(null,27,"Paramètres");
    public static Inventory dmg_menu=Bukkit.createInventory(null,27,"Dégâts du projectile");
    public static Inventory rayon_menu=Bukkit.createInventory(null,27,"Rayon du projectile");
    public static Inventory projectile_menu=Bukkit.createInventory(null,27,"Projectiles");

    public static void setMainMenu() {
        for(int i=0;i<=26;i++) {
            ItemStack target_item=null;
            String custom_name=null;

            switch (i) {
                case 0:
                    target_item=new ItemStack(Material.BARRIER);
                    custom_name=ChatColor.RED+"Fermer";
                    break;
                case 11:
                    target_item=new ItemStack(Material.DIAMOND_SWORD);
                    custom_name="Dégats du projectile";
                    break;
                case 13:
                    target_item=new ItemStack(Material.BOW);
                    custom_name="Rayon du cercle";
                    break;
                case 15:
                    target_item=new ItemStack(Material.ARROW);
                    custom_name="Type de projectile";
                    break;
                default:
                    target_item=new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
                    custom_name=ChatColor.GRAY+"";
                    break;
            }

            ItemMeta item_data=target_item.getItemMeta();
            item_data.setDisplayName(ChatColor.BOLD+custom_name);
            item_data.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            target_item.setItemMeta(item_data);
            main_menu.setItem(i,target_item);
        }
    }

    public static void setDmgMenu() {
        ItemStack target_item = null;
        String custom_name=null;

        for(int i=0;i<=26;i++) {
            switch (i) {
                case 0:
                    target_item=new ItemStack(Material.BARRIER);
                    custom_name=ChatColor.RED+"Fermer";
                    break;
                case 1:
                    target_item=new ItemStack(Material.ARROW);
                    custom_name=ChatColor.YELLOW+"Retour";
                    break;
                case 10:
                    target_item=new ItemStack(Material.FIRE_CHARGE);
                    custom_name=ChatColor.BOLD+""+ChatColor.RED+"-100";
                    break;
                case 11:
                    target_item=new ItemStack(Material.FIRE_CHARGE);
                    custom_name=ChatColor.BOLD+""+ChatColor.RED+"-10";
                    break;
                case 12:
                    target_item=new ItemStack(Material.FIRE_CHARGE);
                    custom_name=ChatColor.BOLD+""+ChatColor.RED+"-1";
                    break;
                case 13:
                    target_item=new ItemStack(Material.DIAMOND_SWORD);
                    custom_name=ChatColor.BOLD+"Dégats du projectile: "+global.projectile_damage;
                    break;
                case 14:
                    target_item=new ItemStack(Material.ENDER_PEARL);
                    custom_name=ChatColor.BOLD+""+ChatColor.GREEN+"+1";
                    break;
                case 15:
                    target_item=new ItemStack(Material.ENDER_PEARL);
                    custom_name=ChatColor.BOLD+""+ChatColor.GREEN+"+10";
                    break;
                case 16:
                    target_item=new ItemStack(Material.ENDER_PEARL);
                    custom_name=ChatColor.BOLD+""+ChatColor.GREEN+"+100";
                    break;
                default:
                    target_item=new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
                    custom_name=ChatColor.GRAY+"";
                    break;
            }

            ItemMeta item_data=target_item.getItemMeta();

            item_data.setDisplayName(custom_name);
            item_data.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            target_item.setItemMeta(item_data);

            dmg_menu.setItem(i,target_item);
        }
    }

    public static void setRayonMenu() {
        ItemStack target_item = null;
        String custom_name=null;

        for(int i=0;i<=26;i++) {
            switch (i) {
                case 0:
                    target_item=new ItemStack(Material.BARRIER);
                    custom_name=ChatColor.RED+"Fermer";
                    break;
                case 1:
                    target_item=new ItemStack(Material.ARROW);
                    custom_name=ChatColor.YELLOW+"Retour";
                    break;
                case 10:
                    target_item=new ItemStack(Material.FIRE_CHARGE);
                    custom_name=ChatColor.BOLD+""+ChatColor.RED+"-10";
                    break;
                case 11:
                    target_item=new ItemStack(Material.FIRE_CHARGE);
                    custom_name=ChatColor.BOLD+""+ChatColor.RED+"-1";
                    break;
                case 12:
                    target_item=new ItemStack(Material.FIRE_CHARGE);
                    custom_name=ChatColor.BOLD+""+ChatColor.RED+"-0.1";
                    break;
                case 13:
                    target_item=new ItemStack(Material.BOW);
                    custom_name=ChatColor.BOLD+"Rayon du projectile: "+projectile_rayon;
                    break;
                case 14:
                    target_item=new ItemStack(Material.ENDER_PEARL);
                    custom_name=ChatColor.BOLD+""+ChatColor.GREEN+"+0.1";
                    break;
                case 15:
                    target_item=new ItemStack(Material.ENDER_PEARL);
                    custom_name=ChatColor.BOLD+""+ChatColor.GREEN+"+1";
                    break;
                case 16:
                    target_item=new ItemStack(Material.ENDER_PEARL);
                    custom_name=ChatColor.BOLD+""+ChatColor.GREEN+"+10";
                    break;
                default:
                    target_item=new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
                    custom_name=ChatColor.GRAY+"";
                    break;
            }

            ItemMeta item_data=target_item.getItemMeta();
            item_data.setDisplayName(custom_name);
            item_data.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

            if(i==13) {
                String[] target_lore = new String[]{ChatColor.GRAY + "~" + Math.round(projectile_rayon * 33) + "blocks"};
                item_data.setLore(Arrays.asList(target_lore));
            }

            target_item.setItemMeta(item_data);

            rayon_menu.setItem(i,target_item);
        }
    }

    public static void setProjectileMenu() {
        ItemStack target_item=null;
        String custom_name=null;

        for (int i = 0; i<=26; i++) {
            switch (i) {
                case 0:
                    target_item=new ItemStack(Material.BARRIER);
                    custom_name=ChatColor.RED+"Fermer";
                    break;
                case 1:
                    target_item=new ItemStack(Material.ARROW);
                    custom_name=ChatColor.YELLOW+"Retour";
                    break;
                case 10:
                    target_item=new ItemStack(Material.ARROW);
                    custom_name="Flèche";
                    break;
                case 11:
                    target_item=new ItemStack(Material.SNOWBALL);
                    custom_name="Boule de neige";
                    break;
                case 12:
                    target_item=new ItemStack(Material.EGG);
                    custom_name="Oeuf";
                    break;
                case 14:
                    target_item=new ItemStack(Material.ENDER_PEARL);
                    custom_name="Perle de l'end";
                    break;
                case 15:
                    target_item=new ItemStack(Material.SHULKER_SHELL);
                    custom_name="Shulker";
                    break;
                case 16:
                    target_item=new ItemStack(Material.TRIDENT);
                    custom_name="Trident";
                    break;
                case 22:
                    target_item=new ItemStack(material_proj);
                    custom_name=ChatColor.BOLD+"Projectile actuel: "+projectile_name;
                    break;
                default:
                    target_item=new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
                    custom_name=ChatColor.GRAY+"";
                    break;
            }

            ItemMeta item_data=target_item.getItemMeta();
            item_data.setDisplayName(ChatColor.BOLD+custom_name);
            item_data.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            target_item.setItemMeta(item_data);
            projectile_menu.setItem(i,target_item);
        }
    }

    public static void UpdateUIItems(String menu) {
        ItemStack target_item = null;
        ItemMeta item_data=null;
        String[] target_lore=null;

        switch (menu) {
            case "degats":
                dmg_menu.clear(13);
                target_item = new ItemStack(Material.DIAMOND_SWORD);

                item_data=target_item.getItemMeta();
                assert item_data != null;
                item_data.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                item_data.setDisplayName(ChatColor.BOLD+"Dégats: "+projectile_damage);
                target_item.setItemMeta(item_data);

                dmg_menu.setItem(13,target_item);
                break;
            case "rayon":
                rayon_menu.clear(13);
                target_item = new ItemStack(Material.BOW);

                item_data=target_item.getItemMeta();
                item_data.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                item_data.setDisplayName(ChatColor.BOLD+"Rayon du projectile: "+projectile_rayon+" unitées");
                target_lore=new String[]{ChatColor.GRAY+"~" +Math.round(projectile_rayon*33)+ " blocks"};
                item_data.setLore(Arrays.asList(target_lore));
                target_item.setItemMeta(item_data);

                rayon_menu.setItem(13,target_item);
                break;
            case "projectile":
                projectile_menu.clear(22);
                target_item=new ItemStack(material_proj);

                item_data=target_item.getItemMeta();
                item_data.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                item_data.setDisplayName(ChatColor.BOLD+"Projectile: "+projectile_name);
                target_item.setItemMeta(item_data);

                projectile_menu.setItem(22,target_item);
                break;
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
