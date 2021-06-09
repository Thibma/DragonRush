package fr.thibma.dragonrush.classes.hunter;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Wolf;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Objects;

public class HunterWolf extends BukkitRunnable {

    private int cooldownMax = 600;
    private int cooldown = 10;

    private final Hunter hunter;

    public HunterWolf(Hunter hunter) { this.hunter = hunter; }

    @Override
    public void run() {
        this.cooldown--;

        if (this.cooldown == 0) {
            this.cooldown = this.cooldownMax;
            Wolf wolf = (Wolf) this.hunter.getPlayer().getWorld().spawnEntity(this.hunter.getPlayer().getLocation(), EntityType.WOLF);
            wolf.setCustomName(this.wolfName());
            wolf.setOwner(this.hunter.getPlayer());
            wolf.setAdult();
            switch (this.hunter.getLevel()) {
                case 2 -> {
                    wolf.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 0));
                    wolf.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 0));
                }
                case 3 -> {
                    wolf.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 1));
                    wolf.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1));
                }
            }
        }
    }

    public void boostLevel() {

        switch (this.hunter.getLevel()) {
            case 2 -> {
                this.cooldownMax = 480;
                if (this.cooldown > 480) {
                    this.cooldown = 480;
                }
            }
            case 3 -> {
                this.cooldownMax = 300;
                if (this.cooldown > 300) {
                    this.cooldown = 300;
                }
            }
        }

        for (LivingEntity entity : Objects.requireNonNull(Bukkit.getServer().getWorld(this.hunter.getPlayer().getWorld().getUID())).getLivingEntities()) {
            if (entity instanceof Wolf) {
                if (Objects.equals(entity.getCustomName(), this.wolfName())) {
                    switch (this.hunter.getLevel()) {
                        case 2 -> {
                            entity.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 0));
                            entity.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 0));
                        }
                        case 3 -> {
                            entity.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 1));
                            entity.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1));
                        }
                    }
                }
            }
        }
    }

    public String wolfName() {
        return "Chien de " + this.hunter.getPlayer().getDisplayName();
    }
}
