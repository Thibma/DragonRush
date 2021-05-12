package fr.thibma.dragonrush.classes.miner;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class MinerLevel2 implements Listener {

    private final Miner miner;

    public MinerLevel2 (Miner miner) { this.miner = miner; }

    @EventHandler
    void onBlockDig(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if (player != this.miner.getPlayer()) {
            return;
        }

        if (event.getItem() == null) {
            return;
        }

        if (event.getAction() != Action.LEFT_CLICK_BLOCK) {
            return;
        }

        if (!event.getItem().getType().toString().contains("PICKAXE")) {
            return;
        }

        switch (this.miner.getLevel()) {
            case 2 -> {
                player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 3 * 20, 0));
            }
            case 3 -> {
                player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 3 * 20, 1));
            }
        }
    }

}
