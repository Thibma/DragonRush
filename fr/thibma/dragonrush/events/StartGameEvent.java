package fr.thibma.dragonrush.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class StartGameEvent extends Event {

    public StartGameEvent() { }

    private static final HandlerList HANDLER = new HandlerList();

    @Override
    public HandlerList getHandlers() {
        return HANDLER;
    }

    public static HandlerList getHandlerList() { return HANDLER; }
}
