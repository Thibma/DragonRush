package fr.thibma.dragonrush.classes.miner;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Map;

public class MinerLevel1 implements Listener {

    private final Miner miner;

    public MinerLevel1 (Miner miner) { this.miner = miner; }

    @EventHandler
    void onBreakOre(BlockBreakEvent event) {
        Player player = event.getPlayer();

        if (player != this.miner.getPlayer()) {
            return;
        }

        Block block = event.getBlock();

        if (block.getType() != Material.IRON_ORE && block.getType() != Material.GOLD_ORE) {
            return;
        }

        if (!player.getInventory().getItemInMainHand().getType().toString().contains("PICKAXE")) {
            return;
        }

        Map<Enchantment, Integer> enchantment = player.getInventory().getItemInMainHand().getEnchantments();

        double random = Math.floor(Math.random()*(100 - 0 + 1) + 0);

        ItemStack dropItem = new ItemStack(Material.AIR);
        int dropExp = 0;

        if (block.getType() == Material.IRON_ORE) {
            if (player.getInventory().getItemInMainHand().getType().equals(Material.WOODEN_PICKAXE)
                    || player.getInventory().getItemInMainHand().getType().equals(Material.GOLDEN_PICKAXE)) {
                return;
            }
            dropItem.setType(Material.IRON_INGOT);
            dropExp = 2;
        }
        else {
            if (player.getInventory().getItemInMainHand().getType().equals(Material.WOODEN_PICKAXE)
                    || player.getInventory().getItemInMainHand().getType().equals(Material.STONE_PICKAXE)
                    || player.getInventory().getItemInMainHand().getType().equals(Material.GOLDEN_PICKAXE)) {
                return;
            }
            dropItem.setType(Material.GOLD_INGOT);
            dropExp = 4;
        }

        if (enchantment.containsKey(Enchantment.LOOT_BONUS_BLOCKS)) {
            int level = player.getInventory().getItemInMainHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS);
            switch (level) {
                case 1 -> {
                    if (random >= 33) {
                        dropItem.setAmount(1);
                    }
                    else {
                        dropItem.setAmount(2);
                    }
                }
                case 2 -> {
                    if (random >= 50) {
                        dropItem.setAmount(1);
                    }
                    else if (random < 50 && random >= 25 ) {
                        dropItem.setAmount(2);
                    }
                    else {
                        dropItem.setAmount(3);
                    }
                }
                case 3 -> {
                    if (random >= 60) {
                        dropItem.setAmount(1);
                    }
                    else if (random < 60 && random >= 40) {
                        dropItem.setAmount(2);
                    }
                    else if (random < 40 && random >= 20) {
                        dropItem.setAmount(3);
                    }
                    else {
                        dropItem.setAmount(4);
                    }
                }
            }
        }
        else {
            dropItem.setAmount(1);
        }
        event.setDropItems(false);
        event.setExpToDrop(dropExp);
        Location location = block.getLocation();
        location.getWorld().dropItemNaturally(location, dropItem);
    }
}
