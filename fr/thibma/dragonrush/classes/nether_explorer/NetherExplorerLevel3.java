package fr.thibma.dragonrush.classes.nether_explorer;

import fr.thibma.dragonrush.DragonRush;
import fr.thibma.dragonrush.utils.Directions;
import org.bukkit.Axis;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Orientable;
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

public class NetherExplorerLevel3 implements Listener {

    private final NetherExplorer netherExplorer;
    private final int maxCooldown = 300;
    private int cooldown = maxCooldown;

    private final int portalMaxCooldown = 10;
    private int portalCooldown = portalMaxCooldown;

    public NetherExplorerLevel3 (NetherExplorer netherExplorer) { this.netherExplorer = netherExplorer; }

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

        if (!itemStack.equals(this.netherExplorer.skillItemLevel3())) {
            return;
        }

        if (this.cooldown == this.maxCooldown) {
            List<Block> lastTwoTargetBlocks = player.getLastTwoTargetBlocks(null, 5);
            Block targetBlock = lastTwoTargetBlocks.get(1);
            Block adjacentBlock = lastTwoTargetBlocks.get(0);
            Location finalLocation = targetBlock.getLocation();
            if (targetBlock.getType() != Material.AIR) {
                switch (targetBlock.getFace(adjacentBlock)) {
                    case DOWN -> finalLocation.setY(finalLocation.getY() - 1);
                    case EAST -> finalLocation.setX(finalLocation.getX() + 1);
                    case WEST -> finalLocation.setX(finalLocation.getX() - 1);
                    case NORTH -> finalLocation.setZ(finalLocation.getZ() - 1);
                    case SOUTH -> finalLocation.setZ(finalLocation.getZ() + 1);
                }
            }
            int limit = 0;
            while (finalLocation.getBlock().getType().equals(Material.AIR)) {
                if (limit == 5) {
                    return;
                }
                limit++;
                finalLocation.setY(finalLocation.getY()-1);
            }
            finalLocation.setY(finalLocation.getY()+1);
            if (this.placePortal(finalLocation, this.getDirections(player.getLocation().getYaw()))) {
                finalLocation.getWorld().strikeLightning(new Location(finalLocation.getWorld(), finalLocation.getX(), finalLocation.getY() + 3, finalLocation.getZ()));
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
                player.sendMessage("Il n'y a pas la place pour faire apparaître un portail.");
            }

        }
        else {
            player.sendMessage("Compétence en rechargement : " + this.cooldown + "s.");
        }
    }

    private boolean placePortal(Location l, Directions d) {
        List<Location> obsidianLocation = new ArrayList<>();
        List<Location> portalLocation = new ArrayList<>();
        portalLocation.add(new Location(l.getWorld(), l.getX(), l.getY() + 1, l.getZ()));
        portalLocation.add(new Location(l.getWorld(), l.getX(), l.getY() + 2, l.getZ()));
        if (d == Directions.NORTH || d == Directions.SOUTH) {
            obsidianLocation.add(new Location(l.getWorld(), l.getX(), l.getY(), l.getZ()));
            obsidianLocation.add(new Location(l.getWorld(), l.getX() - 1, l.getY(), l.getZ()));
            obsidianLocation.add(new Location(l.getWorld(), l.getX() - 1, l.getY() + 1, l.getZ()));
            obsidianLocation.add(new Location(l.getWorld(), l.getX() - 1, l.getY() + 2, l.getZ()));
            obsidianLocation.add(new Location(l.getWorld(), l.getX() - 1, l.getY() + 3, l.getZ()));
            obsidianLocation.add(new Location(l.getWorld(), l.getX(), l.getY() + 3, l.getZ()));
            obsidianLocation.add(new Location(l.getWorld(), l.getX() + 1, l.getY(), l.getZ()));
            obsidianLocation.add(new Location(l.getWorld(), l.getX() + 1, l.getY() + 1, l.getZ()));
            obsidianLocation.add(new Location(l.getWorld(), l.getX() + 1, l.getY() + 2, l.getZ()));
            obsidianLocation.add(new Location(l.getWorld(), l.getX() + 1, l.getY() + 3, l.getZ()));

        }
        else {
            obsidianLocation.add(new Location(l.getWorld(), l.getX(), l.getY(), l.getZ()));
            obsidianLocation.add(new Location(l.getWorld(), l.getX(), l.getY(), l.getZ() - 1));
            obsidianLocation.add(new Location(l.getWorld(), l.getX(), l.getY() + 1, l.getZ() - 1));
            obsidianLocation.add(new Location(l.getWorld(), l.getX(), l.getY() + 2, l.getZ() - 1));
            obsidianLocation.add(new Location(l.getWorld(), l.getX(), l.getY() + 3, l.getZ() - 1));
            obsidianLocation.add(new Location(l.getWorld(), l.getX(), l.getY() + 3, l.getZ()));
            obsidianLocation.add(new Location(l.getWorld(), l.getX(), l.getY(), l.getZ() + 1));
            obsidianLocation.add(new Location(l.getWorld(), l.getX(), l.getY() + 1, l.getZ() + 1));
            obsidianLocation.add(new Location(l.getWorld(), l.getX(), l.getY() + 2, l.getZ() + 1));
            obsidianLocation.add(new Location(l.getWorld(), l.getX(), l.getY() + 3, l.getZ() + 1));
        }

        for (Location checkLocation : obsidianLocation) {
            if (checkLocation.getBlock().getType() != Material.AIR) {
                return false;
            }
        }

        for (Location checkLocation : portalLocation) {
            if (checkLocation.getBlock().getType() != Material.AIR) {
                return false;
            }
        }

        for (Location obsidian : obsidianLocation) {
            obsidian.getBlock().setType(Material.OBSIDIAN);
        }

        for (Location portal : portalLocation) {
            portal.getBlock().setType(Material.NETHER_PORTAL);
            BlockData blockData = portal.getBlock().getBlockData();
            Orientable orientable = (Orientable) blockData;
            if (d == Directions.NORTH || d == Directions.SOUTH) {
                orientable.setAxis(Axis.X);
            }
            else {
                orientable.setAxis(Axis.Z);
            }
            portal.getBlock().setBlockData(blockData);
        }


        new BukkitRunnable() {
            @Override
            public void run() {
                portalCooldown--;
                if (portalCooldown == 0) {
                    portalCooldown = portalMaxCooldown;
                    for (Location obsidian : obsidianLocation) {
                        obsidian.getBlock().setType(Material.AIR);
                    }
                    for (Location portal : portalLocation) {
                        portal.getBlock().setType(Material.AIR);
                    }
                    cancel();
                }
            }
        }.runTaskTimer(JavaPlugin.getPlugin(DragonRush.class), 0, 20);

        return true;
    }

    private Directions getDirections(double yaw) {
        if (yaw >= 135 || yaw < -135) {
            return Directions.NORTH;
        }
        if (yaw >= -135 && yaw < -45) {
            return Directions.EAST;
        }
        if (yaw >= -45 && yaw < 45) {
            return Directions.SOUTH;
        }
        if(yaw >= 45 && yaw < 135) {
            return  Directions.WEST;
        }
        return null;
    }

}
