package fr.thibma.dragonrush.listeners;

import fr.thibma.dragonrush.DragonRush;
import fr.thibma.dragonrush.classes.ClassEnums;
import fr.thibma.dragonrush.items.MenuItem;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;

import java.awt.*;

public class CraftItemProtectionListener implements Listener {

    @EventHandler
    void onFumigeneCrafted(CraftItemEvent event) {
        if (event.getRecipe().getResult().equals(MenuItem.fumigene())) {
            Player player = (Player) event.getWhoClicked();
            if (DragonRush.classes.getPlayerClass(player) == null) {
                event.setCancelled(true);
                player.sendMessage("§cVous n'arrivez pas à crafter cet objet.");
                return;
            }
            if (DragonRush.classes.getPlayerClass(player).getEnum() != ClassEnums.ASSASSIN) {
                event.setCancelled(true);
                player.sendMessage("§cVous n'arrivez pas à crafter cet objet.");
            }
            if (DragonRush.classes.getPlayerClass(player).getLevel() != 3) {
                event.setCancelled(true);
                player.sendMessage("§cVous n'êtes pas assez experimenté pour réalisé cet objet...");
            }
        }
    }

    @EventHandler
    void onPotionCrafted(CraftItemEvent event) {
        ItemStack result = event.getRecipe().getResult();
        int levelRequired = 0;
        if (result.equals(MenuItem.minorRegen()) ||
                result.equals(MenuItem.minorCelerity()) ||
                result.equals(MenuItem.minorSpeed()) ||
                result.equals(MenuItem.minorDamage()) ||
                result.equals(MenuItem.minorSlow()) ||
                result.equals(MenuItem.sanatorium())) {
            levelRequired = 1;
        }
        else if (result.equals(MenuItem.cyanure()) ||
                result.equals(MenuItem.injection()) ||
                result.equals(MenuItem.supplice()) ||
                result.equals(MenuItem.aquethyme()) ||
                result.equals(MenuItem.halcyon()) ||
                result.equals(MenuItem.dracosouffle()) ||
                result.equals(MenuItem.sagou())) {
            levelRequired = 2;
        }
        else if (result.equals(MenuItem.aladore()) ||
                result.equals(MenuItem.croisade()) ||
                result.equals(MenuItem.nuclide()) ||
                result.equals(MenuItem.adamantine()) ||
                result.equals(MenuItem.decubitus()) ||
                result.equals(MenuItem.esuna()) ||
                result.equals(MenuItem.megaElixir()) ||
                result.equals(MenuItem.ankou())) {
            levelRequired = 3;
        }
        else {
            return;
        }


        Player player = (Player) event.getWhoClicked();
        if (DragonRush.classes.getPlayerClass(player) == null) {
            event.setCancelled(true);
            player.sendMessage("§cVous n'arrivez pas à crafter cet objet.");
            return;
        }
        if (DragonRush.classes.getPlayerClass(player).getEnum() != ClassEnums.ALCHEMIST) {
            event.setCancelled(true);
            player.sendMessage("§cVous n'arrivez pas à crafter cet objet.");
            return;
        }

        switch (levelRequired) {
            case 2 -> {
                if (DragonRush.classes.getPlayerClass(player).getLevel() < 2) {
                    event.setCancelled(true);
                    player.sendMessage("§cVous n'êtes pas assez experimenté pour réalisé cet objet...");
                }
            }
            case 3 -> {
                if (DragonRush.classes.getPlayerClass(player).getLevel() < 3) {
                    event.setCancelled(true);
                    player.sendMessage("§cVous n'êtes pas assez experimenté pour réalisé cet objet...");
                }
            }
        }
    }

}
