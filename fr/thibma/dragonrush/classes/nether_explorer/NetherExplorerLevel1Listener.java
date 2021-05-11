package fr.thibma.dragonrush.classes.nether_explorer;

import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;

public class NetherExplorerLevel1Listener implements Listener {

    private final NetherExplorer netherExplorer;

    public NetherExplorerLevel1Listener(NetherExplorer netherExplorer) { this.netherExplorer = netherExplorer; }

    @EventHandler
    void onNetherEnter(PlayerChangedWorldEvent event) {
        Player player = event.getPlayer();

        if (player != this.netherExplorer.getPlayer()) {
            return;
        }

        if (player.getWorld().getEnvironment() == World.Environment.NETHER) {
            player.sendMessage("Vous êtes rentrés dans le nether !");
            player.sendMessage("Objectif atteint");
            this.netherExplorer.objectiveLevel2();
        }
    }
}
