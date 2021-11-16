package fr.thibma.dragonrush.timers;

import fr.thibma.dragonrush.DragonRush;
import fr.thibma.dragonrush.events.DisplaySelectionClassesEvent;
import fr.thibma.dragonrush.players.Team;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;

public class TimerLaunchGame extends BukkitRunnable {

    private int seconds = 10;

    public TimerLaunchGame() {}


    @Override
    public void run() {
        this.seconds--;


        if (this.seconds <= 5 && this.seconds > 0) {
            for (Player player : JavaPlugin.getPlugin(DragonRush.class).getServer().getOnlinePlayers()) {
                player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK, 1, 1);
                player.sendTitle("§9Début dans: §6", this.seconds + " secondes", 1, 20, 1);
            }
        }

        if (this.seconds == 0) {
            cancel();
            for (Player player : JavaPlugin.getPlugin(DragonRush.class).getServer().getOnlinePlayers()) {
                if (DragonRush.teams.getTeamOfAPlayer(player) == null) {
                    player.setGameMode(GameMode.SPECTATOR);
                }
            }

            World overworld = Bukkit.getServer().getWorlds().get(0);
            ArrayList<Team> teams = new ArrayList<>();
            for (Team team : DragonRush.teams.getTeamList()) {
                if (!team.getPlayerList().isEmpty()) {
                    teams.add(team);
                }
            }
            double delta = (2 * Math.PI) / teams.size();
            int angle = 0;
            ArrayList<Location> spawns = new ArrayList<>();

            for (int i = 0; i < teams.size(); i++) {
                spawns.add(new Location(Bukkit.getWorlds().get(0), 1000 * Math.sin(angle), 250, 1000 * Math.cos(angle)));
                angle += delta;
            }

            int i = 0;
            for (Location spawn : spawns) {
                ArrayList<Location> blocksSpawn = new ArrayList<>();
                blocksSpawn.add(new Location(spawn.getWorld(), spawn.getX(), spawn.getY(), spawn.getZ()));
                blocksSpawn.add(new Location(spawn.getWorld(), spawn.getX() + 1, spawn.getY(), spawn.getZ()));
                blocksSpawn.add(new Location(spawn.getWorld(), spawn.getX(), spawn.getY(), spawn.getZ() + 1));
                blocksSpawn.add(new Location(spawn.getWorld(), spawn.getX() - 1, spawn.getY(), spawn.getZ()));
                blocksSpawn.add(new Location(spawn.getWorld(), spawn.getX(), spawn.getY(), spawn.getZ() - 1));
                blocksSpawn.add(new Location(spawn.getWorld(), spawn.getX() + 1, spawn.getY(), spawn.getZ() + 1));
                blocksSpawn.add(new Location(spawn.getWorld(), spawn.getX() - 1, spawn.getY(), spawn.getZ() - 1));
                blocksSpawn.add(new Location(spawn.getWorld(), spawn.getX() + 1, spawn.getY(), spawn.getZ() - 1));
                blocksSpawn.add(new Location(spawn.getWorld(), spawn.getX() - 1, spawn.getY(), spawn.getZ() + 1));

                for (Location block : blocksSpawn) {
                    block.getBlock().setType(Material.GLASS);
                }

                for (Player player : teams.get(i).getPlayerList()) {
                    player.teleport(new Location(spawn.getWorld(), spawn.getX(), spawn.getY() + 2, spawn.getZ()));
                    player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 20 * 30, 10));
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 20 * 30, 10));
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 20 * 30, 10));
                    player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 20 * 30, 128));

                    DisplaySelectionClassesEvent displaySelectionClassesEvent = new DisplaySelectionClassesEvent();
                    Bukkit.getServer().getPluginManager().callEvent(displaySelectionClassesEvent);
                }
            }
        }

    }

}
