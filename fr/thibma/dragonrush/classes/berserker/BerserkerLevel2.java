package fr.thibma.dragonrush.classes.berserker;

import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class BerserkerLevel2 implements Listener {

    private final Berserker berserker;

    public BerserkerLevel2(Berserker berserker) { this.berserker = berserker; }


    @EventHandler
    void onDamageEvent(EntityDamageEvent event) {
        if (!(event.getEntity() instanceof Player)) {
            return;
        }
        Player player = (Player) event.getEntity();
        if (player != this.berserker.getPlayer()) {
            return;
        }

        if (player.getHealth() <= this.berserker.getPlayer().getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue() / 2) {
            if (!this.berserker.passive) {
                this.berserker.passive = true;
                this.setPassive();
            }
        }
    }

    @EventHandler
    void onRegainEvent(EntityRegainHealthEvent event) {
        if (!(event.getEntity() instanceof Player)) {
            return;
        }
        Player player = (Player) event.getEntity();
        if (player != this.berserker.getPlayer()) {
            return;
        }

        if (player.getHealth() >= this.berserker.getPlayer().getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue() / 2) {
            if (this.berserker.passive) {
                this.berserker.passive = false;
                this.setPassive();
            }
        }
    }

    @EventHandler
    void onRespawnEvent(PlayerRespawnEvent event) {
        Player player = event.getPlayer();
        if (player != this.berserker.getPlayer()) {
            return;
        }
        if (this.berserker.passive) {
            this.berserker.passive = false;
            this.setPassive();
        }
    }

    void setPassive() {
        if (this.berserker.passive) {
            this.berserker.getPlayer().sendMessage("Rage activée");
            this.berserker.getPlayer().getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(this.berserker.getPlayer().getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).getBaseValue() + 2);
            this.berserker.getPlayer().getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(this.berserker.getPlayer().getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).getBaseValue() + 0.035);
        }
        else {
            this.berserker.getPlayer().sendMessage("Rage désactivée");
            this.berserker.getPlayer().getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(this.berserker.getPlayer().getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).getBaseValue() - 2);
            this.berserker.getPlayer().getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(this.berserker.getPlayer().getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).getBaseValue() - 0.035);
        }
    }
}
