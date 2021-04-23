package fr.thibma.dragonrush.classes.lancer;

import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class LancerLevel2 implements Listener {

    private Lancer lancer;

    public LancerLevel2(Lancer lancer) { this.lancer = lancer; }

    @EventHandler
    void onTridentThrowDamage(EntityDamageByEntityEvent event) {
        if (!(event.getDamager() instanceof Trident)) {
            return;
        }
        Trident trident = (Trident) event.getDamager();
        if (!(trident.getShooter() instanceof Player)) {
            return;
        }
        Player player = (Player) trident.getShooter();
        if (player != this.lancer.getPlayer()) {
            return;
        }

        switch (this.lancer.getLevel()) {
            case 2 -> event.setDamage(event.getDamage() + 1);
            case 3 -> {
                PotionEffect potionEffect = new PotionEffect(PotionEffectType.POISON, 5 * 20, 0);
                if (event.getEntity() instanceof Mob) {
                    ((Mob) event.getEntity()).addPotionEffect(potionEffect);
                }
                else {
                    ((Player) event.getEntity()).addPotionEffect(potionEffect);
                }
                event.setDamage(event.getDamage() + 2);
            }
        }
    }

}
