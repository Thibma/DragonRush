package fr.thibma.dragonrush.classes.paladin;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class PaladinLevel1Listener implements Listener {

    private final Paladin paladin;

    public PaladinLevel1Listener(Paladin paladin) { this.paladin = paladin; }

    @EventHandler
    private void onBlockAttack(EntityDamageByEntityEvent event) {
        if (!(event.getEntity() instanceof Player)) {
            return;
        }
        Player player = (Player) event.getEntity();

        if (player != this.paladin.getPlayer()) {
            return;
        }

        if (!player.isBlocking()) {
            return;
        }

        player.sendMessage("Attaque bloquée");
        this.paladin.attackBlocked++;
        if (this.paladin.attackBlocked == 20) {
            player.sendMessage("Objectif atteint");
            this.paladin.objectiveLevel2();
        }
    }

}
