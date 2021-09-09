package fr.thibma.dragonrush.items;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.UUID;

public final class MenuItem {


    // ASSASSIN
    public static ItemStack fumigene() {
        ItemStack item = new ItemStack(Material.GUNPOWDER);
        ItemMeta itemMeta = item.getItemMeta();
        ArrayList<String> lore = new ArrayList<>();
        itemMeta.setDisplayName("§5Fumigène");
        lore.add("§5Épique");
        lore.add("§aUne préparation parfaite montée par un");
        lore.add("§aassassin hors pair. Il doit choisir la");
        lore.add("§aprochaine cible à éxecuter.");
        lore.add("");
        lore.add("§c§l§oUtilisable uniquement par la classe Assassin.");
        lore.add("§7Clic droit : ");
        lore.add("§2 Lance un projectile.");
        lore.add("§2 A l'impact, il explose et invoque un brouillard");
        lore.add("§2 pendant §615 secondes §2qui inflige §ecécité");
        lore.add("§2 aux ennemis et §evitesse §2au lanceur dans la zone.");
        itemMeta.setLore(lore);
        itemMeta.addEnchant(Enchantment.DURABILITY, 1, true);
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        item.setItemMeta(itemMeta);

        return item;
    }

    // ALCHEMIST

    public static ItemStack minorRegen() {
        ItemStack item = new ItemStack(Material.SPLASH_POTION);
        PotionMeta itemMeta = (PotionMeta) item.getItemMeta();
        ArrayList<String> lore = new ArrayList<>();
        itemMeta.setDisplayName("§fPotion de regénération mineure");
        lore.add("§fCommun");
        lore.add("§aUn mélange qui permet de soigner des");
        lore.add("§ablessures légères.");
        lore.add("");
        lore.add("§c§l§oUniquement craftable par la classe Alchimiste.");
        lore.add("§7Effet de potion - Splash : ");
        lore.add("§9 Regénération I (~20s)");
        itemMeta.setLore(lore);
        itemMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        itemMeta.setColor(Color.FUCHSIA);
        itemMeta.addCustomEffect(new PotionEffect(PotionEffectType.REGENERATION, 20*20, 0), true);
        item.setItemMeta(itemMeta);

        return item;
    }

    public static ItemStack minorDamage() {
        ItemStack item = new ItemStack(Material.SPLASH_POTION);
        PotionMeta itemMeta = (PotionMeta) item.getItemMeta();
        ArrayList<String> lore = new ArrayList<>();
        itemMeta.setDisplayName("§fPotion de dégâts mineure");
        lore.add("§fCommun");
        lore.add("§aCette potion ayant une odeur étrange permet");
        lore.add("§ad'infliger des dégâts en ignorant l'armure.");
        lore.add("");
        lore.add("§c§l§oUniquement craftable par la classe Alchimiste.");
        lore.add("§7Effet de potion - Splash : ");
        lore.add("§c Dégâts Instantanés I");
        itemMeta.setLore(lore);
        itemMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        itemMeta.setColor(Color.fromBGR(77, 0, 77));
        itemMeta.addCustomEffect(new PotionEffect(PotionEffectType.HARM, 0, 0), true);
        item.setItemMeta(itemMeta);

        return item;
    }

    public static ItemStack minorSpeed() {
        ItemStack item = new ItemStack(Material.SPLASH_POTION);
        PotionMeta itemMeta = (PotionMeta) item.getItemMeta();
        ArrayList<String> lore = new ArrayList<>();
        itemMeta.setDisplayName("§fPotion de vitesse mineure");
        lore.add("§fCommun");
        lore.add("§aLe sucre injecté dans cette potion permet");
        lore.add("§ade décupler la force des muscles de ses jambes.");
        lore.add("");
        lore.add("§c§l§oUniquement craftable par la classe Alchimiste.");
        lore.add("§7Effet de potion - Splash : ");
        lore.add("§9 Vitesse I (~30s)");
        itemMeta.setLore(lore);
        itemMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        itemMeta.setColor(Color.fromBGR(255, 195, 77));
        itemMeta.addCustomEffect(new PotionEffect(PotionEffectType.SPEED, 30*20, 0), true);
        item.setItemMeta(itemMeta);

        return item;
    }

