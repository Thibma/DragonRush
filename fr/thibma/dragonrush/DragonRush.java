package fr.thibma.dragonrush;

import fr.thibma.dragonrush.classes.Classes;
import fr.thibma.dragonrush.items.Crafts;
import fr.thibma.dragonrush.items.MenuItem;
import fr.thibma.dragonrush.listeners.*;
import fr.thibma.dragonrush.players.Teams;
import org.bukkit.plugin.java.JavaPlugin;

public class DragonRush extends JavaPlugin {

    private State state;
    public static Teams teams = new Teams();
    public static Classes classes = new Classes();

    @Override
    public void onEnable() {
        System.out.println("Plugin Dragon Rush Up !");
        this.setState(State.WAITING);

        Crafts crafts = new Crafts();

        // register fr.thibma.dragonrush.listeners
        this.getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
        this.getServer().getPluginManager().registerEvents(new EntityDeathListener(), this);
        this.getServer().getPluginManager().registerEvents(new RightClickListener(), this);
        this.getServer().getPluginManager().registerEvents(new DisplaySelectionClassesListener(), this);
        this.getServer().getPluginManager().registerEvents(new DisplaySelectionTeamListener(), this);
        this.getServer().getPluginManager().registerEvents(new CraftItemProtectionListener(), this);
    }

    void setState(State state) {
        this.state = state;
    }

}
