package fr.thibma.dragonrush.listeners;

import fr.minuskube.netherboard.Netherboard;
import fr.minuskube.netherboard.bukkit.BPlayerBoard;
import fr.thibma.dragonrush.DragonRush;
import fr.thibma.dragonrush.classes.Class;
import fr.thibma.dragonrush.classes.swordman.Swordman;
import fr.thibma.dragonrush.players.Team;
import org.bukkit.Bukkit;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onJoinListener(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        Bukkit.broadcastMessage("§7[§2+§7] §6" + player.getDisplayName());

        switch (DragonRush.state) {
            case WAITING -> {
                player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(1.0);
                player.getAttribute(Attribute.GENERIC_ATTACK_SPEED).setBaseValue(4.0);
                player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(20);
                player.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(0.10000000149011612);

                event.setJoinMessage(null);

                BPlayerBoard board = Netherboard.instance().createBoard(player, "§6§lDragon Rush !");
                board.setAll(
                        "§6",
                        "§lÉquipe :",
                        "§oAucune§6",
                        "§7",
                        "§lClasse :",
                        "§oAucune§7",
                        "§8",
                        "§lTemps :",
                        "§c00:00",
                        "§1",
                        "§lNiveau suivant : ",
                        "§o???",
                        "§c?/?"
                );
            }
        }
    }
}
