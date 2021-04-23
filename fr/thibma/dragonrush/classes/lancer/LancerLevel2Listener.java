package fr.thibma.dragonrush.classes.lancer;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Trident;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;

public class LancerLevel2Listener implements Listener {

    private final Lancer lancer;

    public LancerLevel2Listener(Lancer lancer) { this.lancer = lancer; }

    @EventHandler
    void onHoglin(EntityDeathEvent event) {
        Entity entity = event.getEntity();
        EntityDamageEvent eventDamage = entity.getLastDamageCause();
        if (!(eventDamage instanceof EntityDamageByEntityEvent)) {
            return;
        }
        EntityDamageByEntityEvent entityDamageByEntityEvent = (EntityDamageByEntityEvent) eventDamage;

        if (!(entityDamageByEntityEvent.getDamager() instanceof Trident)) {
            return;
        }

        if (entity.getType() != EntityType.HOGLIN) {
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

        player.sendMessage("Hoglin tué");
        this.lancer.hoglinKilled++;
        if (this.lancer.hoglinKilled == 10) {
            player.sendMessage("Objectif atteint !");
            this.lancer.objectiveLevel3();
        }
    }
}
