package fr.thibma.dragonrush.classes.blacksmith;

import fr.thibma.dragonrush.classes.Class;
import fr.thibma.dragonrush.classes.ClassEnums;
import org.bukkit.entity.Player;

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
    public void destructor() {

    }
}
