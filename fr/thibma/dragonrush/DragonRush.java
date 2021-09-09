package fr.thibma.dragonrush;

import com.ryandw11.structure.CustomStructures;
import com.ryandw11.structure.api.CustomStructuresAPI;
import com.ryandw11.structure.api.structaddon.CustomStructureAddon;
import com.sk89q.worldedit.WorldEdit;
import fr.minuskube.netherboard.Netherboard;
import fr.minuskube.netherboard.bukkit.BPlayerBoard;
import fr.thibma.dragonrush.classes.Classes;
import fr.thibma.dragonrush.items.Crafts;
import fr.thibma.dragonrush.items.MenuItem;
import fr.thibma.dragonrush.listeners.*;
import fr.thibma.dragonrush.players.Teams;
import net.minecraft.network.chat.ChatComponentText;
import net.minecraft.network.protocol.game.PacketPlayOutPlayerListHeaderFooter;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class DragonRush extends JavaPlugin {

    public static State state;
    public static Teams teams = new Teams();
    public static Classes classes = new Classes();

    @Override
    public void onEnable() {
        System.out.println("Plugin Dragon Rush Up !");
        state = State.WAITING;

        Crafts crafts = new Crafts();

        // register fr.thibma.dragonrush.listeners
        this.getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
        this.getServer().getPluginManager().registerEvents(new EntityDeathListener(), this);
        this.getServer().getPluginManager().registerEvents(new RightClickListener(), this);
        this.getServer().getPluginManager().registerEvents(new DisplaySelectionClassesListener(), this);
        this.getServer().getPluginManager().registerEvents(new DisplaySelectionTeamListener(), this);
        this.getServer().getPluginManager().registerEvents(new CraftItemProtectionListener(), this);
        this.getServer().getPluginManager().registerEvents(new PotionSplashListener(), this);
        this.getServer().getPluginManager().registerEvents(new DragonEggListener(), this);
        this.getServer().getPluginManager().registerEvents(new PlayerChatListener(), this);
        this.getServer().getPluginManager().registerEvents(new StartGameListener(), this);

    }

}
