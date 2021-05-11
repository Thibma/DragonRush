package fr.thibma.dragonrush.classes.lancer;

import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.UUID;

public class LancerProtection implements Listener {

    private final Lancer lancer;

    public LancerProtection(Lancer lancer) { this.lancer = lancer; }

    @EventHandler
    void onInventoryClickEvent(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();

        if (player != this.lancer.getPlayer()) {
            return;
        }

        if (event.getInventory().getType() != InventoryType.CRAFTING) {
            if (event.getCurrentItem().getType() != Material.TRIDENT) {
                return;
            }
            if (event.getCurrentItem().getItemMeta().getDisplayName().equals(this.lancer.getStringofWeapon1)
                    || event.getCurrentItem().getItemMeta().getDisplayName().equals(this.lancer.getStringofWeapon2)
                    || event.getCurrentItem().getItemMeta().getDisplayName().equals(this.lancer.getStringofWeapon3)) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    void onDropEvent(PlayerDropItemEvent event) {
        Player player = event.getPlayer();

        if (player != this.lancer.getPlayer()) {
            return;
        }

        if (event.getItemDrop().getItemStack().getType() != Material.TRIDENT) {
            return;
        }
        if (event.getItemDrop().getItemStack().getItemMeta().getDisplayName().equals(this.lancer.getStringofWeapon1)
                || event.getItemDrop().getItemStack().getItemMeta().getDisplayName().equals(this.lancer.getStringofWeapon2)
                || event.getItemDrop().getItemStack().getItemMeta().getDisplayName().equals(this.lancer.getStringofWeapon3)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    void onDeathEvent(PlayerDeathEvent event) {
        Player player = event.getEntity().getPlayer();

        if (player != this.lancer.getPlayer()) {
            return;
        }

        for (ItemStack itemStack : event.getDrops()) {
            if (itemStack != null) {
                if (itemStack.getItemMeta().getDisplayName().equals(this.lancer.getStringofWeapon1)
                || itemStack.getItemMeta().getDisplayName().equals(this.lancer.getStringofWeapon2)
                || itemStack.getItemMeta().getDisplayName().equals(this.lancer.getStringofWeapon3)) {
                    event.getDrops().remove(itemStack);
                }
            }
        }
    }

    @EventHandler
    void onRespawnEvent(PlayerRespawnEvent event) {
        Player player = event.getPlayer();
        if (player != this.lancer.getPlayer()) {
            return;
        }

        switch (this.lancer.getLevel()) {
            case 1 -> {
                ItemStack trident = new ItemStack(Material.TRIDENT);
                ItemMeta itemMeta = trident.getItemMeta();
                ArrayList<String> lore = new ArrayList<>();
                itemMeta.setDisplayName("§fLance de bronze");
                lore.add("§fCommun");
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
                player.getInventory().addItem(trident);
            }
            case 2 -> {
                ItemStack trident = new ItemStack(Material.TRIDENT);
                ItemMeta itemMeta = trident.getItemMeta();
                ArrayList<String> lore = new ArrayList<>();
                itemMeta.setDisplayName("§bLance Boomerang");
                lore.add("§bRare");
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
                player.getInventory().addItem(trident);
            }
            case 3 -> {
                ItemStack trident = new ItemStack(Material.TRIDENT);
                ItemMeta itemMeta = trident.getItemMeta();
                ArrayList<String> lore = new ArrayList<>();
                itemMeta.setDisplayName("§5Lance Fidèle");
                lore.add("§5Épique");
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
                player.getInventory().addItem(trident);
            }
        }
    }
}
