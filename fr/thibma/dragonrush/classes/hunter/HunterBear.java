package fr.thibma.dragonrush.classes.hunter;

import fr.thibma.dragonrush.DragonRush;
import net.minecraft.network.chat.ChatComponentText;
import net.minecraft.server.level.EntityPlayer;
import net.minecraft.world.entity.EntityLiving;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.entity.ai.attributes.GenericAttributes;
import net.minecraft.world.entity.ai.goal.PathfinderGoalFloat;
import net.minecraft.world.entity.ai.goal.PathfinderGoalLookAtPlayer;
import net.minecraft.world.entity.ai.goal.PathfinderGoalMeleeAttack;
import net.minecraft.world.entity.ai.goal.PathfinderGoalPanic;
import net.minecraft.world.entity.ai.goal.target.PathfinderGoalNearestAttackableTarget;
import net.minecraft.world.entity.animal.EntityPolarBear;
import net.minecraft.world.entity.player.EntityHuman;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.craftbukkit.v1_17_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_17_R1.entity.CraftPlayer;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class HunterBear extends EntityPolarBear {

    private final Player entityPlayer;

    public HunterBear(Location location, Player owner) {
        super(EntityTypes.ar, ((CraftWorld)location.getWorld()).getHandle());
        this.entityPlayer = owner;

        //System.out.println(entityPlayer.getName());

        this.setPosition(location.getX(), location.getY(), location.getZ());
        this.setCustomName(new ChatComponentText("Le roi des banquises - " + this.entityPlayer.getDisplayName()));
        this.setCustomNameVisible(true);
        this.getAttributeInstance(GenericAttributes.f).setValue(9D);
        this.getAttributeInstance(GenericAttributes.a).setValue(60);
        this.setHealth(60);


        //this.setGoalTarget(((CraftPlayer)owner).getHandle(), EntityTargetEvent.TargetReason.CUSTOM, true);
        this.bP.a(5, new PathfinderGoalFollowPlayer(this, ((CraftPlayer) entityPlayer).getHandle(), 1.5, 50));
        Bukkit.getServer().getPluginManager().registerEvents(new HunterBearListener(this), JavaPlugin.getPlugin(DragonRush.class));
    }

    @Override
    protected void initPathfinder() {
        this.bP.a(0, new PathfinderGoalFloat(this));
        this.bP.a(1, new HunterBear.c());
        this.bP.a(1, new HunterBear.d());
        //this.goalSelector.a(1, new PathfinderGoalMeleeAttack(this, 1.5D, true));
        this.bP.a(7, new PathfinderGoalLookAtPlayer(this, EntityHuman.class, 6.0F));
        this.bQ.a(4, new PathfinderGoalNearestAttackableTarget<>(this, EntityPlayer.class, false));
    }

    class d extends PathfinderGoalPanic {
        public d() {
            super(HunterBear.this, 2.0D);
        }

        public boolean a() {
            return !HunterBear.this.isBaby() && !HunterBear.this.isBurning() ? false : super.a();
        }
    }

    class c extends PathfinderGoalMeleeAttack {
        public c() {
            super(HunterBear.this, 1.25D, true);
        }

        protected void a(EntityLiving var0, double var1) {
            double var3 = this.a(var0);
            if (var1 <= var3 && this.h()) {
                this.g();
                this.a.attackEntity(var0);
                HunterBear.this.v(false);
            } else if (var1 <= var3 * 2.0D) {
                if (this.h()) {
                    HunterBear.this.v(false);
                    this.g();
                }

                if (this.j() <= 10) {
                    HunterBear.this.v(true);
                    HunterBear.this.t();
                }
            } else {
                this.g();
                HunterBear.this.v(false);
            }

        }

        public void d() {
            HunterBear.this.v(false);
            super.d();
        }

        protected double a(EntityLiving var0) {
            return (double)(4.0F + var0.getWidth());
        }
    }

    public Player getEntityPlayer() { return this.entityPlayer; }

}
