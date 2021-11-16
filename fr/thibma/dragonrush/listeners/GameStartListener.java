package fr.thibma.dragonrush.listeners;

import fr.thibma.dragonrush.DragonRush;
import fr.thibma.dragonrush.State;
import fr.thibma.dragonrush.events.GameStartEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import static com.ryandw11.structure.CustomStructures.plugin;

public class GameStartListener implements Listener {

    @EventHandler
    private void onGameStart(GameStartEvent event) {

        for (Player player : plugin.getServer().getOnlinePlayers()) {
            player.sendTitle("§2Début de la partie !", "§7Lancement dans 10 secondes", 5, 60, 5);
        }

        DragonRush.state = State.STARTING;
        DragonRush.timerLaunchGame.runTaskTimer(JavaPlugin.getPlugin(DragonRush.class), 0, 20);
    }

}
