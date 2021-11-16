package fr.thibma.dragonrush.classes.fishman;

import fr.thibma.dragonrush.DragonRush;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;

public class FishmanLevel3 implements Listener {

    private final Fishman fishman;

    private final int maxCooldown = 180;
    private int cooldown = maxCooldown;

    private final int waterMaxCooldown = 3;
    private int waterCooldown = waterMaxCooldown;

    public FishmanLevel3(Fishman fishman) { this.fishman = fishman; }

    @EventHandler
    void onRightClickSkill(PlayerInteractEvent event){
        Player player = event.getPlayer();
        ItemStack itemStack = event.getItem();

        if (player != this.fishman.getPlayer() || itemStack == null) {
            return;
        }

        if (event.getAction() != Action.RIGHT_CLICK_AIR && event.getAction() != Action.RIGHT_CLICK_BLOCK) {
            return;
        }

        if (!itemStack.equals(this.fishman.skillFishman())) {
            return;
        }

        Location baseLocation = new Location(player.getLocation().getWorld(), player.getLocation().getX() - 7, player.getLocation().getY(), player.getLocation().getZ() - 7);

        if (this.cooldown == this.maxCooldown) {
            List<Location> waterLocation = new ArrayList<>();
            for (int i = 0; i < 16; i++) {
                for (int j = 0; j < 16; j++) {
                    Location water = new Location(baseLocation.getWorld(), baseLocation.getX() + i, baseLocation.getY() + 7, baseLocation.getZ() + j);
                    int limit = 0;
                    while (water.getBlock().getType() != Material.AIR && water.getBlock().getType() != Material.CAVE_AIR) {
                        if (limit == 5) {
                            break;
                        }
                        water.setY(water.getY() - 1);
                        limit++;
                    }
                    if (limit < 5) {
                        waterLocation.add(water);
                        if (player.getWorld().getEnvironment() == World.Environment.NETHER) {
                            water.getBlock().setType(Material.COBBLESTONE);
                        } else {
                            water.getBlock().setType(Material.WATER);
                        }
                    }
                }
            }

            new BukkitRunnable() {
                @Override
                public void run() {
                    waterCooldown--;
                    if (waterCooldown == 0) {
                        waterCooldown = waterMaxCooldown;
                        for (Location water : waterLocation) {
                            water.getBlock().setType(Material.AIR);
                        }
                        cancel();
                    }
                }
            }.runTaskTimer(JavaPlugin.getPlugin(DragonRush.class), 0, 20);

            new BukkitRunnable() {
                @Override
                public void run() {
                    cooldown--;
                    if (cooldown == 0) {
                        cooldown = maxCooldown;
                        cancel();
                    }
                }
            }.runTaskTimerAsynchronously(JavaPlugin.getPlugin(DragonRush.class), 0, 20);
        }
        else {
            player.sendMessage("Compétence en rechargement : " + this.cooldown + "s.");
        }
    }
}
