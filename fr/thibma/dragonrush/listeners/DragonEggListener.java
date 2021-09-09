package fr.thibma.dragonrush.listeners;

import fr.thibma.dragonrush.DragonRush;
import fr.thibma.dragonrush.items.MenuItem;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class DragonEggListener implements Listener {

    @EventHandler
    private void onDragonEggRightClick(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getClickedBlock() == null) {
            return;
        }
        Material material = event.getClickedBlock().getType();

        if (player.getInventory().firstEmpty() == -1) {
            event.setCancelled(true);
            player.sendMessage("Inventaire plein.");
            return;
        }

        if (material == Material.DRAGON_EGG) {
            event.setCancelled(true);
            for (Player players : JavaPlugin.getPlugin(DragonRush.class).getServer().getOnlinePlayers()) {
                players.sendMessage(player.getDisplayName() + " à récupéré l'ender dragon !");
            }
            event.getClickedBlock().getLocation().add(0, -1, 0).getBlock().setType(Material.AIR);
            event.getClickedBlock().setType(Material.AIR);

            player.getInventory().addItem(MenuItem.dragonEgg());
            player.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, Integer.MAX_VALUE, 0));
            player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1));
        }
    }

    @EventHandler
    void onInventoryClickEvent(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();

        if (event.getInventory().getType() != InventoryType.CRAFTING) {
            if (event.getCurrentItem().getType() != Material.DRAGON_EGG) {
                return;
            }
            event.setCancelled(true);
        }
    }

    @EventHandler
    void onDropEvent(PlayerDropItemEvent event) {
        Player player = event.getPlayer();

        if (event.getItemDrop().getItemStack().getType() != Material.DRAGON_EGG) {
            return;
        }
        event.setCancelled(true);
    }

    @EventHandler
    void onBlockPlaceEvent(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        Material material = event.getBlockPlaced().getType();

        if (material == Material.DRAGON_EGG) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    void onDeathEvent(PlayerDeathEvent event) {
        Player player = event.getEntity().getPlayer();
        if (player.getInventory().contains(Material.DRAGON_EGG)) {
            Location location = player.getLocation();
            while (location.getBlock().getType() != Material.AIR) {
                location.add(0, 1, 0);
            }
            location.getBlock().setType(Material.BEDROCK);
            location.add(0, 1, 0).getBlock().setType(Material.DRAGON_EGG);
            for (ItemStack itemStack : event.getDrops()) {
                if (itemStack != null) {
                    if (itemStack.getType() == Material.DRAGON_EGG) {
                        event.getDrops().remove(itemStack);
                    }
                }
            }
        }
    }

}
