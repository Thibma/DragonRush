package fr.thibma.dragonrush.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class DisplaySelectionTeamEvent extends Event {

    private final Player player;

    public DisplaySelectionTeamEvent(Player player) {
        this.player = player;
    }

    public Player getPlayer() { return this.player; }

    private static final HandlerList HANDLERS = new HandlerList();

    @Override
    public HandlerList getHandlers() { return HANDLERS; }

    public static HandlerList getHandlerList() { return HANDLERS; }
}
