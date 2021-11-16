package fr.thibma.dragonrush.classes.alchimist;

import fr.thibma.dragonrush.DragonRush;
import fr.thibma.dragonrush.classes.Class;
import fr.thibma.dragonrush.classes.ClassEnums;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class Alchimist extends Class {

    private Plugin plugin = JavaPlugin.getPlugin(DragonRush.class);

    private AlchemistLevel1Listener alchemistLevel1Listener = new AlchemistLevel1Listener(this);
    private AlchemistLevel2Listener alchemistLevel2Listener = new AlchemistLevel2Listener(this);

    public Alchimist(Player player) {
        this.player = player;
    }

    @Override
    public ClassEnums getEnum() { return ClassEnums.ALCHEMIST; }

    @Override
    public String getClassName() {
        return "Alchimiste";
    }

    @Override
    public void atBegining() {
        super.atBegining();
        Bukkit.getServer().getPluginManager().registerEvents(this.alchemistLevel1Listener, this.plugin);
    }

    @Override
    public void objectiveLevel2() {
        super.objectiveLevel2();
        this.player.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(0.115);
        HandlerList.unregisterAll(this.alchemistLevel1Listener);
        Bukkit.getServer().getPluginManager().registerEvents(this.alchemistLevel2Listener, this.plugin);
    }

    @Override
    public void objectiveLevel3() {
        super.objectiveLevel3();
        this.player.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(0.13);
        HandlerList.unregisterAll(this.alchemistLevel2Listener);
    }

    @Override
    public void potionEffect() {

    }

    @Override
    public ArrayList<ItemStack> itemSpawn() {
        ItemStack bottle = new ItemStack(Material.GLASS_BOTTLE);
        ItemMeta itemMeta = bottle.getItemMeta();
        ArrayList<String> lore = new ArrayList<>();
        itemMeta.setDisplayName("§fFlacon en verre");
        lore.add("§fCommun");
        lore.add("§aUn récipiant pouvant contenir plusieurs");
        lore.add("§asubstances. Utilisé pour les crafts");
        lore.add("§ade potions.");
        itemMeta.setLore(lore);
        itemMeta.setUnbreakable(true);
        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        bottle.setItemMeta(itemMeta);
        bottle.setAmount(5);

        ItemStack gunpowder = new ItemStack(Material.GUNPOWDER);
        itemMeta = gunpowder.getItemMeta();
        lore = new ArrayList<>();
        itemMeta.setDisplayName("§fPoudre de Creeper");
        lore.add("§fCommun");
        lore.add("§aCe produit permet de transformet des flacons");
        lore.add("§aen explosifs. Utilisé pour les crafts");
        lore.add("§ade potions.");
        itemMeta.setLore(lore);
        itemMeta.setUnbreakable(true);
        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        gunpowder.setItemMeta(itemMeta);
        gunpowder.setAmount(5);

        return new ArrayList<>(List.of(bottle, gunpowder));
    }

    @Override
    public ArrayList<ItemStack> skills() {
        return new ArrayList<>();
    }

    @Override
    public void destructor() {
        HandlerList.unregisterAll(this.alchemistLevel1Listener);
        HandlerList.unregisterAll(this.alchemistLevel2Listener);
    }
}
