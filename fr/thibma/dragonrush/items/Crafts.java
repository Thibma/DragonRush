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
        // ASSASSIN
        NamespacedKey key = new NamespacedKey(this.plugin, "fumigene");
        ShapedRecipe fumigene = new ShapedRecipe(key, MenuItem.fumigene());
        fumigene.shape("GFG","FIF","GFG");
        fumigene.setIngredient('G', Material.GUNPOWDER);
        fumigene.setIngredient('F', Material.FIREWORK_STAR);
        fumigene.setIngredient('I', Material.IRON_BLOCK);
        Bukkit.addRecipe(fumigene);


        // ALCHEMIST
        key = new NamespacedKey(this.plugin, "minorRegen1");
        ShapedRecipe minorRegen = new ShapedRecipe(key, MenuItem.minorRegen());
        minorRegen.shape("   ", "PMG", "   ");
        minorRegen.setIngredient('P', Material.POTION);
        minorRegen.setIngredient('M', Material.GLISTERING_MELON_SLICE);
        minorRegen.setIngredient('G', Material.GUNPOWDER);
        Bukkit.addRecipe(minorRegen);

        key = new NamespacedKey(this.plugin, "minorRegen2");
        ShapedRecipe minorRegen2 = new ShapedRecipe(key, MenuItem.minorRegen());
        minorRegen2.shape("PMG", "   ", "   ");
        minorRegen2.setIngredient('P', Material.POTION);
        minorRegen2.setIngredient('M', Material.GLISTERING_MELON_SLICE);
        minorRegen2.setIngredient('G', Material.GUNPOWDER);
        Bukkit.addRecipe(minorRegen2);

        key = new NamespacedKey(this.plugin, "minorRegen3");
        ShapedRecipe minorRegen3 = new ShapedRecipe(key, MenuItem.minorRegen());
        minorRegen3.shape("   ", "   ", "PMG");
        minorRegen3.setIngredient('P', Material.POTION);
        minorRegen3.setIngredient('M', Material.GLISTERING_MELON_SLICE);
        minorRegen3.setIngredient('G', Material.GUNPOWDER);
        Bukkit.addRecipe(minorRegen3);



        key = new NamespacedKey(this.plugin, "minorDamage1");
        ShapedRecipe minorDamage1 = new ShapedRecipe(key, MenuItem.minorDamage());
        minorDamage1.shape("   ", "PZG", "   ");
        minorDamage1.setIngredient('P', Material.POTION);
        minorDamage1.setIngredient('Z', Material.ROTTEN_FLESH);
        minorDamage1.setIngredient('G', Material.GUNPOWDER);
        Bukkit.addRecipe(minorDamage1);

        key = new NamespacedKey(this.plugin, "minorDamage2");
        ShapedRecipe minorDamage2 = new ShapedRecipe(key, MenuItem.minorDamage());
        minorDamage2.shape("PZG", "   ", "   ");
        minorDamage2.setIngredient('P', Material.POTION);
        minorDamage2.setIngredient('Z', Material.ROTTEN_FLESH);
        minorDamage2.setIngredient('G', Material.GUNPOWDER);
        Bukkit.addRecipe(minorDamage2);

        key = new NamespacedKey(this.plugin, "minorDamage3");
        ShapedRecipe minorDamage3 = new ShapedRecipe(key, MenuItem.minorDamage());
        minorDamage3.shape("   ", "   ", "PZG");
        minorDamage3.setIngredient('P', Material.POTION);
        minorDamage3.setIngredient('Z', Material.ROTTEN_FLESH);
        minorDamage3.setIngredient('G', Material.GUNPOWDER);
        Bukkit.addRecipe(minorDamage3);



        key = new NamespacedKey(this.plugin, "minorSpeed1");
        ShapedRecipe minorSpeed1 = new ShapedRecipe(key, MenuItem.minorSpeed());
        minorSpeed1.shape("   ", "PSG", "   ");
        minorSpeed1.setIngredient('P', Material.POTION);
        minorSpeed1.setIngredient('S', Material.SUGAR);
        minorSpeed1.setIngredient('G', Material.GUNPOWDER);
        Bukkit.addRecipe(minorSpeed1);

        key = new NamespacedKey(this.plugin, "minorSpeed2");
        ShapedRecipe minorSpeed2 = new ShapedRecipe(key, MenuItem.minorSpeed());
        minorSpeed2.shape("PSG", "   ", "   ");
        minorSpeed2.setIngredient('P', Material.POTION);
        minorSpeed2.setIngredient('S', Material.SUGAR);
        minorSpeed2.setIngredient('G', Material.GUNPOWDER);
        Bukkit.addRecipe(minorSpeed2);

        key = new NamespacedKey(this.plugin, "minorSpeed3");
        ShapedRecipe minorSpeed3 = new ShapedRecipe(key, MenuItem.minorSpeed());
        minorSpeed3.shape("   ", "   ", "PSG");
        minorSpeed3.setIngredient('P', Material.POTION);
        minorSpeed3.setIngredient('S', Material.SUGAR);
        minorSpeed3.setIngredient('G', Material.GUNPOWDER);
        Bukkit.addRecipe(minorSpeed3);



        key = new NamespacedKey(this.plugin, "minorCelerity1");
        ShapedRecipe minorCelerity1 = new ShapedRecipe(key, MenuItem.minorCelerity());
        minorCelerity1.shape("   ", "   ", "PFG");
        minorCelerity1.setIngredient('P', Material.POTION);
        minorCelerity1.setIngredient('F', Material.FEATHER);
        minorCelerity1.setIngredient('G', Material.GUNPOWDER);
        Bukkit.addRecipe(minorCelerity1);

        key = new NamespacedKey(this.plugin, "minorCelerity2");
        ShapedRecipe minorCelerity2 = new ShapedRecipe(key, MenuItem.minorCelerity());
        minorCelerity2.shape("   ", "PFG", "   ");
        minorCelerity2.setIngredient('P', Material.POTION);
        minorCelerity2.setIngredient('F', Material.FEATHER);
        minorCelerity2.setIngredient('G', Material.GUNPOWDER);
        Bukkit.addRecipe(minorCelerity2);

        key = new NamespacedKey(this.plugin, "minorCelerity3");
        ShapedRecipe minorCelerity3 = new ShapedRecipe(key, MenuItem.minorCelerity());
        minorCelerity3.shape("PFG", "   ", "   ");
        minorCelerity3.setIngredient('P', Material.POTION);
        minorCelerity3.setIngredient('F', Material.FEATHER);
        minorCelerity3.setIngredient('G', Material.GUNPOWDER);
        Bukkit.addRecipe(minorCelerity3);



        key = new NamespacedKey(this.plugin, "minorSlow1");
        ShapedRecipe minorSlow1 = new ShapedRecipe(key, MenuItem.minorSlow());
        minorSlow1.shape("   ", "   ", "PSG");
        minorSlow1.setIngredient('P', Material.POTION);
        minorSlow1.setIngredient('S', Material.STRING);
        minorSlow1.setIngredient('G', Material.GUNPOWDER);
        Bukkit.addRecipe(minorSlow1);

        key = new NamespacedKey(this.plugin, "minorSlow2");
        ShapedRecipe minorSlow2 = new ShapedRecipe(key, MenuItem.minorSlow());
        minorSlow2.shape("   ", "PSG", "   ");
        minorSlow2.setIngredient('P', Material.POTION);
        minorSlow2.setIngredient('S', Material.STRING);
        minorSlow2.setIngredient('G', Material.GUNPOWDER);
        Bukkit.addRecipe(minorSlow2);

        key = new NamespacedKey(this.plugin, "minorSlow3");
        ShapedRecipe minorSlow3 = new ShapedRecipe(key, MenuItem.minorSlow());
        minorSlow3.shape("PSG", "   ", "   ");
        minorSlow3.setIngredient('P', Material.POTION);
        minorSlow3.setIngredient('S', Material.STRING);
        minorSlow3.setIngredient('G', Material.GUNPOWDER);
        Bukkit.addRecipe(minorSlow3);



        key = new NamespacedKey(this.plugin, "sanatorium1");
        ShapedRecipe sanatorium1 = new ShapedRecipe(key, MenuItem.sanatorium());
        sanatorium1.shape("   ", "   ", "PGD");
        sanatorium1.setIngredient('P', Material.POTION);
        sanatorium1.setIngredient('G', Material.GOLDEN_APPLE);
        sanatorium1.setIngredient('D', Material.DIAMOND);
        Bukkit.addRecipe(sanatorium1);

        key = new NamespacedKey(this.plugin, "sanatorium2");
        ShapedRecipe sanatorium2 = new ShapedRecipe(key, MenuItem.sanatorium());
        sanatorium2.shape("   ", "PGD", "   ");
        sanatorium2.setIngredient('P', Material.POTION);
        sanatorium2.setIngredient('G', Material.GOLDEN_APPLE);
        sanatorium2.setIngredient('D', Material.DIAMOND);
        Bukkit.addRecipe(sanatorium2);

        key = new NamespacedKey(this.plugin, "sanatorium3");
        ShapedRecipe sanatorium3 = new ShapedRecipe(key, MenuItem.sanatorium());
        sanatorium3.shape("PGD", "   ", "   ");
        sanatorium3.setIngredient('P', Material.POTION);
        sanatorium3.setIngredient('G', Material.GOLDEN_APPLE);
        sanatorium3.setIngredient('D', Material.DIAMOND);
        Bukkit.addRecipe(sanatorium3);



        key = new NamespacedKey(this.plugin, "cyanure1");
        ShapedRecipe cyanure1 = new ShapedRecipe(key, MenuItem.cyanure());
        cyanure1.shape(" G ", "REU", " P ");
        cyanure1.setIngredient('P', Material.POTION);
        cyanure1.setIngredient('G', Material.GLOWSTONE_DUST);
        cyanure1.setIngredient('R', Material.REDSTONE);
        cyanure1.setIngredient('E', Material.SPIDER_EYE);
        cyanure1.setIngredient('U', Material.GUNPOWDER);
        Bukkit.addRecipe(cyanure1);



        key = new NamespacedKey(this.plugin, "injection");
        ShapedRecipe injection = new ShapedRecipe(key, MenuItem.injection());
        injection.shape(" S ", "GLU", " P ");
        injection.setIngredient('S', Material.SUGAR);
        injection.setIngredient('G', Material.GLOWSTONE_DUST);
        injection.setIngredient('L', Material.RABBIT_FOOT);
        injection.setIngredient('U', Material.GUNPOWDER);
        injection.setIngredient('P', Material.POTION);
        Bukkit.addRecipe(injection);



        key = new NamespacedKey(this.plugin, "supplice");
        ShapedRecipe supplice = new ShapedRecipe(key, MenuItem.supplice());
        supplice.shape("RGL", "OFZ", " P ");
        supplice.setIngredient('R', Material.REDSTONE);
        supplice.setIngredient('G', Material.GUNPOWDER);
        supplice.setIngredient('L', Material.GLOWSTONE_DUST);
        supplice.setIngredient('O', Material.POISONOUS_POTATO);
        supplice.setIngredient('F', Material.FERMENTED_SPIDER_EYE);
        supplice.setIngredient('Z', Material.ROTTEN_FLESH);
        supplice.setIngredient('P', Material.POTION);
        Bukkit.addRecipe(supplice);



        key = new NamespacedKey(this.plugin, "aquethyme");
        ShapedRecipe aquethyme = new ShapedRecipe(key, MenuItem.aquethyme());
        aquethyme.shape(" G ", "AFA", " P ");
        aquethyme.setIngredient('G', Material.GUNPOWDER);
        aquethyme.setIngredient('A', Material.KELP);
        aquethyme.setIngredient('F', Material.PUFFERFISH);
        aquethyme.setIngredient('P', Material.POTION);
        Bukkit.addRecipe(aquethyme);



        key = new NamespacedKey(this.plugin, "halcyon");
        ShapedRecipe halcyon = new ShapedRecipe(key, MenuItem.halcyon());
        halcyon.shape(" G ", "IDO", " P ");
        halcyon.setIngredient('G', Material.GUNPOWDER);
        halcyon.setIngredient('I', Material.IRON_INGOT);
        halcyon.setIngredient('D', Material.DIAMOND);
        halcyon.setIngredient('O', Material.GOLD_INGOT);
        halcyon.setIngredient('P', Material.POTION);
        Bukkit.addRecipe(halcyon);



        key = new NamespacedKey(this.plugin, "dracosouffle");
        ShapedRecipe dracosouffle = new ShapedRecipe(key, MenuItem.dracosouffle());
        dracosouffle.shape("GUG", "GZG", "GPG");
        dracosouffle.setIngredient('G', Material.GLOWSTONE_DUST);
        dracosouffle.setIngredient('U', Material.GUNPOWDER);
        dracosouffle.setIngredient('Z', Material.ROTTEN_FLESH);
        dracosouffle.setIngredient('P', Material.POTION);
        Bukkit.addRecipe(dracosouffle);



        key = new NamespacedKey(this.plugin, "sagou");
        ShapedRecipe sagou = new ShapedRecipe(key, MenuItem.sagou());
        sagou.shape("GUG", "BHW", "GPG");
        sagou.setIngredient('G', Material.GLOWSTONE_DUST);
        sagou.setIngredient('U', Material.GUNPOWDER);
        sagou.setIngredient('B', Material.BLAZE_POWDER);
        sagou.setIngredient('H', Material.GHAST_TEAR);
        sagou.setIngredient('W', Material.NETHER_WART);
        sagou.setIngredient('P', Material.POTION);
        Bukkit.addRecipe(sagou);



        key = new NamespacedKey(this.plugin, "aladore");
        ShapedRecipe aladore = new ShapedRecipe(key, MenuItem.aladore());
        aladore.shape(" G ", "RWL", " P ");
        aladore.setIngredient('G', Material.GUNPOWDER);
        aladore.setIngredient('R', Material.REDSTONE);
        aladore.setIngredient('W', Material.WITHER_SKELETON_SKULL);
        aladore.setIngredient('L', Material.GLOWSTONE_DUST);
        aladore.setIngredient('P', Material.POTION);
        Bukkit.addRecipe(aladore);



        key = new NamespacedKey(this.plugin, "croisade");
        ShapedRecipe croisade = new ShapedRecipe(key, MenuItem.croisade());
        croisade.shape(" G ", "RSL", " P ");
        croisade.setIngredient('G', Material.GUNPOWDER);
        croisade.setIngredient('R', Material.REDSTONE);
        croisade.setIngredient('S', Material.NETHER_STAR);
        croisade.setIngredient('L', Material.GLOWSTONE_DUST);
        croisade.setIngredient('P', Material.POTION);
        Bukkit.addRecipe(croisade);


        key = new NamespacedKey(this.plugin, "nuclide");
        ShapedRecipe nuclide = new ShapedRecipe(key, MenuItem.nuclide());
        nuclide.shape("RGB", "WES", "MPO");
        nuclide.setIngredient('R', Material.ROTTEN_FLESH);
        nuclide.setIngredient('G', Material.GUNPOWDER);
        nuclide.setIngredient('B', Material.BLAZE_POWDER);
        nuclide.setIngredient('W', Material.NETHER_WART);
        nuclide.setIngredient('E', Material.SPIDER_EYE);
        nuclide.setIngredient('S', Material.FERMENTED_SPIDER_EYE);
        nuclide.setIngredient('M', Material.ENDER_PEARL);
        nuclide.setIngredient('O', Material.BONE);
        nuclide.setIngredient('P', Material.POTION);
        Bukkit.addRecipe(nuclide);



        key = new NamespacedKey(this.plugin, "adamantine");
        ShapedRecipe adamantine = new ShapedRecipe(key, MenuItem.adamantine());
        adamantine.shape(" G ", "DED", " P ");
        adamantine.setIngredient('G', Material.GUNPOWDER);
        adamantine.setIngredient('D', Material.DIAMOND);
        adamantine.setIngredient('E', Material.FERMENTED_SPIDER_EYE);
        adamantine.setIngredient('P', Material.POTION);
        Bukkit.addRecipe(adamantine);



        key = new NamespacedKey(this.plugin, "decubitus");
        ShapedRecipe decubitus = new ShapedRecipe(key, MenuItem.decubitus());
        decubitus.shape("EGE", "FFF", "EPE");
        decubitus.setIngredient('E', Material.ENDER_PEARL);
        decubitus.setIngredient('G', Material.GUNPOWDER);
        decubitus.setIngredient('F', Material.FEATHER);
        decubitus.setIngredient('P', Material.POTION);
        Bukkit.addRecipe(decubitus);



        key = new NamespacedKey(this.plugin, "esuna");
        ShapedRecipe esuna = new ShapedRecipe(key, MenuItem.esuna());
        esuna.shape(" G ", "IMI", " P ");
        esuna.setIngredient('I', Material.GOLD_INGOT);
        esuna.setIngredient('G', Material.GUNPOWDER);
        esuna.setIngredient('M', Material.MILK_BUCKET);
        esuna.setIngredient('P', Material.POTION);
        Bukkit.addRecipe(esuna);



        key = new NamespacedKey(this.plugin, "megaelixir");
        ShapedRecipe megaelixir = new ShapedRecipe(key, MenuItem.megaElixir());
        megaelixir.shape("DGD", "AAA", "DPD");
        megaelixir.setIngredient('D', Material.DIAMOND);
        megaelixir.setIngredient('G', Material.GUNPOWDER);
        megaelixir.setIngredient('A', Material.GOLDEN_APPLE);
        megaelixir.setIngredient('P', Material.POTION);
        Bukkit.addRecipe(megaelixir);



        key = new NamespacedKey(this.plugin, "ankou");
        ShapedRecipe ankou = new ShapedRecipe(key, MenuItem.ankou());
        ankou.shape("CGC", "EWE", "CPC");
        ankou.setIngredient('C', Material.MAGMA_CREAM);
        ankou.setIngredient('G', Material.GUNPOWDER);
        ankou.setIngredient('E', Material.ENDER_EYE);
        ankou.setIngredient('W', Material.NETHER_WART);
        ankou.setIngredient('P', Material.POTION);
        Bukkit.addRecipe(ankou);


        // FORGERON

        /*key = new NamespacedKey(this.plugin, "ironSword1");
        ShapedRecipe ironSword1 = new ShapedRecipe(key, MenuItem.ironSword());
        ironSword1.shape(" I ", " I ", "ISI");
        ironSword1.setIngredient('I', Material.IRON_INGOT);
        ironSword1.setIngredient('S', Material.STICK);
        Bukkit.addRecipe(ironSword1);

        key = new NamespacedKey(this.plugin, "ironAxe1");
        ShapedRecipe ironAxe1 = new ShapedRecipe(key, MenuItem.ironAxe());
        ironAxe1.shape(" II", " SI", "ISI");
        ironAxe1.setIngredient('I', Material.IRON_INGOT);
        ironAxe1.setIngredient('S', Material.STICK);
        Bukkit.addRecipe(ironAxe1);

        key = new NamespacedKey(this.plugin, "ironAxe2");
        ShapedRecipe ironAxe2 = new ShapedRecipe(key, MenuItem.ironAxe());
        ironAxe2.shape("II ", "IS ", "ISI");
        ironAxe2.setIngredient('I', Material.IRON_INGOT);
        ironAxe2.setIngredient('S', Material.STICK);
        Bukkit.addRecipe(ironAxe2);

        key = new NamespacedKey(this.plugin, "ironPickaxe");
        ShapedRecipe ironPickaxe = new ShapedRecipe(key, MenuItem.ironPickaxe());
        ironPickaxe.shape("III", " S ", "ISI");
        ironPickaxe.setIngredient('I', Material.IRON_INGOT);
        ironPickaxe.setIngredient('S', Material.STICK);
        Bukkit.addRecipe(ironPickaxe);*/
    }

}
