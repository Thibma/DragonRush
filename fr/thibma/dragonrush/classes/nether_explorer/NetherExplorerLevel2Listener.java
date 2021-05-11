package fr.thibma.dragonrush.classes.nether_explorer;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class NetherExplorerLevel2Listener implements Listener {

    private final NetherExplorer netherExplorer;

    public NetherExplorerLevel2Listener(NetherExplorer netherExplorer) { this.netherExplorer = netherExplorer; }

    @EventHandler
    void onBlazeKilled(EntityDeathEvent event) {
        Entity entity = event.getEntity();
        Player player = event.getEntity().getKiller();

        if (player == null || player != this.netherExplorer.getPlayer()) {
            return;
        }

        if (entity.getType() == EntityType.BLAZE && this.netherExplorer.blazeKilled < 10) {
            player.sendMessage("Blaze tué");
            this.netherExplorer.blazeKilled++;
        }
        else if (entity.getType() == EntityType.WITHER_SKELETON && this.netherExplorer.witherSkeletonKilled < 5) {
            player.sendMessage("Wither squelette tué");
            this.netherExplorer.witherSkeletonKilled++;
        }

        if (this.netherExplorer.blazeKilled == 10 && this.netherExplorer.witherSkeletonKilled == 5) {
            player.sendMessage("Objectif atteint !");
            this.netherExplorer.objectiveLevel3();
        }
    }

}
