package fr.thibma.dragonrush.classes.archer;

import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;

public class ArcherLevel2Listener implements Listener {

    private final Archer archer;

    public ArcherLevel2Listener(Archer archer) {
        this.archer = archer;
    }

    @EventHandler
    void onPiglinOrPillagerKilled(EntityDeathEvent event) {
        Entity entity = event.getEntity();

        EntityDamageEvent eventDamage = entity.getLastDamageCause();
        if (!(eventDamage instanceof EntityDamageByEntityEvent)) {
            return;
        }
        EntityDamageByEntityEvent entityDamageByEntityEvent = (EntityDamageByEntityEvent) eventDamage;

        if (!(entityDamageByEntityEvent.getDamager() instanceof Arrow)) {
            return;
        }

        if (entity.getType() != EntityType.PIGLIN && entity.getType() != EntityType.PILLAGER) {
            return;
        }

        if (entity.getType() == EntityType.PIGLIN) {
            Piglin piglin = (Piglin) entity;
            if (piglin.getEquipment().getItemInMainHand().getType() != Material.CROSSBOW) {
                return;
            }
        } else {
            Pillager pillager = (Pillager) entity;
            if (pillager.getEquipment().getItemInMainHand().getType() != Material.CROSSBOW) {
                return;
            }
        }

        Arrow arrow = (Arrow) entityDamageByEntityEvent.getDamager();

        if (!(arrow.getShooter() instanceof Player)) {
            return;
        }

        Player player = (Player) arrow.getShooter();

        if (player != this.archer.getPlayer()) {
            return;
        }

        player.sendMessage("Pillager ou piglin tué");
        this.archer.piglinPillagerKilled++;
        if (this.archer.piglinPillagerKilled == 5) {
            player.sendMessage("Objectif atteint !");
            this.archer.objectiveLevel3();
        }
    }
}
