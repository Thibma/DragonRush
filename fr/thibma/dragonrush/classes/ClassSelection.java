package fr.thibma.dragonrush.classes;

import fr.thibma.dragonrush.classes.archer.Archer;
import fr.thibma.dragonrush.classes.assassin.Assassin;
import fr.thibma.dragonrush.classes.berserker.Berserker;
import fr.thibma.dragonrush.classes.fishman.Fishman;
import fr.thibma.dragonrush.classes.hunter.Hunter;
import fr.thibma.dragonrush.classes.lancer.Lancer;
import fr.thibma.dragonrush.classes.miner.Miner;
import fr.thibma.dragonrush.classes.nether_explorer.NetherExplorer;
import fr.thibma.dragonrush.classes.paladin.Paladin;
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
                itemLore.add("§7Catégorie :§c DPS mêlée");
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
                itemMeta = item.getItemMeta();
                itemMeta.setDisplayName("§7§lArcher");
                itemLore.add("§7Catégorie :§c DPS à distance");
                itemLore.add("§7Description : §fClasse standard se battant");
                itemLore.add("§fà l'aide d'un arc.");
                itemLore.add("§7Avantages : §aFort à distance avec un");
                itemLore.add("§aarc.");
                itemLore.add("§7Désavantages : §cTrès faible au corps à corps");
                itemMeta.setLore(itemLore);
                itemMeta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                item.setItemMeta(itemMeta);
                return item;
            }
            case LANCER -> {
                item = new ItemStack(Material.TRIDENT);
                itemMeta = item.getItemMeta();
                itemMeta.setDisplayName("§7§lLancier");
                itemLore.add("§7Catégorie :§c DPS mid-range");
                itemLore.add("§7Description : §fClasse standard se battant");
                itemLore.add("§fà l'aide d'une lance.");
                itemLore.add("§7Avantages : §aFort au corps à corps et");
                itemLore.add("§aà distance.");
                itemLore.add("§7Désavantages : §cFaible sur toutes les autres armes.");
                itemMeta.setLore(itemLore);
                itemMeta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                item.setItemMeta(itemMeta);
                return item;
            }
            case BERSERKER -> {
                item = new ItemStack(Material.IRON_AXE);
                itemMeta = item.getItemMeta();
                itemMeta.setDisplayName("§7§lBerserker");
                itemLore.add("§7Catégorie :§c DPS Tank");
                itemLore.add("§7Description : §fClasse basique permettant de faire");
                itemLore.add("§fde gros dégâts et d'être putôt tanky.");
                itemLore.add("§7Avantages : §aFort au corps à corps et en");
                itemLore.add("§adébut de partie.");
                itemLore.add("§7Désavantages : §cPlus faible à la fin et plutôt basique.");
                itemMeta.setLore(itemLore);
                itemMeta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                item.setItemMeta(itemMeta);
                return item;
            }
            case PALADIN -> {
                item = new ItemStack(Material.SHIELD);
                itemMeta = item.getItemMeta();
                itemMeta.setDisplayName("§7§lPaladin");
                itemLore.add("§7Catégorie :§c Tank - Support");
                itemLore.add("§7Description : §fClasse défensive protégeant ses");
                itemLore.add("§falliés avec son bouclier.");
                itemLore.add("§7Avantages : §aExcellente défense et utile pour");
                itemLore.add("§al'équipe.");
                itemLore.add("§7Désavantages : §cDégâts faibles.");
                itemMeta.setLore(itemLore);
                itemMeta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                item.setItemMeta(itemMeta);
                return item;
            }
            case ASSASSIN -> {
                item = new ItemStack(Material.GUNPOWDER);
                itemMeta = item.getItemMeta();
                itemMeta.setDisplayName("§7§lAssassin");
                itemLore.add("§7Catégorie :§c DPS - One shot");
                itemLore.add("§7Description : §fClasse offensive permettant");
                itemLore.add("§fd'engager un combat facilement en assassinant ses");
                itemLore.add("§fennemis.");
                itemLore.add("§7Avantages : §aTrès gros dégâts en début de combat.");
                itemLore.add("§aBonne mobilité.");
                itemLore.add("§7Désavantages : §cTrès faible défense.");
                itemMeta.setLore(itemLore);
                itemMeta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                item.setItemMeta(itemMeta);
                return item;
            }
            case NETHER_EXPLORER -> {
                item = new ItemStack(Material.NETHERRACK);
                itemMeta = item.getItemMeta();
                itemMeta.setDisplayName("§7§lExplorateur du Nether");
                itemLore.add("§7Catégorie :§c Support - Exploration");
                itemLore.add("§7Description : §fClasse de support pouvant aider son");
                itemLore.add("§féquipe dans les dimensions du Nether et de l'End.");
                itemLore.add("§fPeut même générer des portails.");
                itemLore.add("§7Avantages : §aTrès utile dans le Nether et dans");
                itemLore.add("§al'End.");
                itemLore.add("§7Désavantages : §cInutile au début et plutôt");
                itemLore.add("§csituationnel.");
                itemMeta.setLore(itemLore);
                itemMeta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                item.setItemMeta(itemMeta);
                return item;
            }
            case MINER -> {
                item = new ItemStack(Material.IRON_PICKAXE);
                itemMeta = item.getItemMeta();
                itemMeta.setDisplayName("§7§lMineur");
                itemLore.add("§7Catégorie :§c Support - Farming");
                itemLore.add("§7Description : §fClasse de support aidant son équipe");
                itemLore.add("§fà mieux s'équiper puisqu'il permet de récupérer plus");
                itemLore.add("§fde ressources type minerais.");
                itemLore.add("§7Avantages : §aTrès bon farming tout le long du jeu.");
                itemLore.add("§7Désavantages : §cInutile en combat.");
                itemMeta.setLore(itemLore);
                itemMeta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                item.setItemMeta(itemMeta);
                return item;
            }
            case FISHMAN -> {
                item = new ItemStack(Material.PUFFERFISH);
                itemMeta = item.getItemMeta();
                itemMeta.setDisplayName("§7§lHomme-Poisson");
                itemLore.add("§7Catégorie :§c Support et survavibilité dans l'eau");
                itemLore.add("§7Description : §fClasse très spéciale se battant");
                itemLore.add("§fet se déplaçant en grande majorité dans l'eau.");
                itemLore.add("§fMeilleur stats sous l'eau et peut les donner à");
                itemLore.add("§fses alliés.");
                itemLore.add("§7Avantages : §aTrès fort en zone aqueuse.");
                itemLore.add("§7Désavantages : §cSur Terre est dans le Nether,");
                itemLore.add("§ctrès inutile et situationnel.");
                itemMeta.setLore(itemLore);
                itemMeta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                item.setItemMeta(itemMeta);
                return item;
            }
            case HUNTER -> {
                item = new ItemStack(Material.BONE);
                itemMeta = item.getItemMeta();
                itemMeta.setDisplayName("§7§lChasseur");
                itemLore.add("§7Catégorie :§c Farming");
                itemLore.add("§7Description : §fClasse de farming ayant pour");
                itemLore.add("§fobjectif de tuer un maximum d'entités pour mieux");
                itemLore.add("§fs'équiper. Peut invoquer des mobs pour l'aider en");
                itemLore.add("§fcombat.");
                itemLore.add("§7Avantages : §aTrès bon farming et marionnetiste");
                itemLore.add("§7Désavantages : §cPeu utile en combat contre");
                itemLore.add("§cles autres joueurs.");
                itemMeta.setLore(itemLore);
                itemMeta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                item.setItemMeta(itemMeta);
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
            case LANCER -> {
                return new Lancer(player);
            }
            case BERSERKER -> {
                return new Berserker(player);
            }
            case PALADIN -> {
                return new Paladin(player);
            }
            case ASSASSIN -> {
                return new Assassin(player);
            }
            case NETHER_EXPLORER -> {
                return new NetherExplorer(player);
            }
            case MINER -> {
                return new Miner(player);
            }
            case FISHMAN -> {
                return new Fishman(player);
            }
            case HUNTER -> {
                return new Hunter(player);
            }
        }
        return null;
    }
}
