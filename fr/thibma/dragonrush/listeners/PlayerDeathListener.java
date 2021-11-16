package fr.thibma.dragonrush.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeathListener implements Listener {

    private void onPlayerDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();
    }

}
