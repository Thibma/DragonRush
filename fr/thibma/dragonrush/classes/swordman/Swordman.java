package fr.thibma.dragonrush.classes.swordman;

import fr.thibma.dragonrush.DragonRush;
import fr.thibma.dragonrush.classes.Class;
import fr.thibma.dragonrush.classes.ClassEnums;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Swordman extends Class {

    private final SwordmanLevel1Listener swordmanLevel1Listener = new SwordmanLevel1Listener(this);
    private final SwordmanLevel2Listener swordmanLevel2Listener = new SwordmanLevel2Listener(this);
    private final SwordmanLevel2 swordmanLevel2 = new SwordmanLevel2(this);
    private final SwordmanLevel3 swordmanLevel3 = new SwordmanLevel3(this);
    private final SwordmanDisadvantages swordmanDisadvantages = new SwordmanDisadvantages(this);

    protected int pillagerKilled = 0;
    protected int piglinKilled = 0;

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
    public ClassEnums getEnum() {
        return ClassEnums.SWORDSMAN;
    }

    @Override
    public void atBegining() {
        ItemStack stoneSword = new ItemStack(Material.STONE_SWORD);
        ItemMeta itemMeta = stoneSword.getItemMeta();
        ArrayList<String> lore = new ArrayList<>();
        itemMeta.setDisplayName("§fÉpée en pierre améliorée");
        lore.add("§fCommun");
        lore.add("§aUne épée en pierre donnée à des");
        lore.add("§aapprentis chevaliers.");
        lore.add("");
        lore.add("§7Dans la main principale : ");
        lore.add("§2 5 de points d'attaque §6(+1)");
        lore.add("§2 1.6 de vitesse d'attaque");
        itemMeta.setLore(lore);
        itemMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier(UUID.randomUUID(),"generic.attack_damage", 5, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND));
        itemMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, new AttributeModifier(UUID.randomUUID(), "generic.attack_speed", -2.4, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND));
        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        stoneSword.setItemMeta(itemMeta);

        this.player.getInventory().addItem(stoneSword);

        Bukkit.getServer().getPluginManager().registerEvents(this.swordmanDisadvantages, JavaPlugin.getPlugin(DragonRush.class));
        //Bukkit.getServer().getPluginManager().registerEvents(this.swordmanLevel1Listener, JavaPlugin.getPlugin(DragonRush.class));
        this.objectiveLevel3();

    }

    @Override
    public void level1() {
        // Nothing
    }

    @Override
    public void level2() {
        // Nothing
    }

    @Override
    public void level3() {
        // Nothing
    }

    @Override
    public void objectiveLevel2() {
        this.level = 2;
        HandlerList.unregisterAll(this.swordmanLevel1Listener);
        Bukkit.getServer().getPluginManager().registerEvents(this.swordmanLevel2, JavaPlugin.getPlugin(DragonRush.class));
        Bukkit.getServer().getPluginManager().registerEvents(this.swordmanLevel2Listener, JavaPlugin.getPlugin(DragonRush.class));
    }

    @Override
    public void objectiveLevel3() {
        this.level = 3;
        HandlerList.unregisterAll(this.swordmanLevel2Listener);
        Bukkit.getServer().getPluginManager().registerEvents(this.swordmanLevel3, JavaPlugin.getPlugin(DragonRush.class));
    }

    @Override
    public void destructor() {
        HandlerList.unregisterAll(this.swordmanLevel1Listener);
        HandlerList.unregisterAll(this.swordmanLevel2);
        HandlerList.unregisterAll(this.swordmanLevel2Listener);
    }
}
