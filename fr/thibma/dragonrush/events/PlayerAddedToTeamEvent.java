package fr.thibma.dragonrush.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PlayerAddedToTeamEvent extends Event {

    public PlayerAddedToTeamEvent() {  }

    private static final HandlerList HANDLER = new HandlerList();

    @Override
    public HandlerList getHandlers() { return HANDLER; }

    public static HandlerList getHandlerList() { return HANDLER; }
}
