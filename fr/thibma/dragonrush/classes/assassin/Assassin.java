package fr.thibma.dragonrush.classes.assassin;

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
import java.util.logging.Handler;

public class Assassin extends Class {

    protected int villagerKilled = 0;

    private final AssassinLevel2Listener assassinLevel2Listener = new AssassinLevel2Listener(this);
    private final AssassinLevel2 assassinLevel2 = new AssassinLevel2(this);
    private final AssassinLevel3Listener assassinLevel3Listener = new AssassinLevel3Listener(this);
    private final AssassinLevel3 assassinLevel3 = new AssassinLevel3(this);

    public Assassin(Player player) { this.player = player; }

    @Override
    public ClassEnums getEnum() { return ClassEnums.ASSASSIN; }

    @Override
    public void atBegining() {
        this.player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(14);
        this.player.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(0.11);

        Bukkit.getServer().getPluginManager().registerEvents(this.assassinLevel2Listener, JavaPlugin.getPlugin(DragonRush.class));
    }

    @Override
    public void objectiveLevel2() {
        super.objectiveLevel2();
        HandlerList.unregisterAll(this.assassinLevel2Listener);
        this.player.getInventory().addItem(this.assassinSkillItem());
        Bukkit.getServer().getPluginManager().registerEvents(this.assassinLevel2, JavaPlugin.getPlugin(DragonRush.class));
        Bukkit.getServer().getPluginManager().registerEvents(this.assassinLevel3Listener, JavaPlugin.getPlugin(DragonRush.class));
    }

    @Override
    public void objectiveLevel3() {
        super.objectiveLevel3();
        HandlerList.unregisterAll(this.assassinLevel3Listener);
        Bukkit.getServer().getPluginManager().registerEvents(this.assassinLevel3, JavaPlugin.getPlugin(DragonRush.class));
    }

    @Override
    public void potionEffect() {

    }

    public ItemStack assassinSkillItem() {
        ItemStack skill = new ItemStack(Material.BOOK);
        ItemMeta itemMeta = skill.getItemMeta();
        ArrayList<String> lore = new ArrayList<>();
        itemMeta.setDisplayName("??b??lAssassinat");
        lore.add("??bComp??tence");
        lore.add("??a??oLa lame qu'on ne voit pas, est la plus dangereuse.");
        lore.add("??6??l Zed, Ma??tre des ombres");
        lore.add("");
        lore.add("??7Clic droit : ");
        lore.add("??2 Devient ??einvisible ??2et augmente");
        lore.add("??e la vitesse de d??placement ??2pendant 10 secondes");
        lore.add("??2 Double ??eles prochains d??g??ts inflig??s ??2pendant");
        lore.add("??2 ce laps de temps. (Effet annul?? si le joueur");
        lore.add("??2 est attaqu??.) ??9(120s)");
        itemMeta.setLore(lore);
        itemMeta.addEnchant(Enchantment.DURABILITY, 1, true);
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        skill.setItemMeta(itemMeta);

        return skill;
    }

    @Override
    public void destructor() {
        HandlerList.unregisterAll(this.assassinLevel2Listener);
        HandlerList.unregisterAll(this.assassinLevel2);
        HandlerList.unregisterAll(this.assassinLevel3Listener);
        HandlerList.unregisterAll(this.assassinLevel3);
    }
}
