package fr.thibma.dragonrush.classes.lancer;

import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class LancerDisadvantage implements Listener {

    private final Lancer lancer;

    public LancerDisadvantage(Lancer lancer) { this.lancer = lancer; }

    @EventHandler
    void onDamage(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Arrow) {
            Arrow arrow = (Arrow) event.getDamager();
            if (!(arrow.getShooter() instanceof Player)) {
                return;
            }
            Player player = (Player) arrow.getShooter();
            if (player != this.lancer.getPlayer()) {
                return;
            }
            event.setDamage(event.getDamage() - (event.getDamage() * 50 / 100));
        }
        else if (event.getDamager() instanceof Player) {
            Player player = (Player) event.getDamager();
            if (player != this.lancer.getPlayer()) {
                return;
            }
            Material itemInHand = player.getInventory().getItemInMainHand().getType();
            if(itemInHand != Material.TRIDENT)
            event.setDamage(event.getDamage() - (event.getDamage() * 50 / 100));
        }
    }

}
