package fr.thibma.dragonrush.items;

import fr.thibma.dragonrush.DragonRush;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Crafts {

    private final Plugin plugin = JavaPlugin.getPlugin(DragonRush.class);

    public Crafts() {
        this.setCrafts();
    }

    public void setCrafts() {
        NamespacedKey key = new NamespacedKey(this.plugin, "fumigene");
        ShapedRecipe fumigene = new ShapedRecipe(key, MenuItem.fumigene());
        fumigene.shape("GFG","FIF","GFG");
        fumigene.setIngredient('G', Material.GUNPOWDER);
        fumigene.setIngredient('F', Material.FIREWORK_STAR);
        fumigene.setIngredient('I', Material.IRON_BLOCK);
        Bukkit.addRecipe(fumigene);
    }

}
