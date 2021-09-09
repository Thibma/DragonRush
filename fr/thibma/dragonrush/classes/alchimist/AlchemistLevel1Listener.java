package fr.thibma.dragonrush.classes.alchimist;

import fr.thibma.dragonrush.items.MenuItem;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;

public class AlchemistLevel1Listener implements Listener {

    private Alchimist alchimist;

    public AlchemistLevel1Listener(Alchimist alchemist) { this.alchimist = alchemist; }

    @EventHandler
    void onSanatoriumCrafted(CraftItemEvent event) {
        Player player = (Player) event.getWhoClicked();
        if (player != this.alchimist.getPlayer()) {
            return;
        }

        if (!event.getRecipe().getResult().equals(MenuItem.sanatorium())) {
            return;
        }

        player.sendMessage("Sanatorium crafted !");
        this.alchimist.objectiveLevel2();
    }

}
