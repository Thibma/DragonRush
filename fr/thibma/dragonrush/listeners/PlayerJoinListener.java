package fr.thibma.dragonrush.listeners;

import fr.thibma.dragonrush.classes.Class;
import fr.thibma.dragonrush.classes.swordman.Swordman;
import fr.thibma.dragonrush.players.Team;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.List;

public class PlayerJoinListener implements Listener {

    private final List<Team> teamList;

    public PlayerJoinListener(List<Team> teamList) {
        this.teamList = teamList;
    }

    @EventHandler
    public void onJoinListener(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        Class swordman = new Swordman(player);
        swordman.level1();
    }
}
