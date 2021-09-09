package fr.thibma.dragonrush.listeners;

import fr.thibma.dragonrush.items.MenuItem;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PotionSplashEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Collection;

public class PotionSplashListener implements Listener {

    @EventHandler
    void onSpecialPotionSplash(PotionSplashEvent event) {
        ItemStack potion = event.getPotion().getItem();

        if (potion.equals(MenuItem.esuna())) {
            this.esunaEffect(event.getAffectedEntities());
        }
        else if (potion.equals(MenuItem.megaElixir())) {
            this.megaElixirEffect(event.getAffectedEntities());
        }
    }

    private void esunaEffect(Collection<LivingEntity> entities) {
        for (LivingEntity entity : entities) {
            for (PotionEffect potionEffect : entity.getActivePotionEffects()) {
                entity.removePotionEffect(potionEffect.getType());
            }
        }
    }

    private void megaElixirEffect(Collection<LivingEntity> entities) {
        for (LivingEntity entity : entities) {
            for (PotionEffect potionEffect : entity.getActivePotionEffects()) {
                PotionEffectType type = potionEffect.getType();
                if (type.equals(PotionEffectType.SLOW)
                || type.equals(PotionEffectType.SLOW_DIGGING)
                || type.equals(PotionEffectType.CONFUSION)
                || type.equals(PotionEffectType.BLINDNESS)
                || type.equals(PotionEffectType.HUNGER)
                || type.equals(PotionEffectType.WEAKNESS)
                || type.equals(PotionEffectType.POISON)
                || type.equals(PotionEffectType.WITHER)
                || type.equals(PotionEffectType.GLOWING)
                || type.equals(PotionEffectType.LEVITATION)
                || type.equals(PotionEffectType.BAD_OMEN)
                || type.equals(PotionEffectType.UNLUCK)) {
                    entity.removePotionEffect(type);
                }
            }
        }
    }

}
