package fr.thibma.dragonrush.classes.archer;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.AbstractArrow;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.entity.TippedArrow;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionType;

import java.util.ArrayList;

public class ArcherLevel3 implements Listener {

    private final Archer archer;

    public ArcherLevel3(Archer archer) { this.archer = archer; }

    @EventHandler
    void onArrowShot(ProjectileHitEvent event) {

        if (!(event.getEntity() instanceof Arrow)) {
            return;
        }
        Arrow arrow = (Arrow) event.getEntity();

        if (arrow.getBasePotionData().getType() != PotionType.UNCRAFTABLE) {
            return;
        }

        if (!((arrow.getShooter()) instanceof Player)) {
            return;
        }
        Player player = (Player) arrow.getShooter();
        if (player != this.archer.getPlayer()) {
            return;
        }

        if (player.getInventory().getItemInMainHand().getType() == Material.CROSSBOW || player.getInventory().getItemInOffHand().getType() == Material.CROSSBOW) {
            return;
        }

        if (player.getInventory().getItemInMainHand().getEnchantments().containsKey(Enchantment.ARROW_INFINITE) || player.getInventory().getItemInOffHand().getEnchantments().containsKey(Enchantment.ARROW_INFINITE)) {
            return;
        }

        arrow.setPickupStatus(AbstractArrow.PickupStatus.DISALLOWED);
        ItemStack arrowItem = new ItemStack(Material.ARROW);
        ItemMeta itemMetaArrow = arrowItem.getItemMeta();
        ArrayList<String> loreArrow = new ArrayList<>();
        itemMetaArrow.setDisplayName("§fFlèche d'entraînement");
        loreArrow.add("§fCommun");
        loreArrow.add("§aUne flèche utilisée lors des");
        loreArrow.add("§aentraînements sur des cibles fixes.");
        itemMetaArrow.setLore(loreArrow);
        arrowItem.setItemMeta(itemMetaArrow);

        player.getInventory().addItem(arrowItem);
    }

}
