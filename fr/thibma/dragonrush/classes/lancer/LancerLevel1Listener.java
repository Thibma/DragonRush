package fr.thibma.dragonrush.classes.lancer;

import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;

public class LancerLevel1Listener implements Listener {

    private final Lancer lancer;

    public LancerLevel1Listener(Lancer lancer) { this.lancer = lancer; }

    @EventHandler
    void onCreeperKilled(EntityDeathEvent event) {
        Entity entity = event.getEntity();
        EntityDamageEvent eventDamage = entity.getLastDamageCause();
        if (!(eventDamage instanceof EntityDamageByEntityEvent)) {
            return;
        }
        EntityDamageByEntityEvent entityDamageByEntityEvent = (EntityDamageByEntityEvent) eventDamage;

        if (!(entityDamageByEntityEvent.getDamager() instanceof Trident)) {
            return;
        }

        if (entity.getType() != EntityType.CREEPER) {
            return;
        }

        Trident trident = (Trident) entityDamageByEntityEvent.getDamager();

        if (!((trident.getShooter()) instanceof Player)) {
            return;
        }

        Player player = (Player) trident.getShooter();

        if (player != this.lancer.getPlayer()) {
            return;
        }

        player.sendMessage("Creeper tué");
        this.lancer.creeperKilled++;
        if (this.lancer.creeperKilled == 10) {
            player.sendMessage("Objectif atteint !");
            this.lancer.objectiveLevel2();
        }
    }
}
