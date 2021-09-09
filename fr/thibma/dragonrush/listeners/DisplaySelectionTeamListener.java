package fr.thibma.dragonrush.listeners;

import fr.thibma.dragonrush.DragonRush;
import fr.thibma.dragonrush.events.DisplaySelectionTeamEvent;
import fr.thibma.dragonrush.events.PlayerAddedToTeamEvent;
import fr.thibma.dragonrush.players.Team;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class DisplaySelectionTeamListener implements Listener {

    private Inventory inventory = DragonRush.teams.getTeams();

    @EventHandler
    public void onDisplaySelectionTeam(DisplaySelectionTeamEvent event) {
        Player player = event.getPlayer();
        player.openInventory(this.inventory);
    }

    @EventHandler
    public void onRefreshInventory(PlayerAddedToTeamEvent event) {
        List<Player> inventoryToResfresh = new ArrayList<>();
        for (Player onlinePlayer : Bukkit.getServer().getOnlinePlayers()) {
            if (onlinePlayer.getOpenInventory().getTopInventory().equals(this.inventory)) {
                inventoryToResfresh.add(onlinePlayer);
            }
        }

        this.inventory = DragonRush.teams.getTeams();
        for (Player player : inventoryToResfresh) {
            player.openInventory(this.inventory);
        }
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getInventory() != this.inventory) {
            return;
        }

        event.setCancelled(true);

        final ItemStack clickedItem = event.getCurrentItem();

        if (clickedItem == null || clickedItem.getType() == Material.AIR) {
            return;
        }


        final Player player = (Player) event.getWhoClicked();

        Team team = DragonRush.teams.addPlayerToTeam(player, clickedItem);

        if (team == null) {
            return;
        }

        player.sendMessage("Vous avez etez ajouté à l'équipe " + team.getColorString() + team.getName());
        player.closeInventory();
    }

    @EventHandler
    public void onInventoryClick(InventoryDragEvent event) {
        if (event.getInventory() == this.inventory) {
            event.setCancelled(true);
        }
    }

}
