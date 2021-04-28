package fr.thibma.dragonrush.classes.swordman;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class SwordmanDisadvantages implements Listener {

    private final Swordman swordman;

    public SwordmanDisadvantages(Swordman swordman) {
        this.swordman = swordman;
    }

    @EventHandler
    void onArrowDamage(EntityDamageByEntityEvent event) {
        if (!(event.getDamager() instanceof Arrow)) {
            return;
        }
        Arrow arrow = (Arrow) event.getDamager();
        if (!(arrow.getShooter() instanceof Player)) {
            return;
        }
        Player player = (Player) arrow.getShooter();
        if (player != this.swordman.getPlayer()) {
            return;
        }
        event.setDamage(event.getDamage() - (event.getDamage() * 50 / 100));
    }
}
