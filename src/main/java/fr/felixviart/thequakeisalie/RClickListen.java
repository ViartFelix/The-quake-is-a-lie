package fr.felixviart.thequakeisalie;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

public class RClickListen implements Listener {
    @EventHandler
    public void onPlayerInteractEvent(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        Material item_held=player.getInventory().getItemInMainHand().getType();

        if((e.getAction() == Action.RIGHT_CLICK_AIR) | (e.getAction() == Action.RIGHT_CLICK_BLOCK) && e.getHand()==EquipmentSlot.HAND && (item_held==Material.IRON_HOE)) {
            Bukkit.broadcastMessage("Right click w/ iron hoe !");
        }
    }
}