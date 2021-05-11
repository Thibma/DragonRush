package fr.thibma.dragonrush.items.smoke;

import fr.thibma.dragonrush.DragonRush;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class SmokeGrenade extends BukkitRunnable {

    private long lifeTime; // how long the smoke grenade effect should stay
    private Location loc; // the smoke grenade's center location
    private JavaPlugin plugin; // the plugin that spawned this smoke grenade
    private Player player;

    public SmokeGrenade(JavaPlugin plugin, Location loc, long lifeTime, Player player) { // lifeTime here is in seconds as well
        this.lifeTime = lifeTime * 20; // cache life time and set it to ticks
        this.loc = loc.clone().add(0, 1, 0); // cache center location and move it 1 up to show more smoke.
        this.plugin = plugin; // cache plugin
        runTaskTimer(plugin, 0L, 1L); // start BukkitRunnable to spawn smoke every tick
        this.player = player;
    }

    @Override
    public void run() {
        //System.out.println(lifeTime);
        if (lifeTime == 0) { // smoke grenade should stop living at this point
            cancel(); // cancel BukkitRunnable to stop spawning smoke.
            return;
        }
        //new Smoke(plugin, loc, 5, 10); // spawn smoke that will move.
        double offset = 7D;
        for (int i = 0; i < 20; i++) {
            // spawn red particles with the offset 'offset' (the double variable) and no speed at 'loc'. You can use REDSTONE_DUST for this.
            //this.loc.getWorld().playEffect(this.loc, Effect.SMOKE, lifeTime);
            this.loc.getWorld().spawnParticle(Particle.SMOKE_LARGE, loc, i, 4D, 4D, 4D, 0);
        }
        // to prevent people from turning off particles.
        for (Entity entity : loc.getWorld().getNearbyEntities(loc, offset, offset, offset)) { // get nearby entities
            if (!(entity instanceof Player))  // if the entity is something like an item, continue to next entity.
                continue;
            Player player = (Player) entity;
            if (player.equals(this.player)) {
                player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 40, 1));
            }
            if (DragonRush.teams.getTeamOfAPlayer(this.player).getPlayerList().contains(player)) {
                continue;
            }
            player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 40, 2)); // Blind the entity, just in case if they have their particles turned off. Forgot which one is the amplifier and duration, and if the duration is in ticks or seconds etc.
        }
        lifeTime--; // decrease lifeTime 1 tick because 1 tick has passed.
    }
}