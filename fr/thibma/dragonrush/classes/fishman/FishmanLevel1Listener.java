package fr.thibma.dragonrush.classes.fishman;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class FishmanLevel1Listener implements Listener {

    private final Fishman fishman;

    public FishmanLevel1Listener(Fishman fishman) { this.fishman = fishman; }

    @EventHandler
    void onDrownedKilled(EntityDeathEvent event) {
        Entity entity = event.getEntity();
        Player player = event.getEntity().getKiller();

        if (player == null || player != this.fishman.getPlayer() || entity.getType() != EntityType.DROWNED) {
            return;
        }

        player.sendMessage("Drowned tué");
        this.fishman.drownedKilled++;
        if (this.fishman.drownedKilled == 5) {
            player.sendMessage("Objectif atteint !");
            this.fishman.objectiveLevel2();
        }

    }

}
