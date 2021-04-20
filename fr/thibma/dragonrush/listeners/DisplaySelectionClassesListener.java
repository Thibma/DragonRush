package fr.thibma.dragonrush.listeners;

import fr.thibma.dragonrush.DragonRush;
import fr.thibma.dragonrush.classes.ClassEnums;
import fr.thibma.dragonrush.classes.ClassSelection;
import fr.thibma.dragonrush.events.DisplaySelectionClassesEvent;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class DisplaySelectionClassesListener implements Listener {

    private final Inventory inventory = ClassSelection.getClassSelectionInventory();

    @EventHandler
    public void onDisplaySelectionClasses(DisplaySelectionClassesEvent event) {

        for (Player player : Bukkit.getServer().getOnlinePlayers()) {
            player.openInventory(inventory);
        }

    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getInventory() != this.inventory) {
            return;
        }

        event.setCancelled(true);

        final ItemStack clickedItem = event.getCurrentItem();

        if (clickedItem == null || clickedItem.getType() == Material.AIR) {
            return;
        }

        final Player player = (Player) event.getWhoClicked();

        //player.sendMessage("Choix de la classe : " + ClassSelection.getClassEnum(event.getSlot()));
        DragonRush.classes.addClass(ClassSelection.getClass(ClassSelection.getClassEnum(event.getSlot()), player));
        DragonRush.classes.getPlayerClass(player).atBegining();
    }

    @EventHandler
    public void onInventoryClick(InventoryDragEvent event) {
        if (event.getInventory() == this.inventory) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onInventoryLeave(InventoryCloseEvent event) {
        if (event.getInventory() == this.inventory) {
            //Bukkit.getScheduler().scheduleSyncDelayedTask(JavaPlugin.getPlugin(DragonRush.class), () -> event.getPlayer().openInventory(inventory), 1);

        }
    }

}
