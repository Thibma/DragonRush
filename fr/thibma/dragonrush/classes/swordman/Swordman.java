package fr.thibma.dragonrush.classes.swordman;

import fr.thibma.dragonrush.classes.Class;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.util.List;

public class Swordman extends Class {

    public Swordman(Player player) {
        this.player = player;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public List<String> getDescription() {
        return null;
    }

    @Override
    public void level1() {
        System.out.println("Je suis " + this.getPlayer());
        Listener level1Listener = new SwordmanLevel1Listener(this);
        Bukkit.getServer().getPluginManager().registerEvents(level1Listener, Bukkit.getPluginManager().getPlugin("DragonRush"));
    }

    @Override
    public void level2() {

    }

    @Override
    public void level3() {

    }

    @Override
    public void objectiveLevel2() {

    }

    @Override
    public void objectiveLevel3() {

    }
}
