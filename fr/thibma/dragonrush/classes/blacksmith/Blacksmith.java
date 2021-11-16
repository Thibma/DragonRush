package fr.thibma.dragonrush.classes.blacksmith;

import fr.thibma.dragonrush.classes.Class;
import fr.thibma.dragonrush.classes.ClassEnums;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class Blacksmith extends Class {

    public Blacksmith(Player player) { this.player = player; }

    @Override
    public ClassEnums getEnum() { return ClassEnums.BLACKSMITH; }

    @Override
    public String getClassName() {
        return "Forgeron";
    }

    @Override
    public void atBegining() {

    }

    @Override
    public void objectiveLevel2() {
        super.objectiveLevel2();
    }

    @Override
    public void objectiveLevel3() {
        super.objectiveLevel3();
    }

    @Override
    public void potionEffect() {

    }

    @Override
    public ArrayList<ItemStack> itemSpawn() {
        return null;
    }

    @Override
    public ArrayList<ItemStack> skills() {
        return null;
    }

    @Override
    public void destructor() {

    }
}
