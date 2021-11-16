package fr.thibma.dragonrush.listeners;

import fr.thibma.dragonrush.DragonRush;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerRespawnListener implements Listener {

    @EventHandler
    private void onPlayerRespawn(PlayerRespawnEvent event) {
        Player player = event.getPlayer();

        if (DragonRush.classes.getPlayerClass(player) == null) {
            return;
        }

        DragonRush.classes.getPlayerClass(player).addSkills();
    }

}
