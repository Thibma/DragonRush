package fr.thibma.dragonrush.classes.hunter;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftWolf;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.List;

public class HunterLevel2 implements Listener {

    private final Hunter hunter;

    public HunterLevel2(Hunter hunter) { this.hunter = hunter; }

    @EventHandler
    void onDamageEntity(EntityDamageByEntityEvent event) {
        if (!(event.getDamager() instanceof Player)) {
            return;
        }
        Player player = (Player) event.getDamager();

        if (event.getEntity() instanceof Player) {
            return;
        }

        switch (this.hunter.getLevel()) {
            case 2 -> event.setDamage(event.getDamage() + (event.getDamage() * 25 / 100));
            case 3 -> event.setDamage(event.getDamage() + (event.getDamage() * 50 / 100));
        }
    }

    @EventHandler
    void onDeathEntity(EntityDeathEvent event) {
        if (event.getEntity() instanceof Player) {
            return;
        }

        if (!(event.getEntity().getLastDamageCause() instanceof EntityDamageByEntityEvent)) {
            return;
        }

        EntityDamageByEntityEvent entityDamageEvent = (EntityDamageByEntityEvent) event.getEntity().getLastDamageCause();

        if (entityDamageEvent.getDamager() instanceof CraftPlayer) {
            Player player = (Player) entityDamageEvent.getDamager();
            if (player != this.hunter.getPlayer()) {
                return;
            }
            List<ItemStack> loot = this.getLoot(event);
            int getExp = this.getExp(event);

            event.setDroppedExp(getExp);


            Location location = event.getEntity().getLocation();
            for (ItemStack looting : loot) {
                location.getWorld().dropItemNaturally(location, looting);
            }
            event.getDrops().clear();

            if (this.hunter.getLevel() == 3) {
                this.setPotionEffect();
            }

        }
        else if (entityDamageEvent.getDamager() instanceof CraftWolf) {
            Wolf wolf = (Wolf) entityDamageEvent.getDamager();
            if (wolf.getCustomName() == null) {
                return;
            }
            if (!wolf.getCustomName().equals(this.hunter.hunterWolf.wolfName())) {
                return;
            }
            List<ItemStack> loot = this.getLoot(event);

            Location location = this.hunter.getPlayer().getLocation();
            for (ItemStack looting : loot) {
                location.getWorld().dropItemNaturally(location, looting);
            }

            event.getDrops().clear();
            event.setDroppedExp(0);

            if (this.hunter.getLevel() == 3) {
                this.setPotionEffect();
            }
        }

    }

    private List<ItemStack> getLoot(EntityDeathEvent event) {
        List<ItemStack> itemStackList = event.getDrops();

        for (ItemStack item : itemStackList) {
            switch (this.hunter.getLevel()) {
                case 2 -> item.setAmount(item.getAmount() * 2);
                case 3 -> item.setAmount(item.getAmount() * 3);
            }
        }

        return itemStackList;
    }

    private int getExp(EntityDeathEvent event) {
        int expDropped = event.getDroppedExp();
        switch (this.hunter.getLevel()) {
            case 2 -> expDropped = expDropped * 2;
            case 3 -> expDropped = expDropped * 3;
        }
        return expDropped;
    }

    private void setPotionEffect() {
        this.hunter.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20*5, 0));
    }

}
