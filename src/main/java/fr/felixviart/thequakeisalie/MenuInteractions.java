package fr.felixviart.thequakeisalie;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;

import static java.util.Objects.requireNonNull;

public class MenuInteractions implements Listener {
    @EventHandler
    public void onInteractionMenu(InventoryClickEvent event) {

        if(event.getSlot()>=0) {
            ItemStack clicked=event.getCurrentItem();

            Player player=(Player) event.getWhoClicked();
            Location player_loc=player.getLocation();

            if(!event.getClick().equals(ClickType.DOUBLE_CLICK)) {
                switch (event.getView().getTitle()) {
                    case "Paramètres":
                        event.setCancelled(true);
                        player.closeInventory();

                        switch (requireNonNull(clicked).getType()) {
                            case DIAMOND_SWORD:
                                player.openInventory(global.dmg_menu);
                                break;
                            case BOW:
                                player.openInventory(global.rayon_menu);
                                break;
                            case ARROW:
                                player.openInventory(global.projectile_menu);
                                break;
                        }
                        break;
                    case "Dégâts du projectile":
                        event.setCancelled(true);
                        switch (event.getSlot()) {
                            case 0:
                                player.closeInventory();
                                break;
                            case 1:
                                player.closeInventory();
                                player.openInventory(global.main_menu);
                                break;
                            case 10:
                                global.projectile_damage-=100;
                                break;
                            case 11:
                                global.projectile_damage-=10;
                                break;
                            case 12:
                                global.projectile_damage-=1;
                                break;
                            case 14:
                                global.projectile_damage+=1;
                                break;
                            case 15:
                                global.projectile_damage+=10;
                                break;
                            case 16:
                                global.projectile_damage+=100;
                                break;
                        }

                        if(global.projectile_damage<=1.0) {
                            global.projectile_damage=1.0;
                        }

                        if(event.getSlot()>=10 && event.getSlot()<=16) {
                            player.playSound(player_loc,Sound.BLOCK_NOTE_BLOCK_PLING,0.5f,1f);
                        }

                        global.UpdateUIItems("degats");
                        break;
                    case "Rayon du projectile":
                        event.setCancelled(true);
                        switch (event.getSlot()) {
                            case 0:
                                player.closeInventory();
                                break;
                            case 1:
                                player.closeInventory();
                                player.openInventory(global.main_menu);
                                break;
                            case 10:
                                global.projectile_rayon-=10f;
                                break;
                            case 11:
                                global.projectile_rayon-=1f;
                                break;
                            case 12:
                                global.projectile_rayon-=0.1f;
                                break;
                            case 14:
                                global.projectile_rayon+=0.1f;
                                break;
                            case 15:
                                global.projectile_rayon+=1f;
                                break;
                            case 16:
                                global.projectile_rayon+=10f;
                                break;
                        }



                        if(global.projectile_rayon<0.1f) {
                            global.projectile_rayon=0.1f;
                        } else {
                            global.projectile_rayon=Math.round(global.projectile_rayon*10f)/10f;
                        }

                        if(event.getSlot()>=10 && event.getSlot()<=16) {
                            player.playSound(player_loc,Sound.BLOCK_NOTE_BLOCK_PLING,0.5f,1f);
                        }

                        global.UpdateUIItems("rayon");
                        break;
                    case "Projectiles":
                        event.setCancelled(true);


                        switch (event.getSlot()) {
                            case 0:
                                player.closeInventory();
                                break;
                            case 1:
                                player.closeInventory();
                                player.openInventory(global.main_menu);
                                break;
                            case 10:
                                global.current_projectile=Arrow.class;
                                global.projectile_name="Flèche";
                                global.material_proj=Material.ARROW;
                                break;
                            case 11:
                                global.current_projectile=Snowball.class;
                                global.projectile_name="Boule de neige";
                                global.material_proj=Material.SNOWBALL;
                                break;
                            case 12:
                                global.current_projectile=Egg.class;
                                global.projectile_name="Oeuf";
                                global.material_proj=Material.EGG;
                                break;
                            case 14:
                                global.current_projectile=EnderPearl.class;
                                global.projectile_name="Perle de l'end";
                                global.material_proj=Material.ENDER_PEARL;
                                break;
                            case 15:
                                global.current_projectile=ShulkerBullet.class;
                                global.projectile_name="Shulker";
                                global.material_proj=Material.SHULKER_SHELL;
                                break;
                            case 16:
                                global.current_projectile=Trident.class;
                                global.projectile_name="Trident";
                                global.material_proj=Material.TRIDENT;
                                break;
                        }

                        if((event.getSlot()>=10 && event.getSlot()<=12) || (event.getSlot()>=14 && event.getSlot()<=16)) {
                            player.playSound(player_loc,Sound.BLOCK_NOTE_BLOCK_PLING,0.5f,1f);
                        }

                        global.UpdateUIItems("projectile");

                        break;
                }
            }
        }
    }
}
