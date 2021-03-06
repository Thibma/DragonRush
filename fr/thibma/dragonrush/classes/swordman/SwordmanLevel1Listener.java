package fr.thibma.dragonrush.classes.swordman;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class SwordmanLevel1Listener implements Listener {

    private final Swordman swordman;

    public SwordmanLevel1Listener(Swordman swordman) {
        this.swordman = swordman;
    }

    @EventHandler
    void onPillagerKilled(EntityDeathEvent event) {
        Entity entity = event.getEntity();
        Player player = event.getEntity().getKiller();

        if (player == null || player != swordman.getPlayer() || entity.getType() != EntityType.PILLAGER) {
            return;
        }

        player.sendMessage("Pillager tué");
        swordman.pillagerKilled++;
        if (swordman.pillagerKilled == 5) {
            player.sendMessage("Objectif atteint !");
            swordman.objectiveLevel2();
        }

    }

}
