package fr.thibma.dragonrush.listeners;

import fr.thibma.dragonrush.events.DisplaySelectionClassesEvent;
import fr.thibma.dragonrush.events.DisplaySelectionTeamEvent;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class RightClickListener implements Listener {

    @EventHandler
    public void selectionClass(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack item = event.getItem();

        if (item == null) {
            return;
        }

        if (item.getType() == Material.NETHERITE_AXE) {
            DisplaySelectionClassesEvent displaySelectionClassesEvent = new DisplaySelectionClassesEvent();
            Bukkit.getServer().getPluginManager().callEvent(displaySelectionClassesEvent);
        }
        else if (item.getType() == Material.DIAMOND) {
            Bukkit.getServer().getPluginManager().callEvent(new DisplaySelectionTeamEvent(player));
        }
    }

}
