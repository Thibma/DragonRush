package fr.thibma.dragonrush.classes.paladin;

import fr.thibma.dragonrush.DragonRush;
import fr.thibma.dragonrush.classes.Class;
import fr.thibma.dragonrush.classes.ClassEnums;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class Paladin extends Class {

    protected int attackBlocked = 0;
    protected int endermanAttackBlocked = 0;

    private final PaladinLevel1Listener paladinLevel1Listener = new PaladinLevel1Listener(this);
    private final PaladinLevel2 paladinLevel2 = new PaladinLevel2(this);
    private final PaladinLevel2Listener paladinLevel2Listener = new PaladinLevel2Listener(this);
    private final PaladinLevel3 paladinLevel3 = new PaladinLevel3(this);
    private final PaladinSkillProtection paladinSkillProtection = new PaladinSkillProtection(this);
    private final PaladinDisadvantage paladinDisadvantage = new PaladinDisadvantage(this);

    public Paladin(Player player) { this.player = player; }

    @Override
    public ClassEnums getEnum() { return ClassEnums.PALADIN; }

    @Override
    public String getClassName() {
        return "Paladin";
    }

    @Override
    public void atBegining() {
        ItemStack shield = new ItemStack(Material.SHIELD);
        ItemMeta itemMeta = shield.getItemMeta();
        ArrayList<String> lore = new ArrayList<>();
        itemMeta.setDisplayName("§fÉcu renforcé");
        lore.add("§fCommun");
        lore.add("§aCe bouclier donné à des chevaliers");
        lore.add("§apermet de protéger ses alliés des attaques.");
        lore.add("");
        lore.add("§7Clic droit : ");
        lore.add("§2 Bloquer une attaque de mêlée ou un projectile.");
        itemMeta.setLore(lore);
        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        shield.setItemMeta(itemMeta);
        shield.addEnchantment(Enchantment.DURABILITY, 2);
        this.player.getInventory().addItem(shield);

        this.player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(22);
        Bukkit.getServer().getPluginManager().registerEvents(this.paladinLevel1Listener, JavaPlugin.getPlugin(DragonRush.class));
        Bukkit.getServer().getPluginManager().registerEvents(this.paladinDisadvantage, JavaPlugin.getPlugin(DragonRush.class));
        this.objectiveLevel2();
        this.objectiveLevel3();
    }

    @Override
    public void objectiveLevel2() {
        super.objectiveLevel2();
        HandlerList.unregisterAll(this.paladinLevel1Listener);
        Bukkit.getServer().getPluginManager().registerEvents(this.paladinLevel2, JavaPlugin.getPlugin(DragonRush.class));
        Bukkit.getServer().getPluginManager().registerEvents(this.paladinLevel2Listener, JavaPlugin.getPlugin(DragonRush.class));
        this.player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(26);
    }

    @Override
    public void objectiveLevel3() {
        super.objectiveLevel3();
        HandlerList.unregisterAll(this.paladinLevel2Listener);
        this.player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(32);
        this.player.getInventory().addItem(this.paladinSkillItem());
        Bukkit.getServer().getPluginManager().registerEvents(this.paladinLevel3, JavaPlugin.getPlugin(DragonRush.class));
        Bukkit.getServer().getPluginManager().registerEvents(this.paladinSkillProtection, JavaPlugin.getPlugin(DragonRush.class));
    }

    @Override
    public void potionEffect() {

    }

    public ItemStack paladinSkillItem() {
        ItemStack skill = new ItemStack(Material.BOOK);
        ItemMeta itemMeta = skill.getItemMeta();
        ArrayList<String> lore = new ArrayList<>();
        itemMeta.setDisplayName("§b§lCourage");
        lore.add("§bCompétence");
        lore.add("§a§oLa lumière protège ceux qui la détiennent.");
        lore.add("§6§l Uther, le Porteur de Lumière");
        lore.add("");
        lore.add("§7Clic gauche : ");
        lore.add("§2 Confère §e2 coeurs bonus §2et de");
        lore.add("§e la résistance §2à tous les alliés autour");
        lore.add("§2 pendant 30 secondes. §9(60s)");
        itemMeta.setLore(lore);
        itemMeta.addEnchant(Enchantment.DURABILITY, 1, true);
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        skill.setItemMeta(itemMeta);

        return skill;
    }

    @Override
    public void destructor() {
        HandlerList.unregisterAll(this.paladinLevel1Listener);
        HandlerList.unregisterAll(this.paladinLevel2);
        HandlerList.unregisterAll(this.paladinLevel2Listener);
        HandlerList.unregisterAll(this.paladinLevel3);
        HandlerList.unregisterAll(this.paladinSkillProtection);
        HandlerList.unregisterAll(this.paladinDisadvantage);
    }
}
