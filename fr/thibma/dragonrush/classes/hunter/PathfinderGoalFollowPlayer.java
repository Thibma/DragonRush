package fr.thibma.dragonrush.classes.hunter;

import net.minecraft.server.level.EntityPlayer;
import net.minecraft.world.entity.EntityInsentient;
import net.minecraft.world.entity.ai.goal.PathfinderGoal;

public class PathfinderGoalFollowPlayer extends PathfinderGoal {

    private final EntityInsentient pet;
    private EntityPlayer owner;
    
    private final double speed;
    private final float distance;
    
    private double x;
    private double y;
    private double z;
    
    public PathfinderGoalFollowPlayer(EntityInsentient pet, EntityPlayer owner, double speed, float distance) {
        this.owner = owner;
        this.pet = pet;
        this.speed = speed;
        this.distance = distance;
    }

    @Override
    public boolean a() {
        if (this.owner == null) {
            return false;
        }

        else if (this.owner.getBukkitEntity().getLocation().distance(this.pet.getBukkitEntity().getLocation()) > (double) (this.distance * this.distance)) {
            System.out.println("tp");
            pet.setPosition(this.owner.locX(), this.owner.locY(), this.owner.locZ());
            return false;
        }
        return true;
    }

    public void c() {
        //this.pet.getNavigation().a(this.x, this.y, this.z, this.speed);
    }

    /*public boolean b() {
        return !this.pet.getNavigation().m() && this.owner.h(this.pet) < (double) (this.distance * this.distance);
    }
     */

    /*public void d() {
        this.owner = null;
    }*/
}
