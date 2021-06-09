package fr.thibma.dragonrush.classes.hunter;

import fr.thibma.dragonrush.DragonRush;
import net.minecraft.server.v1_16_R3.EntityPolarBear;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftPolarBear;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.PolarBear;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTargetLivingEntityEvent;

import java.util.Objects;

public class HunterBearListener implements Listener {

    private final HunterBear hunterBear;

    public HunterBearListener(HunterBear hunterBear) { this.hunterBear = hunterBear; }

    @EventHandler
    void onTargetEntity(EntityTargetLivingEntityEvent event) {
        if (!(event.getEntity() instanceof PolarBear)) {
            return;
        }
        PolarBear hunterBear = (PolarBear) event.getEntity();

        if (Objects.equals(hunterBear.getCustomName(), this.hunterBear.getCustomName())) {
            return;
        }

        if (!(event.getTarget() instanceof Player)) {
            return;
        }

        Player target = (Player) event.getTarget();

        if (DragonRush.teams.getTeamOfAPlayer(this.hunterBear.getEntityPlayer()).getPlayerList().contains(target)) {
            event.setTarget(null);
        }
    }

}
