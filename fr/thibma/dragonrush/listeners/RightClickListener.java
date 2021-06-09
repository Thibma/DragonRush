package fr.thibma.dragonrush.listeners;

import fr.thibma.dragonrush.classes.hunter.HunterBear;
import fr.thibma.dragonrush.events.DisplaySelectionClassesEvent;
import fr.thibma.dragonrush.events.DisplaySelectionTeamEvent;
import net.minecraft.server.v1_16_R3.WorldServer;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;
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
        else if (item.getType() == Material.IRON_INGOT) {
            WorldServer worldServer = ((CraftWorld) player.getWorld()).getHandle();
            HunterBear hunterBear = new HunterBear(player.getLocation(), player);
            worldServer.addEntity(hunterBear);
        }
    }

}
