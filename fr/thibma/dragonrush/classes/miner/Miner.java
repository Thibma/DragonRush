package fr.thibma.dragonrush.classes.miner;

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
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Handler;

public class Miner extends Class {

    private final Plugin plugin = JavaPlugin.getPlugin(DragonRush.class);

    protected int ironMined = 0;
    protected int goldMined = 0;
    protected int diamEmeraldMined = 0;

    private final MinerLevel1 minerLevel1 = new MinerLevel1(this);
    private final MinerLevel1Listener minerLevel1Listener = new MinerLevel1Listener(this);
    private final MinerLevel2 minerLevel2 = new MinerLevel2(this);
    private final MinerLevel2Listener minerLevel2Listener = new MinerLevel2Listener(this);

    public Miner(Player player) { this.player = player; }

    @Override
    public ClassEnums getEnum() { return ClassEnums.MINER; }

    @Override
    public String getClassName() {
        return "Mineur";
    }

    @Override
    public void atBegining() {
        super.atBegining();
        Bukkit.getServer().getPluginManager().registerEvents(this.minerLevel1, this.plugin);
        Bukkit.getServer().getPluginManager().registerEvents(this.minerLevel1Listener, this.plugin);
    }

    @Override
    public void objectiveLevel2() {
        super.objectiveLevel2();
        HandlerList.unregisterAll(this.minerLevel1Listener);
        Bukkit.getServer().getPluginManager().registerEvents(this.minerLevel2, this.plugin);
        Bukkit.getServer().getPluginManager().registerEvents(this.minerLevel2Listener, this.plugin);
    }

    @Override
    public void objectiveLevel3() {
        super.objectiveLevel3();
        HandlerList.unregisterAll(this.minerLevel2Listener);
    }

    protected ItemStack diamondPickaxe() {
        ItemStack diamondPickaxe = new ItemStack(Material.DIAMOND_PICKAXE);
        ItemMeta itemMeta = diamondPickaxe.getItemMeta();
        ArrayList<String> lore = new ArrayList<>();
        itemMeta.setDisplayName("§5Pioche en Bedrock");
        lore.add("§5Épique");
        lore.add("§bPersonnel");
        lore.add("§aAprès avoir obtenu de nombreuses ressources");
        lore.add("§apour la fabrication de cet objet magique,");
        lore.add("§ale propriétaire de cet objet est devenu tellement");
        lore.add("§ariche qu'il en est mort d'avarice.");
        lore.add("");
        lore.add("§c§l§oUniquement utilisable par son propriétaire.");
        lore.add("§7Dans la main principale : ");
        lore.add("§2 5 de points d'attaque");
        lore.add("§2 1.2 de vitesse d'attaque");
        lore.add("§2 Cet objet est incassable.");
        itemMeta.setLore(lore);
        itemMeta.setUnbreakable(true);
        itemMeta.addEnchant(Enchantment.DIG_SPEED, 3, false);
        itemMeta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 1, false);
        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        diamondPickaxe.setItemMeta(itemMeta);

        return diamondPickaxe;
    }

    @Override
    public void potionEffect() {

    }

    @Override
    public ArrayList<ItemStack> itemSpawn() {
        ItemStack stonePickaxe = new ItemStack(Material.STONE_PICKAXE);
        ItemMeta itemMeta = stonePickaxe.getItemMeta();
        ArrayList<String> lore = new ArrayList<>();
        itemMeta.setDisplayName("§fPioche en pierre améliorée");
        lore.add("§fCommun");
        lore.add("§aUne pioche en pierre fabriquée avec des");
        lore.add("§aressources de base.");
        lore.add("");
        lore.add("§7Dans la main principale : ");
        lore.add("§2 3 de points d'attaque");
        lore.add("§2 1.2 de vitesse d'attaque");
        itemMeta.setLore(lore);
        itemMeta.addEnchant(Enchantment.DIG_SPEED, 1, false);
        itemMeta.addEnchant(Enchantment.DURABILITY, 1, false);
        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        stonePickaxe.setItemMeta(itemMeta);

        return new ArrayList<>(List.of(stonePickaxe));
    }

    @Override
    public ArrayList<ItemStack> skills() {
        ArrayList<ItemStack> listItem = new ArrayList<>();
        if (this.level == 3) {
            listItem.add(diamondPickaxe());
        }
        return listItem;
    }

    @Override
    public void destructor() {
        HandlerList.unregisterAll(this.minerLevel1);
        HandlerList.unregisterAll(this.minerLevel1Listener);
        HandlerList.unregisterAll(this.minerLevel2);
        HandlerList.unregisterAll(this.minerLevel2Listener);
    }
}
