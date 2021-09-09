package fr.thibma.dragonrush.classes.alchimist;

import fr.thibma.dragonrush.items.MenuItem;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;

public class AlchemistLevel2Listener implements Listener {

    private Alchimist alchimist;

    public AlchemistLevel2Listener(Alchimist alchemist) { this.alchimist = alchemist; }

    @EventHandler
    void onSagouCrafted(CraftItemEvent event) {
        Player player = (Player) event.getWhoClicked();
        if (player != this.alchimist.getPlayer()) {
            return;
        }

        if (!event.getRecipe().getResult().equals(MenuItem.sagou())) {
            return;
        }

        player.sendMessage("Sagou crafted !");
        this.alchimist.objectiveLevel3();
    }

}