package fr.thibma.dragonrush.classes.paladin;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;

public class PaladinSkillProtection implements Listener {

    private final Paladin paladin;

    public PaladinSkillProtection(Paladin paladin) { this.paladin = paladin; }

    @EventHandler
    void onInventoryClickEvent(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();

        if (player != this.paladin.getPlayer()) {
            return;
        }

        if (event.getInventory().getType() != InventoryType.CRAFTING) {
            if (event.getCurrentItem().equals(this.paladin.paladinSkillItem())) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    void onDropEvent(PlayerDropItemEvent event) {
        Player player = event.getPlayer();

        if (player != this.paladin.getPlayer()) {
            return;
        }

        if (event.getItemDrop().getItemStack().equals(this.paladin.paladinSkillItem())) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    void onDeathEvent(PlayerDeathEvent event) {
        Player player = event.getEntity().getPlayer();

        if (player != this.paladin.getPlayer()) {
            return;
        }

        for (ItemStack itemStack : event.getDrops()) {
            if (itemStack != null) {
                if (itemStack.equals(this.paladin.paladinSkillItem())) {
                    event.getDrops().remove(itemStack);
                }
            }
        }
    }

    @EventHandler
    void onRespawnEvent(PlayerRespawnEvent event) {
        Player player = event.getPlayer();
        if (player != this.paladin.getPlayer()) {
            return;
        }

        player.getInventory().addItem(this.paladin.paladinSkillItem());
    }

    @EventHandler
    void onCraftItem(CraftItemEvent event) {
        if (event.getRecipe().getResult().equals(Material.WRITABLE_BOOK)) {
            for (int i = 1; i < 9; i++) {
                if (event.getInventory().getItem(i) != null) {
                    if (event.getInventory().getItem(i).equals(this.paladin.paladinSkillItem())) {
                        event.setCancelled(true);
                    }
                }
            }
        }
    }
}
