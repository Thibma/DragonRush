package fr.thibma.dragonrush.listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;

public class PersonalItemsListener implements Listener {

    @EventHandler
    void onInventoryClickEvent(InventoryClickEvent event) {
        if (event.getInventory().getType() != InventoryType.CRAFTING) {
            if (event.getCurrentItem().getItemMeta().getLore().contains("§bCompétence") || event.getCurrentItem().getItemMeta().getLore().contains("§bPersonnel")) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    void onDropEvent(PlayerDropItemEvent event) {
        if (event.getItemDrop().getItemStack().getItemMeta().getLore().contains("§bCompétence") || event.getItemDrop().getItemStack().getItemMeta().getLore().contains("§bPersonnel")) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    void onDeathEvent(PlayerDeathEvent event) {
        for (ItemStack itemStack : event.getDrops()) {
            if (itemStack != null) {
                if (itemStack.getItemMeta().getLore().contains("§bCompétence")  || itemStack.getItemMeta().getLore().contains("§bPersonnel")) {
                    event.getDrops().remove(itemStack);
                }
            }
        }
    }

    /*@EventHandler
    void onRespawnEvent(PlayerRespawnEvent event) {
        Player player = event.getPlayer();
        if (player != this.paladin.getPlayer()) {
            return;
        }

        player.getInventory().addItem(this.paladin.paladinSkillItem());
    }*/

    @EventHandler
    void onCraftItem(CraftItemEvent event) {
        if (event.getRecipe().getResult().equals(Material.WRITABLE_BOOK)) {
            for (int i = 1; i < 9; i++) {
                if (event.getInventory().getItem(i) != null) {
                    if (event.getInventory().getItem(i).getItemMeta().getLore().contains("§bCompétence")  || event.getInventory().getItem(i).getItemMeta().getLore().contains("§bPersonnel")) {
                        event.setCancelled(true);
                    }
                }
            }
        }
    }

}
