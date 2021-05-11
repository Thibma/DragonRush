package fr.thibma.dragonrush.classes.nether_explorer;

import fr.thibma.dragonrush.DragonRush;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;

public class NetherExplorerLevel2 implements Listener {

    private final NetherExplorer netherExplorer;
    private int cooldown = 120;

    public NetherExplorerLevel2 (NetherExplorer netherExplorer) { this.netherExplorer = netherExplorer; }

    @EventHandler
    void onDimensionChanged(PlayerChangedWorldEvent event) {
        Player player = event.getPlayer();

        if (!DragonRush.teams.getTeamOfAPlayer(this.netherExplorer.getPlayer()).getPlayerList().contains(player)) {
            return;
        }

        this.detectDimension(player);
    }

    @EventHandler
    void onMilkDrink(PlayerItemConsumeEvent event) {
        Player player = event.getPlayer();
        if (!DragonRush.teams.getTeamOfAPlayer(this.netherExplorer.getPlayer()).getPlayerList().contains(player)) {
            return;
        }
        if (!event.getItem().getType().equals(Material.MILK_BUCKET)) {
            return;
        }
        Bukkit.getScheduler().scheduleSyncDelayedTask(JavaPlugin.getPlugin(DragonRush.class), () -> this.detectDimension(player), 1);


    }

    public void detectDimension(Player player) {
        if (this.netherExplorer.getPlayer().equals(player)) {
            switch (this.netherExplorer.getLevel()) {
                case 2 -> {
                    if (player.getWorld().getEnvironment() == World.Environment.NETHER) {
                        this.addPotionEffect(player);
                        for (Player teamPlayer : DragonRush.teams.getTeamOfAPlayer(player).getPlayerList()) {
                            if (teamPlayer.getWorld().getEnvironment() == World.Environment.NETHER) {
                                this.addPotionEffect(teamPlayer);
                            }
                        }
                    }
                    else {
                        this.removePotionEffect(player);
                        for (Player teamPlayer : DragonRush.teams.getTeamOfAPlayer(player).getPlayerList()) {
                            if (teamPlayer.getWorld().getEnvironment() == World.Environment.NETHER) {
                                this.removePotionEffect(teamPlayer);
                            }
                        }
                    }
                }
                case 3 -> {
                    if (player.getWorld().getEnvironment() == World.Environment.NETHER || player.getWorld().getEnvironment() == World.Environment.THE_END) {
                        this.addPotionEffect(player);
                        for (Player teamPlayer : DragonRush.teams.getTeamOfAPlayer(player).getPlayerList()) {
                            if (teamPlayer.getWorld().getEnvironment() == World.Environment.NETHER || player.getWorld().getEnvironment() == World.Environment.THE_END) {
                                this.addPotionEffect(teamPlayer);
                            }
                        }
                    }
                    else {
                        this.removePotionEffect(player);
                        for (Player teamPlayer : DragonRush.teams.getTeamOfAPlayer(player).getPlayerList()) {
                            if (teamPlayer.getWorld().getEnvironment() == World.Environment.NETHER || player.getWorld().getEnvironment() == World.Environment.THE_END) {
                                this.removePotionEffect(teamPlayer);
                            }
                        }
                    }
                }
            }
        }
        else {
            switch (this.netherExplorer.getLevel()) {
                case 2 -> {
                    if (player.getWorld().getEnvironment() == World.Environment.NETHER && this.netherExplorer.getPlayer().getWorld().getEnvironment() == World.Environment.NETHER) {
                        this.addPotionEffect(player);
                    }
                    else {
                        this.removePotionEffect(player);
                    }
                }
                case 3 -> {
                    if ((player.getWorld().getEnvironment() == World.Environment.NETHER || player.getWorld().getEnvironment() == World.Environment.THE_END)
                            && (this.netherExplorer.getPlayer().getWorld().getEnvironment() == World.Environment.NETHER || this.netherExplorer.getPlayer().getWorld().getEnvironment() == World.Environment.THE_END)) {
                        this.addPotionEffect(player);
                    }
                    else {
                        this.removePotionEffect(player);
                    }
                }
            }
        }
    }

    public void addPotionEffect(Player player) {
        switch (this.netherExplorer.getLevel()) {
            case 2 -> {
                player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 0));
                player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, Integer.MAX_VALUE, 0));
            }
            case 3 -> {
                player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1));
                player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, Integer.MAX_VALUE, 0));
            }
        }
    }

    public void removePotionEffect(Player player) {
        player.removePotionEffect(PotionEffectType.SPEED);
        player.removePotionEffect(PotionEffectType.REGENERATION);
    }


    @EventHandler
    void onRightClickSkill(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack itemStack = event.getItem();

        if (player != this.netherExplorer.getPlayer() || itemStack == null) {
            return;
        }

        if (event.getAction() != Action.RIGHT_CLICK_AIR && event.getAction() != Action.RIGHT_CLICK_BLOCK) {
            return;
        }

        if (!itemStack.equals(this.netherExplorer.skillItemLevel2())) {
            return;
        }

        if (this.cooldown == 120) {
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
                        + this.netherExplorer.skillItemLevel2().getItemMeta().getDisplayName() + " !");
                if (DragonRush.teams.getTeamOfAPlayer(playerConcerned) == DragonRush.teams.getTeamOfAPlayer(player)) {
                    this.effect(playerConcerned);
                }
            }
            new BukkitRunnable() {
                @Override
                public void run() {
                    cooldown--;
                    if (cooldown == 0) {
                        cooldown = 120;
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
        player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 60 * 20, 0));
    }
}
