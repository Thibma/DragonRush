package fr.thibma.dragonrush.classes.archer;

import fr.thibma.dragonrush.DragonRush;
import fr.thibma.dragonrush.classes.Class;
import fr.thibma.dragonrush.classes.ClassEnums;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.w3c.dom.Attr;

import java.util.ArrayList;
import java.util.List;

public class Archer extends Class {

    private final ArcherLevel1Listener archerLevel1Listener = new ArcherLevel1Listener(this);
    private final ArcherLevel2Listener archerLevel2Listener = new ArcherLevel2Listener(this);
    private final ArcherLevel2 archerLevel2 = new ArcherLevel2(this);
    private final ArcherLevel3 archerLevel3 = new ArcherLevel3(this);

    protected int skeletonKilled = 0;
    protected int piglinPillagerKilled = 0;

    public Archer(Player player) { this.player = player; }

    @Override
    public ClassEnums getEnum() {
        return ClassEnums.ARCHER;
    }

    @Override
    public String getClassName() {
        return "Archer";
    }

    @Override
    public void atBegining() {
        super.atBegining();
        Bukkit.getServer().getPluginManager().registerEvents(this.archerLevel1Listener, JavaPlugin.getPlugin(DragonRush.class));
        this.player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(16);
        this.player.setHealth(16);
        this.player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(-2);

        this.objectiveLevel2();
        this.objectiveLevel3();
    }

    @Override
    public void objectiveLevel2() {
        super.objectiveLevel2();
        HandlerList.unregisterAll(this.archerLevel1Listener);
        Bukkit.getServer().getPluginManager().registerEvents(this.archerLevel2, JavaPlugin.getPlugin(DragonRush.class));
        Bukkit.getServer().getPluginManager().registerEvents(this.archerLevel2Listener, JavaPlugin.getPlugin(DragonRush.class));
    }

    @Override
    public void objectiveLevel3() {
        super.objectiveLevel3();
        this.potionEffect();
        this.player.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(0.12);
        HandlerList.unregisterAll(this.archerLevel2Listener);
        Bukkit.getServer().getPluginManager().registerEvents(this.archerLevel3, JavaPlugin.getPlugin(DragonRush.class));
    }

    @Override
    public void potionEffect() {
        PotionEffect nightVision = new PotionEffect(PotionEffectType.NIGHT_VISION, Integer.MAX_VALUE, 0);
        this.player.addPotionEffect(nightVision);
    }

    @Override
    public ArrayList<ItemStack> itemSpawn() {
        ItemStack bow = new ItemStack(Material.BOW);
        ItemMeta itemMeta = bow.getItemMeta();
        ArrayList<String> lore = new ArrayList<>();
        itemMeta.setDisplayName("§fArc court");
        lore.add("§fCommun");
        lore.add("§aUn arc fait de bois donné à des");
        lore.add("§aapprentis archers.");
        lore.add("");
        lore.add("§7Projectile tiré : ");
        lore.add("§2 1 point d'attaque -> 10 points d'attaque");
        lore.add("§2 (En fonction de la charge)");
        itemMeta.setLore(lore);
        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        bow.setItemMeta(itemMeta);

        ItemStack arrow = new ItemStack(Material.ARROW);
        ItemMeta itemMetaArrow = arrow.getItemMeta();
        ArrayList<String> loreArrow = new ArrayList<>();
        itemMetaArrow.setDisplayName("§fFlèche d'entraînement");
        loreArrow.add("§fCommun");
        loreArrow.add("§aUne flèche utilisée lors des");
        loreArrow.add("§aentraînements sur des cibles fixes.");
        itemMetaArrow.setLore(loreArrow);
        arrow.setItemMeta(itemMetaArrow);
        arrow.setAmount(32);

        return new ArrayList<>(List.of(bow, arrow));
    }

    @Override
    public ArrayList<ItemStack> skills() {
        return new ArrayList<>();
    }

    @Override
    public void destructor() {
        HandlerList.unregisterAll(this.archerLevel1Listener);
        HandlerList.unregisterAll(this.archerLevel2);
        HandlerList.unregisterAll(this.archerLevel2Listener);
        HandlerList.unregisterAll(this.archerLevel3);
    }
}
