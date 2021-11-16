package fr.thibma.dragonrush.listeners;

import fr.minuskube.netherboard.Netherboard;
import fr.minuskube.netherboard.bukkit.BPlayerBoard;
import fr.thibma.dragonrush.DragonRush;
import fr.thibma.dragonrush.classes.ClassSelection;
import fr.thibma.dragonrush.events.AddClassEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class AddClassListener implements Listener {

    @EventHandler
    public void onPlayerAddClass(AddClassEvent event) {

        DragonRush.classes.addClass(ClassSelection.getClass(event.getPlayerClass(), event.getPlayer()));
        //DragonRush.classes.getPlayerClass(player).atBegining();
        BPlayerBoard board = Netherboard.instance().getBoard(event.getPlayer());
        board.set("§7§l" + DragonRush.classes.getPlayerClass(event.getPlayer()).getClassName(), 8);

        event.getPlayer().sendMessage("Vous avez obtenu la classe " + event.getPlayerClass().toString());

    }

}
