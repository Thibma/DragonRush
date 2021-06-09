package fr.thibma.dragonrush.classes.fishman;

import fr.thibma.dragonrush.DragonRush;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class FishmanLevel1 implements Listener {

    private final Fishman fishman;

    public FishmanLevel1 (Fishman fishman) { this.fishman = fishman; }

    @EventHandler
    void onPlayerInWater(PlayerMoveEvent event) {
        Player player = event.getPlayer();

        if (player != this.fishman.getPlayer()) {
            return;
        }

        Material material = player.getLocation().getBlock().getType();

        if (material != Material.WATER) {
            return;
        }

        switch (this.fishman.getLevel()) {
            case 1 -> {
                this.fishman.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 20 * 2, 0));
                this.fishman.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 20 * 2, 0));
            }

            case 2 -> {
                for (Player teamPlayer : DragonRush.teams.getTeamOfAPlayer(player).getPlayerList()) {
                    if (teamPlayer.getLocation().getBlock().getType() == Material.WATER) {
                        teamPlayer.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 20 * 2, 0));
                        teamPlayer.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 20 * 2, 0));
                        teamPlayer.addPotionEffect(new PotionEffect(PotionEffectType.DOLPHINS_GRACE, 20 * 2, 0));
                        teamPlayer.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 20 * 2, 0));
                        teamPlayer.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 20 * 2, 0));
                    }
                }
            }
            case 3 -> {
                for (Player teamPlayer : DragonRush.teams.getTeamOfAPlayer(player).getPlayerList()) {
                    if (teamPlayer.getLocation().getBlock().getType() == Material.WATER) {
                        teamPlayer.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 20 * 2, 1));
                        teamPlayer.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 20 * 2, 0));
                        teamPlayer.addPotionEffect(new PotionEffect(PotionEffectType.DOLPHINS_GRACE, 20 * 2, 0));
                        teamPlayer.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 20 * 2, 0));
                        teamPlayer.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 20 * 2, 1));
                        teamPlayer.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 20 * 2, 1));
                    }
                }
            }
        }
    }

}
