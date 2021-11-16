package fr.thibma.dragonrush.classes.lancer;

import fr.thibma.dragonrush.DragonRush;
import fr.thibma.dragonrush.classes.Class;
import fr.thibma.dragonrush.classes.ClassEnums;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
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

public class Lancer extends Class {

    private final LancerLevel1Listener lancerLevel1Listener = new LancerLevel1Listener(this);
    private final LancerLevel2 lancerLevel2 = new LancerLevel2(this);
    private final LancerLevel2Listener lancerLevel2Listener = new LancerLevel2Listener(this);
    private final LancerDisadvantage lancerDisadvantage = new LancerDisadvantage(this);

    protected int creeperKilled = 0;
    protected int hoglinKilled = 0;

    public Lancer(Player player) { this.player = player; }

    @Override
    public ClassEnums getEnum() { return ClassEnums.LANCER; }

    @Override
    public String getClassName() {
        return "Lancier";
    }

    @Override
    public void atBegining() {
        super.atBegining();
        Bukkit.getServer().getPluginManager().registerEvents(this.lancerLevel1Listener, JavaPlugin.getPlugin(DragonRush.class));
        Bukkit.getServer().getPluginManager().registerEvents(this.lancerDisadvantage, JavaPlugin.getPlugin(DragonRush.class));
    }

    @Override
    public void objectiveLevel2() {
        super.objectiveLevel2();
        HandlerList.unregisterAll(this.lancerLevel1Listener);
        Bukkit.getServer().getPluginManager().registerEvents(this.lancerLevel2, JavaPlugin.getPlugin(DragonRush.class));
        Bukkit.getServer().getPluginManager().registerEvents(this.lancerLevel2Listener, JavaPlugin.getPlugin(DragonRush.class));

        for (ItemStack itemStack : this.getPlayer().getInventory()) {
            if (itemStack != null) {
                if (itemStack.getItemMeta().getDisplayName().equals(this.getStringofWeapon1)) {
                    this.getPlayer().getInventory().remove(itemStack);
                }
            }
        }

        this.getPlayer().getInventory().addItem(this.itemSpawn().get(0));
    }

    @Override
    public void objectiveLevel3() {
        super.objectiveLevel3();
        HandlerList.unregisterAll(this.lancerLevel2Listener);

        for (ItemStack itemStack : this.getPlayer().getInventory()) {
            if (itemStack != null) {
                if (itemStack.getItemMeta().getDisplayName().equals(this.getStringofWeapon2)) {
                    this.getPlayer().getInventory().remove(itemStack);
                }
            }

        }

        this.player.getInventory().addItem(this.itemSpawn().get(0));

    }

    @Override
    public void potionEffect() {

    }

    @Override
    public ArrayList<ItemStack> itemSpawn() {
        ItemStack trident = new ItemStack(Material.TRIDENT);
        ItemMeta itemMeta = trident.getItemMeta();
        ArrayList<String> lore = new ArrayList<>();
        itemMeta.setDisplayName("§fLance de bronze");
        lore.add("§fCommun");
        lore.add("§bPersonnel");
        lore.add("§aUne lance permettant d'attaquer");
        lore.add("§aau corps à corps ou à distance.");
        lore.add("");
        lore.add("§7Dans la main principale : ");
        lore.add("§2 9 de points d'attaque");
        lore.add("§2 1.1 de vitesse d'attaque");
        lore.add("");
        lore.add("§7Projectile tiré : ");
        lore.add("§2 8 points d'attaque");
        lore.add("");
        itemMeta.setLore(lore);
        itemMeta.setUnbreakable(true);
        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        trident.setItemMeta(itemMeta);

        return new ArrayList<>(List.of(trident));
    }

