package fr.thibma.dragonrush.listeners;

import fr.thibma.dragonrush.DragonRush;
import fr.thibma.dragonrush.classes.ClassEnums;
import fr.thibma.dragonrush.items.MenuItem;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;

public class CraftItemProtectionListener implements Listener {

    @EventHandler
    void onFumigeneCrafted(CraftItemEvent event) {
        if (event.getRecipe().getResult().equals(MenuItem.fumigene())) {
            Player player = (Player) event.getWhoClicked();
            if (DragonRush.classes.getPlayerClass(player).getEnum() != ClassEnums.ASSASSIN) {
                event.setCancelled(true);
                player.sendMessage("§cVous n'arrivez pas à crafter cet objet.");
            }
            if (DragonRush.classes.getPlayerClass(player).getLevel() != 3) {
                event.setCancelled(true);
                player.sendMessage("§cVous n'êtes pas assez experimenté pour réalisé cet objet...");
            }
        }
    }

}
