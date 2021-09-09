package fr.thibma.dragonrush.classes.hunter;

import fr.thibma.dragonrush.DragonRush;
import fr.thibma.dragonrush.items.MenuItem;
import net.minecraft.server.level.WorldServer;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_17_R1.CraftWorld;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.PolarBear;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Set;

public class HunterLevel3 implements Listener {

    private Hunter hunter;

    private final int maxCooldownBear = 60;
    private int cooldownBear = maxCooldownBear;

    private int maxCooldown = 240;
    private int cooldown = maxCooldown;

    public HunterLevel3(Hunter hunter) { this.hunter = hunter; }

    @EventHandler
    void onRightClickSkill(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack itemStack = event.getItem();

        if (player != this.hunter.getPlayer() || itemStack == null) {
            return;
        }

        if (event.getAction() != Action.RIGHT_CLICK_AIR && event.getAction() != Action.RIGHT_CLICK_BLOCK) {
            return;
        }

        if (!itemStack.equals(this.hunter.hunterSkillItem())) {
            return;
        }

        if (cooldown == maxCooldown) {
            WorldServer worldServer = ((CraftWorld) player.getWorld()).getHandle();
            HunterBear hunterBear = new HunterBear(player.getLocation(), player);
            worldServer.addEntity(hunterBear);

            new BukkitRunnable() {

                @Override
                public void run() {
                    cooldown--;
                    cooldownBear--;
                    if (cooldownBear == 0 && cooldown == maxCooldown - maxCooldownBear) {
                        System.out.println("kill");
                        for (Entity entitiesBear : player.getNearbyEntities(50, 50, 50)) {
                            if (entitiesBear instanceof PolarBear) {
                                if (entitiesBear.getCustomName().equals("Le roi des banquises - " + player.getDisplayName())) {
                                    entitiesBear.remove();
                                }
                            }
                        }
                    }
                    if (cooldown == 0) {
                        cooldown = maxCooldown;
                        cooldownBear = maxCooldownBear;
                        cancel();
                    }
                }

            }.runTaskTimer(JavaPlugin.getPlugin(DragonRush.class), 0, 20);
        }
        else if (cooldownBear > 0) {
            ArrayList<Entity> entities = (ArrayList<Entity>) player.getNearbyEntities(25, 25, 25);
            ArrayList<Block> sightBlock = (ArrayList<Block>) player.getLineOfSight(null, 25);
            ArrayList<Location> sight = new ArrayList<>();
            for (Block block : sightBlock) sight.add(block.getLocation());
            for (Location location : sight) {
                for (Entity entity : entities) {
                    if (Math.abs(entity.getLocation().getX() - location.getX()) < 1.3) {
                        if (Math.abs(entity.getLocation().getY() - location.getY()) < 1.5) {
                            if (Math.abs(entity.getLocation().getZ() - location.getZ()) < 1.3) {
                               if (entity instanceof Player) {
                                   if (!DragonRush.teams.getTeamOfAPlayer(this.hunter.getPlayer()).getPlayerList().contains(entity)) {
                                       for (Entity entitiesBear : player.getNearbyEntities(50, 50, 50)) {
                                           if (entitiesBear instanceof PolarBear) {
                                               if (entitiesBear.getCustomName().equals("Le roi des banquises - " + player.getDisplayName())) {
                                                   ((PolarBear) entitiesBear).setTarget((LivingEntity) entity);
                                                   player.sendMessage("Les ours ont pour cible :" + ((Player) entity).getDisplayName());
                                               }
                                           }
                                       }
                                   }
                               }
                            }
                        }
                    }
                }
            }
        }
        else {
            player.sendMessage("Compétence en rechargement : " + this.cooldown + "s.");
        }
    }

}
