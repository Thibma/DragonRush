package fr.thibma.dragonrush.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class DisplaySelectionClassesEvent extends Event {

    public DisplaySelectionClassesEvent() {

    }

    private static final HandlerList HANDLERS = new HandlerList();

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}
