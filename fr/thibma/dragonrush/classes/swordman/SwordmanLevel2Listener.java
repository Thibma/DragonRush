package fr.thibma.dragonrush.classes.swordman;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class SwordmanLevel2Listener implements Listener {

    private final Swordman swordman;

    public SwordmanLevel2Listener(Swordman swordman) {
        this.swordman = swordman;
    }

    @EventHandler
    void onPiglinKilled(EntityDeathEvent event) {
        Entity entity = event.getEntity();
        Player player = event.getEntity().getKiller();

        if (player == null || player != swordman.getPlayer() || entity.getType() != EntityType.PIGLIN) {
            return;
        }

        player.sendMessage("Piglin tué");
        swordman.piglinKilled++;
        if (swordman.piglinKilled == 10) {
            player.sendMessage("Objectif atteint !");
            swordman.objectiveLevel3();
        }

    }

}
