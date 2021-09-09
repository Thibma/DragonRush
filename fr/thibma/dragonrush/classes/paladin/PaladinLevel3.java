package fr.thibma.dragonrush.classes.paladin;

import fr.thibma.dragonrush.DragonRush;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class PaladinLevel3 implements Listener {

    private final Paladin paladin;

    private int cooldown = 60;

    public PaladinLevel3(Paladin paladin) { this.paladin = paladin; }

    @EventHandler
    private void onRightClickSkill(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack itemStack = event.getItem();

        if (player != paladin.getPlayer() || itemStack == null) {
            return;
        }

        if (event.getAction() != Action.LEFT_CLICK_AIR && event.getAction() != Action.LEFT_CLICK_BLOCK) {
            return;
        }

        if (!itemStack.equals(paladin.paladinSkillItem())) {
            return;
        }

        if (this.cooldown == 60) {
            List<Player> listPlayer = new ArrayList<>();
            for (Player concernedPlayer : Bukkit.getOnlinePlayers()) {
                if (concernedPlayer.getWorld() == player.getWorld()) {
                    if (concernedPlayer.getLocation().distance(player.getLocation()) <= 20) {
                        listPlayer.add(concernedPlayer);
                    }
                }
            }

            for (Player playerConcerned : listPlayer) {
                playerConcerned.sendMessage(DragonRush.teams.getTeamOfAPlayer(player).getColorString()
                        + player.getDisplayName()
                        + " §futilise "
                        + this.paladin.paladinSkillItem().getItemMeta().getDisplayName() + " !");
                if (DragonRush.teams.getTeamOfAPlayer(playerConcerned) == DragonRush.teams.getTeamOfAPlayer(player)) {
                    this.effect(playerConcerned);
                }
            }

            new BukkitRunnable() {
                @Override
                public void run() {
                    cooldown--;
                    if (cooldown == 0) {
                        cooldown = 60;
                        cancel();
                    }
                }
            }.runTaskTimerAsynchronously(JavaPlugin.getPlugin(DragonRush.class), 0, 20);
        }
        else {
            player.sendMessage("Compétence en rechargement : " + this.cooldown + "s.");
        }

    }

    private void effect(Player player) {
        PotionEffect health = new PotionEffect(PotionEffectType.HEALTH_BOOST, 30 * 20, 0);
        PotionEffect resistance = new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 30 * 20, 0);
        PotionEffect fireResistance = new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 30 * 20, 0);
        player.addPotionEffect(health);
        player.addPotionEffect(resistance);
        player.addPotionEffect(fireResistance);
        player.setHealth(player.getHealth() + 4);
    }
}
