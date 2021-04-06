package fr.thibma.dragonrush.classes;

import org.bukkit.entity.Player;

import java.util.List;

public abstract class Class {

    protected Player player;
    protected int level = 1;

    public int getLevel() { return this.level; }
    public Player getPlayer() { return player; }

    public abstract String getName();
    public abstract List<String> getDescription();

    public abstract void level1();
    public abstract void level2();
    public abstract void level3();

    public abstract void objectiveLevel2();
    public abstract void objectiveLevel3();


}
