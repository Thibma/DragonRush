package fr.thibma.dragonrush.classes.assassin;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class AssassinLevel2Listener implements Listener {

    private final Assassin assassin;

    public AssassinLevel2Listener(Assassin assassin) { this.assassin = assassin; }

    @EventHandler
    void onVillagerKilled(EntityDeathEvent event) {
        Entity entity = event.getEntity();
        Player player = event.getEntity().getKiller();

        if (player == null || player != this.assassin.getPlayer() || entity.getType() != EntityType.VILLAGER) {
            return;
        }

        player.sendMessage("Villageois tué");
        this.assassin.villagerKilled++;
        if (this.assassin.villagerKilled == 5) {
            player.sendMessage("Objectif atteint !");
            this.assassin.objectiveLevel2();
        }
    }
}
