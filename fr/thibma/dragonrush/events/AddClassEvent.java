package fr.thibma.dragonrush.events;

import fr.thibma.dragonrush.classes.ClassEnums;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class AddClassEvent extends Event {

    private final Player player;
    private final ClassEnums playerClass;

    public AddClassEvent(Player player, ClassEnums playerClass) {
        this.player = player;
        this.playerClass = playerClass;
    }

    public Player getPlayer() {
        return this.player;
    }

    public ClassEnums getPlayerClass() {
        return this.playerClass;
    }

    private static final HandlerList HANDLERS = new HandlerList();

    @Override
    public HandlerList getHandlers() { return HANDLERS; }

    public static HandlerList getHandlerList() { return HANDLERS; }

}
