package fr.thibma.dragonrush;

import fr.thibma.dragonrush.listeners.EntityDeathListener;
import fr.thibma.dragonrush.listeners.PlayerJoinListener;
import fr.thibma.dragonrush.listeners.RightClickListener;
import fr.thibma.dragonrush.players.Team;
import org.bukkit.Color;
import org.bukkit.DyeColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class DragonRush extends JavaPlugin {

    private State state;
    private List<Team> teamList = new ArrayList<>();

    @Override
    public void onEnable() {
        System.out.println("Plugin Dragon Rush Up !");
        this.setState(State.WAITING);

        teamList.add(new Team("Rouge", DyeColor.RED));
        teamList.add(new Team("Bleue", DyeColor.BLUE));

        // register fr.thibma.dragonrush.listeners
        this.getServer().getPluginManager().registerEvents(new PlayerJoinListener(this.teamList), this);
        this.getServer().getPluginManager().registerEvents(new EntityDeathListener(), this);
        this.getServer().getPluginManager().registerEvents(new RightClickListener(), this);
    }

    void setState(State state) {
        this.state = state;
    }

}
