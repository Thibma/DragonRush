package fr.thibma.dragonrush.classes.berserker;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class BerserkerLevel1Listener implements Listener {

    private final Berserker berserker;

    public BerserkerLevel1Listener(Berserker berserker) { this.berserker = berserker; }

    @EventHandler
    void onZombieKilled(EntityDeathEvent event) {
        Entity entity = event.getEntity();
        Player player = event.getEntity().getKiller();

        if (player == null || player != this.berserker.getPlayer() || entity.getType() != EntityType.ZOMBIE) {
            return;
        }

        player.sendMessage("Zombie tué");
        this.berserker.zombieKilled++;
        if (this.berserker.zombieKilled == 15) {
            player.sendMessage("Objectif atteint !");
            this.berserker.objectiveLevel2();
        }
    }

}
