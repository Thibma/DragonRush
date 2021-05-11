package fr.thibma.dragonrush.classes.paladin;

import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class PaladinDisadvantage implements Listener {

    private final Paladin paladin;

    public PaladinDisadvantage(Paladin paladin) { this.paladin = paladin; }

    @EventHandler
    void onDamageEntity(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Arrow) {
            Arrow arrow = (Arrow) event.getDamager();
            if (!(arrow.getShooter() instanceof Player)) {
                return;
            }
            Player player = (Player) arrow.getShooter();
            if (player != this.paladin.getPlayer()) {
                return;
            }
            event.setDamage(event.getDamage() - (event.getDamage() * 20 / 100));
        }
        else if (event.getDamager() instanceof Player) {
            Player player = (Player) event.getDamager();
            if (player != this.paladin.getPlayer()) {
                return;
            }
            event.setDamage(event.getDamage() - (event.getDamage() * 20 / 100));
        }
    }

}
