package fr.felixviart.thequakeisalie;


import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class playerJoinsInvSet implements Listener {
    @EventHandler
    public void onPlayerJoins(PlayerJoinEvent event) {
        Player p=event.getPlayer();
        p.getInventory().clear();

        for (Integer i=0;i<=8;i++) {
            ItemStack target_item=null;
            String custom_name=null;
            ItemMeta item_data = null;
            Boolean isOk=false;

            switch (i) {
                case 0:
                    target_item=new ItemStack(Material.IRON_HOE);
                    custom_name=ChatColor.BOLD+""+ChatColor.GOLD+"Quakator 3000";
                    item_data=target_item.getItemMeta();
                    isOk=true;
                    break;
                case 7:
                    target_item=new ItemStack(Material.MAGMA_CREAM);
                    custom_name=ChatColor.RED+"Mode fantôme inactif";
                    item_data=target_item.getItemMeta();
                    isOk=true;
                    break;
                case 8:
                    target_item=new ItemStack(Material.NETHER_STAR);
                    custom_name=ChatColor.BOLD+""+ChatColor.WHITE+"Menu";
                    item_data=target_item.getItemMeta();
                    isOk=true;
                    break;
                default:
                    isOk=false;
                    break;
            }

            if(isOk) {
                item_data.setDisplayName(custom_name);
                item_data.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                target_item.setItemMeta(item_data);

                p.getInventory().setItem(i,target_item);
            }
        }

        //p.getInventory().setItem(0,new ItemStack(Material.IRON_HOE));
        //p.getInventory().setItem(7, new ItemStack(Material.MAGMA_CREAM));
        //p.getInventory().setItem(8,new ItemStack(Material.NETHER_STAR));
    }
}
