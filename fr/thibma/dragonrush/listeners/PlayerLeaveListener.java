package fr.thibma.dragonrush.listeners;

import fr.minuskube.netherboard.Netherboard;
import fr.minuskube.netherboard.bukkit.BPlayerBoard;
import fr.thibma.dragonrush.DragonRush;
import fr.thibma.dragonrush.events.PlayerAddedToTeamEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerLeaveListener implements Listener {

    @EventHandler
    public void onPlayerDisconnect(PlayerQuitEvent event) {
        Player player = event.getPlayer();

        BPlayerBoard board = Netherboard.instance().getBoard(player);
        board.delete();

        switch (DragonRush.state) {
            case WAITING -> {
                if (DragonRush.classes.getPlayerClass(player) != null) {
                    DragonRush.classes.removePlayerClass(player);
                }

                if (DragonRush.teams.getTeamOfAPlayer(player) != null) {
                    DragonRush.teams.getTeamOfAPlayer(player).removePlayer(player);
                    Bukkit.getServer().getPluginManager().callEvent(new PlayerAddedToTeamEvent());
                }
            }
        }
    }
}
