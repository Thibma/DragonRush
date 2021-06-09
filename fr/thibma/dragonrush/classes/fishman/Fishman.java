package fr.thibma.dragonrush.classes.fishman;

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
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;

public class Fishman extends Class {

    private Plugin plugin = JavaPlugin.getPlugin(DragonRush.class);

    protected int drownedKilled = 0;

    private final FishmanLevel1 fishmanLevel1 = new FishmanLevel1(this);
    private final FishmanLevel1Listener fishmanLevel1Listener = new FishmanLevel1Listener(this);
    private final FishmanLevel2Listener fishmanLevel2Listener = new FishmanLevel2Listener(this);
    private final FishmanLevel3 fishmanLevel3 = new FishmanLevel3(this);

    public Fishman(Player player) { this.player = player; }


    @Override
    public ClassEnums getEnum() { return ClassEnums.FISHMAN; }

    @Override
    public void atBegining() {
        this.potionEffect();
        Bukkit.getServer().getPluginManager().registerEvents(this.fishmanLevel1, this.plugin);
        Bukkit.getServer().getPluginManager().registerEvents(this.fishmanLevel1Listener, this.plugin);
        this.objectiveLevel2();
        this.objectiveLevel3();
    }

    @Override
    public void objectiveLevel2() {
        super.objectiveLevel2();
        HandlerList.unregisterAll(this.fishmanLevel1Listener);
        Bukkit.getServer().getPluginManager().registerEvents(this.fishmanLevel2Listener, this.plugin);
    }

    @Override
    public void objectiveLevel3() {
        super.objectiveLevel3();
        HandlerList.unregisterAll(this.fishmanLevel2Listener);
        Bukkit.getServer().getPluginManager().registerEvents(this.fishmanLevel3, this.plugin);
        this.player.getInventory().addItem(this.skillFishman());
    }

    @Override
    public void potionEffect() {
        if (this.level >= 1) {
            this.player.addPotionEffect(new PotionEffect(PotionEffectType.DOLPHINS_GRACE, Integer.MAX_VALUE, 0));
        }
        if (this.level >= 2) {
            this.player.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, Integer.MAX_VALUE, 0));
        }
    }

    protected ItemStack skillFishman() {
        ItemStack skill = new ItemStack(Material.BOOK);
        ItemMeta itemMeta = skill.getItemMeta();
        ArrayList<String> lore = new ArrayList<>();
        itemMeta.setDisplayName("§b§lTsunami");
        lore.add("§bCompétence");
        lore.add("§a§oJe décide ce qu'apporte la marée.");
        lore.add("§6§l Nami, Aquamancienne");
        lore.add("");
        lore.add("§7Clic droit : ");
        lore.add("§eInonde §2toute la zone au dessus");
        lore.add("§2 du lanceur. Les sources d'eau dûrent");
        lore.add("§6 3 secondes. §9(180s)");
        itemMeta.setLore(lore);
        itemMeta.addEnchant(Enchantment.DURABILITY, 1, true);
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        skill.setItemMeta(itemMeta);

        return skill;
    }

    @Override
    public void destructor() {
        HandlerList.unregisterAll(this.fishmanLevel1);
        HandlerList.unregisterAll(this.fishmanLevel1Listener);
        HandlerList.unregisterAll(this.fishmanLevel2Listener);
        HandlerList.unregisterAll(this.fishmanLevel3);
    }
}
