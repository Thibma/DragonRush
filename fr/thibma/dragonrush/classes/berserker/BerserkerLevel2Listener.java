package fr.thibma.dragonrush.classes.berserker;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class BerserkerLevel2Listener implements Listener {

    private final Berserker berserker;

    public BerserkerLevel2Listener(Berserker berserker) { this.berserker = berserker; }

    @EventHandler
    void onIronGolemKilled(EntityDeathEvent event) {
        Entity entity = event.getEntity();
        Player player = event.getEntity().getKiller();

        if (player == null || player != this.berserker.getPlayer() || entity.getType() != EntityType.IRON_GOLEM) {
            return;
        }

        player.sendMessage("Golem de fer tué");
        player.sendMessage("Objectif atteint !");
        this.berserker.objectiveLevel3();
    }
}
