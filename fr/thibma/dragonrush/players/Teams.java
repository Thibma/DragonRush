package fr.thibma.dragonrush.players;

import fr.thibma.dragonrush.events.PlayerAddedToTeamEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class Teams {

    public Teams() {
        this.teamList.add(new Team("Rouge", DyeColor.RED, ChatColor.RED));
        this.teamList.add(new Team("Bleu", DyeColor.BLUE, ChatColor.BLUE));
        this.teamList.add(new Team("Vert", DyeColor.GREEN, ChatColor.GREEN));
        this.teamList.add(new Team("Jaune", DyeColor.YELLOW, ChatColor.YELLOW));
        this.teamList.add(new Team("Violet", DyeColor.PURPLE, ChatColor.DARK_PURPLE));
        this.teamList.add(new Team("Gris", DyeColor.LIGHT_GRAY, ChatColor.GRAY));
        this.teamList.add(new Team("Cyan", DyeColor.CYAN, ChatColor.DARK_AQUA));
        this.teamList.add(new Team("Blanc", DyeColor.WHITE, ChatColor.WHITE));
        this.teamList.add(new Team("Rose", DyeColor.MAGENTA, ChatColor.LIGHT_PURPLE));
    }

    private List<Team> teamList = new ArrayList<>();

    public List<Team> getTeamList() { return teamList; }

    public Team getTeamOfAPlayer(Player player) {
        for (Team team : this.teamList) {
            if (team.getPlayerList().contains(player)) {
                return team;
            }
        }
        return null;
    }

    public Inventory getTeams() {
        Inventory inventory = Bukkit.createInventory(null, 9, "§2§lChoisissez une équipe !");
        for (Team team : teamList) {
            inventory.addItem(team.getBanner());
        }
        return inventory;
    }

    public Team addPlayerToTeam(Player player, ItemStack teamItem) {

        Team getPlayerTeam = this.getTeamOfAPlayer(player);
        if (getPlayerTeam != null) {
            getPlayerTeam.removePlayer(player);
        }

        for (Team team : this.teamList) {
            if (teamItem.equals(team.getBanner())) {
                team.addPlayer(player);
                Bukkit.getServer().getPluginManager().callEvent(new PlayerAddedToTeamEvent());
                return team;
            }
        }
        return null;
    }

}
