package fr.thibma.dragonrush.classes.berserker;

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
import java.util.UUID;
import java.util.logging.Handler;

public class Berserker extends Class {

    public Berserker(Player player) { this.player = player; }
    protected boolean passive = false;
    protected int zombieKilled = 0;

    private final BerserkerLevel1Listener berserkerLevel1Listener = new BerserkerLevel1Listener(this);
    private final BerserkerLevel2 berserkerLevel2 = new BerserkerLevel2(this);
    private final BerserkerLevel2Listener berserkerLevel2Listener = new BerserkerLevel2Listener(this);

    @Override
    public ClassEnums getEnum() { return ClassEnums.BERSERKER; }

    @Override
    public void atBegining() {
        ItemStack trident = new ItemStack(Material.STONE_AXE);
        ItemMeta itemMeta = trident.getItemMeta();
        ArrayList<String> lore = new ArrayList<>();
        itemMeta.setDisplayName("§fMachette en Silex");
        lore.add("§fCommun");
        lore.add("§aUne hache utilisée par des guerriers");
        lore.add("§avenus d'une contrée lointaine.");
        lore.add("");
        lore.add("§7Dans la main principale : ");
        lore.add("§2 9 de points d'attaque §6(+1)");
        lore.add("§2 0.8 de vitesse d'attaque");
        itemMeta.setLore(lore);
        itemMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier(UUID.randomUUID(),"generic.attack_damage", 10, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND));
        itemMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, new AttributeModifier(UUID.randomUUID(), "generic.attack_speed", -3.2, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND));
        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        trident.setItemMeta(itemMeta);
        this.player.getInventory().addItem(trident);
        this.player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(26);
        this.player.setHealth(26);

        Bukkit.getServer().getPluginManager().registerEvents(this.berserkerLevel1Listener, JavaPlugin.getPlugin(DragonRush.class));
        this.objectiveLevel2();
    }

    @Override
    public void objectiveLevel2() {
        super.objectiveLevel2();
        HandlerList.unregisterAll(this.berserkerLevel1Listener);
        this.player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(28);
        Bukkit.getServer().getPluginManager().registerEvents(this.berserkerLevel2, JavaPlugin.getPlugin(DragonRush.class));
        Bukkit.getServer().getPluginManager().registerEvents(this.berserkerLevel2Listener, JavaPlugin.getPlugin(DragonRush.class));
    }

    @Override
    public void objectiveLevel3() {
        super.objectiveLevel3();
        HandlerList.unregisterAll(this.berserkerLevel2Listener);
        this.player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(30);
        this.getPlayer().getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(this.getPlayer().getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).getBaseValue() + 2);
    }

    @Override
    public void potionEffect() {

    }

    @Override
    public void destructor() {
        HandlerList.unregisterAll(this.berserkerLevel1Listener);
        HandlerList.unregisterAll(this.berserkerLevel2);
        HandlerList.unregisterAll(this.berserkerLevel2Listener);
    }
}
