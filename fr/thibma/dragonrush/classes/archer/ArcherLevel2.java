package fr.thibma.dragonrush.classes.archer;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Map;

public class ArcherLevel2 implements Listener {

    private final Archer archer;

    public ArcherLevel2(Archer archer) { this.archer = archer; }

    @EventHandler
    void onBreakGravel(BlockBreakEvent event) {
        Block block = event.getBlock();
        Player player = event.getPlayer();

        if (player != this.archer.getPlayer()) {
            return;
        }

        if (block.getType() != Material.GRAVEL) {
            return;
        }

        event.setDropItems(false);

        Location location = block.getLocation();

        ItemStack arrow = new ItemStack(Material.ARROW);
        ItemMeta itemMetaArrow = arrow.getItemMeta();
        ArrayList<String> loreArrow = new ArrayList<>();
        itemMetaArrow.setDisplayName("§fFlèche d'entraînement");
        loreArrow.add("§fCommun");
        loreArrow.add("§aUne flèche utilisée lors des");
        loreArrow.add("§aentraînements sur des cibles fixes.");
        itemMetaArrow.setLore(loreArrow);
        arrow.setItemMeta(itemMetaArrow);

        Map<Enchantment, Integer> enchantment = player.getInventory().getItemInMainHand().getEnchantments();

        double random = Math.floor(Math.random()*(100 - 0 + 1) + 0);

        if (enchantment.containsKey(Enchantment.LOOT_BONUS_BLOCKS)) {
            int level = player.getInventory().getItemInMainHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS);
            switch (level) {
                case 1 -> {
                    if (random > 14.29) {
                        location.getWorld().dropItemNaturally(location, new ItemStack(Material.GRAVEL));
                    }
                    else if (random > 5 && random < 14.29) {
                        arrow.setAmount(1);
                        location.getWorld().dropItemNaturally(location, arrow);
                    }
                    else {
                        arrow.setAmount(2);
                        location.getWorld().dropItemNaturally(location, arrow);
                    }
                }
                case 2 -> {
                    if (random > 25) {
                        location.getWorld().dropItemNaturally(location, new ItemStack(Material.GRAVEL));
                    }
                    else if (random > 14.29 && random < 25) {
                        arrow.setAmount(1);
                        location.getWorld().dropItemNaturally(location, arrow);
                    }
                    else {
                        arrow.setAmount(2);
                        location.getWorld().dropItemNaturally(location, arrow);
                    }
                }
                case 3 -> {
                    if (random > 35) {
                        arrow.setAmount(1);
                    }
                    else {
                        arrow.setAmount(2);
                    }
                    location.getWorld().dropItemNaturally(location, arrow);
                }
            }
        }
        else {
            if (random > 10) {
                location.getWorld().dropItemNaturally(location, new ItemStack(Material.GRAVEL));
            }
            else if (random > 3 && random < 10) {
                arrow.setAmount(1);
                location.getWorld().dropItemNaturally(location, arrow);
            }
            else {
                arrow.setAmount(2);
                location.getWorld().dropItemNaturally(location, arrow);
            }
        }
    }

    @EventHandler
    void onDamageArrow(EntityDamageByEntityEvent event) {
        if (!(event.getDamager() instanceof Arrow)) {
            return;
        }
        Arrow arrow = (Arrow) event.getDamager();
        if (!(arrow.getShooter() instanceof Player)) {
            return;
        }
        Player player = (Player) arrow.getShooter();
        if (player != this.archer.getPlayer()) {
            return;
        }

        if (player.getInventory().getItemInMainHand().getType() == Material.CROSSBOW || player.getInventory().getItemInOffHand().getType() == Material.CROSSBOW) {
            return;
        }

        if (this.archer.getLevel() == 2) {
            event.setDamage(event.getDamage() + (event.getDamage() * 10 / 100));
        }
        else if (this.archer.getLevel() == 3) {
            event.setDamage(event.getDamage() + (event.getDamage() * 20 / 100));
        }

    }

}
