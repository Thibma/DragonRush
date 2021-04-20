package fr.thibma.dragonrush.classes.swordman;

import fr.thibma.dragonrush.DragonRush;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.invoke.SerializedLambda;
import java.util.concurrent.atomic.AtomicReference;

public class SwordmanLevel2 implements Listener {

    private final Swordman swordman;
    boolean onSword = false;

    public SwordmanLevel2(Swordman swordman) {
        this.swordman = swordman;
    }

    @EventHandler
    void onSwordHeldItem(PlayerItemHeldEvent event) {
        Player player = event.getPlayer();
        ItemStack itemStack = player.getInventory().getItem(event.getNewSlot());
        if (itemStack == null) {
            this.setBonus(Material.AIR);
            return;
        }
        Material item = itemStack.getType();

        if (player != this.swordman.getPlayer()) {
            return;
        }

        this.setBonus(item);

    }

    @EventHandler
    void onMoveItem(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        InventoryType.SlotType slotType = event.getSlotType();

        if (player != this.swordman.getPlayer()) {
            return;
        }

        if (slotType != InventoryType.SlotType.QUICKBAR) {
            return;
        }

        Material item = event.getCursor().getType();
        int slot = player.getInventory().getHeldItemSlot();

        if (slot != event.getSlot()) {
            return;
        }

        this.setBonus(item);
    }

    @EventHandler
    void onItemSwitchHand(PlayerSwapHandItemsEvent event) {
        Player player = event.getPlayer();
        if (player != this.swordman.getPlayer()) {
            return;
        }
        Material item = event.getMainHandItem().getType();

        this.setBonus(item);
    }

    @EventHandler
    void onGetItem(EntityPickupItemEvent event) {
        Player player = (Player) event.getEntity();
        if (player != this.swordman.getPlayer()) {
            return;
        }

        Material item = event.getItem().getItemStack().getType();
        if (!(item == Material.WOODEN_SWORD || item == Material.STONE_SWORD || item == Material.IRON_SWORD || item == Material.GOLDEN_SWORD || item == Material.DIAMOND_SWORD || item == Material.NETHERITE_SWORD)) {
            return;
        }

        Bukkit.getScheduler().scheduleSyncDelayedTask(JavaPlugin.getPlugin(DragonRush.class), new Runnable() {

            @Override
            public void run() {
                Material item = player.getInventory().getItemInMainHand().getType();
                setBonus(item);
            }

        }, 1);

    }

    @EventHandler
    void onDropItem(PlayerDropItemEvent event) {
        Player player = event.getPlayer();
        if (player != this.swordman.getPlayer()) {
            return;
        }

        Material item = event.getItemDrop().getItemStack().getType();
        if (!(item == Material.WOODEN_SWORD || item == Material.STONE_SWORD || item == Material.IRON_SWORD || item == Material.GOLDEN_SWORD || item == Material.DIAMOND_SWORD || item == Material.NETHERITE_SWORD)) {
            return;
        }

        Bukkit.getScheduler().scheduleSyncDelayedTask(JavaPlugin.getPlugin(DragonRush.class), new Runnable() {

            @Override
            public void run() {
                Material item = player.getInventory().getItemInMainHand().getType();
                setBonus(item);
            }

        }, 1);
    }

    private void setBonus(Material material) {
        if (!(material == Material.WOODEN_SWORD || material == Material.STONE_SWORD || material == Material.IRON_SWORD || material == Material.GOLDEN_SWORD || material == Material.DIAMOND_SWORD || material == Material.NETHERITE_SWORD)) {
            if (this.onSword) {
                this.onSword = false;
                this.swordman.getPlayer().getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(this.swordman.getPlayer().getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).getBaseValue() - 1);
                this.swordman.getPlayer().getAttribute(Attribute.GENERIC_ATTACK_SPEED).setBaseValue(this.swordman.getPlayer().getAttribute(Attribute.GENERIC_ATTACK_SPEED).getBaseValue() - 0.2);
            }
        }
        else {
            if (!this.onSword) {
                this.onSword = true;
                this.swordman.getPlayer().getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(this.swordman.getPlayer().getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).getBaseValue() + 1);
                this.swordman.getPlayer().getAttribute(Attribute.GENERIC_ATTACK_SPEED).setBaseValue(this.swordman.getPlayer().getAttribute(Attribute.GENERIC_ATTACK_SPEED).getBaseValue() + 0.2);
            }
        }
    }
}
