package fr.thibma.dragonrush.classes;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public abstract class Class {

    protected Player player;
    protected int level = 1;

    public int getLevel() { return this.level; }
    public void setLevel(int level) { this.level = level; }
    public Player getPlayer() { return player; }

    public Inventory selectionClassInventory = ClassSelection.getClassSelectionInventory(getClassName());

    public abstract ClassEnums getEnum();
    public abstract String getClassName();

    public void atBegining() {
        this.potionEffect();
        for (ItemStack item : itemSpawn()) {
            this.player.getInventory().addItem(item);
        }
    }
    public void objectiveLevel2() {
        this.level = 2;
        this.addSkills();
    }
    public void objectiveLevel3() {
        this.level = 3;
        this.addSkills();
    }

    public void addSkills() {
        for (ItemStack item : skills()) {
            if (!this.player.getInventory().contains(item)) {
                this.player.getInventory().addItem(item);
            }
        }
    }

    public abstract void potionEffect();

    public abstract ArrayList<ItemStack> itemSpawn();
    public abstract ArrayList<ItemStack> skills();

    public abstract void destructor();
}
