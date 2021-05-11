package fr.thibma.dragonrush.classes.assassin;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class AssassinLevel3Listener implements Listener {

    private final Assassin assassin;

    public AssassinLevel3Listener(Assassin assassin) { this.assassin = assassin; }

    @EventHandler
    void onPlayerKilled(PlayerDeathEvent event) {
        Player player = event.getEntity().getKiller();

        if (player != this.assassin.getPlayer()) {
            return;
        }

        player.sendMessage("Joueur tué");
        player.sendMessage("Objectif atteint");
        this.assassin.objectiveLevel3();
    }

}
