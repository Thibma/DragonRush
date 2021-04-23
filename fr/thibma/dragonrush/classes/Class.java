package fr.thibma.dragonrush.classes;

import org.bukkit.entity.Player;

import java.util.List;

public abstract class Class {

    protected Player player;
    protected int level = 1;

    public int getLevel() { return this.level; }
    public Player getPlayer() { return player; }

    public abstract ClassEnums getEnum();

    public abstract void atBegining();
    public abstract void objectiveLevel2();
    public abstract void objectiveLevel3();

    public abstract void potionEffect();

    public abstract void destructor();
}
