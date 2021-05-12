package fr.thibma.dragonrush.classes.miner;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class MinerLevel1Listener implements Listener {

    private final Miner miner;

    public MinerLevel1Listener(Miner miner) { this.miner = miner; }

    @EventHandler
    void onBreakBlock(BlockBreakEvent event) {
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

        if (block.getType() == Material.IRON_ORE && this.miner.ironMined < 30) {
            player.sendMessage("Fer miné");
            this.miner.ironMined++;
        }
        else if (block.getType() == Material.GOLD_ORE && this.miner.goldMined < 15) {
            player.sendMessage("Or miné");
            this.miner.goldMined++;
        }

        if (this.miner.ironMined == 30 && this.miner.goldMined == 15) {
            player.sendMessage("Objectif atteint !");
            this.miner.objectiveLevel2();
        }
    }

}
