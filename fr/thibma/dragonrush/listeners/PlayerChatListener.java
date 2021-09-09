package fr.thibma.dragonrush.listeners;

import fr.thibma.dragonrush.DragonRush;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerChatListener implements Listener {

    @EventHandler
    private void onChatEvent(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();

        if (DragonRush.teams.getTeamOfAPlayer(player) == null) {
            event.setFormat("§7§o" + player.getDisplayName() + " §f§l>> §7" + event.getMessage());
        }
        else {
            if (event.getMessage().charAt(0) == '!') {
                String message = event.getMessage().substring(1);
                event.setFormat(DragonRush.teams.getTeamOfAPlayer(player).getColorString() + player.getDisplayName() + " §f§l>> §7" + message);
            }
            else {
                event.setCancelled(true);
                for (Player teamPlayer : DragonRush.teams.getTeamOfAPlayer(player).getPlayerList()) {
                    teamPlayer.sendMessage(DragonRush.teams.getTeamOfAPlayer(player).getColorString() + "[Équipe] " + player.getDisplayName() + " §f§l>> §7" + event.getMessage());
                }
            }
        }
    }

}
