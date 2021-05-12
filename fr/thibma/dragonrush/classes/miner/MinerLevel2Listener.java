package fr.thibma.dragonrush.classes.miner;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class MinerLevel2Listener implements Listener {

    private final Miner miner;

    public MinerLevel2Listener(Miner miner) { this.miner = miner; }

    @EventHandler
    void onBreakBlock(BlockBreakEvent event) {
        Player player = event.getPlayer();

        if (player != this.miner.getPlayer()) {
            return;
        }

        Block block = event.getBlock();

        if (block.getType() != Material.DIAMOND_ORE && block.getType() != Material.EMERALD_ORE) {
            return;
        }

        if (!player.getInventory().getItemInMainHand().getType().toString().contains("PICKAXE")) {
            return;
        }

        this.miner.diamEmeraldMined++;
        player.sendMessage("Diamant ou emeraude cassé");
        if (this.miner.diamEmeraldMined == 10) {
            player.sendMessage("Objectif atteint !");
            this.miner.objectiveLevel3();
        }
    }

}