    public static ItemStack minorCelerity() {
        ItemStack item = new ItemStack(Material.SPLASH_POTION);
        PotionMeta itemMeta = (PotionMeta) item.getItemMeta();
        ArrayList<String> lore = new ArrayList<>();
        itemMeta.setDisplayName("§fPotion de célérité mineure");
        lore.add("§fCommun");
        lore.add("§aLes fibres de cette potion permet");
        lore.add("§ade décupler la force des muscles de ses bras.");
        lore.add("");
        lore.add("§c§l§oUniquement craftable par la classe Alchimiste.");
        lore.add("§7Effet de potion - Splash : ");
        lore.add("§9 Célérité I (~60s)");
        itemMeta.setLore(lore);
        itemMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        itemMeta.setColor(Color.fromBGR(0, 230, 230));
        itemMeta.addCustomEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 60*20, 0), true);
        item.setItemMeta(itemMeta);

        return item;
    }

    public static ItemStack minorSlow() {
        ItemStack item = new ItemStack(Material.SPLASH_POTION);
        PotionMeta itemMeta = (PotionMeta) item.getItemMeta();
        ArrayList<String> lore = new ArrayList<>();
        itemMeta.setDisplayName("§fPotion de lenteure mineure");
        lore.add("§fCommun");
        lore.add("§aLe flacon plutôt lourd fatigue facilement la");
        lore.add("§acible lui faisant perdre de la vitesse.");
        lore.add("");
        lore.add("§c§l§oUniquement craftable par la classe Alchimiste.");
        lore.add("§7Effet de potion - Splash : ");
        lore.add("§c Lenteur I (~30s)");
        itemMeta.setLore(lore);
        itemMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        itemMeta.setColor(Color.fromBGR(153, 102, 51));
        itemMeta.addCustomEffect(new PotionEffect(PotionEffectType.SLOW, 30*20, 0), true);
        item.setItemMeta(itemMeta);

        return item;
    }

    public static ItemStack sanatorium() {
        ItemStack item = new ItemStack(Material.POTION);
        PotionMeta itemMeta = (PotionMeta) item.getItemMeta();
        ArrayList<String> lore = new ArrayList<>();
        itemMeta.setDisplayName("§bSanatorium");
        lore.add("§bRare");
        lore.add("§aUne drogue assez rare que de nombreux accros");
        lore.add("§as'arrachent. Malheureusement, le prix de cette potion");
        lore.add("§aest relativement chère.");
        lore.add("");
        lore.add("§c§l§oUniquement craftable par la classe Alchimiste.");
        lore.add("§7Effet de potion : ");
        lore.add("§9 Regénération II (25s)");
        lore.add("§9 Absorption II (120s)");
        itemMeta.setLore(lore);
        itemMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        itemMeta.setColor(Color.fromBGR(217, 179, 255));
        itemMeta.addCustomEffect(new PotionEffect(PotionEffectType.REGENERATION, 25*20, 1), true);
        itemMeta.addCustomEffect(new PotionEffect(PotionEffectType.ABSORPTION, 120*20, 1), true);
        item.setItemMeta(itemMeta);

        return item;
    }

    public static ItemStack cyanure() {
        ItemStack item = new ItemStack(Material.SPLASH_POTION);
        PotionMeta itemMeta = (PotionMeta) item.getItemMeta();
        ArrayList<String> lore = new ArrayList<>();
        itemMeta.setDisplayName("§bCyanure");
        lore.add("§bRare");
        lore.add("§aLes sorcières pratiquaient cette mixture pour");
        lore.add("§aempoisonner leurs cibles. C'était plutôt");
        lore.add("§aefficace.");
        lore.add("");
        lore.add("§c§l§oUniquement craftable par la classe Alchimiste.");
        lore.add("§7Effet de potion - Splash : ");
        lore.add("§c Poison I (~30s)");
        lore.add("§c Lenteur I (~30s)");
        lore.add("§c Faiblesse I (~30s)");
        itemMeta.setLore(lore);
        itemMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        itemMeta.setColor(Color.fromBGR(0, 77, 0));
        itemMeta.addCustomEffect(new PotionEffect(PotionEffectType.POISON, 30*20, 0), true);
        itemMeta.addCustomEffect(new PotionEffect(PotionEffectType.SLOW, 30*20, 0), true);
        itemMeta.addCustomEffect(new PotionEffect(PotionEffectType.WEAKNESS, 30*20, 0), true);

        item.setItemMeta(itemMeta);

        return item;
    }

    public static ItemStack injection() {
        ItemStack item = new ItemStack(Material.SPLASH_POTION);
        PotionMeta itemMeta = (PotionMeta) item.getItemMeta();
        ArrayList<String> lore = new ArrayList<>();
        itemMeta.setDisplayName("§bInjection");
        lore.add("§bRare");
        lore.add("§aUn produit boostant les jambes de manière");
        lore.add("§aeffroyable. Cette potion fut utilisée lors de");
        lore.add("§acompétitions sportives.");
        lore.add("");
        lore.add("§c§l§oUniquement craftable par la classe Alchimiste.");
        lore.add("§7Effet de potion - Splash : ");
        lore.add("§9 Vitesse II (~50s)");
        lore.add("§9 Saut amélioré II (~50s)");
        itemMeta.setLore(lore);
        itemMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        itemMeta.setColor(Color.fromBGR(153, 255, 255));
        itemMeta.addCustomEffect(new PotionEffect(PotionEffectType.SPEED, 50*20, 1), true);
        itemMeta.addCustomEffect(new PotionEffect(PotionEffectType.JUMP, 50*20, 1), true);

        item.setItemMeta(itemMeta);

        return item;
    }

    public static ItemStack supplice() {
        ItemStack item = new ItemStack(Material.SPLASH_POTION);
        PotionMeta itemMeta = (PotionMeta) item.getItemMeta();
        ArrayList<String> lore = new ArrayList<>();
        itemMeta.setDisplayName("§bSupplice");
        lore.add("§bRare");
        lore.add("§aBien que n'infligeant pas de réels dégâts physique,");
        lore.add("§ace mélange est pourtant très efficace pour dissuader");
        lore.add("§ades cibles. Il les immobilise instantanément tout en brisant");
        lore.add("§ale mental de ceux qui absorbent ses vapeurs.");
        lore.add("");
        lore.add("§c§l§oUniquement craftable par la classe Alchimiste.");
        lore.add("§7Effet de potion - Splash : ");
        lore.add("§c Lenteur II (~20s)");
        lore.add("§c Fatigue II (~20s)");
        lore.add("§c Cécité (~20s)");
        lore.add("§c Faim II (~20s)");
        lore.add("§c Faiblesse II (~20s)");
        itemMeta.setLore(lore);
        itemMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        itemMeta.setColor(Color.fromBGR(0, 102, 51));
        itemMeta.addCustomEffect(new PotionEffect(PotionEffectType.SLOW, 20*20, 1), true);
        itemMeta.addCustomEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 20*20, 1), true);
        itemMeta.addCustomEffect(new PotionEffect(PotionEffectType.BLINDNESS, 20*20, 0), true);
        itemMeta.addCustomEffect(new PotionEffect(PotionEffectType.HUNGER, 20*20, 1), true);
        itemMeta.addCustomEffect(new PotionEffect(PotionEffectType.WEAKNESS, 20*20, 1), true);

        item.setItemMeta(itemMeta);

        return item;
    }

    public static ItemStack aquethyme() {
        ItemStack item = new ItemStack(Material.SPLASH_POTION);
        PotionMeta itemMeta = (PotionMeta) item.getItemMeta();
        ArrayList<String> lore = new ArrayList<>();
        itemMeta.setDisplayName("§bAquethyme");
        lore.add("§bRare");
        lore.add("§aLes Hommes-Poisson fabriquaient cette potion");
        lore.add("§aavec leurs ressources pour les vendres aux humains");
        lore.add("§aet se faire de l'argent.");
        lore.add("");
        lore.add("§c§l§oUniquement craftable par la classe Alchimiste.");
        lore.add("§7Effet de potion - Splash : ");
        lore.add("§9 Apnée (~60s)");
        lore.add("§9 Nyctalopie (~60s)");
        lore.add("§9 Grâce du dauphin (~60s)");
        itemMeta.setLore(lore);
        itemMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        itemMeta.setColor(Color.fromBGR(255, 204, 102));
        itemMeta.addCustomEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 60*20, 0), true);
        itemMeta.addCustomEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 60*20, 0), true);
        itemMeta.addCustomEffect(new PotionEffect(PotionEffectType.DOLPHINS_GRACE, 60*20, 0), true);
        item.setItemMeta(itemMeta);

        return item;
    }

    public static ItemStack halcyon() {
        ItemStack item = new ItemStack(Material.SPLASH_POTION);
        PotionMeta itemMeta = (PotionMeta) item.getItemMeta();
        ArrayList<String> lore = new ArrayList<>();
        itemMeta.setDisplayName("§bHalcyon");
        lore.add("§bRare");
        lore.add("§aLes alchimistes fabriquaient cette potion pour");
        lore.add("§aqu'en combat sur le terrain, ils puissent être");
        lore.add("§aplus résistants.");
        lore.add("");
        lore.add("§c§l§oUniquement craftable par la classe Alchimiste.");
        lore.add("§7Effet de potion - Splash : ");
        lore.add("§9 Résistance II (~45s)");
        itemMeta.setLore(lore);
        itemMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        itemMeta.setColor(Color.fromBGR(225, 208, 208));
        itemMeta.addCustomEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 45*20, 1), true);
        item.setItemMeta(itemMeta);

        return item;
    }

    public static ItemStack dracosouffle() {
        ItemStack item = new ItemStack(Material.LINGERING_POTION);
        PotionMeta itemMeta = (PotionMeta) item.getItemMeta();
        ArrayList<String> lore = new ArrayList<>();
        itemMeta.setDisplayName("§bDracosouffle");
        lore.add("§bRare");
        lore.add("§aUn poison toxique sécrété d'un ancien Dragon du");
        lore.add("§aNether. Évitez de rester dans la zone ! C'est");
        lore.add("§atrès dangereux !");
        lore.add("");
        lore.add("§c§l§oUniquement craftable par la classe Alchimiste.");
        lore.add("§7Effet de potion - Zone : ");
        lore.add("§c Dégâts instantanés I ");
        itemMeta.setLore(lore);
        itemMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        itemMeta.setColor(Color.fromBGR(0, 51, 102));
        itemMeta.addCustomEffect(new PotionEffect(PotionEffectType.HARM, 0, 0), true);
        item.setItemMeta(itemMeta);

        return item;
    }

    public static ItemStack sagou() {
        ItemStack item = new ItemStack(Material.SPLASH_POTION);
        PotionMeta itemMeta = (PotionMeta) item.getItemMeta();
        ArrayList<String> lore = new ArrayList<>();
        itemMeta.setDisplayName("§5Sagou");
        lore.add("§5Épique");
        lore.add("§aLa force émanante de cette potion permet");
        lore.add("§aà son utilisateur de tout détruire sur son");
        lore.add("§apassage. La légende raconte qu'un ours buvant du");
        lore.add("§aSagou pourrait détruire un village entier.");
        lore.add("");
        lore.add("§c§l§oUniquement craftable par la classe Alchimiste.");
        lore.add("§7Effet de potion - Splash : ");
        lore.add("§9 Force I (~50s)");
        lore.add("§9 Regénération I (~50s)");
        lore.add("§9 Résistance au feu (~50s)");
        lore.add("§9 Saturation I (~50s)");
        itemMeta.setLore(lore);
        itemMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        itemMeta.setColor(Color.fromBGR(26, 163, 255));
        itemMeta.addCustomEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 50*20, 0), true);
        itemMeta.addCustomEffect(new PotionEffect(PotionEffectType.REGENERATION, 50*20, 0), true);
        itemMeta.addCustomEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 50*20, 0), true);
        itemMeta.addCustomEffect(new PotionEffect(PotionEffectType.SATURATION, 50*20, 0), true);
        item.setItemMeta(itemMeta);

        return item;
    }

    public static ItemStack aladore() {
        ItemStack item = new ItemStack(Material.SPLASH_POTION);
        PotionMeta itemMeta = (PotionMeta) item.getItemMeta();
        ArrayList<String> lore = new ArrayList<>();
        itemMeta.setDisplayName("§6§lAladore");
        lore.add("§6§lLégendaire");
        lore.add("§aAladore est une préparation tristement célèbre");
        lore.add("§apour les dégâts qu'elle inflige.");
        lore.add("§aLa légende raconte qu'un alchimiste ayant produit");
        lore.add("§aune goutte d'Aladore aurait succombé sur place à cause");
        lore.add("§ades vapeurs de cette dernière.");
        lore.add("");
        lore.add("§c§l§oUniquement craftable par la classe Alchimiste.");
        lore.add("§7Effet de potion - Splash : ");
        lore.add("§c Wither II (~45s)");
        lore.add("§c Lenteur II (~45s)");
        lore.add("§c Faim II (~45s)");
        itemMeta.setLore(lore);
        itemMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        itemMeta.setColor(Color.fromBGR(13, 26, 38));
        itemMeta.addCustomEffect(new PotionEffect(PotionEffectType.WITHER, 45*20, 1), true);
        itemMeta.addCustomEffect(new PotionEffect(PotionEffectType.SLOW, 45*20, 1), true);
        itemMeta.addCustomEffect(new PotionEffect(PotionEffectType.HUNGER, 45*20, 1), true);
        item.setItemMeta(itemMeta);

        return item;
    }

    public static ItemStack croisade() {
        ItemStack item = new ItemStack(Material.SPLASH_POTION);
        PotionMeta itemMeta = (PotionMeta) item.getItemMeta();
        ArrayList<String> lore = new ArrayList<>();
        itemMeta.setDisplayName("§6§lCroisade");
        lore.add("§6§lLégendaire");
        lore.add("§aLa Croisade ne fut qu'une théorie pour beaucoup");
        lore.add("§amais pas pour un certain scientifique de la garde royale");
        lore.add("§aqui a pu produire une substance d'une pureté extraordinaire.");
        lore.add("§aL'ingrédient principale est une étoile des cieux qui produit");
        lore.add("§ales voeux de son possesseur.");
        lore.add("");
        lore.add("§c§l§oUniquement craftable par la classe Alchimiste.");
        lore.add("§7Effet de potion - Splash : ");
        lore.add("§9 Vitesse II (~60s)");
        lore.add("§9 Force I (~60s)");
        lore.add("§9 Soin Instantané II");
        lore.add("§9 Regénération II (~60s)");
        lore.add("§9 Résistance I (~60s)");
        lore.add("§9 Résistance au feu (~60s)");
        lore.add("§9 Absorption II (~60s)");
        lore.add("§9 Saturation II (~60s)");
        lore.add("§9 Surbrillance (~60s)");
        itemMeta.setLore(lore);
        itemMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        itemMeta.setColor(Color.fromBGR(255, 255, 204));
        itemMeta.addCustomEffect(new PotionEffect(PotionEffectType.SPEED, 60*20, 1), true);
        itemMeta.addCustomEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 60*20, 0), true);
        itemMeta.addCustomEffect(new PotionEffect(PotionEffectType.HEAL, 0, 1), true);
        itemMeta.addCustomEffect(new PotionEffect(PotionEffectType.REGENERATION, 60*20, 1), true);
        itemMeta.addCustomEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 60*20, 0), true);
        itemMeta.addCustomEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 60*20, 0), true);
        itemMeta.addCustomEffect(new PotionEffect(PotionEffectType.ABSORPTION, 60*20, 1), true);
        itemMeta.addCustomEffect(new PotionEffect(PotionEffectType.SATURATION, 60*20, 1), true);
        itemMeta.addCustomEffect(new PotionEffect(PotionEffectType.GLOWING, 60*20, 0), true);

        item.setItemMeta(itemMeta);

        return item;
    }

    public static ItemStack nuclide() {
        ItemStack item = new ItemStack(Material.LINGERING_POTION);
        PotionMeta itemMeta = (PotionMeta) item.getItemMeta();
        ArrayList<String> lore = new ArrayList<>();
        itemMeta.setDisplayName("§6§lNuclide");
        lore.add("§6§lLégendaire");
        lore.add("§aToute la misère et les ténèbres de ce monde");
        lore.add("§aregroupé en un flacon. Des générations ont été terrorisés");
        lore.add("§aau Nuclide, des peuples entiers furent drogués à ce produit");
        lore.add("§apar des dictateurs sans merci. Faites attention en pratiquant");
        lore.add("§ace produit, cela peut se retourner contre vous...");
        lore.add("");
        lore.add("§c§l§oUniquement craftable par la classe Alchimiste.");
        lore.add("§7Effet de potion - Zone : ");
        lore.add("§c Poison III (~25s)");
        lore.add("§c Lenteur II (~25s)");
        lore.add("§c Faim II (~25s)");
        lore.add("§c Nausée (~25s)");
        itemMeta.setLore(lore);
        itemMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        itemMeta.setColor(Color.fromBGR(26, 0, 0));
        itemMeta.addCustomEffect(new PotionEffect(PotionEffectType.POISON, 25*20, 2), true);
        itemMeta.addCustomEffect(new PotionEffect(PotionEffectType.SLOW, 25*20, 1), true);
        itemMeta.addCustomEffect(new PotionEffect(PotionEffectType.HUNGER, 25*20, 1), true);
        itemMeta.addCustomEffect(new PotionEffect(PotionEffectType.CONFUSION, 25*20, 0), true);
        item.setItemMeta(itemMeta);

        return item;
    }

    public static ItemStack adamantine() {
        ItemStack item = new ItemStack(Material.SPLASH_POTION);
        PotionMeta itemMeta = (PotionMeta) item.getItemMeta();
        ArrayList<String> lore = new ArrayList<>();
        itemMeta.setDisplayName("§5Adamantine");
        lore.add("§5Épique");
        lore.add("§aIl est dit que boire cette potion permettrai");
        lore.add("§ade ressentir une armure magique sur soi.");
        lore.add("§aCependant, elle consomme beaucoup d'énergie pour");
        lore.add("§ason possesseur.");
        lore.add("");
        lore.add("§c§l§oUniquement craftable par la classe Alchimiste.");
        lore.add("§7Effet de potion - Splash : ");
        lore.add("§9 Résistance IV (~60s)");
        lore.add("§c Lenteur II (~60s)");
        lore.add("§c Faiblesse II (~60s)");
        itemMeta.setLore(lore);
        itemMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        itemMeta.setColor(Color.fromBGR(255, 255, 0));
        itemMeta.addCustomEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 60*20, 3), true);
        itemMeta.addCustomEffect(new PotionEffect(PotionEffectType.SLOW, 60*20, 1), true);
        itemMeta.addCustomEffect(new PotionEffect(PotionEffectType.WEAKNESS, 60*20, 1), true);
        item.setItemMeta(itemMeta);

        return item;
    }

    public static ItemStack decubitus() {
        ItemStack item = new ItemStack(Material.SPLASH_POTION);
        PotionMeta itemMeta = (PotionMeta) item.getItemMeta();
        ArrayList<String> lore = new ArrayList<>();
        itemMeta.setDisplayName("§5Décubitus");
        lore.add("§5Épique");
        lore.add("§aCette potion des cieux permet à la cible de");
        lore.add("§as'envoler pendant un moment. Elle peut être utilisé");
        lore.add("§apour s'échapper ou pour envoyer un ennemi dans le ciel.");
        lore.add("");
        lore.add("§c§l§oUniquement craftable par la classe Alchimiste.");
        lore.add("§7Effet de potion - Splash : ");
        lore.add("§c Lévitation II (~30s)");
        lore.add("§9 Chute lente (~60s)");
        itemMeta.setLore(lore);
        itemMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        itemMeta.setColor(Color.fromBGR(204, 255, 204));
        itemMeta.addCustomEffect(new PotionEffect(PotionEffectType.LEVITATION, 30*20, 1), true);
        itemMeta.addCustomEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 60*20, 0), true);
        item.setItemMeta(itemMeta);

        return item;
    }

    public static ItemStack esuna() {
        ItemStack item = new ItemStack(Material.SPLASH_POTION);
        PotionMeta itemMeta = (PotionMeta) item.getItemMeta();
        ArrayList<String> lore = new ArrayList<>();
        itemMeta.setDisplayName("§5Esuna");
        lore.add("§5Épique");
        lore.add("§aUn remède permettant de soigner n'importe quelle");
        lore.add("§amaladie. On dit que c'est grâce au Esuna que l'on a");
        lore.add("§apu détruire Aladore.");
        lore.add("");
        lore.add("§c§l§oUniquement craftable par la classe Alchimiste.");
        lore.add("§7Effet de potion - Splash : ");
        lore.add("§9 Annule tous les effets de potions");
        itemMeta.setLore(lore);
        itemMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        itemMeta.setColor(Color.fromBGR(255, 153, 255));
        item.setItemMeta(itemMeta);

        return item;
    }

    public static ItemStack megaElixir() {
        ItemStack item = new ItemStack(Material.SPLASH_POTION);
        PotionMeta itemMeta = (PotionMeta) item.getItemMeta();
        ArrayList<String> lore = new ArrayList<>();
        itemMeta.setDisplayName("§6§lMéga-Elixir");
        lore.add("§6§lLégendaire");
        lore.add("§aUne célèbre potion légendaire qui a permis à une armée");
        lore.add("§autilisant cette potion de remporter intégralement une guerre.");
        lore.add("§aIl est dit que tous les soldats était devenus invincibles");
        lore.add("§alorsqu'ils absorbaient cette potion. Malheureusement,");
        lore.add("§asa recette de base ayant été perdue,");
        lore.add("§ail a fallu en trouver une autre avec des produits");
        lore.add("§abeaucoup plus rare pour en synthétiser à nouveau.");
        lore.add("");
        lore.add("§c§l§oUniquement craftable par la classe Alchimiste.");
        lore.add("§7Effet de potion - Splash : ");
        lore.add("§9 Regénération IV (~30s)");
        lore.add("§9 Annule tous les effets négatifs de potion.");
        itemMeta.setLore(lore);
        itemMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        itemMeta.setColor(Color.fromBGR(0, 204, 255));
        itemMeta.addCustomEffect(new PotionEffect(PotionEffectType.REGENERATION, 30*20, 3), true);

        item.setItemMeta(itemMeta);

        return item;
    }

    public static ItemStack ankou() {
        ItemStack item = new ItemStack(Material.SPLASH_POTION);
        PotionMeta itemMeta = (PotionMeta) item.getItemMeta();
        ArrayList<String> lore = new ArrayList<>();
        itemMeta.setDisplayName("§5Ankou");
        lore.add("§5Épique");
        lore.add("§aSi la mort était une potion, la voici.");
        lore.add("§aAnkou inflige de gros dégâts aux cibles, étant");
        lore.add("§adonné que la potion s'attaque directement au corps.");
        lore.add("§aIgnore l'armure.");
        lore.add("");
        lore.add("§c§l§oUniquement craftable par la classe Alchimiste.");
        lore.add("§7Effet de potion - Splash : ");
        lore.add("§c Dégâts instantanés II");
        itemMeta.setLore(lore);
        itemMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        itemMeta.setColor(Color.fromBGR(0, 0, 0));
        itemMeta.addCustomEffect(new PotionEffect(PotionEffectType.HARM, 0, 1), true);

        item.setItemMeta(itemMeta);

        return item;
    }


    // FORGERON

    public static ItemStack ironSword() {
        ItemStack item = new ItemStack(Material.IRON_SWORD);
        ItemMeta itemMeta = item.getItemMeta();
        ArrayList<String> lore = new ArrayList<>();
        itemMeta.setDisplayName("§fÉpée en fer améliorée");
        lore.add("§fCommun");
        lore.add("§aUne épée en fer plus puissante que la normale.");
        lore.add("");
        lore.add("§7Dans la main principale : ");
        lore.add("§2 6 de points d'attaque §6(+1)");
        lore.add("§2 1.6 de vitesse d'attaque §6(+0.2)");
        itemMeta.setLore(lore);
        itemMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier(UUID.randomUUID(),"generic.attack_damage", 6, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND));
        itemMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, new AttributeModifier(UUID.randomUUID(), "generic.attack_speed", -2.2, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND));
        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        item.setItemMeta(itemMeta);

        return item;
    }

    public static ItemStack ironAxe() {
        ItemStack item = new ItemStack(Material.IRON_AXE);
        ItemMeta itemMeta = item.getItemMeta();
        ArrayList<String> lore = new ArrayList<>();
        itemMeta.setDisplayName("§fHache en fer améliorée");
        lore.add("§fCommun");
        lore.add("§aUne hache en fer plus puissante que la normale");
        lore.add("");
        lore.add("§7Dans la main principale : ");
        lore.add("§2 9 de points d'attaque");
        lore.add("§2 0.9 de vitesse d'attaque §6(+0.2)");
        itemMeta.setLore(lore);
        itemMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier(UUID.randomUUID(),"generic.attack_damage", 8, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND));
        itemMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, new AttributeModifier(UUID.randomUUID(), "generic.attack_speed", -2.9, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND));
        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        item.setItemMeta(itemMeta);

        return item;
    }

    public static ItemStack ironPickaxe() {
        ItemStack item = new ItemStack(Material.IRON_PICKAXE);
        ItemMeta itemMeta = item.getItemMeta();
        ArrayList<String> lore = new ArrayList<>();
        itemMeta.setDisplayName("§fPioche en fer améliorée");
        lore.add("§fCommun");
        lore.add("§aUne pioche en fer plus performante que la normale");
        lore.add("");
        lore.add("§7Dans la main principale : ");
        lore.add("§2 4 de points d'attaque");
        lore.add("§2 1.2 de vitesse d'attaque");
        itemMeta.setLore(lore);
        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        item.setItemMeta(itemMeta);
        item.addEnchantment(Enchantment.DIG_SPEED, 1);
        item.addEnchantment(Enchantment.DURABILITY, 1);

        return item;
    }

    public static ItemStack dragonEgg() {
        ItemStack item = new ItemStack(Material.DRAGON_EGG);
        ItemMeta itemMeta = item.getItemMeta();
        ArrayList<String> lore = new ArrayList<>();
        itemMeta.setDisplayName("§b§lŒuf de Dragon");
        lore.add("§b§lUltime");
        lore.add("§aL'objectif de tout être humain. Un objet si");
        lore.add("§ararissime qu'il confère un vœu à celui qui le");
        lore.add("§arapporte à l'autel au centre du monde.");
        lore.add("");
        lore.add("§7Passif : Pouvoir du Dragon de l'End");
        lore.add("§2 Confère §eVitesse II §2et §eSurbrillance");
        lore.add("§2 Si le porteur de l'œuf meurt, il est directement");
        lore.add("§2posé au sol");
        lore.add("§2 Ne peut pas être posé, lâché ou jeté (sauf à l'autel)");
        itemMeta.setLore(lore);
        item.setItemMeta(itemMeta);
        return item;
    }
}
