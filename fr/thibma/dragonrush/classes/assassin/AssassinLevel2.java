package fr.thibma.dragonrush.classes.assassin;

import fr.thibma.dragonrush.DragonRush;
import org.bukkit.Bukkit;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;

public class AssassinLevel2 implements Listener {

    private final Assassin assassin;
    private int cooldown = 15;
    private int durationCooldown = 10;
    private boolean effect = false;

    public AssassinLevel2(Assassin assassin) { this.assassin = assassin; }

    @EventHandler
    private void onRightClickSkill(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack itemStack = event.getItem();

        if (player != this.assassin.getPlayer() || itemStack == null) {
            return;
        }

        if (event.getAction() != Action.RIGHT_CLICK_AIR && event.getAction() != Action.RIGHT_CLICK_BLOCK) {
            return;
        }

        if (!itemStack.equals(this.assassin.assassinSkillItem())) {
            return;
        }

        if (this.cooldown == 15) {
            List<Player> listPlayer = new ArrayList<>();
            for (Player concernedPlayer : Bukkit.getOnlinePlayers()) {
                if (DragonRush.teams.getTeamOfAPlayer(concernedPlayer) == DragonRush.teams.getTeamOfAPlayer(player)) {
                    concernedPlayer.sendMessage(DragonRush.teams.getTeamOfAPlayer(player).getColorString()
                            + player.getDisplayName()
                            + " §futilise "
                            + this.assassin.assassinSkillItem().getItemMeta().getDisplayName() + " !");
                }
            }
            this.setEffect();
        }
        else {
            player.sendMessage("Compétence en rechargement : " + this.cooldown + "s.");
        }
    }

    @EventHandler
    void onPassiveDamaged(EntityDamageByEntityEvent event) {
        if (!this.effect) {
            return;
        }

        if (event.getDamager() instanceof Player) {
            Player player = (Player) event.getDamager();
            if (player == this.assassin.getPlayer()) {
                event.setDamage(event.getDamage() * 2);
                this.cancelEffect();
            }
        }
    }

    @EventHandler
    void onPassiveGetDamaged(EntityDamageByEntityEvent event) {
        if (!this.effect) {
            return;
        }

        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            if (player == this.assassin.getPlayer()) {
                event.setDamage(event.getDamage() * 2);
                this.cancelEffect();
            }
        }
    }

    @EventHandler
    void onDisconnectedPlayer(PlayerQuitEvent event) {
        if (!this.effect) {
            return;
        }

        Player player = event.getPlayer();
        if (player != this.assassin.getPlayer()) {
            return;
        }
        this.cancelEffect();

    }

    private void setEffect() {
        this.effect = true;
        this.assassin.getPlayer().getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(this.assassin.getPlayer().getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).getBaseValue() + 0.03);
        PotionEffect potionEffect = new PotionEffect(PotionEffectType.INVISIBILITY, 9 * 20, 0);
        this.assassin.getPlayer().addPotionEffect(potionEffect);

        new BukkitRunnable() {
            @Override
            public void run() {
                cooldown--;
                durationCooldown--;
                if (durationCooldown == 0) {
                    cancelEffect();
                }
                if (cooldown == 0) {
                    cooldown = 15;
                    durationCooldown = 10;
                    cancel();
                }
            }
        }.runTaskTimerAsynchronously(JavaPlugin.getPlugin(DragonRush.class), 0, 20);
    }

    private void cancelEffect() {
        if (this.effect) {
            this.assassin.getPlayer().getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(this.assassin.getPlayer().getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).getBaseValue() - 0.03);
            this.assassin.getPlayer().removePotionEffect(PotionEffectType.INVISIBILITY);
            //this.durationCooldown = 10;
            this.effect = false;
        }
    }

}
