package fr.thibma.dragonrush.items;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public final class MenuItem {

    public static ItemStack fumigene() {
        ItemStack item = new ItemStack(Material.GUNPOWDER);
        ItemMeta itemMeta = item.getItemMeta();
        ArrayList<String> lore = new ArrayList<>();
        itemMeta.setDisplayName("§5Fumigène");
        lore.add("§5Épique");
        lore.add("§aUne préparation parfaite montée par un");
        lore.add("§aassassin hors pair. Il doit choisir la");
        lore.add("§aprochaine cible à éxecuter.");
        lore.add("");
        lore.add("§c§l§oUtilisable uniquement par la classe Assassin.");
        lore.add("§7Clic droit : ");
        lore.add("§2 Lance un projectile.");
        lore.add("§2 A l'impact, il explose et invoque un brouillard");
        lore.add("§2 pendant §615 secondes §2qui inflige §ecécité");
        lore.add("§2 aux ennemis et §evitesse §2au lanceur dans la zone.");
        itemMeta.setLore(lore);
        itemMeta.addEnchant(Enchantment.DURABILITY, 1, true);
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        item.setItemMeta(itemMeta);

        return item;
    }

}
