package fr.thibma.dragonrush.classes.hunter;

import fr.thibma.dragonrush.DragonRush;
import fr.thibma.dragonrush.classes.Class;
import fr.thibma.dragonrush.classes.ClassEnums;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.logging.Handler;

public class Hunter extends Class {

    protected int onEntityKilled1 = 0;
    protected int onEntityKilled2 = 0;

    private final HunterLevel1Listener hunterLevel1Listener = new HunterLevel1Listener(this);
    private final HunterLevel2 hunterLevel2 = new HunterLevel2(this);
    private final HunterLevel2Listener hunterLevel2Listener = new HunterLevel2Listener(this);
    private final HunterLevel3 hunterLevel3 = new HunterLevel3(this);

    private final Plugin plugin = JavaPlugin.getPlugin(DragonRush.class);

    protected final HunterWolf hunterWolf = new HunterWolf(this);

    public Hunter(Player player) { this.player = player; }

    @Override
    public ClassEnums getEnum() { return ClassEnums.HUNTER; }

    @Override
    public void atBegining() {
        this.hunterWolf.runTaskTimer(this.plugin, 0, 20);
        Bukkit.getServer().getPluginManager().registerEvents(this.hunterLevel1Listener, this.plugin);
        this.objectiveLevel2();
        this.objectiveLevel3();
    }

    @Override
    public void objectiveLevel2() {
        super.objectiveLevel2();
        HandlerList.unregisterAll(this.hunterLevel1Listener);
        this.hunterWolf.boostLevel();
        Bukkit.getServer().getPluginManager().registerEvents(this.hunterLevel2, this.plugin);
        Bukkit.getServer().getPluginManager().registerEvents(this.hunterLevel2Listener, this.plugin);
    }

    @Override
    public void objectiveLevel3() {
        super.objectiveLevel3();
        HandlerList.unregisterAll(this.hunterLevel2Listener);
        Bukkit.getServer().getPluginManager().registerEvents(this.hunterLevel3, this.plugin);
        this.hunterWolf.boostLevel();
        this.player.getInventory().addItem(this.hunterSkillItem());
    }

    @Override
    public void potionEffect() {

    }

    public ItemStack hunterSkillItem() {
        ItemStack skill = new ItemStack(Material.BOOK);
        ItemMeta itemMeta = skill.getItemMeta();
        ArrayList<String> lore = new ArrayList<>();
        itemMeta.setDisplayName("§b§lDompteur Ultime");
        lore.add("§bCompétence");
        lore.add("§a§oLes ours ne connaissent pas la peur.");
        lore.add("§6§l Volibear, Tempête impitoyable");
        lore.add("");
        lore.add("§7Clic droit : ");
        lore.add("§2 Invoque §eun ours §2avec une puissance améliorée");
        lore.add("§2 pendant §e60 secondes§2.");
        lore.add("§2 Si l'ours est déjà invoqué, permet de choisir la cible");
        lore.add("§2 (joueur) à attaquer. §9(240s)");
        itemMeta.setLore(lore);
        itemMeta.addEnchant(Enchantment.DURABILITY, 1, true);
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        skill.setItemMeta(itemMeta);

        return skill;
    }

    @Override
    public void destructor() {
        this.hunterWolf.cancel();
        HandlerList.unregisterAll(this.hunterLevel1Listener);
        HandlerList.unregisterAll(this.hunterLevel2);
        HandlerList.unregisterAll(this.hunterLevel2Listener);
        HandlerList.unregisterAll(this.hunterLevel3);
    }
}
