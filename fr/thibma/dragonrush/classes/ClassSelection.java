package fr.thibma.dragonrush.classes;

import fr.thibma.dragonrush.classes.archer.Archer;
import fr.thibma.dragonrush.classes.swordman.Swordman;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class ClassSelection {

    public static ItemStack getItem(ClassEnums classEnums) {
        ItemStack item;
        ItemMeta itemMeta;
        ArrayList<String> itemLore = new ArrayList<>();

        switch (classEnums) {
            case SWORDSMAN -> {
                item = new ItemStack(Material.IRON_SWORD);
                itemMeta = item.getItemMeta();
                itemMeta.setDisplayName("§7§lÉpéiste");
                itemLore.add("§7Catégorie :§c DPS");
                itemLore.add("§7Description : §fClasse standard se battant");
                itemLore.add("§fà l'aide d'une épée.");
                itemLore.add("§7Avantages : §aFort au corps à corps avec une");
                itemLore.add("§aépée. Simple à utiliser.");
                itemLore.add("§7Désavantages : §cFaible à distance");
                itemMeta.setLore(itemLore);
                itemMeta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                item.setItemMeta(itemMeta);
                return item;
            }
            case ARCHER -> {
                item = new ItemStack(Material.BOW);
                return item;
            }
            case LANCER -> {
                item = new ItemStack(Material.TRIDENT);
                return item;
            }
            case BERSERKER -> {
                item = new ItemStack(Material.IRON_AXE);
                return item;
            }
            case PALADIN -> {
                item = new ItemStack(Material.SHIELD);
                return item;
            }
            case ASSASSIN -> {
                item = new ItemStack(Material.GUNPOWDER);
                return item;
            }
            case NETHER_EXPLORER -> {
                item = new ItemStack(Material.NETHERRACK);
                return item;
            }
            case MINER -> {
                item = new ItemStack(Material.IRON_PICKAXE);
                return item;
            }
            case FISHMAN -> {
                item = new ItemStack(Material.PUFFERFISH);
                return item;
            }
            case HUNTER -> {
                item = new ItemStack(Material.BONE);
                return item;
            }
            case ALCHEMIST -> {
                item = new ItemStack(Material.POTION);
                return item;
            }
            case BLACKSMITH -> {
                item = new ItemStack(Material.ANVIL);
                return item;
            }

        }

        return null;
    }

    public static ClassEnums getClassEnum(int number) {
        int i = 0;
        for (ClassEnums classEnums : ClassEnums.values()) {
            if (number == i) {
                return classEnums;
            }
            i++;
        }
        return null;
    }

    public static Inventory getClassSelectionInventory() {
        Inventory inventory = Bukkit.createInventory(null, 18, "§2§lChoisissez une classe !");
        for (ClassEnums classEnums : ClassEnums.values()) {
            inventory.addItem(getItem(classEnums));
        }

        return inventory;
    }

    public static Class getClass(ClassEnums classEnums, Player player) {
        switch (classEnums) {
            case SWORDSMAN -> {
                return new Swordman(player);
            }
            case ARCHER -> {
                return new Archer(player);
            }
        }
        return null;
    }
}
