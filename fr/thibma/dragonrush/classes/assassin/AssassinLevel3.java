package fr.thibma.dragonrush.classes.assassin;

import fr.thibma.dragonrush.DragonRush;
import fr.thibma.dragonrush.items.MenuItem;
import fr.thibma.dragonrush.items.smoke.SmokeGrenade;
import org.bukkit.block.data.type.Snow;
import org.bukkit.craftbukkit.v1_17_R1.entity.CraftSnowball;
import org.bukkit.craftbukkit.v1_17_R1.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class AssassinLevel3 implements Listener {

    private final Assassin assassin;

    private int cooldown = 30;

    public AssassinLevel3(Assassin assassin) { this.assassin = assassin; }

    @EventHandler
    void onRightClickSmoke(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack itemStack = event.getItem();

        if (player != this.assassin.getPlayer() || itemStack == null) {
            return;
        }

        if (event.getAction() != Action.RIGHT_CLICK_AIR && event.getAction() != Action.RIGHT_CLICK_BLOCK) {
            return;
        }

        if (!itemStack.getItemMeta().equals(MenuItem.fumigene().getItemMeta())) {
            return;
        }

        if (this.cooldown == 30) {
            player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
            Snowball projectile = player.launchProjectile(Snowball.class);
            ((CraftSnowball) projectile).getHandle().setItem(CraftItemStack.asNMSCopy(MenuItem.fumigene()));

            new BukkitRunnable() {
                @Override
                public void run() {
                    cooldown--;
                    if (cooldown == 0) {
                        cooldown = 30;
                        cancel();
                    }
                }
            }.runTaskTimerAsynchronously(JavaPlugin.getPlugin(DragonRush.class), 0, 20);
        }
        else {
            player.sendMessage("Objet en rechargement : " + this.cooldown + "s.");
        }


    }

    @EventHandler
    void onProjectileHit(ProjectileHitEvent event) {
        if (!(event.getEntity().getShooter() instanceof Player)) {
            return;
        }
        Player player = (Player) event.getEntity().getShooter();

        if (!(event.getEntity() instanceof Snowball)) {
            return;
        }
        Snowball projectile = (Snowball) event.getEntity();

        if (!((CraftSnowball) projectile).getHandle().getItem().getItem().equals(CraftItemStack.asNMSCopy(MenuItem.fumigene()).getItem())) {
            return;
        }
        SmokeGrenade smokeGrenade = new SmokeGrenade(JavaPlugin.getPlugin(DragonRush.class), event.getEntity().getLocation(), 15, player);
    }

}
