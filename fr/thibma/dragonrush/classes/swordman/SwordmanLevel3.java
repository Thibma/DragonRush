package fr.thibma.dragonrush.classes.swordman;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class SwordmanLevel3 implements Listener {

    private final Swordman swordman;

    public SwordmanLevel3(Swordman swordman) {
        this.swordman = swordman;
    }


    @EventHandler
    void onEntityDamaged(EntityDamageByEntityEvent event) {
        if (!(event.getDamager() instanceof Player)) {
            return;
        }
        Player player = (Player) event.getDamager();
        if (player != this.swordman.getPlayer()) {
            return;
        }

        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 60, 0));
    }
}
