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
    void onPiglinKilled(EntityDeathEvent event) {
        Entity entity = event.getEntity();
        Player player = event.getEntity().getKiller();

        if (player == null) {
            return;
        }

        System.out.println("KILL");
        if (player != this.swordman.getPlayer() || entity.getType() != EntityType.PIGLIN) {
            return;
        }
        System.out.println(entity.getType().toString() + " " + player + " good !");
    }

}
