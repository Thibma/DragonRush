package fr.thibma.dragonrush.classes.paladin;

import fr.thibma.dragonrush.DragonRush;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class PaladinLevel2 implements Listener {

    private final Paladin paladin;

    public PaladinLevel2 (Paladin paladin) { this.paladin = paladin; }

    private int timer = 30;

    @EventHandler
    private void onBlockedAttack(EntityDamageByEntityEvent event) {
        if (!(event.getEntity() instanceof Player && event.getDamager() instanceof Player)) {
            return;
        }
        Player player = (Player) event.getEntity();
        Player damager = (Player) event.getDamager();

        if (player != this.paladin.getPlayer()) {
            return;
        }

        if (!player.isBlocking()) {
            return;
        }

        if (this.timer == 30) {
            this.passive(damager);
            new BukkitRunnable() {
                @Override
                public void run() {
                    timer--;
                    if (timer == 0) {
                        timer = 30;
                        cancel();
                    }
                }
            }.runTaskTimerAsynchronously(JavaPlugin.getPlugin(DragonRush.class), 0, 20);
        }
        else {
            player.sendMessage("Temps restant : " + this.timer + "s");
        }

    }

    private void passive(Player attacker) {
        PotionEffect weakness = new PotionEffect(PotionEffectType.WEAKNESS, 10 * 20, 1);
        PotionEffect miningFatigue = new PotionEffect(PotionEffectType.SLOW_DIGGING, 10 * 20, 1);
        attacker.addPotionEffect(weakness);
        attacker.addPotionEffect(miningFatigue);
    }

}