    @Override
    public ArrayList<ItemStack> skills() {
        ItemStack trident;

        switch (this.level) {
            case 1 -> {
                trident = new ItemStack(Material.TRIDENT);
                ItemMeta itemMeta = trident.getItemMeta();
                ArrayList<String> lore = new ArrayList<>();
                itemMeta.setDisplayName("§fLance de bronze");
                lore.add("§fCommun");
                lore.add("§bPersonnel");
                lore.add("§aUne lance permettant d'attaquer");
                lore.add("§aau corps à corps ou à distance.");
                lore.add("");
                lore.add("§7Dans la main principale : ");
                lore.add("§2 9 de points d'attaque");
                lore.add("§2 1.1 de vitesse d'attaque");
                lore.add("");
                lore.add("§7Projectile tiré : ");
                lore.add("§2 8 points d'attaque");
                lore.add("");
                itemMeta.setLore(lore);
                itemMeta.setUnbreakable(true);
                itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                trident.setItemMeta(itemMeta);
            }
            case 2 -> {
                trident = new ItemStack(Material.TRIDENT);
                ItemMeta itemMeta = trident.getItemMeta();
                ArrayList<String> lore = new ArrayList<>();
                itemMeta.setDisplayName("§bLance Boomerang");
                lore.add("§bRare");
                lore.add("§bPersonnel");
                lore.add("§aUtilisable seulement par des initiés,");
                lore.add("§acette lance à le pouvoir de revenir vers");
                lore.add("§ason propriétaire après avoir été lancée.");
                lore.add("");
                lore.add("§7Dans la main principale : ");
                lore.add("§2 9 de points d'attaque §6(+1)");
                lore.add("§2 1.1 de vitesse d'attaque");
                lore.add("");
                lore.add("§7Projectile tiré : ");
                lore.add("§2 8 points d'attaque §6(+1)");
                lore.add("");
                itemMeta.setLore(lore);
                itemMeta.setUnbreakable(true);
                itemMeta.addEnchant(Enchantment.LOYALTY, 1, true);
                itemMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier(UUID.randomUUID(), "generic.attack_damage", 9, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND));
                itemMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, new AttributeModifier(UUID.randomUUID(), "generic.attack_speed", -2.9, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND));
                itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                trident.setItemMeta(itemMeta);
            }
            case 3 -> {
                trident = new ItemStack(Material.TRIDENT);
                ItemMeta itemMeta = trident.getItemMeta();
                ArrayList<String> lore = new ArrayList<>();
                itemMeta.setDisplayName("§5Lance Fidèle");
                lore.add("§5Épique");
                lore.add("§bPersonnel");
                lore.add("§aAprès avoir été pratiquée si longtemps par");
                lore.add("§aun lancier extraordinaire, cette dernière");
                lore.add("§aa atteint une apogée formidable pour son utilisateur .");
                lore.add("");
                lore.add("§7Dans la main principale : ");
                lore.add("§2 9 de points d'attaque §6(+2)");
                lore.add("§2 1.1 de vitesse d'attaque");
                lore.add("");
                lore.add("§7Projectile tiré : ");
                lore.add("§2 8 points d'attaque §6(+2)");
                lore.add("");
                itemMeta.setLore(lore);
                itemMeta.setUnbreakable(true);
                itemMeta.addEnchant(Enchantment.LOYALTY, 3, true);
                itemMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier(UUID.randomUUID(), "generic.attack_damage", 10, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND));
                itemMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, new AttributeModifier(UUID.randomUUID(), "generic.attack_speed", -2.9, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND));
                itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                trident.setItemMeta(itemMeta);
            }
            default -> throw new IllegalStateException("Unexpected value: " + this.level);
        }

        return new ArrayList<>(List.of(trident));
    }

    @Override
    public void destructor() {
        HandlerList.unregisterAll(this.lancerLevel1Listener);
        HandlerList.unregisterAll(this.lancerLevel2);
        HandlerList.unregisterAll(this.lancerLevel2Listener);
        HandlerList.unregisterAll(this.lancerDisadvantage);
    }

    protected final String getStringofWeapon1 = "§fLance de bronze";
    protected final String getStringofWeapon2 = "§bLance Boomerang";
    protected final String getStringofWeapon3 = "§5Lance Fidèle";

}
