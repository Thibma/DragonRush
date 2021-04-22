package fr.thibma.dragonrush.classes.archer;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;

public class ArcherLevel1Listener implements Listener {

    private final Archer archer;

    public ArcherLevel1Listener(Archer archer) { this.archer = archer; }

    @EventHandler
    void onSkeletonKilled(EntityDeathEvent event) {
        Entity entity = event.getEntity();
        EntityDamageEvent eventDamage = entity.getLastDamageCause();
        if (!(eventDamage instanceof EntityDamageByEntityEvent)) {
            return;
        }
        EntityDamageByEntityEvent entityDamageByEntityEvent = (EntityDamageByEntityEvent) eventDamage;

        if (!(entityDamageByEntityEvent.getDamager() instanceof Arrow)) {
            return;
        }

        if (entity.getType() != EntityType.SKELETON) {
            return;
        }

        Arrow arrow = (Arrow) entityDamageByEntityEvent.getDamager();

        if (!(arrow.getShooter() instanceof Player)) {
            return;
        }

        Player player = (Player) arrow.getShooter();

        if (player != this.archer.getPlayer()) {
            return;
        }

        player.sendMessage("Skeleton tué");
        this.archer.skeletonKilled++;
        if (this.archer.skeletonKilled == 10) {
            player.sendMessage("Objectif atteint !");
            this.archer.objectiveLevel2();
        }
    }

}
