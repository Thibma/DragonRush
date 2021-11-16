package fr.thibma.dragonrush.classes.nether_explorer;

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

public class NetherExplorer extends Class {

    private final NetherExplorerLevel1Listener netherExplorerLevel1Listener = new NetherExplorerLevel1Listener(this);
    private final NetherExplorerLevel2 netherExplorerLevel2 = new NetherExplorerLevel2(this);
    private final NetherExplorerLevel2Listener netherExplorerLevel2Listener = new NetherExplorerLevel2Listener(this);
    private final NetherExplorerLevel3 netherExplorerLevel3 = new NetherExplorerLevel3(this);

    protected int blazeKilled = 0;
    protected int witherSkeletonKilled = 0;

    public NetherExplorer(Player player) { this.player = player; }

    @Override
    public ClassEnums getEnum() { return ClassEnums.NETHER_EXPLORER; }

    @Override
    public String getClassName() {
        return "Explorateur du Nether";
    }

    @Override
    public void atBegining() {
        super.atBegining();
        Bukkit.getServer().getPluginManager().registerEvents(this.netherExplorerLevel1Listener, JavaPlugin.getPlugin(DragonRush.class));
        this.objectiveLevel2();
        this.objectiveLevel3();
    }

    @Override
    public void potionEffect() {

    }

    @Override
    public ArrayList<ItemStack> itemSpawn() {
        ItemStack obsidian = new ItemStack(Material.OBSIDIAN);
        ItemMeta itemMeta = obsidian.getItemMeta();
        ArrayList<String> lore = new ArrayList<>();
        itemMeta.setDisplayName("§fMorceaux d'obsidienne");
        lore.add("§fCommun");
        lore.add("§aUne très vieille pierre vraiment solide");
        lore.add("§arécupérée par des archéologues.");
        itemMeta.setLore(lore);
        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        obsidian.setItemMeta(itemMeta);
        obsidian.setAmount(3);

        ItemStack flintAndSteel = new ItemStack(Material.FLINT_AND_STEEL);
        itemMeta = flintAndSteel.getItemMeta();
        lore = new ArrayList<>();
        itemMeta.setDisplayName("§fAllume-feu");
        lore.add("§fCommun");
        lore.add("§aUn smple outil permettant d'allumer");
        lore.add("§aun feu. Pratique en caverne.");
        lore.add("");
        lore.add("§7Clic droit : ");
        lore.add("§2 Allume §eun feu §2sur le bloc ciblé.");
        itemMeta.setLore(lore);
        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        flintAndSteel.setItemMeta(itemMeta);

        return new ArrayList<>(List.of(obsidian, flintAndSteel));
    }

    @Override
    public ArrayList<ItemStack> skills() {
        ArrayList<ItemStack> listSkill = new ArrayList<>();
        if (this.level >= 2) {
            listSkill.add(skillItemLevel2());
        }
        if (this.level == 3) {
            listSkill.add(skillItemLevel3());
        }
        return listSkill;
    }

    protected ItemStack skillItemLevel2() {
        ItemStack skill = new ItemStack(Material.BOOK);
        ItemMeta itemMeta = skill.getItemMeta();
        ArrayList<String> lore = new ArrayList<>();
        itemMeta.setDisplayName("§b§lInferno");
        lore.add("§bCompétence");
        lore.add("§a§oSOYEZ PURIFIÉ PAR LE FEU !");
        lore.add("§6§l Ragnaros, Seigneur du feu");
        lore.add("");
        lore.add("§7Clic droit : ");
        lore.add("§2 Le lanceur et tous les alliés autour");
        lore.add("§2 obtiennent §eune protection contre le feu");
        lore.add("§2 pendant §660 secondes. §9(120s)");
        itemMeta.setLore(lore);
        itemMeta.addEnchant(Enchantment.DURABILITY, 1, true);
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        skill.setItemMeta(itemMeta);

        return skill;
    }

    protected ItemStack skillItemLevel3() {
        ItemStack skill = new ItemStack(Material.BOOK);
        ItemMeta itemMeta = skill.getItemMeta();
        ArrayList<String> lore = new ArrayList<>();
        itemMeta.setDisplayName("§b§lPortail portable");
        lore.add("§bCompétence");
        lore.add("§a§oNotre combat est autre part !");
        lore.add("§6§l Ryze, Mage runique");
        lore.add("");
        lore.add("§7Clic droit : ");
        lore.add("§2 Génère §eun portail du Nether§2 dans une");
        lore.add("§2 zone libre qui disparait au bout de");
        lore.add("§2 §610 secondes. §9(300s)");
        itemMeta.setLore(lore);
        itemMeta.addEnchant(Enchantment.DURABILITY, 1, true);
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        skill.setItemMeta(itemMeta);

        return skill;
    }

    @Override
    public void objectiveLevel2() {
        super.objectiveLevel2();
        HandlerList.unregisterAll(this.netherExplorerLevel1Listener);
        Bukkit.getServer().getPluginManager().registerEvents(this.netherExplorerLevel2, JavaPlugin.getPlugin(DragonRush.class));
        Bukkit.getServer().getPluginManager().registerEvents(this.netherExplorerLevel2Listener, JavaPlugin.getPlugin(DragonRush.class));
        for (Player playerTeam : DragonRush.teams.getTeamOfAPlayer(this.getPlayer()).getPlayerList()) {
            this.netherExplorerLevel2.detectDimension(playerTeam);
        }
    }

    @Override
    public void objectiveLevel3() {
        super.objectiveLevel3();
        HandlerList.unregisterAll(this.netherExplorerLevel2Listener);
        Bukkit.getServer().getPluginManager().registerEvents(this.netherExplorerLevel3, JavaPlugin.getPlugin(DragonRush.class));
        for (Player playerTeam : DragonRush.teams.getTeamOfAPlayer(this.getPlayer()).getPlayerList()) {
            this.netherExplorerLevel2.detectDimension(playerTeam);
        }
    }

    @Override
    public void destructor() {
        HandlerList.unregisterAll(this.netherExplorerLevel1Listener);
        HandlerList.unregisterAll(this.netherExplorerLevel2);
        HandlerList.unregisterAll(this.netherExplorerLevel2Listener);
        HandlerList.unregisterAll(this.netherExplorerLevel3);
    }
}
