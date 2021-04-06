package fr.thibma.dragonrush.players;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.block.banner.Pattern;
import org.bukkit.block.banner.PatternType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BannerMeta;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private final String name;
    private final DyeColor color;

    private final List<Player> playerList = new ArrayList<>();

    public Team(String name, DyeColor color) {
        this.name = name;
        this.color = color;
    }

    public ItemStack getBanner() {
        ItemStack banner = new ItemStack(Material.WHITE_BANNER, 1);
        BannerMeta meta = (BannerMeta)banner.getItemMeta();
        List<Pattern> patterns = new ArrayList<>();
        patterns.add(new Pattern(this.color, PatternType.BASE));
        meta.setPatterns(patterns);
        meta.setDisplayName("§fÉquipe " + ChatColor.valueOf(this.color.toString()) + this.name);
        List<String> loreList = new ArrayList<>();
        if (this.playerList.size() >= 1) {
            for (Player player : playerList) {
                loreList.add(this.color + player.getDisplayName());
            }
            meta.setLore(loreList);
        }
        banner.setItemMeta(meta);
        return banner;
    }

    public void addPlayer(Player player) { this.playerList.add(player); }
    public void removePlayer(Player player) { this.playerList.remove(player); }

    public List<Player> getPlayerList() { return this.playerList; }
}
