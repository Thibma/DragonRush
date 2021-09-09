package fr.thibma.dragonrush.classes.hunter;

import org.bukkit.craftbukkit.v1_17_R1.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_17_R1.entity.CraftWolf;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wolf;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;

public class HunterLevel2Listener implements Listener {

    private final Hunter hunter;

    public HunterLevel2Listener(Hunter hunter) { this.hunter = hunter; }

    @EventHandler
    void onEntityKilled(EntityDeathEvent event) {
        if (!(event.getEntity().getLastDamageCause() instanceof EntityDamageByEntityEvent)) {
            return;
        }
        EntityDamageByEntityEvent entityDamageEvent = (EntityDamageByEntityEvent) event.getEntity().getLastDamageCause();

        if (entityDamageEvent.getDamager() instanceof CraftPlayer) {
            Player player = (Player) entityDamageEvent.getDamager();
            if (player != this.hunter.getPlayer()) {
                return;
            }
            this.entityKilled();
        }

        else if (entityDamageEvent.getDamager() instanceof CraftWolf) {
            Wolf wolf = (Wolf) entityDamageEvent.getDamager();
            if (wolf.getCustomName() == null) {
                return;
            }
            if (!wolf.getCustomName().equals(this.hunter.hunterWolf.wolfName())) {
                return;
            }
            this.entityKilled();
        }
    }

    private void entityKilled() {
        this.hunter.onEntityKilled2++;
        this.hunter.getPlayer().sendMessage("Entité tué.");
        if (this.hunter.onEntityKilled2 == 60) {
            this.hunter.getPlayer().sendMessage("Objectif atteint !");
            this.hunter.objectiveLevel3();
        }
    }

}
