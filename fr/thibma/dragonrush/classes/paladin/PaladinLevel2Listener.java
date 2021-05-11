package fr.thibma.dragonrush.classes.paladin;

import org.bukkit.entity.Enderman;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class PaladinLevel2Listener implements Listener {

    private final Paladin paladin;

    public PaladinLevel2Listener (Paladin paladin) { this.paladin = paladin; }

    @EventHandler
    private void onEndermanBlocked(EntityDamageByEntityEvent event) {
        if (!(event.getEntity() instanceof Player)) {
            return;
        }
        Player player = (Player) event.getEntity();

        if (player != this.paladin.getPlayer()) {
            return;
        }

        if (!(event.getDamager() instanceof Enderman)) {
            return;
        }

        if (!player.isBlocking()) {
            return;
        }

        player.sendMessage("Attaque d'Enderman bloquée");
        this.paladin.endermanAttackBlocked++;
        if (this.paladin.endermanAttackBlocked == 10) {
            player.sendMessage("Objectif atteint");
            this.paladin.objectiveLevel3();
        }

    }

}
